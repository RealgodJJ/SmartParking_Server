package smartparking.dao;

import smartparking.model.UserData;

import java.util.List;

public interface UserDao {
    /**
     * 获取用户所有信息
     *
     * @param offset
     * @param limit
     * @return
     */
    List<UserData> getUsers(long offset, long limit);

    /**
     * 通过用户id查找用户信息
     *
     * @param id
     * @return
     */
    UserData getUserById(int id);

    /**
     * 通过用户名查找用户信息
     *
     * @param userName
     * @return
     */
    UserData getUserByName(String userName);

    /**
     * 添加用户
     *
     * @param userData 类对象的所有属性
     * @return id
     */
    String addUser(UserData userData);

    /**
     * 修改用户数据
     *
     * @param userData 类对象的所有属性
     * @return id
     */
    int updateUser(UserData userData);

    /**
     * 修改用户密码
     * @return id
     */
    int changePassword(UserData userData);

    /**
     * 通过id删除用户信息（注销该用户）
     *
     * @param id
     * @return
     */
    int removeUserById(int id);

    /**
     * 判断登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    String login(String userName, String password);
}
