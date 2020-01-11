package fr.epsi.jconte.p2pchat.controller.front.impl;

import fr.epsi.jconte.p2pchat.controller.front.ISendMessageController;
import fr.epsi.jconte.p2pchat.dto.IncomingMessage;
import fr.epsi.jconte.p2pchat.dto.SendMessageFrontToBack;
import fr.epsi.jconte.p2pchat.dto.Signature;
import fr.epsi.jconte.p2pchat.model.Message;
import fr.epsi.jconte.p2pchat.model.Personne;
import fr.epsi.jconte.p2pchat.repository.MessageRepository;
import fr.epsi.jconte.p2pchat.repository.PersonneRepository;
import fr.epsi.jconte.p2pchat.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;

@RestController
public class SendMessageController implements ISendMessageController {

    @Autowired
    private ISignService signService;

    @Autowired
    private IGetPrivateKeyService getPrivateKeyService;

    @Autowired
    private IGetPublicKeyService getPublicKeyService;

    @Autowired
    private IEncryptService encryptService;

    @Autowired
    private IPublicKeyConversionService publicKeyConversionService;

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

        String encryptedMessage = encryptService.encryptString(sendMessageFrontToBack.getCleanMessage(), publicKeyConversionService.getPublicKey(base64PublicKey));

        incomingMessage.setMessageEncrypted(encryptedMessage);

        incomingMessage.setPublicKeyBase64(publicKeyConversionService.getBase64(getPublicKeyService.getPublicKeyFromResource("secret.pub")));

        final String uri = "http://" + sendMessageFrontToBack.getIpAdress() + ":8080/chat/receive";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(uri, incomingMessage, String.class);

        System.out.println(result);

        String encryptedMessageForMe = encryptService.encryptString(sendMessageFrontToBack.getCleanMessage(), getPublicKeyService.getPublicKeyFromResource("secret.pub"));

        Message message = new Message(personne, encryptedMessageForMe, new Date(), true);

        messageRepository.save(message);

    }
}
