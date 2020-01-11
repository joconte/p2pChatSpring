package fr.epsi.jconte.p2pchat.dto;

import java.util.List;

public class NetworkAndAdress {

    private String network;

    private List<String> addresses;

    public NetworkAndAdress(String network, List<String> addresses) {
        this.network = network;
        this.addresses = addresses;
    }

    public NetworkAndAdress() {}

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
