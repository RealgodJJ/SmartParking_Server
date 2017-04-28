package smartparking.client;

import com.sun.jndi.toolkit.url.Uri;
import org.junit.Test;
import org.restlet.data.Expectation;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.security.User;
import smartparking.api.UserAPI;
import smartparking.api.UserAPIImpl;
import smartparking.model.UserData;

import java.io.IOException;
import java.net.URL;

public class UserClient {
    //create user interface


    public static void main(String[] args) {
        String url ="http://localhost:8085";
        //login();
        //ClientResource login = new ClientResource(url + "");
//        login(url);
//        UserAPI userAPI = new UserAPIImpl();
//        UserData user1 = new UserData();
//        try {
//            Form form = new Form();
//            form.add("userName", "MaAonan");
//            form.add("password", "Xiaomage0313");
//            form.add("phoneNumber", "13439127523");
//            form.add("email", "xiaozhiqiu13@sina.com");
//            form.add("plateNo", "A-12345");
//            Representation representation = form.getWebRepresentation();
//            String text = representation.getText();
//            StringRepresentation stringRepresentation = new StringRepresentation(text, MediaType.ALL);
//            userAPI.addUser(stringRepresentation);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //create user2
//        UserData user2 = new UserData();
//        user2.setUserName("XiaoMing");
//        user2.setPassword("111111");
//        user2.setPhoneNumber("11111111111");
//        user2.setEmail("xiaoming@sina.com");
//        user2.setPlateNo("A-11111");
//        userAPI.addUser(user2);
//        //create user3
//        UserData user3 = new UserData();
//        user3.setUserName("XiaoHong");
//        user3.setPassword("222222");
//        user3.setPhoneNumber("22222222222");
//        user3.setEmail("xiaohong@sina.com");
//        user3.setPlateNo("A-22222");
//        userAPI.addUser(user3);
//        UserData user4 = new UserData();
//        user4.setUserName("XiaoHong");
//        user4.setPassword("222222");
//        user4.setPhoneNumber("22222222222");
//        user4.setEmail("xiaohong@sina.com");
//        user4.setPlateNo("A-22222");
//        userAPI.addUser(user4);

        //Login
//        UserData login = new UserData();
//        String userName = "XiaoMing";
//        String password = "111111";
//        login.setUserName(userName);
//        login.setPassword(password);
//        boolean isLogin = userAPI.login(login);
//        System.out.println("Login:" + isLogin);

        //get user by id
//        UserData getUserById = userAPI.getUserById(1);
//        String userName = getUserById.getUserName();
//        String password = getUserById.getPassword();
//        String phoneNumber = getUserById.getPhoneNumber();
//        String email = getUserById.getEmail();
//        String plateNo = getUserById.getPlateNo();
//        System.out.printf("userName:" + userName + "\n" +
//                "password:" + password + "\n" + "phoneNumber:" + phoneNumber + "\n"
//                + "email:" + email + "\n" + "plateNo:" + plateNo);

        //get user by userName
//        UserData getUserByName = userAPI.getUserByName("XiaoMing");
//        String userName1 = getUserByName.getUserName();
//        String password1 = getUserByName.getPassword();
//        String phoneNumber1 = getUserByName.getPhoneNumber();
//        String email1 = getUserByName.getEmail();
//        String plateNo1 = getUserByName.getPlateNo();
//        System.out.printf("\n\nuserName:" + userName1 + "\n" +
//                "password:" + password1 + "\n" + "phoneNumber:" + phoneNumber1 + "\n"
//                + "email:" + email1 + "\n" + "plateNo:" + plateNo1);

        //remove user by id
//        int removeUserId = userAPI.removeUserById(4);
//        System.out.println(removeUserId);

//        UserData updateUser = userAPI.getUserByName("XiaoHong");
//        updateUser.setPhoneNumber("98765432100");
//        userAPI.updateUser(updateUser);
//        String userName1 = updateUser.getUserName();
//        String password1 = updateUser.getPassword();
//        String phoneNumber1 = updateUser.getPhoneNumber();
//        String email1 = updateUser.getEmail();
//        String plateNo1 = updateUser.getPlateNo();
//        System.out.printf("\n\nuserName:" + userName1 + "\n" +
//                "password:" + password1 + "\n" + "phoneNumber:" + phoneNumber1 + "\n"
//                + "email:" + email1 + "\n" + "plateNo:" + plateNo1);

    }
}

//TODO:

//to be done:
//1. server and client business logic.
//2. client GUI: activities,
//
//to be delayed:
//1. server and client communication.
//2. payment service integration.
