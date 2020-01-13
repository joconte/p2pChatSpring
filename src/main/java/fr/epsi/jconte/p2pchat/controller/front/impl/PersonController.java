package fr.epsi.jconte.p2pchat.controller.front.impl;

import fr.epsi.jconte.p2pchat.controller.front.IPersonController;
import fr.epsi.jconte.p2pchat.dto.PersonIdAndName;
import fr.epsi.jconte.p2pchat.model.Personne;
import fr.epsi.jconte.p2pchat.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController implements IPersonController {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public void changeName(@RequestBody PersonIdAndName personIdAndName) {

        Optional<Personne> optionalPersonne = personneRepository.findById(personIdAndName.getId());

        if (!optionalPersonne.isPresent()) {
            return;
        }

        if (personIdAndName.getName() == null || personIdAndName.getName().isEmpty()) {
            return;
        }

        Personne personne = optionalPersonne.get();
        personne.setPseudo(personIdAndName.getName());
        personneRepository.save(personne);
    }

    @Override
    public List<Personne> getAllPersons() {
        return this.personneRepository.findAll();
    }
}
