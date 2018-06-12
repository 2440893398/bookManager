package com.bookManager.servelt;

import com.bookManager.service.getallBookSV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delebook")
public class delebook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter ( "id" );
        //进行删除操作
        getallBookSV SV = new getallBookSV ();
        SV.delebook ( id );
        //跳转
        response.sendRedirect ( "hello" );
    }
}
