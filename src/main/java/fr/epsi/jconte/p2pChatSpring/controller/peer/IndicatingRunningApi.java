package fr.epsi.jconte.p2pChatSpring.controller.peer;

import fr.epsi.jconte.p2pChatSpring.dto.OnlineMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat/online")
public interface IndicatingRunningApi {

    @GetMapping
    OnlineMessage online() throws Exception;
}

