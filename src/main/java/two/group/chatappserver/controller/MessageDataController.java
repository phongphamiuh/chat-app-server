package two.group.chatappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.group.chatappserver.entity.Message;
import two.group.chatappserver.entity.Messages;
import two.group.chatappserver.entity.Person;
import two.group.chatappserver.repository.MessageDataRepository;
import two.group.chatappserver.repository.MessageRepository;

import java.util.List;

@RestController
@RequestMapping("/messagesdata")
@CrossOrigin("*")
public class MessageDataController {
    @Autowired
    private MessageDataRepository messageDataRepository;

    @GetMapping("/{id}")
    public List<Messages> findById(@PathVariable(value = "id") String id){
        return messageDataRepository.findById(id);
    }

    @PostMapping("/{chatRoomId}")
    public Messages save(@RequestBody Messages messages,@PathVariable String chatRoomId){
        return messageDataRepository.save(chatRoomId, messages);
    }
}
