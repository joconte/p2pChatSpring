package fr.epsi.jconte.p2pchat.controller.front.impl;

import fr.epsi.jconte.p2pchat.controller.front.IConversationController;
import fr.epsi.jconte.p2pchat.model.Message;
import fr.epsi.jconte.p2pchat.repository.MessageRepository;
import fr.epsi.jconte.p2pchat.service.impl.DecryptService;
import fr.epsi.jconte.p2pchat.service.impl.GetPrivateKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConversationController implements IConversationController {

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
