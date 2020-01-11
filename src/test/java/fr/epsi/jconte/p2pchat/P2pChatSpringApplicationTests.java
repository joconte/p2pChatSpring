package fr.epsi.jconte.p2pchat;

import fr.epsi.jconte.p2pchat.service.*;
import fr.epsi.jconte.p2pchat.service.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class P2pChatSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void fullTest() throws Exception {

		GetPrivateKeyService getPrivateKeyService = new GetPrivateKeyService();
		GetPublicKeyService getPublicKeyService = new GetPublicKeyService();
		DecryptService decryptService = new DecryptService();
		EncryptService encryptService = new EncryptService();
		SignService signService = new SignService();
		VerifyService verifyService = new VerifyService();

		//First generate a public/private key pair
		KeyPair pair1 = generateKeyPair();
		KeyPair pair2 = generateKeyPair();

		//Our secret message
		String message = "the answer to life the universe and everything";

		// Signature
		String foobar = "foobar";
		String signature = signService.signString(foobar, pair1.getPrivate());

		// Encrypt with the other person public key
		String cipherText = encryptService.encryptString(message, pair2.getPublic());

		//Now decrypt it
		String decipheredMessage = decryptService.decryptString(cipherText, pair2.getPrivate());
		boolean verify = verifyService.verifyString(foobar, signature, pair1.getPublic());

		assertEquals(message, decipheredMessage);
		assertTrue(verify);
	}

	private KeyPair generateKeyPair() throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(2048, new SecureRandom());
		KeyPair pair = generator.generateKeyPair();

		return pair;
	}

}
