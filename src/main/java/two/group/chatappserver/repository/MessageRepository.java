package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import two.group.chatappserver.entity.Friend;
import two.group.chatappserver.entity.Message;
import two.group.chatappserver.entity.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MessageRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Message> findAll(){
        return dynamoDBMapper.scan(Message.class, new DynamoDBScanExpression())
                .stream()
                .sorted(Comparator.comparingLong(Message::getSentAt))
                .collect(Collectors.toList());
    }

    public Message save(Message message){
        dynamoDBMapper.save(message);
        return message;
    }

    public List<Message> getAllMessage(String uid, String friend){
        String s1 = uid + "_user_" + friend;
        String s2 = friend + "_user_" + uid;

        System.out.println(s1);
        System.out.println(s2);

        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(s1));
        eav.put(":val2", new AttributeValue().withS(s2));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("conversationId = :val1 or conversationId = :val2")
                .withExpressionAttributeValues(eav);
        return dynamoDBMapper.scan(Message.class, scanExpression)
                .stream()
                .sorted(Comparator.comparingLong(Message::getSentAt))
                .collect(Collectors.toList());
    }
}
