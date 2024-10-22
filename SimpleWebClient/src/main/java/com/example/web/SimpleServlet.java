package com.example.web;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.ejb.SimpleBeanLocal;

import java.io.IOException;

@WebServlet("/simple")
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleBeanLocal simpleBean = null;
        try {
            
            Context context = new InitialContext();
            simpleBean = (SimpleBeanLocal) context.lookup("java:global/CalcXEAR/CalcX/SimpleBean!com.example.ejb.SimpleBeanLocal");
            String message = simpleBean.sayHello(); 
            response.getWriter().write(message);
        } catch (NamingException e) {
            e.printStackTrace();
            response.getWriter().write("Error looking up EJB: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error invoking EJB: " + e.getMessage());
        }
    }
}
