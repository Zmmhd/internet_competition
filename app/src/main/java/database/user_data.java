package database;

//  主要用于管理基本的用户信息
//  继承Reciting_Words类，用于调用各种方法


import java.io.Serializable;

public class user_data extends Reciting_Words implements Serializable {
    String user_name;
    double user_coin;

    public user_data() {

    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public double getUser_coin() {
        return user_coin;
    }

    public void setUser_coin(double user_coin) {
        this.user_coin = user_coin;
    }

    public user_data(String user_name, double user_coin) {
        this.user_name = user_name;
        this.user_coin = user_coin;
    }
}
