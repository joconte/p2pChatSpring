package fr.epsi.jconte.p2pchat.controller.peer;

import fr.epsi.jconte.p2pchat.dto.OnlineMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

@RequestMapping("/chat/online")
public interface IIndicatingRunningController {

    /**
     * Permet d'indiquer que l'on est en ligne si un autre pair effectue un scan du réseau.
     * @return
     * @throws Exception
     */
    @GetMapping
    OnlineMessage online() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SignatureException, InvalidKeyException;
}

