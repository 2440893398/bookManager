package com.bookManager.servelt;

import com.bookManager.dao.impl.userDaoImpl;
import com.bookManager.dbutil.email;
import com.bookManager.domin.register;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/registSL")
public class registSL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        register re = new register ();
        try {
            //获取表达数据
            BeanUtils.populate ( re,request.getParameterMap ());
            //获取验证码内容
            Object o = request.getSession ().getAttribute ( "checkcode_session" );
            //第一层判断验证码是否正确
            if(o.equals ( re.getCheckcode () )){
                //验证两个密码是否正确
                if(re.getPassword ().equals ( re.getRepassword () )){
                    //执行添加数据操作
                    userDaoImpl user = new userDaoImpl ();
                    //激活码
                    String id = user.insertuser ( re );
                    email.sendEmail ( "2440893398@qq.com","邮箱激活","请点击下方链接进行激活" +
                            "<a href=\"http://localhost:8080/book/emailcheck?idcode="+id+"\">快点我呀！！！！！</a>" );
                    response.getWriter ().print ( 2 );
                }else{
                    //输出错误代码
                    response.getWriter ().print ( 1 );
                }
            }else {
                //输出错误代码
                response.getWriter ().print ( 0 );
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InvocationTargetException e) {
            e.printStackTrace ();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
