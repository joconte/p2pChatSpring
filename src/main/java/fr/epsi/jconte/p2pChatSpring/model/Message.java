package fr.epsi.jconte.p2pChatSpring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Personne personne;

    @Column(columnDefinition = "text")
    private String contenu;

    private Date date;

    private boolean myMessage;

    public Message(Personne personne, String contenu, Date date, boolean myMessage) {
        this.personne = personne;
        this.contenu = contenu;
        this.date = date;
        this.myMessage = myMessage;
    }

    public Message() {}

    public Long getId() {
        return id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isMyMessage() {
        return myMessage;
    }

    public void setMyMessage(boolean myMessage) {
        this.myMessage = myMessage;
    }
}
