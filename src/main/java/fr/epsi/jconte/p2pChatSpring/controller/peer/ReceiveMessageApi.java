package fr.epsi.jconte.p2pChatSpring.controller.peer;


import fr.epsi.jconte.p2pChatSpring.dto.IncomingMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat/receive")
public interface ReceiveMessageApi {

    @PostMapping
    void receiveMessage(@RequestBody IncomingMessage incomingMessage) throws Exception;
}
