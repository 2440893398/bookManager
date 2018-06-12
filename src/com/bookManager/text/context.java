package com.bookManager.text;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;


public class context {
    @Test
    public  void  test() throws Exception {
        /// 发件人的 邮箱 和 密码
        String myemail = "17610775285@163.com";
        String myemailpwd="chen2440893398";
        // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
        // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
        String myEmailSMTPHost="smtp.163.com";
        // 收件人邮箱（替换为自己知道的有效邮箱）
        String receiveMailAccount="17610775285@163.com";
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties pp = new Properties (  );
        pp.setProperty ( "mail.transport.protocol","smtp" );    //设置使用的协议（javaEmail规范要求）
        pp.setProperty ( "mail.smtp.host" ,myEmailSMTPHost);       //设置发件人邮箱的stmp服务地址
        pp.setProperty ( "mail.smtp.auth","true" );                //设置是否需要验证
        //创建回话对象，用于和邮件服务器进行交互
        Session se = Session.getInstance ( pp );
        se.setDebug ( true );                                           // 设置为debug模式, 可以查看详细的发送 log
        //创建一封信
        MimeMessage mm = new MimeMessage ( se );
        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        mm.setFrom (new InternetAddress ( myemail,"某宝网","utf-8" ));
        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        mm.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "XX用户", "UTF-8"));
        //4. Subject: 邮件主题
        mm.setSubject ( "text","utf-8" );
        //5.content:邮件正文
        mm.setContent ( "sfa;lasdjklfjal;fjasdklfjasld;jf;lasdjf","text/html;charset=utf-8" );
        //6.设置发送时间
        mm.setSentDate ( new Date (  ) );
        //7.保存设置
        mm.saveChanges ();
        //邮件传输      根据 Session 获取邮件传输对象
        Transport transport = se.getTransport ();
        //根据账号密码
        transport.connect (myemail,myemailpwd);
        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(mm, mm.getAllRecipients());
        transport.close();
    }
}
