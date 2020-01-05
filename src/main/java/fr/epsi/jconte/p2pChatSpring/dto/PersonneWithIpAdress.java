package fr.epsi.jconte.p2pChatSpring.dto;

import fr.epsi.jconte.p2pChatSpring.model.Personne;

public class PersonneWithIpAdress {

    private Personne personne;

    private String ipAdress;

    public PersonneWithIpAdress(Personne personne, String ipAdress) {
        this.personne = personne;
        this.ipAdress = ipAdress;
    }

    public PersonneWithIpAdress() {}

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }
}
