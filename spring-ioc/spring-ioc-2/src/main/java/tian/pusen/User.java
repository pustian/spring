package tian.pusen;

import java.io.Serializable;

/**
 * Created by tianpusen on 2017/3/25.
 */
public class User implements Serializable {
    private String userID;
    private String name;
    private String address;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
