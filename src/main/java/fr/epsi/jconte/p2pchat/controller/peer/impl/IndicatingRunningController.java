package fr.epsi.jconte.p2pchat.controller.peer.impl;

import fr.epsi.jconte.p2pchat.controller.peer.IIndicatingRunningController;
import fr.epsi.jconte.p2pchat.dto.OnlineMessage;
import fr.epsi.jconte.p2pchat.dto.Signature;
import fr.epsi.jconte.p2pchat.service.impl.GetPrivateKeyService;
import fr.epsi.jconte.p2pchat.service.impl.GetPublicKeyService;
import fr.epsi.jconte.p2pchat.service.impl.PublicKeyConversionService;
import fr.epsi.jconte.p2pchat.service.impl.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndicatingRunningController implements IIndicatingRunningController {

    @Autowired
    private SignService signService;

    @Autowired
    private GetPrivateKeyService getPrivateKeyService;

    @Autowired
    private GetPublicKeyService getPublicKeyService;

    @Autowired
    private PublicKeyConversionService publicKeyConversionService;

    @Override
    public OnlineMessage online() throws Exception {

        String signedMessage = signService.signString("online", getPrivateKeyService.getPrivateKeyFromResource("secret.key"));
        Signature signature = new Signature("online", signedMessage);
        OnlineMessage onlineMessage = new OnlineMessage(signature, publicKeyConversionService.getBase64(getPublicKeyService.getPublicKeyFromResource("secret.pub")));
        return onlineMessage;
    }
}
