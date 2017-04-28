package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.model.ParkData;
import smartparking.model.UserData;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<UserData, Integer> implements UserDao {

    //构造方法
    public UserDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, UserData.class);
    }

    //获取用户
    @Override
    public List<UserData> getUsers(long offset, long limit) {
        try {
            return queryBuilder().offset(offset).limit(limit).query();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //通过用户id获得用户信息
    @Override
    public UserData getUserById(int userId) {
        try {
            return queryForId(userId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //通过用户名获得用户信息
    @Override
    public UserData getUserByName(String userName) {
        try {
            List<UserData> list = queryForEq("userName", userName);
            return list != null && list.size() > 0 ? list.get(0) : null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 添加用户
     *
     * @param userData 类对象的所有属性
     * @return id
     */
    @Override
    public String addUser(UserData userData) {
        try {
            create(userData);
            String id = String.valueOf(userData.getId());
//            return "Register success!" + id;
            return "Register success!";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Register error!";
        }
    }

    /**
     * 修改用户数据
     *
     * @param userData 类对象的所有属性
     * @return id
     */
    @Override
    public int updateUser(UserData userData) {
        try {
            return update(userData);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * 通过id删除用户信息（注销该用户）
     *
     * @param id
     * @return id
     */
    @Override
    public int removeUserById(int id) {
        try {
            return deleteById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * 判断登录
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public String login(String userName,String password) {
        try {
            QueryBuilder<UserData, Integer> queryBuilder = queryBuilder();
            Where<UserData, Integer> where = queryBuilder.where();
            where.and(where.eq("userName", userName), where.eq("password",password));
            PreparedQuery preparedQuery = queryBuilder.prepare();
            List<UserData> userList = query(preparedQuery);
            if(userList.size() > 0) {
                return "Login success!";
            } else {
                return "Login error!";
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Login error!";
        }
    }
}
