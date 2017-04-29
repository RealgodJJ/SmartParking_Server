package smartparking.resource;

import com.fasterxml.jackson.dataformat.xml.ser.UnwrappingXmlBeanSerializer;
import org.restlet.data.Form;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.UserDao;
import smartparking.model.UserData;

import java.util.List;
import java.util.Objects;

public class UsersResourceImpl extends ServerResource implements UsersResource {
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

    /**
     * 所有用户
     * @return 用户列表
     */

    @Override
    public List<UserData> getUsers() {
        int page = 1;
        long limit = 10L;
        long offset;
        if (this.page != null && this.page.matches("^[0-9]*[1-9][0-9]*$")) {
            page = Integer.parseInt(this.page);
        }

        if (this.num != null && this.num.matches("^[0-9]*[1-9][0-9]*$")) {
            limit = Long.parseLong(this.num);
        }
        offset = (page - 1) * limit;
        return userDao.getUsers(offset, limit);
    }

    /**
     * 修改用户信息
     *
     * @return 返回修改用户的id
     */
    @Override
    @Put
    public String updateUser(StringRepresentation entity) {
        System.out.printf("server come : ");
        Form form = new Form(entity);
        String userId = form.getFirstValue("userId");
        String userName = form.getFirstValue("userName");
        String phoneNumber = form.getFirstValue("phoneNumber");
        String email = form.getFirstValue("email");
        String plateNo = form.getFirstValue("plateNo");
        System.out.printf("getUserName : " + userName + "\ngetPhoneNumber : " +
        phoneNumber + "\ngetEmail : " + email + "\ngetPlateNo : " + plateNo);
        //通过id号获取用户信息
        UserData userData = userDao.getUserById(Integer.parseInt(userId));
        //修改用户信息
        userData.setUserName(userName);
        userData.setPhoneNumber(phoneNumber);
        userData.setEmail(email);
        userData.setPlateNo(plateNo);
        int changeId = userDao.updateUser(userData);
        return String.valueOf(changeId);
    }
}
