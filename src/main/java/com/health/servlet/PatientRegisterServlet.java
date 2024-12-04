package com.health.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

public class PatientRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        resp.setContentType("text/html");

        // Optional: Set some attributes to be accessed in the JSP
        req.setAttribute("message", "<b>Hello</b>, admin user!");

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/patient_register.jsp");
        dispatcher.forward(req, resp);
    }
}
