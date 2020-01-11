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
        List<NetworkAndAdress> networkAndAdresses = new ArrayList<>();
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaceEnumeration.hasMoreElements()) {
            NetworkAndAdress networkAndAdress = new NetworkAndAdress();
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            networkAndAdress.setNetwork(networkInterface.getDisplayName());

            List<String> adresses = new ArrayList<>();
            Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
            while (inetAddressEnumeration.hasMoreElements()) {
                InetAddress inetAddress = inetAddressEnumeration.nextElement();
                if (!inetAddress.getHostAddress().contains(".")) {
                    continue;
                }
                adresses.add(inetAddress.getHostAddress());
            }
            networkAndAdress.setAddresses(adresses);
            if (networkAndAdress.getAddresses().isEmpty()) {
                continue;
            }
            networkAndAdresses.add(networkAndAdress);
        }
        return networkAndAdresses;
    }
}
