package fr.epsi.jconte.p2pChatSpring.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

import static org.junit.jupiter.api.Assertions.*;

class GetPrivateKeyServiceTest {

    private GetPrivateKeyService getPrivateKeyService = new GetPrivateKeyService();

    @Test
    void getPrivateKeyFromRessource() throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {

        PrivateKey privateKey = getPrivateKeyService.getPrivateKeyFromResource("secret.key");

        assertNotNull(privateKey);
    }
}