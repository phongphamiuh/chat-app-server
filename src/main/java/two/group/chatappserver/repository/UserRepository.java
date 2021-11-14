package two.group.chatappserver.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import two.group.chatappserver.entity.Friend;
import two.group.chatappserver.entity.Person;
import two.group.chatappserver.entity.User;

import java.util.List;
@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<User> findAll(){
        return dynamoDBMapper.scan(User.class, new DynamoDBScanExpression());
    }

    public User findById(String id){
        return dynamoDBMapper.load(User.class, id);
    }


    public List<Friend> getListFriendsById(String id){
        return dynamoDBMapper.load(User.class, id).getFriends();
    }

    public User save(User user){
        dynamoDBMapper.save(user);
        return user;
    }

    public User saveFriends(String id ,Friend friend){
        User userLoad = dynamoDBMapper.load(User.class, id);
        friend.setConversationId(id + "_user_" + friend.getUid());
        userLoad.getFriends().add(friend);
        dynamoDBMapper.save(userLoad);
        return userLoad;
    }

    public User addFriends(String id ,String friendId){
        User userLoad = dynamoDBMapper.load(User.class, id);
        User friendLoad = dynamoDBMapper.load(User.class, friendId);

        Friend friend = new Friend();
        friend.setName(friendLoad.getName());
        friend.setRole(friendLoad.getRole());
        friend.setStatus(friendLoad.getStatus());
        friend.setUid(friendLoad.getUid());
        friend.setConversationId(id + "_user_" + friendLoad.getUid());

        userLoad.getFriends().add(friend);
        dynamoDBMapper.save(userLoad);
        return userLoad;
    }
}
