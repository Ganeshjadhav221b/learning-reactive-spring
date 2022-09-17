package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxController {

    @GetMapping("/flux")
    public Flux<Integer> getFlux(){
        Flux<Integer> range = Flux.range(1, 100);
        range.log().filter(x -> x % 2 == 0).subscribe(x -> System.out.println("Here; " + x));
        System.out.println("Hello from "+Thread.currentThread().getName());
        return range;
    }
    @GetMapping("/demo")
    public boolean getDemo(){
        Flux<Integer> range = Flux.range(1, 100);
        range.log().filter(x -> x % 2 == 0).subscribe(x -> System.out.println("Here; " + x));
        System.out.println("Hello from "+Thread.currentThread().getName());
        return true;
    }
    @GetMapping("/mono")
    public Mono<Integer> getMono(){
        return Mono.just(1);
    }
}
