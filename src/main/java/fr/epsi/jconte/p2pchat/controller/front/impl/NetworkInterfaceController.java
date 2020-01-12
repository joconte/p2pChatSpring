package fr.epsi.jconte.p2pchat.controller.front.impl;

import fr.epsi.jconte.p2pchat.controller.front.INetworkInterfaceController;
import fr.epsi.jconte.p2pchat.dto.NetworkAndAdress;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
public class NetworkInterfaceController implements INetworkInterfaceController {

    @Override
    public List<NetworkAndAdress> getNetwork() throws SocketException {

        // On initialise notre liste de réseau et d'adresses IP associées.
        List<NetworkAndAdress> networkAndAdresses = new ArrayList<>();

        // On récupère la liste de tous les réseaux disponibles de la machine.
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();

        // Pour chaque réseau disponible
        while (networkInterfaceEnumeration.hasMoreElements()) {

            // On le récupère dans une variable
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();

            List<String> adresses = new ArrayList<>();

            // On récupère la liste des adresses IP associés à ce réseau
            Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();

            // Pour chacune de ces adresses
            while (inetAddressEnumeration.hasMoreElements()) {

                InetAddress inetAddress = inetAddressEnumeration.nextElement();

                // Si l'adresse ne contient pas de '.' on passe à la suivante
                if (!inetAddress.getHostAddress().contains(".")) {
                    continue;
                }

                // On ajoute l'adresse IP à notre liste d'adresse associé au réseau en cours.
                adresses.add(inetAddress.getHostAddress());
            }

            // Si aucune adresses IP valide n'a été trouvée alors on passe au réseau suivant.
            if (adresses.isEmpty()) {
                continue;
            }

            // On contruit notre objet NetworkAndAdress et on lui renseigne le réseau et la liste d'adresse IP.
            NetworkAndAdress networkAndAdress = new NetworkAndAdress();
            networkAndAdress.setNetwork(networkInterface.getDisplayName());
            networkAndAdress.setAddresses(adresses);

            // On ajoute notre objet NetworkAndAdress à la liste.
            networkAndAdresses.add(networkAndAdress);
        }

        // On retourne notre liste de réseau et d'adresses IP associées.
        return networkAndAdresses;
    }
}
