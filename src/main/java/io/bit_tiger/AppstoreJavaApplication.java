package io.bit_tiger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("spring-config.xml")
public class AppstoreJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppstoreJavaApplication.class, args);
	}
}
