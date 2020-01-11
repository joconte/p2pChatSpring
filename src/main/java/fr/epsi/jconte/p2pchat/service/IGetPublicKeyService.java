package fr.epsi.jconte.p2pchat.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public interface IGetPublicKeyService {

    PublicKey getPublicKeyFromResource(String fileName) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
}
