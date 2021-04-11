package org.jpmorgan.helix.commandcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("/api/helloworld")
    public String hello() {

        return "Hello Amigo, the time at the server is now " + new Date() + "\n";
    }



}
