package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.time.Duration;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {

//		SpringApplication.run(DemoApplication.class, args);
		Flux<Integer> range = Flux.range(1, 100);
		range.log().filter(x -> x % 2 == 0).subscribeOn(Schedulers.boundedElastic()).subscribe(x -> System.out.println("Here: " + Thread.currentThread().getName()+" "+x));

		Flux.range(1, 5)
				.delayElements(Duration.ofMillis(100))
				.log()
				.subscribe(x->System.out.println("Here again: "+x));
//		System.in.read();
		System.out.println("Hello from "+Thread.currentThread().getName());
	}

}
