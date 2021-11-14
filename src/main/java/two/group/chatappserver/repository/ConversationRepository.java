package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import two.group.chatappserver.entity.Conversation;

import java.util.List;

@Repository
public class ConversationRepository  {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Conversation save(Conversation conversation){
        dynamoDBMapper.save(conversation);
        return conversation;
    }


    public List<Conversation> findAll(){
        return dynamoDBMapper.scan(Conversation.class, new DynamoDBScanExpression());
    }

}
