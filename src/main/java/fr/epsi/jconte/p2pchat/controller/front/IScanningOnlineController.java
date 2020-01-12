package fr.epsi.jconte.p2pchat.controller.front;

import fr.epsi.jconte.p2pchat.dto.NetworkAndAdressChoice;
import fr.epsi.jconte.p2pchat.dto.PersonneWithIpAdress;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

@RequestMapping("/chat/scan")
public interface IScanningOnlineController {

    /**
     * Permet de scanner le réseau pour voir si un d'autre pairs sont connectés.
     * Retourne les pairs connectés s'il y en a.
     * @param networkAndAdressChoice
     * @return
     * @throws SocketException
     * @throws UnknownHostException
     */
    @PostMapping
    List<PersonneWithIpAdress> scan(@RequestBody NetworkAndAdressChoice networkAndAdressChoice) throws SocketException, UnknownHostException, InterruptedException;
}