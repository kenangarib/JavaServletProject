package com.example.javaservletproject;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlett")
@WebServlet(urlPatterns = {"/kenan","/revan"})
public class HelloServlet extends HttpServlet {

    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/University", "postgres", "kenan12345");
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet resultSet;
    public HelloServlet() throws SQLException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        try {
            statement=connection.createStatement();
            resultSet = statement.executeQuery("select * from public.teacher");
            while (resultSet.next()){
                printWriter.write(resultSet.getInt("id")+": "+resultSet.getString("name"));
                //System.out.println(resultSet.getInt("id")+": "+resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        Scanner mySc = new Scanner(System.in);
        PreparedStatement preparedStatement;
        Statement statement;
        ResultSet resultSet;
        boolean error;


    }
    @Override
    public void destroy() {

    }

   /* private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }*/
}