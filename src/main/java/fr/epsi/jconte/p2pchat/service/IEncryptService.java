package fr.epsi.jconte.p2pchat.service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public interface IEncryptService {

    /**
     * Permet de chiffrer une chaine de caractère avec une clé publique.
     * Retourne la chaine de caractère chiffrée.
     * @param plainText
     * @param publicKey
     * @return
     * @throws Exception
     */
    String encryptString(String plainText, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;
}
