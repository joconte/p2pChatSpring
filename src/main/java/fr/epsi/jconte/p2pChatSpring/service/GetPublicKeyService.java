package fr.epsi.jconte.p2pChatSpring.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@Service
public class GetPublicKeyService {

    public PublicKey getPublicKeyFromResource(String fileName) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        File file = ResourceUtils.getFile("classpath:" + fileName);
        /* Read the public key bytes */
        Path path = file.toPath();
        byte[] bytes = Files.readAllBytes(path);

        /* Generate public key. */
        X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pub = kf.generatePublic(ks);

        return pub;
    }
}
