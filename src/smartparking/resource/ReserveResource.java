package smartparking.resource;


import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;

public interface ReserveResource {
    /**
     * 停车位预订
     * @param entity
     * @return
     */
    @Put
    String reservePark(StringRepresentation entity);
}
