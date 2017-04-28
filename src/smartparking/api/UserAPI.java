package smartparking.api;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import smartparking.model.UserData;
import java.util.List;

/**
 * 功能同UserDao中定义的方法相同，用于客户端对其进行的调用
 */
public interface UserAPI {
    List<UserData> getUsers(int page, int number);

    String getUserById(int id);

    String getUserByName(String userName);

    String addUser(StringRepresentation entity);

//    int updateUser(UserData userData);

//    int removeUserById(int id);

//    String login(StringRepresentation entity);

//    boolean authenticate(String username, String password);
}
