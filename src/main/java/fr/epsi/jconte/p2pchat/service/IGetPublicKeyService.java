package fr.epsi.jconte.p2pchat.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public interface IGetPublicKeyService {

    /**
     * Permet de retourner une clé publique, par son nom de fichier, se trouvant dans le dossier 'resources' de l'application.
     * @param fileName
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    PublicKey getPublicKeyFromResource(String fileName) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
}
