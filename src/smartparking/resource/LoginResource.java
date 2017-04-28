package smartparking.resource;


import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;


public interface LoginResource {

    /**
     * 登录判断
     * @return 返回是否成功
     */
    @Post
    String login(StringRepresentation entity);
}
