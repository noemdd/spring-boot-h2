package com.spring.cloud.gftbanck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients("com.spring.cloud.gftbanck")
public class GftbanckRestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GftbanckRestserviceApplication.class, args);
	}

}
