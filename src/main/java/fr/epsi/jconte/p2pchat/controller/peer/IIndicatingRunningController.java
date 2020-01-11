package fr.epsi.jconte.p2pchat.controller.peer;

import fr.epsi.jconte.p2pchat.dto.OnlineMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chat/online")
public interface IIndicatingRunningController {

    @GetMapping
    OnlineMessage online() throws Exception;
}

