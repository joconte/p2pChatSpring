package fr.epsi.jconte.p2pChatSpring.controller.front;

import fr.epsi.jconte.p2pChatSpring.dto.NetworkAndAdress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.SocketException;
import java.util.List;

@RequestMapping("/chat/network")
public interface NetworkInterfaceApi {

    @GetMapping
    List<NetworkAndAdress> getNetwork() throws SocketException;
}
