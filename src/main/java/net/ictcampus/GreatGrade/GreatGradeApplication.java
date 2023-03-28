package net.ictcampus.GreatGrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GreatGradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatGradeApplication.class, args);
	}

}
