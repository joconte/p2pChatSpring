package fr.epsi.jconte.p2pchat.service.impl;

import fr.epsi.jconte.p2pchat.service.ISignService;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class SignService implements ISignService {

    @Override
    public String signString(String plainText, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(UTF_8));

        byte[] signature = privateSignature.sign();

        return Base64.getEncoder().encodeToString(signature);
    }
}
