package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BienvenidoServlet", urlPatterns = {"/BienvenidoServlet"})
public class BienvenidoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        
        Cookie[] cooki = request.getCookies();
        
        if (cooki != null) {
            for (Cookie c : cooki) {
                if (c.getName().equals("aplicacion")) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        contador ++;
        Cookie c = new Cookie("aplicacion", Integer.toString(contador));
        c.setMaxAge(60);
        response.addCookie(c);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (contador == 1) {
            out.print("Bienvenído a la aplicacion");
            out.println("<br>");
        }else{
            out.print("Estas visitandonos de nuevo");
            out.println("<br>");
        }
        out.print(" las visitas que realizaste son: "+contador);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
