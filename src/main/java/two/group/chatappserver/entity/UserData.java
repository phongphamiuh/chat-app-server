package two.group.chatappserver.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class UserData {
    @DynamoDBAttribute
    private String avatar;

    @DynamoDBAttribute
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String conversationId;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String role;

    @DynamoDBAttribute
    private String status;

    @DynamoDBAttribute
    private String uid;
}
