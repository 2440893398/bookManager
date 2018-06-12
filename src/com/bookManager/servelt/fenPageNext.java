package com.bookManager.servelt;

import com.bookManager.domin.pageinf;
import com.bookManager.service.getallBookSV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fenPageNext")
public class fenPageNext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getallBookSV sv  = new getallBookSV ();
        //获取当前页
        pageinf pageinf = (pageinf) request.getSession ().getAttribute ( "pageinf" );
        int currentpage = pageinf.getCurrentpage ();
        pageinf.setEndelecode ( pageinf.getEndelecode ()+1 );
        currentpage+=pageinf.getEndelecode ()*pageinf.getCount ();
        pageinf.setCurrentpage ( currentpage );
        sv.showsomebook ( request );
        request.getRequestDispatcher (  "product_list.jsp").forward ( request,response );

    }
}
