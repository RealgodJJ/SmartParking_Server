package smartparking.resource;


import org.restlet.data.Form;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.UserDao;
import smartparking.model.UserData;

public class ChangePasswordResourceImpl extends ServerResource implements ChangePasswordResource {

    private UserDao userDao;
    /**
     * 页号
     */
    private String page;
    /**
     * 每页显示的项目数
     */
    private String num;

    @Override
    protected void doInit() {
        super.doInit();
        page = getQueryValue("page");
        num = getQueryValue("num");
        userDao = Server.getUserDao();
    }

    @Override
    @Put
    public String changePassword(StringRepresentation entity) {
        System.out.printf("server come : ");
        Form form = new Form(entity);
        String userId = form.getFirstValue("userId");
        String password = form.getFirstValue("password");
        System.out.printf("getPassword : " + password);
        //通过id号获取用户信息
        UserData userData = userDao.getUserById(Integer.parseInt(userId));
        //修改用户信息
        userData.setPassword(password);
        int changeId = userDao.changePassword(userData);
        return String.valueOf(changeId);
    }

}
