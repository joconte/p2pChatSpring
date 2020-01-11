package fr.epsi.jconte.p2pchat.service;

import java.security.PublicKey;

public interface IPublicKeyConversionService {

    PublicKey getPublicKey(String key);

    String getBase64(PublicKey publicKey);
}
