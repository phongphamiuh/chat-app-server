package two.group.chatappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.group.chatappserver.entity.Conversation;
import two.group.chatappserver.repository.ConversationRepository;
import java.util.List;

@RestController
@RequestMapping("/conversations")
@CrossOrigin("*")
public class ConversationController {

    @Autowired
    private ConversationRepository conversationRepository;

    @PostMapping
    public Conversation save(@RequestBody Conversation conversation){
        return conversationRepository.save(conversation);
    }

    @GetMapping
    public List<Conversation> findAll(){
        return conversationRepository.findAll();
    }

}

