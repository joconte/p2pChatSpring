package fr.epsi.jconte.p2pchat.service;

import java.security.PrivateKey;

public interface ISignService {

    /**
     * Permet de signer une chaine de caractère avec une clé privée.
     * @param plainText
     * @param privateKey
     * @return
     * @throws Exception
     */
    String signString(String plainText, PrivateKey privateKey) throws Exception;
}
