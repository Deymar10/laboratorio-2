package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "NuevaTarea", urlPatterns = {"/NuevaTarea"})
public class NuevaTarea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op.equals("borrar")) {
            int pos = -1;
            int buscado = -1;
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            ArrayList<Tareas> lista = (ArrayList<Tareas>) ses.getAttribute("ListaTareas");

            for (Tareas t : lista) {
                pos++;
                if (t.getId() == id) {
                    buscado = pos;
                }
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");

        Tareas tar = new Tareas();

        tar.setId(id);
        tar.setTarea(tarea);

        HttpSession ses = request.getSession();

        ArrayList<Tareas> tare = (ArrayList<Tareas>) ses.getAttribute("ListaTareas");

        tare.add(tar);

        response.sendRedirect("index.jsp");
    }
}
