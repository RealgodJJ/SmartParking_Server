package smartparking;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;

import org.restlet.routing.Router;
import smartparking.dao.ParkDaoImpl;
import smartparking.model.ParkData;
import smartparking.model.UserData;
import smartparking.dao.ParkDao;
import smartparking.dao.UserDao;
import smartparking.dao.UserDaoImpl;
import smartparking.resource.*;

import java.sql.SQLException;

public class Server extends Application {

    /**
     * 连接数据库的属性配置
     */
    private static final String url = "jdbc:mysql://localhost:3306/parking_database?useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "Xiaomage0313";

    //数据库连接源
    private static ConnectionSource connectionSource;
    //创建用户类数据库接口
    private static UserDao userDao;
    //创建Park类数据库接口
    private static ParkDao parkDao;
    //创建用户接口
//    private UserAPIImpl userImpl;

    /**
     * 静态初始化各实例
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connectionSource = new JdbcConnectionSource(url, username, password);
            userDao = new UserDaoImpl(connectionSource);
            parkDao = new ParkDaoImpl(connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Server() throws SQLException {
        setName("Parking_Server");
        setDescription("Parking_Server");
        setOwner("Xiaomage");
        //创建用户信息表单
//        TableUtils.createTableIfNotExists(getConnectionSource(), UserData.class);
        //create parkData table
//        TableUtils.createTableIfNotExists(getConnectionSource(), ParkData.class);
    }

    public static void main(String[] args) throws Exception {
        Component server = new Component();
        server.getServers().add(Protocol.HTTP, "0.0.0.0", 8085);
        server.getDefaultHost().attach(new Server());
        server.start();
    }

    @Override
    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/login", LoginResourceImpl.class);
        router.attach("/register", RegisterResourceImpl.class);
        router.attach("/user/{idOrName}", UserResourceImpl.class);
        router.attach("/park/{idOrUid}", ParkResourceImpl.class);
        router.attach("/reserve",ReserveResourceImpl.class);
        router.attach("/undoReserve", UndoReserveResourceImpl.class);
        router.attach("/updateUser",UsersResourceImpl.class);
//        router.attach("/users", UsersResourceImpl.class);
        return router;
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public static synchronized UserDao getUserDao() {
        return userDao;
    }

    public static synchronized ParkDao getParkDao() {
        return parkDao;
    }
}
