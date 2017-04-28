package smartparking.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.UserDao;
import smartparking.model.UserData;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UserResourceImpl extends ServerResource implements UserResource {
    private String idOrName;
    private String choose;

    @Override
    protected void doInit() {
        super.doInit();
        try {
            idOrName = URLDecoder.decode(getAttribute("idOrName"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        choose = getQueryValue("choose");
    }


    @Override
    @Get
    public String getUser() {
        UserData userData;
        UserDao userDao = Server.getUserDao();
        String userName, phoneNumber, email, plateNo, userId;
        if (choose.equals("userId")){
            userData = userDao.getUserById(Integer.parseInt(idOrName));
            userName = userData.getUserName();
            phoneNumber = userData.getPhoneNumber();
            email = userData.getEmail();
            plateNo = userData.getPlateNo();
            userId = String.valueOf(userData.getId());
            return userName + "$" + phoneNumber + "$" + email + "$" + plateNo + "$" + userId;
        }
        else if (choose.equals("userName")) {
            userData = userDao.getUserByName(idOrName);
            userName = userData.getUserName();
            phoneNumber = userData.getPhoneNumber();
            email = userData.getEmail();
            plateNo = userData.getPlateNo();
            userId = String.valueOf(userData.getId());
            return userName + "#" + phoneNumber + "#" + email + "#" + plateNo + "#" + userId;
        }
        else return null;
    }


//    @Override
//    public int removeUser() {
//        return Server.getUserDao().removeUserById(Integer.parseInt(idOrName));
//    }
}
