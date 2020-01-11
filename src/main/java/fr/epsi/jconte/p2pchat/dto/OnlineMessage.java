package fr.epsi.jconte.p2pchat.dto;

public class OnlineMessage {

    private Signature signature;

    private String publicKeyBase64;

    public OnlineMessage(Signature signature, String publicKeyBase64) {
        this.signature = signature;
        this.publicKeyBase64 = publicKeyBase64;
    }

    public OnlineMessage() {}

    public Signature getSignature() {
        return signature;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public String getPublicKeyBase64() {
        return publicKeyBase64;
    }

    public void setPublicKeyBase64(String publicKeyBase64) {
        this.publicKeyBase64 = publicKeyBase64;
    }
}
