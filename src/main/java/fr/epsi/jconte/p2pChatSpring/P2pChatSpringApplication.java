package fr.epsi.jconte.p2pChatSpring;

import fr.epsi.jconte.p2pChatSpring.service.GetPrivateKeyService;
import fr.epsi.jconte.p2pChatSpring.utility.CreateRSAKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.PrivateKey;

@SpringBootApplication
public class P2pChatSpringApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(P2pChatSpringApplication.class, args);

		//CreateRSAKeys.create(2048, "secret");
	}

}
