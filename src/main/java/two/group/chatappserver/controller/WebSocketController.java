package two.group.chatappserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;
import java.util.Set;

@Controller
@CrossOrigin("*")
public class WebSocketController {
    private final SimpMessagingTemplate template;
    @Autowired private SimpUserRegistry simpUserRegistry;
    public Set<SimpUser> getUsers() {
        return simpUserRegistry.getUsers();
    }

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void onReceivedMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(message);

        String roomId = mapper.readTree(message).get("id_chatroom").asText();

        System.out.println(getUsers());
        this.getUsers().forEach(user -> {
            System.out.println(user);
        });

        this.template.convertAndSend("/chat/" + roomId, message);
        //this.template.convertAndSend("/chat" + roomId, message);
    }

    @SubscribeMapping("/chat/phongiuh")
    public void try1() {
    }
}
