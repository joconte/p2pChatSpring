package fr.epsi.jconte.p2pchat.dto;

public class PersonIdAndName {

    private Long id;

    private String name;

    public PersonIdAndName(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonIdAndName() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
