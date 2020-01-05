package fr.epsi.jconte.p2pChatSpring.controller.peer;

import fr.epsi.jconte.p2pChatSpring.dto.OnlineMessage;
import fr.epsi.jconte.p2pChatSpring.dto.Signature;
import fr.epsi.jconte.p2pChatSpring.service.GetPrivateKeyService;
import fr.epsi.jconte.p2pChatSpring.service.GetPublicKeyService;
import fr.epsi.jconte.p2pChatSpring.service.PublicKeyConversion;
import fr.epsi.jconte.p2pChatSpring.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/online")
public class IndicatingRunningController {

    @Autowired
    private SignService signService;

    @Autowired
    private GetPrivateKeyService getPrivateKeyService;

    @Autowired
    private GetPublicKeyService getPublicKeyService;

    @Autowired
    private PublicKeyConversion publicKeyConversion;

    @GetMapping
    public OnlineMessage online() throws Exception {

        String signedMessage = signService.signString("online", getPrivateKeyService.getPrivateKeyFromResource("secret.key"));
        Signature signature = new Signature("online", signedMessage);
        OnlineMessage onlineMessage = new OnlineMessage(signature, publicKeyConversion.getBase64(getPublicKeyService.getPublicKeyFromResource("secret.pub")));
        return onlineMessage;
    }
}
