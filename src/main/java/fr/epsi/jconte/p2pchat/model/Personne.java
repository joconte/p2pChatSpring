package fr.epsi.jconte.p2pchat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Personne {

    @Id
    @GeneratedValue
    private Long id;

    private String pseudo;

    @Column(columnDefinition="text")
    private String clePublique;

    public Personne(String pseudo, String clePublique) {
        this.pseudo = pseudo;
        this.clePublique = clePublique;
    }

    public Personne() {}

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getClePublique() {
        return clePublique;
    }

    public void setClePublique(String clePublique) {
        this.clePublique = clePublique;
    }
}
