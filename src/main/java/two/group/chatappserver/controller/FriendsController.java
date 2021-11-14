package two.group.chatappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.group.chatappserver.entity.Friend;
import two.group.chatappserver.entity.Person;
import two.group.chatappserver.repository.FriendRepository;
import two.group.chatappserver.repository.MessageRepository;

import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin("*")
public class FriendsController {
    @Autowired
    private FriendRepository friendRepository;
    @GetMapping("/{id}")
    public List<Friend> findAll(@PathVariable(value = "id") String id){
        return friendRepository.findAll(id);
    }
}
