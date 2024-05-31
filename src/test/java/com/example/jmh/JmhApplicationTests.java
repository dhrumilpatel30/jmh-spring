package com.example.jmh;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JmhApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private ConfigurableApplicationContext context;

    @Setup(Level.Trial)
    public void setUp() {

        context = SpringApplication.run(JmhApplication.class);
        context.registerShutdownHook();

        userRepository = context.getBean(UserRepository.class);
        for (int i = 0; i < 10000; i++) {
            userRepository.save(new User(i, "User" + i, "user" + i + "@example.com"));
        }
    }

    @TearDown
    public void closeContext(){
        context.close();
    }
    @Benchmark
    public void benchmarkSearch() {
        userRepository.findByNameContaining("User");
    }
}
