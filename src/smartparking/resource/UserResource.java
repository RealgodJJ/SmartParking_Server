package smartparking.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import smartparking.model.UserData;


public interface UserResource {
    /**
     * 获取某个用户信息
     * @return
     */
    @Get
    String getUser();

//    /**
//     * 删除某个用户信息
//     * @return
//     */
//    @Delete
//    int removeUser();
}
