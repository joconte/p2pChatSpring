package fr.epsi.jconte.p2pchat.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;

public interface IVerifyService {

    /**
     * Permet de vérifier une signature à l'aide du texte non chiffré, du texte chiffré et de la clé publique.
     * @param plainText
     * @param signature
     * @param publicKey
     * @return
     * @throws Exception
     */
    boolean verifyString(String plainText, String signature, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
}
