package fr.epsi.jconte.p2pchat.service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public interface IDecryptService {

    /**
     * Permet de déchiffrer une chaine de caractère à l'aide d'une clé privée.
     * Retourne la chaine de caractère déchiffrée.
     * @param cipherText
     * @param privateKey
     * @return
     * @throws Exception
     */
    String decryptString(String cipherText, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException;
}
