package smartparking.api;

import smartparking.model.ParkData;
import java.util.List;

/**
 * 功能同ParkDao中定义的方法相同，用于客户端对其进行的调用
 */
public interface ParkAPI {

    List<ParkData> getNearParksByDistance(double latitude, double longitude, float limitDistance);

    List<ParkData> getParks(int page, int num);

    String getParkById(int parkId);

    String getParkByName(String parkName);

    int addParkingLot(ParkData parkData);

    int updateParkingLot(ParkData parkData);

//    int removeParkingLot(int parkId);
}
