package com.bookManager.dbutil;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class email {
    private static Properties pp =null;
    static {
        pp=new Properties (  );
        try {
            pp.load ( email.class.getClassLoader ().getResourceAsStream ( "com/configg/email.properties" ) );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public static  void sendEmail(String receiveMailAccount,String  subject,String text){
        String  emailName  = pp.getProperty ( "myEmailAccount" );
       String  emailPwd = pp.getProperty ( "myEmailPassword" );
        Session se = Session.getInstance ( pp );
        se.setDebug ( true );
        //创建一封邮件
        MimeMessage mm = new MimeMessage ( se );
        try {
            mm.setFrom ( new InternetAddress ( emailName,"3y14网","utf-8" ) );
            mm.setRecipient ( MimeMessage.RecipientType.TO,new InternetAddress(receiveMailAccount,"亲爱的用户","utf-8") );
            mm.setSubject ( subject );
            mm.setContent ( text,"text/html;charset=utf-8" );
            mm.setSentDate ( new Date (  ) );
            mm.saveChanges ();
            Transport tr = se.getTransport ();
            tr.connect (emailName,emailPwd);
            tr.sendMessage ( mm,mm.getAllRecipients () );
            tr.close ();
        } catch (MessagingException e) {
            e.printStackTrace ();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        }
    }
}
