package fr.epsi.jconte.p2pchat.controller.peer;


import fr.epsi.jconte.p2pchat.dto.IncomingMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat/receive")
public interface IReceiveMessageController {

    @PostMapping
    void receiveMessage(@RequestBody IncomingMessage incomingMessage) throws Exception;
}
