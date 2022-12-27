package com.capgemini.webfluxdemo.controller;

import com.capgemini.webfluxdemo.dto.MultipleRequestDto;
import com.capgemini.webfluxdemo.dto.Response;
import com.capgemini.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.Map;

@RestController
@RequestMapping("reactive")
public class ReactiveMathController {

    @Autowired
    ReactiveMathService reactiveMathService;


    @GetMapping("square/{input}")
    public Mono<Response> findSquare(@PathVariable int input){
        return reactiveMathService.findSquare(input);
       // reactiveMathService.findSquare(input).block();// if we use block()here it will not be reactive service at all.
    }

    @GetMapping("table/{input}")
    public Flux<Response>multiplicationTable(@PathVariable int input){
        return reactiveMathService.multiplicationTable(input);
    }
    @GetMapping(value = "table/{input}/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response>multiplicationStreamTable(@PathVariable int input){
        return reactiveMathService.multiplicationTable(input);
    }
    @PostMapping("multiple/reactive")
    public Mono<Response>multipleTwoNumber(@RequestBody Mono<MultipleRequestDto> dto){
        return this.reactiveMathService.multiply(dto);
    }

    @PostMapping("multiple")
    public Mono<Response>multipleTwoNumber(@RequestBody MultipleRequestDto dto){
       return this.reactiveMathService.multiply(dto);
    }
    @PostMapping("reactive-math-headers")
    public Mono<Response>multipleTwoNumber(@RequestBody MultipleRequestDto dto,@RequestHeader Map<String,String> header){
        System.out.println(header);
        return this.reactiveMathService.multiply(dto);
    }
}
