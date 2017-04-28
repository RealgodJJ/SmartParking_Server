package smartparking.resource;


import org.restlet.data.Form;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Patch;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.ParkDao;
import smartparking.model.ParkData;


public class ReserveResourceImpl extends ServerResource implements ReserveResource {

    private ParkDao parkDao;

    @Override
    protected void doInit() {
        super.doInit();
        parkDao = Server.getParkDao();
    }

    @Override
    @Put
    public String reservePark(StringRepresentation entity) {
        System.out.printf("server come : ");
        Form form = new Form(entity);
        String parkUid = form.getFirstValue("parkUid");
        String userName = form.getFirstValue("userName");
        System.out.printf("getUserName : " + userName + ",getParkUid : " + parkUid);
        ParkData parkData = parkDao.getParkByUid(parkUid);
        int parkId = parkDao.reservePark(parkData);
        return String.valueOf(parkId);
    }
}
