package fr.epsi.jconte.p2pchat.service;

import java.security.PublicKey;

public interface IEncryptService {

    String encryptString(String plainText, PublicKey publicKey) throws Exception;
}
