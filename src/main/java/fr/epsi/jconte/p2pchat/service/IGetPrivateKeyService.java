package fr.epsi.jconte.p2pchat.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

public interface IGetPrivateKeyService {

    /**
     * Permet de retourner une clé privée, par son nom de fichier, se trouvant dans le dossier 'resources' de l'application.
     * @param fileName
     * @return
     * @throws IOException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    PrivateKey getPrivateKeyFromResource(String fileName) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException;
}
