package com.bookManager.servelt;

import com.bookManager.service.getallBookSV;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")@MultipartConfig
public class getAllbookSL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getallBookSV list =new getallBookSV ();
        list.getall ( request );
        request.getRequestDispatcher ( "admin/products/list.jsp" ).forward ( request,response );
    }
}
