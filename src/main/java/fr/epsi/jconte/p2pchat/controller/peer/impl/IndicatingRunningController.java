package fr.epsi.jconte.p2pchat.controller.peer.impl;

import fr.epsi.jconte.p2pchat.controller.peer.IIndicatingRunningController;
import fr.epsi.jconte.p2pchat.dto.OnlineMessage;
import fr.epsi.jconte.p2pchat.dto.Signature;
import fr.epsi.jconte.p2pchat.service.IGetPrivateKeyService;
import fr.epsi.jconte.p2pchat.service.IGetPublicKeyService;
import fr.epsi.jconte.p2pchat.service.IPublicKeyConversionService;
import fr.epsi.jconte.p2pchat.service.ISignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

@RestController
public class IndicatingRunningController implements IIndicatingRunningController {

    @Autowired
    private ISignService signService;

    @Autowired
    private IGetPrivateKeyService getPrivateKeyService;

    @Autowired
    private IGetPublicKeyService getPublicKeyService;

    @Autowired
    private IPublicKeyConversionService publicKeyConversionService;

    @Override
    public OnlineMessage online() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SignatureException, InvalidKeyException {

        String signedMessage = signService.signString("online", getPrivateKeyService.getPrivateKeyFromResource("secret.key"));
        Signature signature = new Signature("online", signedMessage);
        return new OnlineMessage(signature, publicKeyConversionService.getBase64(getPublicKeyService.getPublicKeyFromResource("secret.pub")));
    }
}
