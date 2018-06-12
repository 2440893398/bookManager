package com.bookManager.servelt;

import com.bookManager.service.getallBookSV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkEmailSL")
public class checkEmailSL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取传入的值
        String email = request.getParameter ( "email" );
        email = new String ( email.getBytes ( "iso-8859-1" ),"utf-8" );
        System.out.println (email);
        getallBookSV SV = new getallBookSV ();
        int i = SV.checkEmail ( email );
        System.out.println (i);
        response.setContentType ( "text/html;charset=utf-8" );
       response.getWriter ().print ( i );
    }
}
