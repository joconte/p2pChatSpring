package fr.epsi.jconte.p2pChatSpring.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

class SignServiceTest {

    private SignService signService = new SignService();

    @Test
    void signString() throws Exception {

        // TODO : mock this
        GetPrivateKeyService getPrivateKeyService = new GetPrivateKeyService();
        PrivateKey privateKey = getPrivateKeyService.getPrivateKeyFromResource("secret.key");

        String encrypted = signService.signString("test", privateKey);

        System.out.println(encrypted);
    }
}