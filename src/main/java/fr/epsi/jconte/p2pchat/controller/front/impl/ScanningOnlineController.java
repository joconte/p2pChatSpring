package fr.epsi.jconte.p2pchat.controller.front.impl;

import fr.epsi.jconte.p2pchat.controller.front.IScanningOnlineController;
import fr.epsi.jconte.p2pchat.dto.NetworkAndAdressChoice;
import fr.epsi.jconte.p2pchat.dto.OnlineMessage;
import fr.epsi.jconte.p2pchat.dto.PersonneWithIpAdress;
import fr.epsi.jconte.p2pchat.model.Personne;
import fr.epsi.jconte.p2pchat.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@RestController
public class ScanningOnlineController implements IScanningOnlineController {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public List<PersonneWithIpAdress> scan(@RequestBody NetworkAndAdressChoice networkAndAdressChoice) throws SocketException, UnknownHostException {

        List<PersonneWithIpAdress> personnes = new ArrayList<>();

        InetAddress myInetAddress = getInetAddressFrom(networkAndAdressChoice);

        List<InetAddress> inetAddresses = getNetworkIPs(8080, myInetAddress);

        for (InetAddress inetAddress : inetAddresses) {

            final String uri = "http://" + inetAddress.getHostAddress() + ":8080/chat/online";

            RestTemplate restTemplate = new RestTemplate();
            OnlineMessage result = restTemplate.getForObject(uri, OnlineMessage.class);

            Optional<Personne> optionalPersonne = personneRepository.findPersonneByClePublique(result.getPublicKeyBase64());

            PersonneWithIpAdress personneWithIpAdress = new PersonneWithIpAdress();
            Personne personne;
            if (!optionalPersonne.isPresent()) {
                personne = new Personne("John Doe", result.getPublicKeyBase64());
                personne = personneRepository.save(personne);
            } else {
                personne = optionalPersonne.get();
            }
            personneWithIpAdress.setPersonne(personne);
            personneWithIpAdress.setIpAdress(inetAddress.getHostAddress());
            personnes.add(personneWithIpAdress);
        }
        return personnes;
    }

    private List<InetAddress> getNetworkIPs(final int port, final InetAddress myIp) throws SocketException {

        final List<InetAddress> inetAddresses = new ArrayList<>();
        final byte[] ip = myIp.getAddress();

        for(int i=1;i<=254;i++) {
            final int j = i;  // i as non-final variable cannot be referenced from inner class
            new Thread(new Runnable() {   // new thread for parallel execution
                public void run() {
                    try {

                        ip[3] = (byte)j;
                        InetAddress address = InetAddress.getByAddress(ip);

                        // If my ip address I ignore it
                        if (address.equals(myIp))
                          return;

                        try (Socket sock = new Socket();) {
                            SocketAddress sockaddr = new InetSocketAddress(address, port);
                            // Create an unbound socket

                            // This method will block no more than timeoutMs.
                            // If the timeout occurs, SocketTimeoutException is thrown.
                            int timeoutMs = 2000;   // 2 seconds
                            sock.connect(sockaddr, timeoutMs);
                            inetAddresses.add(address);
                        } catch(IOException e) {
                            // Handle exception
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();     // dont forget to start the thread
        }
        return inetAddresses;
    }

    private InetAddress getInetAddressFrom(NetworkAndAdressChoice networkAndAdressChoice) throws UnknownHostException, SocketException {

        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaceEnumeration.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            if (!networkInterface.getDisplayName().equals(networkAndAdressChoice.getNetworkName())) {
                continue;
            }

            Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();

            while (inetAddressEnumeration.hasMoreElements()) {
                InetAddress inetAddress = inetAddressEnumeration.nextElement();
                if (!inetAddress.getHostAddress().equals(networkAndAdressChoice.getIpAddress())) {
                    continue;
                }

                return inetAddress;
            }
        }
        return null;
    }
}
