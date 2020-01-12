package fr.epsi.jconte.p2pchat.controller.front;

import fr.epsi.jconte.p2pchat.dto.PersonIdAndName;
import fr.epsi.jconte.p2pchat.model.Personne;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/chat/persons")
public interface IPersonController {

    @PostMapping
    @RequestMapping("/change-name")
    void changeName(@RequestBody PersonIdAndName personIdAndName);

    @GetMapping
    List<Personne> getAllPersons();
}
