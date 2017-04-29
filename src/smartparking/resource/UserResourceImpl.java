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
        String userName = "error", phoneNumber = "error", email = "error", plateNo = "error", userId = "error", password = "error";
        if (choose.equals("userId")){
            userData = userDao.getUserById(Integer.parseInt(idOrName));
            if (userData != null) {
                userName = userData.getUserName();
                phoneNumber = userData.getPhoneNumber();
                email = userData.getEmail();
                plateNo = userData.getPlateNo();
                password = userData.getPassword();
                userId = String.valueOf(userData.getId());
            }
            return userName + "$" + phoneNumber + "$" + email + "$" + plateNo + "$" + userId + "$" + password;
        }
        else if (choose.equals("userName")) {
            userData = userDao.getUserByName(idOrName);
            if (userData != null) {
                userName = userData.getUserName();
                phoneNumber = userData.getPhoneNumber();
                email = userData.getEmail();
                plateNo = userData.getPlateNo();
                password = userData.getPassword();
                userId = String.valueOf(userData.getId());
            }
            return userName + "#" + phoneNumber + "#" + email + "#" + plateNo + "#" + userId + "#" + password;
        }
        else return null;
    }


//    @Override
//    public int removeUser() {
//        return Server.getUserDao().removeUserById(Integer.parseInt(idOrName));
//    }
}
