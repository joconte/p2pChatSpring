package fr.epsi.jconte.p2pchat.service;

import java.security.PrivateKey;

public interface ISignService {

    String signString(String plainText, PrivateKey privateKey) throws Exception;
}
