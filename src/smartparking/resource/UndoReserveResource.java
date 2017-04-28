package smartparking.resource;


import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;

public interface UndoReserveResource {
    /**
     * 停车位预订归还
     * @param entity
     * @return
     */
    @Put
    String undoReservePark(StringRepresentation entity);
}
