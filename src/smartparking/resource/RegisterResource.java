package smartparking.resource;


import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import smartparking.model.UserData;

public interface RegisterResource {
    /**
     * 添加用户
     * @return id
     */
    @Post
    String addUser(StringRepresentation entity);
}
