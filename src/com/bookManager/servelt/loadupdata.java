package com.bookManager.servelt;

import com.bookManager.dao.impl.bookDAOimpl;
import com.bookManager.domin.book;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/loadupdata")
public class loadupdata extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        book b = new book ();
        //获取磁盘文件项目工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory (  );
        //获取文件上传的路径
        String path=request.getServletContext ().getRealPath ("img");
        //设置暂存存地址
         factory.setRepository ( new File ( path ));
         //设置缓冲区大小
        factory.setSizeThreshold ( 1024*1024 );
        //使用内置方法进行上传操作
        ServletFileUpload upload = new ServletFileUpload(factory);
        //获取上传文件信息  支持获取多文件
        try {
            List<FileItem> items = upload.parseRequest ( request );
            //遍历多个文件信息分别进行上传操作
            for (FileItem file:items) {
                //获取表单的属性名
                String name = file.getFieldName ();
                //确定上传文件类型以进行不同的上传操作
                if(file.isFormField ()){
                    //用户填写的纯文本信息  直接获取内容
                   String s =  file.getString ();
                    s=new String ( s.getBytes ( "iso-8859-1" ),"utf-8" );
                    addvlue ( b,name,s );

                }else{
                    //当上传的为照片等文件时通过流进行处理
                    //获取文件路径名
                    String fileName = file.getName ();
                    //截取文件名
                    String fname = fileName.substring ( fileName.indexOf ( "\\" ) + 1 );
                    fname=new String ( fname.getBytes ( "iso-8859-1" ),"utf-8" );
                    addvlue ( b,name,fname );
                    //上传文件方法1 通过api提供的方法
                   /* try {
                        file.write ( new File ( path,fname ) );
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }*/
                   //方法2 手写流传输
                    InputStream inputStream = file.getInputStream ();
                    FileOutputStream outputStream = new FileOutputStream ( new File ( path, fname ) );
                    byte[] list = new byte[1024];
                    while (inputStream.read (list)!=-1){
                        outputStream.write ( list );
                    }
                    outputStream.flush ();
                    outputStream.close ();
                    inputStream.close ();
                    System.out.println (b);
                    bookDAOimpl imp = new bookDAOimpl ();
                    imp.gaibook ( b );
                    response.sendRedirect ( "hello" );
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace ();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public  void addvlue(book a,String name ,String v){
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor (name, book.class);
            Method method = pd.getWriteMethod() ;
            method.invoke(a, v) ;
        } catch (Exception e) {

        }

    }
}
