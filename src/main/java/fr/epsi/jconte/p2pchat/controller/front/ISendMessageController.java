package fr.epsi.jconte.p2pchat.controller.front;

import fr.epsi.jconte.p2pchat.dto.SendMessageFrontToBack;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

@RequestMapping("/chat/send")
public interface ISendMessageController {

    /**
     * Permet d'envoyer un message à un autre pair.
     * @param sendMessageFrontToBack
     * @throws Exception
     */
    @PostMapping
    void sendMessage(@RequestBody SendMessageFrontToBack sendMessageFrontToBack) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SignatureException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException;
}
