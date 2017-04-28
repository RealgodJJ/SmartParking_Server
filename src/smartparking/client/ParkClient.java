package smartparking.client;

import smartparking.api.ParkAPI;
import smartparking.api.ParkAPIImpl;
import smartparking.model.ParkData;

public class ParkClient {
    //create park interface


    public static void main(String[] args) {
        ParkAPI parkAPI = new ParkAPIImpl();
        //register
//        ParkData park1 = new ParkData();
//        park1.setParkName("qwe");
//        park1.setDestination("asd");
//        park1.setLatitude(34.4);
//        park1.setLongitude(95.4);
//        park1.setTotalAvailable(80);
//        park1.setParkPrice(3.4);
//        parkAPI.addParkingLot(park1);
//        ParkData park2 = new ParkData("rty", "fgh", 39.9, 100.0, 60,2.3);
//        parkAPI.addParkingLot(park2);
//        ParkData park3 = new ParkData("uio", "jkl", 25.6, 78.4, 70,3.7);
//        parkAPI.addParkingLot(park3);
//        ParkData park4 = new ParkData("zxc", "vbn", 32.1, 56.7, 120,4);
//        parkAPI.addParkingLot(park4);

        //get park by parkId
//        ParkData getParkById = parkAPI.getParkById(1);
//        String parkName = getParkById.getParkName();
//        String destination = getParkById.getDestination();
//        double latitude = getParkById.getLatitude();
//        double longitude = getParkById.getLongitude();
//        int totalAvailable = getParkById.getTotalAvailable();
//        double parkPrice = getParkById.getParkPrice();
//        System.out.printf("parkName:" + parkName + "\n" +
//                "destination:" + destination + "\n" + "latitude:" +
//                latitude + "\n" + "longitude:" + longitude + "\n" +
//                "totalAvailable:" + totalAvailable + "\n" + "parkPrice:"
//                + parkPrice);

        //get park by parkName
//        ParkData getParkByName = parkAPI.getParkByName("rty");
//        String parkName1 = getParkByName.getParkName();
//        String destination1 = getParkByName.getDestination();
//        double latitude1 = getParkByName.getLatitude();
//        double longitude1 = getParkByName.getLongitude();
//        int totalAvailable1 = getParkByName.getTotalAvailable();
//        double parkPrice1 = getParkByName.getParkPrice();
//        System.out.printf("parkName:" + parkName1 + "\n" +
//                "destination" + destination1 + "\n" + "latitude:" +
//                latitude1 + "\n" + "longitude:" + longitude1 + "\n" +
//                "totalAvailable:" + totalAvailable1 + "\n" + "parkPrice:"
//                + parkPrice1);

        //update park
//        ParkData updateParkingLot = parkAPI.getParkById(3);
//        updateParkingLot.setTotalAvailable(65);
//        parkAPI.updateParkingLot(updateParkingLot);
//        String parkName1 = updateParkingLot.getParkName();
//        String destination1 = updateParkingLot.getDestination();
//        double latitude1 = updateParkingLot.getLatitude();
//        double longitude1 = updateParkingLot.getLongitude();
//        int totalAvailable1 = updateParkingLot.getTotalAvailable();
//        double parkPrice1 = updateParkingLot.getParkPrice();
//        System.out.printf("\n\nparkName:" + parkName1 + "\n" +
//                "destination" + destination1 + "\n" + "latitude:" +
//                latitude1 + "\n" + "longitude:" + longitude1 + "\n" +
//                "totalAvailable:" + totalAvailable1 + "\n" + "parkPrice:"
//                + parkPrice1);

        //remove park by parkId
//        int removeParkingLot = parkAPI.removeParkingLot(4);
//        System.out.println(removeParkingLot);
    }
}
