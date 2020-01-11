package fr.epsi.jconte.p2pchat.dto;

public class NetworkAndAdressChoice {

    private String networkName;

    private String ipAddress;

    public NetworkAndAdressChoice(String networkName, String ipAddress) {
        this.networkName = networkName;
        this.ipAddress = ipAddress;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
