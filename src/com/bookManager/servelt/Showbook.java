package com.bookManager.servelt;

import com.bookManager.service.getallBookSV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Showbook")
public class Showbook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter ( "id" );
        id = new String ( id.getBytes ("iso-8859-1"),"utf-8" );
        getallBookSV sv  = new getallBookSV ();
        sv.getbookbyid ( request,id );
        request.getRequestDispatcher ( "product_info.jsp" ).forward ( request,response );
    }
}
