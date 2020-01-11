package fr.epsi.jconte.p2pchat.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

public interface IGetPrivateKeyService {

    PrivateKey getPrivateKeyFromResource(String fileName) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
}
