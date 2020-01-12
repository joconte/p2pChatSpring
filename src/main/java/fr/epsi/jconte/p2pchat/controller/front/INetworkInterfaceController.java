package fr.epsi.jconte.p2pchat.controller.front;

import fr.epsi.jconte.p2pchat.dto.NetworkAndAdress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.SocketException;
import java.util.List;

@RequestMapping("/chat/network")
public interface INetworkInterfaceController {

    /**
     * Permet de retourner la liste des différents réseaux disponibles.
     * @return
     * @throws SocketException
     */
    @GetMapping
    List<NetworkAndAdress> getNetwork() throws SocketException;
}
