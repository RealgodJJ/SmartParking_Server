package smartparking.resource;

import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import smartparking.Server;
import smartparking.dao.ParkDao;
import smartparking.model.ParkData;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ParkResourceImpl extends ServerResource implements ParkResource {
    private String choose;
    private String idOrUid;

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        try{
            idOrUid = URLDecoder.decode(getAttribute("idOrUid"), "utf-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        choose = getQueryValue("choose");
    }

    @Override
    @Get
    public String getParkingLot() {
        ParkData parkData;
        ParkDao parkDao = Server.getParkDao();
        int totalSpaces, totalAvailable;
        double parkPrice, parkNightPrice;
        if(choose.equals("parkId")){
            parkData = parkDao.getParkById(Integer.parseInt(idOrUid));
            totalSpaces = parkData.getTotalSpaces();
            totalAvailable = parkData.getTotalAvailable();
            parkPrice = parkData.getParkPrice();
            parkNightPrice = parkData.getParkNightPrice();
            return totalSpaces + "@" + totalAvailable + "@" + parkPrice + "@" + parkNightPrice;
        }else if(choose.equals("parkUid")) {
            parkData = parkDao.getParkByUid(idOrUid);
            if(parkData != null) {
                totalSpaces = parkData.getTotalSpaces();
                totalAvailable = parkData.getTotalAvailable();
                parkPrice = parkData.getParkPrice();
                parkNightPrice = parkData.getParkNightPrice();
                return totalSpaces + "!" + totalAvailable + "!" + parkPrice + "!" + parkNightPrice;
            } else {
                return null;
            }
        }else{
            return null;
        }
    }

//    @Delete
//    public int removeParkingLot() {
//        return Server.getParkDao().removeParkingLot(Integer.parseInt(idOrUid));
//    }

}
