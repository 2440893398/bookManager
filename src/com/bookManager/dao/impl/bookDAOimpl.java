package com.bookManager.dao.impl;

import com.bookManager.dao.IbookDao;
import com.bookManager.dbutil.dbConnection;
import com.bookManager.domin.book;
import com.bookManager.domin.selectDate;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDAOimpl implements IbookDao {
   private QueryRunner run;
     {
        run = new QueryRunner (   dbConnection.getDs ());
    }
    @Override
    public List<book> getall() {
        String sql="select * from books";
        List<book> query=null;
        try {
             query = run.query ( sql, new BeanListHandler<book> ( book.class ) );

        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return query;
    }

    @Override
    public book getbookbyid(String id) {
         book a = new book ();
         String sql = "select * from books where id=?";
        try {
            a = run.query ( sql, new BeanHandler<book> ( book.class ), id );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return a;
    }

    @Override
    public void savebook(book a) {
        String sql ="insert into books values(?,?,?,?,?,?,?)";
        try {
             run.update ( sql, a.getId (), a.getName (), a.getPrice (), a.getPnum (), a.getCategory (), a.getDescription (), a.getImg_url () );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
    public  void  gaibook(book a){
        String sql = "update books set name=?, price=?, pnum=?, category=?, description=?, img_url=? where id=?";
        try {
            run.update ( sql, a.getName (), a.getPrice (), a.getPnum (), a.getCategory (), a.getDescription (), a.getImg_url (), a.getId () );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
    public void delbookbyid(String id){
         String sql = "delete from books where id=?";
        try {
            run.update ( sql,id );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
    public List<book> getbook(selectDate date){
         String sql = "SELECT * from books where 1=1 and id LIKE ? \n" +
                 "and name like ? and price>=? and price<=? AND category LIKE ?";
        List<book> query= null;
         try {
             query = run.query ( sql, new BeanListHandler<book> ( book.class ), "%" + date.getId () + "%",
                    "%" + date.getName () + "%", date.getMin (), date.getMax (), date.getCategory ()+"%" );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return query;
    }

    public  Long getcountbyemail(String email){
         Long end=null;
        String sql = "select count(*) from bookuser where email=?";
        try {
            end =(Long) run.query ( sql, new ScalarHandler(),email);
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return end;
    }
    public List<book> getsomebook(int begin , int count){
         List<book> end = new ArrayList<book> (  );
         String sql= "select * from books limit ?,?";
        try {
            end = run.query ( sql, new BeanListHandler<book> ( book.class ), begin, count );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return end;
    }
    public  Long getCount(){
      Long end = null;
         String sql = "select count(*) from books";
        try {
           end=  (Long) run.query ( sql,new ScalarHandler (  ) );
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return end;
    }
}
