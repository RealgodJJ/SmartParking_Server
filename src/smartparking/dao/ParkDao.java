package smartparking.dao;

import smartparking.model.ParkData;
import java.util.List;

public interface ParkDao {

//    List<ParkData> getNearParksByDistance(double latitude, double longitude, float limitDistance);

    List<ParkData> getParks(long offset, long limit);

    ParkData getParkById(int parkId);

    ParkData getParkByUid(String uid);

    int reservePark(ParkData parkData);

    int undoReservePark(ParkData parkData);

    int addParkingLot(ParkData parkData);

    int updateParkingLot(ParkData parkData);

    int removeParkingLot(int parkId);

    //int getTotalAvailable(int parkId);

    //int attainSpaceNo(int parkingLotId);
}
