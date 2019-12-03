package com.zhang.test;

import java.io.IOException;

/**
 * @author Zhangkj
 * @date 2019-05-17-16:09
 */
@javax.servlet.annotation.WebServlet(name = "AServlet" ,urlPatterns = "/AServlet")
public class AServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setAttribute("msg","this is a servlet");

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setAttribute("msg","this is a servlet");

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
