package org.jpmorgan.helix.commandcenter.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/command")
public class CommandController {

    @GetMapping(path = "/random/{count}")
    public String getRandomGeneratorRequest(@PathVariable int count){

        log.info("Count : {}", count);

        return "Hey Amigo, you entered - " + count;
    }



}
