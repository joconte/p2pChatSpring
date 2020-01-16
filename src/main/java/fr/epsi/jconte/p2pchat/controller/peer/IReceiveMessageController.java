package fr.epsi.jconte.p2pchat.controller.peer;


import fr.epsi.jconte.p2pchat.dto.IncomingMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

@RequestMapping("/chat/receive")
public interface IReceiveMessageController {

    /**
     * Permet de recevoir les messages d'un autre pair.
     * @param incomingMessage
     * @throws Exception
     */
    @PostMapping
    void receiveMessage(@RequestBody IncomingMessage incomingMessage) throws SignatureException, InvalidKeyException, NoSuchAlgorithmException;
}
