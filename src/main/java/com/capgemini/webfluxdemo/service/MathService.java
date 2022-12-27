package com.capgemini.webfluxdemo.service;

import com.capgemini.webfluxdemo.dto.Response;
import com.capgemini.webfluxdemo.util.SleepUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Response findSquare(int input){
    return new Response(input*input);
    }

    public List<Response>multiplicationTable(int input){
        return IntStream.rangeClosed(1,10)
                .peek(i-> SleepUtil.sleepSeconds(1))//this method can be use for debugging purpose
                .peek(i-> System.out.println("method service processing element: "+i))
                .mapToObj(i->new Response(i*input))
                .collect(Collectors.toList());
    }

}
