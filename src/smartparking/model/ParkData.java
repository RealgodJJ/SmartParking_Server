package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.ParkDaoImpl;

@DatabaseTable(tableName = "parkingLots",daoClass = ParkDaoImpl.class)
public class ParkData {

    @DatabaseField(generatedId = true, dataType = DataType.INTEGER)
    private int parkId;

    @DatabaseField(canBeNull = false, columnName = "uid", dataType = DataType.STRING)
    private String uid;

    @DatabaseField(canBeNull = false, columnName = "parkName", dataType = DataType.STRING)
    private String parkName;

//    @DatabaseField(canBeNull = false, columnName = "destination", dataType = DataType.STRING)
//    private String destination;
//
//    @DatabaseField(canBeNull = false, columnName = "latitude", dataType = DataType.DOUBLE)
//    private double latitude;
//
//    @DatabaseField(canBeNull = false, columnName = "longitude", dataType = DataType.DOUBLE)
//    private double longitude;

    @DatabaseField(canBeNull = false, columnName = "totalSpaces", dataType = DataType.INTEGER)
    private int totalSpaces;

    @DatabaseField(canBeNull = false, columnName = "totalAvailable", dataType = DataType.INTEGER)
    private int totalAvailable;

    @DatabaseField(canBeNull = false, columnName = "parkPrice", dataType = DataType.DOUBLE)
    private double parkPrice;

    @DatabaseField(canBeNull = false, columnName = "parkNightPrice", dataType = DataType.DOUBLE)
    private double parkNightPrice;


    public ParkData(){

    }

    public ParkData(String uid, String parkName, int totalSpaces, int totalAvailable, double parkPrice, double parkNightPrice) {
        this.uid = uid;
        this.parkName = parkName;
//        this.destination = destination;
//        this.latitude = latitude;
//        this.longitude = longitude;
        this.totalSpaces = totalSpaces;
        this.totalAvailable = totalAvailable;
        this.parkPrice = parkPrice;
        this.parkNightPrice = parkNightPrice;
    }

    public int getId() {
        return parkId;
    }

    public void setId(int parkId) {
        this.parkId = parkId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }

//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }


    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public double getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(double parkPrice) {
        this.parkPrice = parkPrice;
    }

    public double getParkNightPrice() {
        return parkNightPrice;
    }

    public void setParkNightPrice(double parkNightPrice) {
        this.parkNightPrice = parkNightPrice;
    }

    @Override
    public String toString() {
        return String.format("Park{parkId='%d', uid='%s', parkName='%s', totalSpaces='%d', totalAvailable='%d', parkPrice='%s', parkNightPrice='%s'}", parkId, uid, parkName, totalSpaces, totalAvailable, parkPrice, parkNightPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkData parkData = (ParkData) o;
        return parkId == parkData.parkId;

    }
    @Override
    public int hashCode() {
        return parkId;
    }
}
