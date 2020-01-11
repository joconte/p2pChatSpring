package fr.epsi.jconte.p2pchat.dto;

public class IncomingMessage {

    private Signature signature;

    private String messageEncrypted;

    private String publicKeyBase64;

    public IncomingMessage(Signature signature, String messageEncrypted, String publicKeyBase64) {
        this.signature = signature;
        this.messageEncrypted = messageEncrypted;
        this.publicKeyBase64 = publicKeyBase64;
    }

    public IncomingMessage() {}

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public String getMessageEncrypted() {
        return messageEncrypted;
    }

    public void setMessageEncrypted(String messageEncrypted) {
        this.messageEncrypted = messageEncrypted;
    }

    public String getPublicKeyBase64() {
        return publicKeyBase64;
    }

    public void setPublicKeyBase64(String publicKeyBase64) {
        this.publicKeyBase64 = publicKeyBase64;
    }
}
