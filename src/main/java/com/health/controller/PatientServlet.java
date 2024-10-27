package com.health.controller;

import com.health.model.Patient;
import com.health.service.PatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/patients")
public class PatientServlet extends HttpServlet {
    private PatientService patientService = new PatientService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Patient List</h1>");
        for (Patient patient : patientService.getAllPatients()) {
            out.println("<p>" + patient.getName() + " (Age: " + patient.getAge() + ")</p>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int id = patientService.getAllPatients().size() + 1; // Simple ID assignment
        patientService.addPatient(new Patient(id, name, age));
        response.sendRedirect("patients");
    }
}
