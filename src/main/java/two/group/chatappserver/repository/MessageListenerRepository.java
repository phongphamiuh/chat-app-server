package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import two.group.chatappserver.entity.Message;
import two.group.chatappserver.entity.MessageListener;
import two.group.chatappserver.entity.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class MessageListenerRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<MessageListener> findAll(){
        return dynamoDBMapper.scan(MessageListener.class, new DynamoDBScanExpression())
                .stream()
                .sorted(Comparator.comparingLong(MessageListener::getSentAt))
                .collect(Collectors.toList());
    }

    public MessageListener save(MessageListener message){
        dynamoDBMapper.save(message);
        return message;
    }

    public MessageListener findById(String id){
        return dynamoDBMapper.load(MessageListener.class, id);
    }

    public void delete(String id){
        MessageListener messageListener = dynamoDBMapper.load(MessageListener.class, id);
        dynamoDBMapper.delete(messageListener);
    }
}
