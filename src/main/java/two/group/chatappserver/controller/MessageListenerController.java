package two.group.chatappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.group.chatappserver.entity.MessageListener;
import two.group.chatappserver.entity.Person;
import two.group.chatappserver.repository.MessageListenerRepository;

import java.util.List;

@RestController
@RequestMapping("/messagesltn")
@CrossOrigin("*")
public class MessageListenerController {
    @Autowired
    private MessageListenerRepository messageListenerRepository;

    @PostMapping
    public MessageListener save(@RequestBody MessageListener message){
        return messageListenerRepository.save(message);
    }

    @GetMapping
    public List<MessageListener> findAll(){
        return messageListenerRepository.findAll();
    }

    @GetMapping("/{id}")
    public MessageListener findById(@PathVariable(value = "id") String id){
        return messageListenerRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id){
        messageListenerRepository.delete(id);
    }
}
