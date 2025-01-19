package com.health.servlet;

import java.io.IOException;
import java.util.List;

import com.health.dao.AppointmentDAO;
import com.health.model.Appointment;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AppointmentsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        request.setAttribute("message", "<b>Welcome, "+session.getAttribute("email")+"</b>");
        // Forward the request to the login.jsp page
        AppointmentDAO dao = new AppointmentDAO();
        List<Appointment> appointments = dao.listAllAppointments();
        request.setAttribute("appointments", appointments);
        System.out.println(appointments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../../appointments_list.jsp");
        dispatcher.forward(request, response);
    }
}
