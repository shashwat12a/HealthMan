package com.health.servlet;

import java.io.IOException;

import com.health.dao.AppointmentDAO;
import java.sql.Timestamp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppointmentAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        resp.setContentType("text/html");

        // Optional: Set some attributes to be accessed in the JSP
        req.setAttribute("message", "<b>Hello</b>, patient user!");

        // Forward the request to the JSP page
        req.getRequestDispatcher("../../appointments_add.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientIdStr = req.getParameter("patientId");
        String doctorIdStr = req.getParameter("dcotorId");
        String dateStr = req.getParameter("appointmentDate");

        int patientId = Integer.parseInt(patientIdStr);
        int doctorId = Integer.parseInt(doctorIdStr);
        Timestamp date = Timestamp.valueOf(dateStr);

        AppointmentDAO dao = new AppointmentDAO();
        dao.addAppointment(patientId, doctorId, date, "pending");
        resp.setContentType("text/html");
        req.setAttribute("message", "<b>Appointment added successfully</b>");
        // Forward the request to the login.jsp page
        RequestDispatcher dispatcher = req.getRequestDispatcher("../../appointments_add.jsp");
        dispatcher.forward(req, resp);
    }
}
