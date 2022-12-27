package com.capgemini.webfluxdemo.service;

import com.capgemini.webfluxdemo.dto.MultipleRequestDto;
import com.capgemini.webfluxdemo.dto.Response;
import com.capgemini.webfluxdemo.util.SleepUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input){
        return Mono.fromSupplier(()->input*input)////any operation any calculation work do from supplier
                .map(Response::new);
    }

    public Flux<Response> multiplicationTable(int input){
        return Flux.range(1,10)
                //.doOnNext(i-> SleepUtil.sleepSeconds(1))//this is blocking for thread
                .delayElements(Duration.ofSeconds(1))//nonblocking asyncronous behaviour
                .doOnNext(i-> System.out.println("reactive math service processing :"+i))
                .map(i-> new Response(i*input));
    }

    public Mono<Response>multiply(Mono<MultipleRequestDto>dtoMono){
        return dtoMono.map(dto->dto.getFirstNumber()*dto.getSecondNumber())
                       .map(response->new Response(response));
    }
    public Mono<Response>multiply(MultipleRequestDto dtoMono){
        return Mono.just(new Response(dtoMono.getFirstNumber()*dtoMono.getSecondNumber()));
    }
}
