package com.coppel.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamenApplication {

	public static void main(String[] args) {
		try {
		SpringApplication.run(ExamenApplication.class, args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
