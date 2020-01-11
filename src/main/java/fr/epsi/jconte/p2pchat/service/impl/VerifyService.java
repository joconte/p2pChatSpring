package fr.epsi.jconte.p2pchat.service.impl;

import fr.epsi.jconte.p2pchat.service.IVerifyService;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class VerifyService implements IVerifyService {

    @Override
    public boolean verifyString(String plainText, String signature, PublicKey publicKey) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(publicKey);
        publicSignature.update(plainText.getBytes(UTF_8));

        byte[] signatureBytes = Base64.getDecoder().decode(signature);

        return publicSignature.verify(signatureBytes);
    }
}
