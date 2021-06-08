package com.orangetalents3.orangetalents3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangeTalents3Application {

	public static void main(String[] args) {
        SpringApplication.run(OrangeTalents3Application.class, args);
	}

}
