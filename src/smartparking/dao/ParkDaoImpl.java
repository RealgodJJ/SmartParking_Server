package smartparking.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import smartparking.Server;
import smartparking.model.ParkData;
import smartparking.model.UserData;

import java.sql.SQLException;
import java.util.List;

public class ParkDaoImpl extends BaseDaoImpl<ParkData,Integer> implements ParkDao {

    public ParkDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ParkData.class);
    }

    //Having some problems
//    @Override
//    public List<ParkData> getNearParksByDistance(double destinationLatitude, double destinationLongitude, float limitDistance){
//        try{
//            //利用百度地图API球面距离公式
//            String eligibleParkingLots = "SELECT pklt.*,6371 * 2 * ASIN(SQRT(POWER(SIN((" + destinationLatitude + "-latitude) *pi()/180 / 2), 2) " +
//                    "+COS(" + destinationLatitude + "* pi()/180) * COS(latitude * pi()/180) *POWER(SIN((" + destinationLatitude + "-longitude) * pi()/180 / 2), 2) )) " +
//                    "as distance FROM parkingLots pklt WHERE longitude between " + destinationLongitude + "-" + limitDistance
//                    + "/abs(cos(radians(" + destinationLatitude + "))*69) and " + destinationLongitude + "+" + limitDistance + "/abs(cos(radians(" + destinationLatitude + "))*69)"
//                    + "and latitude " + "between " + destinationLatitude + "-(" + limitDistance + "/69) and " + destinationLatitude + "+(" + limitDistance + "/69) " +
//                    "HAVING distance<" + limitDistance + " order by distance";
//
//            GenericRawResults<ParkData> genericRawResults =
//                    queryRaw(eligibleParkingLots, new RawRowMapper<ParkData>() {
//                        public ParkData mapRow(String[] columnNames, String[] resultColumns) {
//                            ParkData parkData = new ParkData(resultColumns[0],
//                                    resultColumns[1], Double.parseDouble(resultColumns[2]),
//                                    Double.parseDouble(resultColumns[3]), Integer.parseInt(resultColumns[4]),
//                                    Float.parseFloat(resultColumns[5]));
//                            return parkData;
//                        }
//            });
//            return genericRawResults.getResults();
//        }catch(SQLException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    @Override
    public ParkData getParkById(int parkId){
        try {
            return queryForId(parkId);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public ParkData getParkByUid(String uid){
        try {
            List<ParkData> parkData = queryForEq("uid", uid);
            return parkData != null && parkData.size() > 0 ? parkData.get(0): null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int reservePark(ParkData parkData) {
        try{
//            UpdateBuilder<ParkData, Integer> update = updateBuilder();
            int totalAvailable = parkData.getTotalAvailable() - 1;
            System.out.println(totalAvailable);
            parkData.setTotalAvailable(totalAvailable);
//            update.updateColumnValue("totalAvailable",totalAvailable).where().eq("uid", parkData.getUid());
            return update(parkData);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int undoReservePark(ParkData parkData) {
        try{
//            UpdateBuilder<ParkData, Integer> update = updateBuilder();
            int totalAvailable = parkData.getTotalAvailable() + 1;
            System.out.println(totalAvailable);
            parkData.setTotalAvailable(totalAvailable);
            return update(parkData);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<ParkData> getParks(long offset, long limit){
        try{
            return queryBuilder().offset(offset).limit(limit).query();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int addParkingLot(ParkData parkData) {
        try {
            create(parkData);
            return parkData.getId();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateParkingLot(ParkData parkData) {
        try {
            return update(parkData);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int removeParkingLot(int parkId) {
        try {
            return deleteById(parkId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
