package smartparking.resource;

import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;

public interface ChangePasswordResource {

    @Put
    String changePassword(StringRepresentation entity);

}
