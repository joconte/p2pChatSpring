package fr.epsi.jconte.p2pchat.service;

import java.security.PrivateKey;

public interface IDecryptService {

    String decryptString(String cipherText, PrivateKey privateKey) throws Exception;
}
