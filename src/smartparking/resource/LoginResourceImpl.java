package smartparking.resource;

import org.restlet.data.Form;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.UserDao;

public class LoginResourceImpl extends ServerResource implements LoginResource {

    private UserDao userDao;

    @Override
    protected void doInit() {
        super.doInit();
        userDao = Server.getUserDao();
    }

    @Override
    @Post
    public String login(StringRepresentation entity) {
        System.out.printf("server come : ");
        Form form = new Form(entity);
        String userName = form.getFirstValue("userName");
        String password = form.getFirstValue("password");
        System.out.printf("getUserName : " + userName + ",getPassword : " + password);
        return userDao.login(userName, password);
    }
}
