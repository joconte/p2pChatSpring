package fr.epsi.jconte.p2pchat.service.impl;

import fr.epsi.jconte.p2pchat.service.IDecryptService;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class DecryptService implements IDecryptService {

    @Override
    public String decryptString(String cipherText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(cipherText);

        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);

        return new String(decriptCipher.doFinal(bytes), UTF_8);
    }
}
