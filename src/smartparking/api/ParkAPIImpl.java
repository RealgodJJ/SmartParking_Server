package smartparking.api;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;
import smartparking.model.ParkData;
import smartparking.resource.ParkResource;
import smartparking.resource.ParksResource;

import java.util.List;


public class ParkAPIImpl implements ParkAPI {

    //创建客户端使其连接本地服务器
    private ClientResource service = new ClientResource("http://localhost:8085");

    //创建构造方法
    public ParkAPIImpl() {
        service.setNext(new Client(new Context(), Protocol.HTTP));
    }

    @Override
    public List<ParkData> getNearParksByDistance(double latitude, double longitude, float limitDistance) {

        return null;
    }

    @Override
    public List<ParkData> getParks(int page, int num) {
        ParksResource parksResource = service.getChild("/parks?page=" + page + "&num=" + num,ParksResource.class);
        return parksResource.getParks();
    }

    @Override
    public String getParkById(int parkId) {
        ParkResource parkResource = service.getChild("/park/" + parkId + "?choose=parkId", ParkResource.class);
        return parkResource.getParkingLot();
    }

    @Override
    public String getParkByName(String parkName) {
        ParkResource parkResource = service.getChild("/park/" + parkName + "?choose=parkName", ParkResource.class);
        return parkResource.getParkingLot();
    }

    @Override
    public int addParkingLot(ParkData parkData) {
        ParksResource parksResource = service.getChild("/parks", ParksResource.class);
        return parksResource.addParkingLot(parkData);
    }

    @Override
    public int updateParkingLot(ParkData parkData) {
        ParksResource parksResource = service.getChild("/parks", ParksResource.class);
        return parksResource.updateParkingLot(parkData);
    }

//    @Override
//    public int removeParkingLot(int parkId) {
//        ParkResource parkResource = service.getChild("/park/" + parkId, ParkResource.class);
//        return parkResource.removeParkingLot();
//    }
}
