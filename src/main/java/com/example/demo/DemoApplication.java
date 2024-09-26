package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private Calculator calculator;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Calculator calculator = new Calculator();
		System.out.println("2 + 3 = " + calculator.calculate(Operation.ADD, 2, 3));
		System.out.println("5 + 3 * 2 = " + calculator.chainOperations(5.0, Arrays.asList(Operation.ADD, Operation.MULTIPLY), Arrays.asList(3.0, 2.0)));
	}

	@Override
	public void run(String... args) throws Exception {
		Number result = calculator.calculate(Operation.ADD, 2, 3);
		System.out.println("2 + 3 = " + result);

		Number chainResult = calculator.chainOperations(5.0, Arrays.asList(Operation.ADD, Operation.MULTIPLY), Arrays.asList(3.0, 2.0));
		System.out.println("5 + 3 * 2 = " + chainResult);
	}
}
