
package main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RipoutApplication {

	private static final Logger log = LoggerFactory.getLogger(RipoutApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RipoutApplication.class, args);
	}
}
