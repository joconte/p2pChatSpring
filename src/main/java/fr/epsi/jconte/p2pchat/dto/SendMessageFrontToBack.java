package fr.epsi.jconte.p2pchat.dto;

public class SendMessageFrontToBack {

    private String signature;

    private String cleanMessage;

    private Long idPersonne;

    private String ipAdress;

    public SendMessageFrontToBack(String signature, String cleanMessage, Long idPersonne, String ipAdress) {
        this.signature = signature;
        this.cleanMessage = cleanMessage;
        this.idPersonne = idPersonne;
        this.ipAdress = ipAdress;
    }

    public SendMessageFrontToBack() {}

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCleanMessage() {
        return cleanMessage;
    }

    public void setCleanMessage(String cleanMessage) {
        this.cleanMessage = cleanMessage;
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }
}
