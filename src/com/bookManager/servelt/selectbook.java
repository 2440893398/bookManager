package com.bookManager.servelt;

import com.bookManager.domin.selectDate;
import com.bookManager.service.getallBookSV;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/selectbook")
public class selectbook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding ( "utf-8" );
        selectDate date = new selectDate ();
        try {
            BeanUtils.populate ( date,request.getParameterMap () );
            System.out.println (date);
            getallBookSV sv = new getallBookSV ();
            sv.getsomebook ( request,date );
            request.getRequestDispatcher ( "admin/products/list.jsp" ).forward ( request,response );
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InvocationTargetException e) {
            e.printStackTrace ();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
