package hm.projekty.kombajn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "hm.projekty.kombajn.model")
@EnableJpaRepositories("hm.projekty.kombajn.repository")
@ComponentScan(basePackages = {"hm.projekty.kombajn.serwis","hm.projekty.kombajn.controller","hm.projekty.kombajn.app"})
@EnableAutoConfiguration


public class KombajnApplication {

	public static void main(String[] args) {
		SpringApplication.run(KombajnApplication.class, args);
	}

}
