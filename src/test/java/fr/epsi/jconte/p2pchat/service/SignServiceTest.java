package fr.epsi.jconte.p2pchat.service;

import fr.epsi.jconte.p2pchat.service.impl.GetPrivateKeyService;
import fr.epsi.jconte.p2pchat.service.impl.SignService;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;

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