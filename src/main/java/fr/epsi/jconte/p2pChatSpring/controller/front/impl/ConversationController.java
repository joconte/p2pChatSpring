package fr.epsi.jconte.p2pChatSpring.controller.front.impl;

import fr.epsi.jconte.p2pChatSpring.controller.front.ConversationApi;
import fr.epsi.jconte.p2pChatSpring.model.Message;
import fr.epsi.jconte.p2pChatSpring.repository.MessageRepository;
import fr.epsi.jconte.p2pChatSpring.repository.PersonneRepository;
import fr.epsi.jconte.p2pChatSpring.service.DecryptService;
import fr.epsi.jconte.p2pChatSpring.service.GetPrivateKeyService;
import fr.epsi.jconte.p2pChatSpring.service.PublicKeyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConversationController implements ConversationApi {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private DecryptService decryptService;

    @Autowired
    private GetPrivateKeyService getPrivateKeyService;

    @Override
    public List<Message> getCleanMessageFromPersonne(@PathVariable Long idPersonne) throws Exception {

        List<Message> cleanMessages = new ArrayList<>();
        List<Message> encryptedMessages = messageRepository.findAllByPersonne_Id(idPersonne);

        for (Message encryptedMessage : encryptedMessages) {
            encryptedMessage.setContenu(decryptService.decryptString(encryptedMessage.getContenu(), getPrivateKeyService.getPrivateKeyFromResource("secret.key")));
            cleanMessages.add(encryptedMessage);
        }
        return cleanMessages;
    }
}
