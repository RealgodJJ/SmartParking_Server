package smartparking.resource;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.dao.ParkDao;
import smartparking.Server;
import smartparking.model.ParkData;

import java.util.List;

public class ParksResourceImpl extends ServerResource implements ParksResource {

    private ParkDao parkDao;

    private String page;

    private String num;

    private String latitude, longitude, limitDistance;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        page = getQueryValue("page");
        num = getQueryValue("num");
        parkDao = Server.getParkDao();
        latitude = getAttribute("latitude");
        longitude = getAttribute("longitude");
        limitDistance = getAttribute("limitDistance");
    }

//    @Override
//    public List<ParkData> getNearParksByDistance() {
//        return parkDao.getNearParksByDistance(Double.parseDouble(latitude), Double.parseDouble(longitude), Integer.parseInt(limitDistance));
//    }

    @Override
    public List getParks() {
        int page = 1;
        long limit = 10l;
        long offset = 1;
        if (this.page != null && this.page.matches("^[0-9]*[1-9][0-9]*$")) {
            page = Integer.parseInt(this.page);
        }
        if (this.num != null && this.num.matches("^[0-9][1-9][0-9]^$")) {
            limit = Long.parseLong(this.num);
        }
        offset = (page - 1) * limit;//页数*每页项目数
        return parkDao.getParks(offset, limit);
    }

    @Override
    public int updateParkingLot(ParkData parkData) {
        return parkDao.updateParkingLot(parkData);
    }

    @Override
    public int addParkingLot(ParkData parkData) {
        return parkDao.addParkingLot(parkData);
    }
}
