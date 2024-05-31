package com.example.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyContoller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

//    public void setUp() {
//        for (int i = 0; i < 10000; i++) {
//            userRepository.save(new User(i,"User" + i, "user" + i + "@example.com"));
//        }
//    }
//
//    @Benchmark
//    public void benchmarkSearch() {
//        userRepository.findByNameContaining("324");
//    }
}
