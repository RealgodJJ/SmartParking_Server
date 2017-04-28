package smartparking.api;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import smartparking.model.UserData;
import smartparking.resource.LoginResource;
import smartparking.resource.RegisterResource;
import smartparking.resource.UserResource;
import smartparking.resource.UsersResource;

import java.util.List;

/**
 * 解决用户接口
 */
public class UserAPIImpl implements UserAPI {

    //创建客户端使其连接本地服务器
    private ClientResource service = new ClientResource("http://localhost:8085");

    //创建构造方法
    public UserAPIImpl() {
        service.setNext(new Client(new Context(), Protocol.HTTP));
    }

    //获得用户信息
    @Override
    public List<UserData> getUsers(int page, int num) {
        UsersResource usersResource = service.getChild("/users?page=" + page + "&num=" + num, UsersResource.class);
        return usersResource.getUsers();
    }

    //通过用户的id获取用户信息
    @Override
    public String getUserById(int id) {
        UserResource userResource = service.getChild("/user/" + id + "?choose=id", UserResource.class);
        return userResource.getUser();
    }

    //通过用户名获取用户信息
    @Override
    public String getUserByName(String userName) {
        UserResource userResource = service.getChild("/user/" + userName + "?choose=userName", UserResource.class);
        return userResource.getUser();
    }

    //添加用户
    @Override
    public String addUser(StringRepresentation entity) {
        RegisterResource registerResource = service.getChild("/users", RegisterResource.class);
        return registerResource.addUser(entity);
    }

//    //修改用户信息
//    @Override
//    public int updateUser(UserData userData) {
//        UsersResource usersResource = service.getChild("/users", UsersResource.class);
//        return usersResource.updateUser(userData);
//    }

//    //根据id号删除用户
//    @Override
//    public int removeUserById(int userId) {
//        UserResource userResource = service.getChild("/user/" + userId, UserResource.class);
//        return userResource.removeUser();
//    }

    //登录
//    @Override
//    public String login(StringRepresentation entity) {
//        LoginResource loginResource = service.getChild("/login", LoginResource.class);
//        return loginResource.login(entity);
//    }

//    @Override
//    public boolean authenticate(String username, String password) {
//        UsersResource usersResource = service.getChild("/users", UsersResource.class);
//        return usersResource.authenticate(username, password);
//    }
}
