package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class StreamController {
    @GetMapping("get-value")
    public int getValue() {
        Long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 1_000_000)
                .sum();

        Long endTime = System.currentTimeMillis();
        Long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime);

        return sum;
    }

   /* public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();

        int sum = Stream.iterate(1, a -> a+1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a+b);

        Long endTime = System.currentTimeMillis();
        Long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime);

        startTime = System.currentTimeMillis();

        sum = IntStream.rangeClosed(1, 1_000_000)
                .sum();

        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println(elapsedTime);
    }*/
}
