package fr.epsi.jconte.p2pchat.service.impl;

import fr.epsi.jconte.p2pchat.service.IGetPrivateKeyService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

@Service
public class GetPrivateKeyService implements IGetPrivateKeyService {

    @Override
    public PrivateKey getPrivateKeyFromResource(String fileName) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
        File file = ResourceUtils.getFile("classpath:" + fileName);
        /* Read the private key bytes */
        Path path = file.toPath();
        byte[] bytes = Files.readAllBytes(path);

        /* Generate private key. */
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pvt = kf.generatePrivate(ks);
        return pvt;
    }
}
