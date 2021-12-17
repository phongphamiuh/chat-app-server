package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import two.group.chatappserver.entity.Messages;
import two.group.chatappserver.entity.MessagesData;

import java.util.List;

@Repository
public class MessageDataRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Messages> findById(String id){
        return dynamoDBMapper.load(MessagesData.class, id).getContent();
    }

    public Messages save(String chatRoomId,Messages messages){
        MessagesData messagesData = dynamoDBMapper.load(MessagesData.class, chatRoomId);
        messagesData.getContent().add(messages);
        dynamoDBMapper.save(messagesData);
        return messages;
    }

    public Messages remove(String chatRoomId,Messages messages, Long deleteAt,String deletedBy){
        MessagesData messagesData = dynamoDBMapper.load(MessagesData.class, chatRoomId);


       Integer index = messagesData.getContent().indexOf(messages);

       Messages messages1 = messagesData.getContent().get(index);
        messages1.setDeletedAt(deleteAt);
        messages1.setDeletedBy(deletedBy);


//        messagesData.getContent().forEach(messages1 -> {
//            if(messages.getSentAt() == messages1.getSentAt()) {
//                messages1.setDeleteAt(deleteAt);
//            }
//        });
//        if(messagesData.getContent().contains(messages)){
//            messagesData.getContent().get()
//            messagesData.getContent().remove(messages);
//        }
        dynamoDBMapper.save(messagesData);
        return messagesData.getContent().get(index);
    }

}
