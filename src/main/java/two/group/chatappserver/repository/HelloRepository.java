package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;


}
