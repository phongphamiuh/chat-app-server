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

import java.util.List;

@Repository
public class FriendRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Friend> findAll(String owner){
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        scanExpression.addFilterCondition("Price",
                new Condition()
                        .withComparisonOperator(ComparisonOperator.EQ)
                        .withAttributeValueList(new AttributeValue().withN(owner)));
        return dynamoDBMapper.scan(Friend.class, scanExpression);
    }

}
