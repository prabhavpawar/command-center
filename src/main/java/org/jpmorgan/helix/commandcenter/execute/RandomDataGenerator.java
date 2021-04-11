package org.jpmorgan.helix.commandcenter.execute;

import io.opentelemetry.javaagent.shaded.io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.javaagent.shaded.io.opentelemetry.api.trace.Span;
import io.opentelemetry.javaagent.shaded.io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.javaagent.shaded.io.opentelemetry.context.Context;
import io.opentelemetry.javaagent.shaded.io.opentelemetry.context.Scope;
import io.opentelemetry.javaagent.shaded.io.opentelemetry.context.propagation.TextMapPropagator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Slf4j
//@Component
public class RandomDataGenerator implements CommandLineRunner {


    private WebClient webClient;

    @Override
    public void run(String... args) throws Exception {

      log.info("I'm running");
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:9090")
                .build();

        String uuid = UUID.randomUUID().toString();
        log.info(uuid);

        /*Header 'accept-encoding' = gzip
        Header 'user-agent' = ReactorNetty/0.9.7.RELEASE
        Header 'host' = localhost:9091
        Header 'accept' = *
        Header 'trace-transaction-id' = 14e4974f-30e3-4ba3-877a-13d8bd814f74
        Header 'X-Amzn-Trace-Id' = Root=1-60017d03-65242a336c8edda93dea9d2b;Parent=1c0c1f59d9a1f9e1;Sampled=1
        Header 'traceparent' = 00-60017d0365242a336c8edda93dea9d2b-1c0c1f59d9a1f9e1-01
        Header 'b3' = 60017d0365242a336c8edda93dea9d2b-1c0c1f59d9a1f9e1-1
        Header 'X-B3-TraceId' = 60017d0365242a336c8edda93dea9d2b
        Header 'X-B3-SpanId' = 1c0c1f59d9a1f9e1
        Header 'X-B3-Sampled' = 1*/


        log.info(this.webClient.get().uri("/auth")
                .header("X-B3-transaction-id", uuid)
                .header("x-b3-trace_transaction", uuid)
                .header("x-b3-trace_id", uuid)
                .header("X-B3-TraceId", uuid)
                .header("TRACE_ID", uuid)
                .header("X-Amzn-Trace-Id", uuid)
                .header("baggage", "userId=alice")


                .retrieve().bodyToFlux(String.class).blockFirst().toString());

    }

    public static void main(String[] args){

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        log.info("UUID : " + uuid);


        Map<String, String> headers = new HashMap<>();
        headers.put("traceId", uuid);
        headers.put("X-Amzn-Trace-Id", uuid);

        Context extractedContext = OpenTelemetry.getGlobalPropagators().getTextMapPropagator()
                .extract(Context.current(), headers, getter);

        Span downStreamSpan = OpenTelemetry.getGlobalTracer("io.opentelemetry.javaagent.netty")
                .spanBuilder("EdgeService").setSpanKind(Span.Kind.CONSUMER).setParent(extractedContext)
                .startSpan();
        downStreamSpan.setAttribute("TRACE_ID", uuid);
        try (Scope scope = downStreamSpan.makeCurrent()) {

            log.info("I'm running");
            WebClient webClient = WebClient.builder()
                    .baseUrl("http://localhost:9090")
                    .build();


            log.info(webClient.get().uri("/auth")
                    .header("X-B3-transaction-id", uuid)
                    .header("x-b3-trace_transaction", uuid)
                    .header("x-b3-trace_id", uuid)
                    .header("X-B3-TraceId", uuid)
                    .header("TRACE_ID", uuid)
                    .header("X-Amzn-Trace-Id", uuid)
                    .header("baggage", "userId=alice")


                    .retrieve().bodyToFlux(String.class).blockFirst().toString());
        } catch (Throwable t) {
            downStreamSpan.setStatus(StatusCode.ERROR, "Change it to your error message");
        } finally {
            downStreamSpan.end(); // closing the scope does not end the span, this has to be done manually
        }

    }

    public static TextMapPropagator.Getter<Map<String, String>> getter = new TextMapPropagator.Getter<Map<String, String>>() {
        @Override
        public String get(Map<String, String> headers, String key) {

            if( headers.size() > 0) {
                return headers.get(key);
            }
            /*if (carrier.hasNext()) {
                return new String(carrier.headers().lastHeader(key).value(), StandardCharsets.UTF_8);
            }*/
            return null;
        }

        @Override
        public Iterable<String> keys(Map<String, String> headers) {
            List<String> keySet = new ArrayList<String>();

            headers.entrySet().forEach(entry -> {
                keySet.add(entry.getKey());
            });
            return keySet;
        }
    };
}
