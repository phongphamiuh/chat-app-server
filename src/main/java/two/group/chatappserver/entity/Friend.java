package two.group.chatappserver.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Friend {

    @DynamoDBAttribute
    private String conversationId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String role;

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String uid;

    @DynamoDBAttribute
    private String status;

//    @DynamoDBRangeKey(attributeName = "OrderID")
//    private String owner;
}