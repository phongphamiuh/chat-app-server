package two.group.chatappserver.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Messages {
    @DynamoDBAttribute
    private String message;

    @DynamoDBAttribute
    private String type;

    @DynamoDBAttribute
    private String id_send;

    @DynamoDBAttribute
    private Long sentAt;

    @DynamoDBAttribute
    private Long deletedAt;

    @DynamoDBAttribute
    private String deletedBy;

    @DynamoDBAttribute
    private String fileUrl;
}
