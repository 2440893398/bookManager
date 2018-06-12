package com.bookManager.servelt;

import com.bookManager.domin.pageinf;
import com.bookManager.service.getallBookSV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fenPage")
public class fenPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        pageinf p = new pageinf ();
        request.getSession ().setAttribute ( "pageinf",p );
        getallBookSV sv= new getallBookSV ();
        sv.showsomebook ( request );
        request.getRequestDispatcher ( "product_list.jsp" ).forward ( request,response );

    }
}
