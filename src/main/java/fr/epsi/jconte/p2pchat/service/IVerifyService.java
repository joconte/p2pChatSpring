package fr.epsi.jconte.p2pchat.service;

import java.security.PublicKey;

public interface IVerifyService {

    boolean verifyString(String plainText, String signature, PublicKey publicKey) throws Exception;
}
