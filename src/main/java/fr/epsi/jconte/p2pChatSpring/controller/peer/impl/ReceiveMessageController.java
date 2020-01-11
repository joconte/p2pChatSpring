package fr.epsi.jconte.p2pChatSpring.controller.peer.impl;

import fr.epsi.jconte.p2pChatSpring.controller.peer.ReceiveMessageApi;
import fr.epsi.jconte.p2pChatSpring.dto.IncomingMessage;
import fr.epsi.jconte.p2pChatSpring.model.Message;
import fr.epsi.jconte.p2pChatSpring.model.Personne;
import fr.epsi.jconte.p2pChatSpring.repository.MessageRepository;
import fr.epsi.jconte.p2pChatSpring.repository.PersonneRepository;
import fr.epsi.jconte.p2pChatSpring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class ReceiveMessageController implements ReceiveMessageApi {

    @Autowired
    private VerifyService verifyService;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private PublicKeyConversion publicKeyConversion;

    @Override
    public void receiveMessage(@RequestBody IncomingMessage incomingMessage) throws Exception {

        if (!verifyService.verifyString(incomingMessage.getSignature().getPlainText(), incomingMessage.getSignature().getSignedText(), publicKeyConversion.getPublicKey(incomingMessage.getPublicKeyBase64()))) {
            return;
        }

        Optional<Personne> optionalPersonne = personneRepository.findPersonneByClePublique(incomingMessage.getPublicKeyBase64());

        Personne personne;
        if (!optionalPersonne.isPresent()) {
            personne = new Personne("John Doe", incomingMessage.getPublicKeyBase64());
            personne = personneRepository.save(personne);
        } else {
            personne = optionalPersonne.get();
        }

        Message message = new Message(personne, incomingMessage.getMessageEncrypted(), new Date(), false);

        messageRepository.save(message);

    }


}
