package two.group.chatappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import two.group.chatappserver.entity.Friend;
import two.group.chatappserver.entity.Person;
import two.group.chatappserver.entity.User;
import two.group.chatappserver.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable(value = "id") String id){
        return userRepository.findById(id);
    }

    @GetMapping("/{id}/friends")
    public List<Friend> getAllFriendsById(@PathVariable(value = "id") String id){
        return userRepository.getListFriendsById(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userRepository.save(user);
    }


    @PostMapping("/{id}/friends")
    public User saveFriend(@RequestBody Friend friend,@PathVariable String id){
        return userRepository.saveFriends(id,friend);
    }

    @GetMapping("/{id}/{idFriend}/friends")
    public User addFriend(@PathVariable String idFriend,@PathVariable String id){
        return userRepository.addFriends(id,idFriend);
    }
}
