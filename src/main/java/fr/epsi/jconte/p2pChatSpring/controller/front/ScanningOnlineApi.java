package fr.epsi.jconte.p2pChatSpring.controller.front;

import fr.epsi.jconte.p2pChatSpring.dto.NetworkAndAdressChoice;
import fr.epsi.jconte.p2pChatSpring.dto.PersonneWithIpAdress;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

@RequestMapping("/chat/scan")
public interface ScanningOnlineApi {

    @PostMapping
    List<PersonneWithIpAdress> scan(@RequestBody NetworkAndAdressChoice networkAndAdressChoice) throws SocketException, UnknownHostException;
}