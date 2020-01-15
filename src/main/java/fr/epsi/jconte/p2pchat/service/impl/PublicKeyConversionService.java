package fr.epsi.jconte.p2pchat.service.impl;

import fr.epsi.jconte.p2pchat.service.IPublicKeyConversionService;
import org.springframework.stereotype.Service;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class PublicKeyConversionService implements IPublicKeyConversionService {

    @Override
    public PublicKey getPublicKey(String key){
        try{
            byte[] byteKey = Base64.getDecoder().decode(key.getBytes());
            X509EncodedKeySpec X509PUBLICKEY = new X509EncodedKeySpec(byteKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");

            return kf.generatePublic(X509PUBLICKEY);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getBase64(PublicKey publicKey) {
        byte[] encodedPublicKey = publicKey.getEncoded();
        return Base64.getEncoder().encodeToString(encodedPublicKey);
    }
}
