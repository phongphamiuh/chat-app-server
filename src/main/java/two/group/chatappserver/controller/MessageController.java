package two.group.chatappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.group.chatappserver.entity.Message;
import two.group.chatappserver.entity.Person;
import two.group.chatappserver.repository.MessageRepository;
import two.group.chatappserver.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/messages")
@CrossOrigin("*")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping
    public Message save(@RequestBody Message message){
        return messageRepository.save(message);
    }

    @GetMapping
    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    @GetMapping("/{uid}/{friendId}")
    public List<Message> findAllMessage(@PathVariable String uid, @PathVariable String friendId){
        return messageRepository.getAllMessage(uid,friendId);
    }
}
