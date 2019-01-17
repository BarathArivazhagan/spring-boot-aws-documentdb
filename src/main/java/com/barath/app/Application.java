package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		 System.setProperty ("javax.net.ssl.keyStore","rds-combined-ca-bundle.pem");
		SpringApplication.run(Application.class, args);
	}

}

