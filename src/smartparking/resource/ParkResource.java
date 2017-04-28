package smartparking.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import smartparking.model.ParkData;

public interface ParkResource {
    /**
     * use ParkName or ParkId to get the parkingLot
     * @return ParkData
     */
    @Get
    String getParkingLot();

//    @Delete
//    int removeParkingLot();
}
