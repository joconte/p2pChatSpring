package fr.epsi.jconte.p2pchat.controller.peer.impl;

import fr.epsi.jconte.p2pchat.controller.peer.IReceiveMessageController;
import fr.epsi.jconte.p2pchat.dto.IncomingMessage;
import fr.epsi.jconte.p2pchat.model.Message;
import fr.epsi.jconte.p2pchat.model.Personne;
import fr.epsi.jconte.p2pchat.repository.MessageRepository;
import fr.epsi.jconte.p2pchat.repository.PersonneRepository;
import fr.epsi.jconte.p2pchat.service.IPublicKeyConversionService;
import fr.epsi.jconte.p2pchat.service.IVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Date;
import java.util.Optional;

@RestController
public class ReceiveMessageController implements IReceiveMessageController {

    @Autowired
    private IVerifyService verifyService;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private IPublicKeyConversionService publicKeyConversionService;

    @Override
    public void receiveMessage(@RequestBody IncomingMessage incomingMessage) throws SignatureException, InvalidKeyException, NoSuchAlgorithmException {

        if (!verifyService.verifyString(incomingMessage.getSignature().getPlainText(), incomingMessage.getSignature().getSignedText(), publicKeyConversionService.getPublicKey(incomingMessage.getPublicKeyBase64()))) {
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
