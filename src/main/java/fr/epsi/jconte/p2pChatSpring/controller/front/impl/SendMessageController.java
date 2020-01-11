package fr.epsi.jconte.p2pChatSpring.controller.front.impl;

import fr.epsi.jconte.p2pChatSpring.controller.front.SendMessageApi;
import fr.epsi.jconte.p2pChatSpring.dto.IncomingMessage;
import fr.epsi.jconte.p2pChatSpring.dto.SendMessageFrontToBack;
import fr.epsi.jconte.p2pChatSpring.dto.Signature;
import fr.epsi.jconte.p2pChatSpring.model.Message;
import fr.epsi.jconte.p2pChatSpring.model.Personne;
import fr.epsi.jconte.p2pChatSpring.repository.MessageRepository;
import fr.epsi.jconte.p2pChatSpring.repository.PersonneRepository;
import fr.epsi.jconte.p2pChatSpring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;

@RestController
public class SendMessageController implements SendMessageApi {

    @Autowired
    private SignService signService;

    @Autowired
    private GetPrivateKeyService getPrivateKeyService;

    @Autowired
    private GetPublicKeyService getPublicKeyService;

    @Autowired
    private EncryptService encryptService;

    @Autowired
    private PublicKeyConversion publicKeyConversion;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void sendMessage(@RequestBody SendMessageFrontToBack sendMessageFrontToBack) throws Exception {

        IncomingMessage incomingMessage = new IncomingMessage();

        Signature signature = new Signature(sendMessageFrontToBack.getSignature(), signService.signString(sendMessageFrontToBack.getSignature(), getPrivateKeyService.getPrivateKeyFromResource("secret.key")));

        incomingMessage.setSignature(signature);

        Optional<Personne> optionalPersonne = personneRepository.findById(sendMessageFrontToBack.getIdPersonne());

        if (!optionalPersonne.isPresent()) {
            return;
        }

        Personne personne = optionalPersonne.get();

        String base64PublicKey = personne.getClePublique();

        String encryptedMessage = encryptService.encryptString(sendMessageFrontToBack.getCleanMessage(), publicKeyConversion.getPublicKey(base64PublicKey));

        incomingMessage.setMessageEncrypted(encryptedMessage);

        incomingMessage.setPublicKeyBase64(publicKeyConversion.getBase64(getPublicKeyService.getPublicKeyFromResource("secret.pub")));

        final String uri = "http://" + sendMessageFrontToBack.getIpAdress() + ":8080/chat/receive";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, incomingMessage, String.class);

        System.out.println(result);

        String encryptedMessageForMe = encryptService.encryptString(sendMessageFrontToBack.getCleanMessage(), getPublicKeyService.getPublicKeyFromResource("secret.pub"));

        Message message = new Message(personne, encryptedMessageForMe, new Date(), true);

        messageRepository.save(message);

    }
}
