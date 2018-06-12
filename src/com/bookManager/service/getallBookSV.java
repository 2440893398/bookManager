package com.bookManager.service;

import com.bookManager.dao.impl.bookDAOimpl;
import com.bookManager.domin.book;
import com.bookManager.domin.pageinf;
import com.bookManager.domin.selectDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class getallBookSV {
    private  bookDAOimpl impl;
    {
        impl = new  bookDAOimpl();
    }
        public void getall(HttpServletRequest sr){
        List<book> getall = impl.getall ();
        sr.setAttribute ( "list",getall );
    }
    public void  getbookbyid(HttpServletRequest sr,String id){
        book book = impl.getbookbyid ( id );
        sr.setAttribute ( "books",book );
    }
    public String  geturl(HttpServletRequest rs){
        String path = null;
        return path;
    }
    public void delebook(String id){
        impl.delbookbyid ( id );
    }
    public  void  getsomebook(HttpServletRequest sr , selectDate date){
        List<book> getbook = impl.getbook ( date );
        sr.setAttribute ( "list",getbook );
    }
    public  int checkEmail(String email){
        int end=0;
        int count =impl.getcountbyemail ( email ).intValue ();
        if(count>0){
            end=1;
        }else{
            end=0;
        }
        return end;
    }
    public void  showsomebook(HttpServletRequest re){
        // 获取总页数
        pageinf pageinf = (pageinf) re.getSession ().getAttribute ( "pageinf" );
        pageinf.setAllpage ((int)Math.ceil (  impl.getCount ().intValue ()/pageinf.getCount () ) -1 );
        //获取当前页内容
        List<book> getsomebook = impl.getsomebook ( pageinf.getCurrentpage (), pageinf.getCount () );
        System.out.println (pageinf.getCurrentpage ());
        re.setAttribute ( "list",getsomebook );
    }
}
