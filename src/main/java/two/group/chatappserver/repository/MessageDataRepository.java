package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import two.group.chatappserver.entity.Message;
import two.group.chatappserver.entity.Messages;
import two.group.chatappserver.entity.MessagesData;
import two.group.chatappserver.entity.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

}
