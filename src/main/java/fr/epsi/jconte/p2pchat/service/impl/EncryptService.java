package fr.epsi.jconte.p2pchat.service.impl;

import fr.epsi.jconte.p2pchat.service.IEncryptService;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class EncryptService implements IEncryptService {

    @Override
    public String encryptString(String plainText, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));

        return Base64.getEncoder().encodeToString(cipherText);
    }
}
