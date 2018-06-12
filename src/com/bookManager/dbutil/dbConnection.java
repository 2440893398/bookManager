package com.bookManager.dbutil;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bookManager.text.context;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public  class dbConnection {
  public static   Properties pr;
  public static DataSource ds;
    static {
        try {
            pr= new Properties (  );
            pr.load ( dbConnection.class.getClassLoader ().getResourceAsStream ( "com/configg/dbcpconfig.properties" ) );
           ds = DruidDataSourceFactory.createDataSource ( pr );
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }
    public static Connection getcon(){
        Connection c =null;
        try {
            c=ds.getConnection ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return c;
    }

    public static DataSource getDs() {
        return ds;
    }

    public static void close(PreparedStatement a, ResultSet b , Connection c) {
       if(a!=null){
           try {
               a.close ();
           } catch (SQLException e) {
               e.printStackTrace ();
           }
       }
       if(b!=null){
           try {
               b.close ();
           } catch (SQLException e) {
               e.printStackTrace ();
           }
       }
       if(c!=null){
           try {
               c.close ();
           } catch (SQLException e) {
               e.printStackTrace ();
           }
       }
    }
 }
