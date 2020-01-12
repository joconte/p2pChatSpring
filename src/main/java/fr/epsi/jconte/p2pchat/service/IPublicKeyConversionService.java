package fr.epsi.jconte.p2pchat.service;

import java.security.PublicKey;

public interface IPublicKeyConversionService {

    /**
     * Permet de transformer une clé pulique sous la forme d'une chaine de caractère en objet de type 'PublicKey'.
     * @param key
     * @return
     */
    PublicKey getPublicKey(String key);

    /**
     * Permet de transformer une clé publique sous la forme d'un objet de type 'PublicKey' en chaine de caractère.
     * @param publicKey
     * @return
     */
    String getBase64(PublicKey publicKey);
}
