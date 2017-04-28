package smartparking.resource;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.UserData;

import java.util.List;

public interface UsersResource {

    /**
     * 返回给客户端数据
     * @return List形式
     */
    @Get
    List<UserData> getUsers();

    /**
     * 修改数据
     * @return id
     */
    @Put
    String updateUser(StringRepresentation entity);

//    /**
//     * 添加用户
//     * @param userData
//     * @return id
//     */
//    @Post
//    int addUser(UserData userData);

//    boolean authenticate(String username, String password);
}
