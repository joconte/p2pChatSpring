package fr.epsi.jconte.p2pChatSpring.controller.front;

import fr.epsi.jconte.p2pChatSpring.dto.SendMessageFrontToBack;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat/send")
public interface SendMessageApi {

    @PostMapping
    void sendMessage(@RequestBody SendMessageFrontToBack sendMessageFrontToBack) throws Exception;
}
