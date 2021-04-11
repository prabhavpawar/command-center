package org.jpmorgan.helix.commandcenter.config;

import java.util.Map;


class CustomHttpSpanExtractor { /*implements SpanExtractor {

    @Override public Span joinTrace(SpanTextMap carrier) {
        Map<String, String> map = TextMapUtil.asMap(carrier);
        long traceId = Span.hexToId(map.get("correlationid"));
        long spanId = Span.hexToId(map.get("myspanid"));
        // extract all necessary headers
        Span.SpanBuilder builder = Span.builder().traceId(traceId).spanId(spanId);
        // build rest of the Span
        return builder.build();
    }*/
}