package hu.hunszasz.example.spring.springjackson;

import hu.hunszasz.example.spring.springjackson.config.TestAppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Import(TestAppConfiguration.class)
@EnableConfigurationProperties
@EnableWebMvc
public class SpringJacksonDemoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJacksonDemoConfigApplication.class, args);
	}

}
