package com.example.demo;

@FunctionalInterface
public interface CommandLineRunner {
    // Using this interface, we can run it in the CMD line, just in case.
    void run(String... args) throws Exception;
}
