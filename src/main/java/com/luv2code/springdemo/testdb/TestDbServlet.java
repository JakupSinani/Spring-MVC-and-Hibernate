package com.luv2code.testdb;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "testdbservlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //setup connection variables
        String user="root";
        String pass="123456";

        String jdbcurl="jdbc:mysql://localhost:3306/hb_web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver ="com.mysql.cj.jdbc.Driver";
        //get connection to database
        try {
            PrintWriter out=response.getWriter();

            out.println("Connecting to database: "+jdbcurl);

            Class.forName(driver);
            Connection myConn= DriverManager.getConnection(jdbcurl,user,pass);
            out.println("SUCCESS");

            myConn.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }

        //        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }


}