package com.capgemini.webfluxdemo.controller;

import com.capgemini.webfluxdemo.dto.Response;
import com.capgemini.webfluxdemo.exception.InputValidationException;
import com.capgemini.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathValidatorController {

    @Autowired
    ReactiveMathService reactiveMathService;


    @GetMapping("square/{input}/throw")
    public Mono<Response> findSquare(@PathVariable int input){
        if(input<10||input>20){
         throw new InputValidationException(input);
        }
        return reactiveMathService.findSquare(input);
        // reactiveMathService.findSquare(input).block();// if we use block()here it will not be reactive service at all.
    }
}
