package smartparking.resource;

import org.restlet.data.Form;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.UserDao;
import smartparking.model.UserData;

public class RegisterResourceImpl extends ServerResource implements RegisterResource {

    private UserDao userDao;

    @Override
    protected void doInit() {
        super.doInit();
        userDao = Server.getUserDao();
    }

    @Override
    @Post
    public String addUser(StringRepresentation entity) {
        System.out.printf("server come : ");
        Form form = new Form(entity);
        String userName = form.getFirstValue("userName");
        String password = form.getFirstValue("password");
        String phoneNumber = form.getFirstValue("phoneNumber");
        String email = form.getFirstValue("email");
        String plateNo = form.getFirstValue("plateNo");
        UserData userData = new UserData();
        userData.setUserName(userName);
        userData.setPassword(password);
        userData.setPhoneNumber(phoneNumber);
        userData.setEmail(email);
        userData.setPlateNo(plateNo);
        System.out.printf("getUserName : " + userName + "\n" + ",getPassword : " + password + "\n" +
                "getPhoneNumber : " + phoneNumber + "\n" + "getEmail : " + email + "\n" +
                "getPlateNo : " + plateNo);
        return userDao.addUser(userData);
    }
}
