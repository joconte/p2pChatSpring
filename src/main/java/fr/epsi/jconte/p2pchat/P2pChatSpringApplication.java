package fr.epsi.jconte.p2pchat;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P2pChatSpringApplication {

	public static void main(String[] args) {

		BasicConfigurator.configure();

		SpringApplication.run(P2pChatSpringApplication.class, args);
	}

}
