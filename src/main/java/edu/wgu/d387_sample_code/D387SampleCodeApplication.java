package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		ThreadClass threadOne = new ThreadClass("translation_fr_CA.properties");
		threadOne.start();

		ThreadClass threadTwo = new ThreadClass("translation_en_US.properties");
		threadTwo.start();


	}
}