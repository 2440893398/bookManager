package com.bookManager.dao.impl;

import com.bookManager.dbutil.dbConnection;
import com.bookManager.domin.register;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class userDaoImpl {
    private QueryRunner run;
    {
        run = new QueryRunner (   dbConnection.getDs ());
    }
    {

    }
    public  String insertuser(register re){
        String sql = "insert into bookuser(username,`password`,gender,email,telephone,introduce,activeCode,state,role,registTime)" +
                " values(?,?,?,?,?,?,?,0,'注册用户',?)";
        String id = UUID.randomUUID ().toString ();
        String time =new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format ( new Date (  ) );
        try {
            run.update ( sql,re.getUsername (),re.getPassword (),re.getGender (),re.getEmail (),re.getTelephone (),re.getIntroduce (),id,time);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return id;
    }
    public void activation(String idcode){
        String sql="update bookuser set state=1 where activeCode=?";
        try {
            run.update ( sql,idcode );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
