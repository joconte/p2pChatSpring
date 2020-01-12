package fr.epsi.jconte.p2pchat.controller.front;

import fr.epsi.jconte.p2pchat.dto.SendMessageFrontToBack;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat/send")
public interface ISendMessageController {

    /**
     * Permet d'envoyer un message à un autre pair.
     * @param sendMessageFrontToBack
     * @throws Exception
     */
    @PostMapping
    void sendMessage(@RequestBody SendMessageFrontToBack sendMessageFrontToBack) throws Exception;
}
