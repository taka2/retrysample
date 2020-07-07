package com.example.demo;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	int count;
	
	@Retryable(value = {RuntimeException.class}, maxAttempts = 10, backoff = @Backoff(delay = 500))
	public void someMethod() {
		count++;
		if(count < 3) {
			System.out.println("fail");
			throw new RuntimeException("error!");
		}
		System.out.println("success");
	}
}
