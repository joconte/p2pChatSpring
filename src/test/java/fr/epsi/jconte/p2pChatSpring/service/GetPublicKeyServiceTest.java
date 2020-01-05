package fr.epsi.jconte.p2pChatSpring.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.*;

class GetPublicKeyServiceTest {

    private GetPublicKeyService getPublicKeyService = new GetPublicKeyService();

    @Test
    void getPublicKeyFromResource() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {

        PublicKey publicKey = getPublicKeyService.getPublicKeyFromResource("secret.pub");

        assertNotNull(publicKey);
    }
}