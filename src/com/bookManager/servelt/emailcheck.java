package com.bookManager.servelt;

import com.bookManager.dao.impl.userDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/emailcheck")
public class emailcheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter ( "idcode" );
        email = new String ( email.getBytes ( "iso-8859-1" ),"utf-8" );
        userDaoImpl imp = new userDaoImpl ();
        imp.activation ( email );
        response.sendRedirect ( "registersuccess.jsp" );
    }
}
