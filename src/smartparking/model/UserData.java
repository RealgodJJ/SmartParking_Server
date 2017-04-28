package smartparking.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import smartparking.dao.UserDaoImpl;

import java.util.Date;

/**
 * 用户类
 */

@DatabaseTable(tableName = "users", daoClass = UserDaoImpl.class)
public class UserData {

    @DatabaseField(generatedId = true, dataType = DataType.INTEGER)
    private int id;

    @DatabaseField(canBeNull = false, columnName = "userName", dataType = DataType.STRING)
    private String userName;

    @DatabaseField(canBeNull = false, columnName = "password", dataType = DataType.STRING)
    private String password;

    @DatabaseField(canBeNull = false, columnName = "plateNo", dataType = DataType.STRING)
    private String plateNo;

    @DatabaseField(canBeNull = false, columnName = "registerDate", dataType = DataType.DATE_STRING, format = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;

    @DatabaseField(index = true, columnName = "phoneNumber", dataType = DataType.STRING)
    private String phoneNumber;

    @DatabaseField(canBeNull = false, columnName = "email", dataType = DataType.STRING)
    private String email;

    public UserData() {
        this.userName = getUserName();
        this.password = getPassword();
        this.plateNo = getPlateNo();
        this.registerDate = new Date();
        this.phoneNumber = getPhoneNumber();
        this.email = getEmail();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, userName='%s', password='%s', plateNo='%s', registerDate=%s, phoneNumber='%s', email='%s'}", id, userName, password, plateNo, registerDate, phoneNumber, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
