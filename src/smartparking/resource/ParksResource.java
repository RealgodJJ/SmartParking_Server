package smartparking.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import smartparking.model.ParkData;

import java.util.List;

public interface ParksResource {
//    @Get
//    List<ParkData> getNearParksByDistance();

    @Get
    List<ParkData> getParks();

    @Put
    int updateParkingLot(ParkData parkData);

    @Post
    int addParkingLot(ParkData parkData);
}
