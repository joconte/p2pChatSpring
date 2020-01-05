package fr.epsi.jconte.p2pChatSpring.dto;

public class Signature {

    private String plainText;

    private String signedText;

    public Signature(String plainText, String signedText) {
        this.plainText = plainText;
        this.signedText = signedText;
    }

    public Signature() {}

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getSignedText() {
        return signedText;
    }

    public void setSignedText(String signedText) {
        this.signedText = signedText;
    }
}
