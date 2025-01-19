package com.health.servlet;

import com.health.dao.UserDAO;
import com.health.dao.PatientDAO;
import com.health.dao.DoctorDAO;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String phoneNumber = request.getParameter("phone");

        // Role-specific parameters
        String speciality = null, qualifications = null, dob = null, gender = null, address = null;
        if ("doctor".equalsIgnoreCase(role)) {
            speciality = request.getParameter("speciality");
            qualifications = request.getParameter("qualifications");
        } else if ("patient".equalsIgnoreCase(role)) {
            dob = request.getParameter("dob");
            gender = request.getParameter("gender");
            address = request.getParameter("address");
        }

        // Input validation
        if (username == null || password == null || email == null || role == null ||
            firstName == null || lastName == null || phoneNumber == null || 
            username.isEmpty() || password.isEmpty() || email.isEmpty() || 
            role.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid parameters.");
            return;
        }

        // Additional validation for roles
        if ("doctor".equalsIgnoreCase(role) && (speciality == null || qualifications == null ||
            speciality.isEmpty() || qualifications.isEmpty())) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing doctor-specific parameters.");
            return;
        }

        if ("patient".equalsIgnoreCase(role) && (dob == null || gender == null || address == null ||
            dob.isEmpty() || gender.isEmpty() || address.isEmpty())) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing patient-specific parameters.");
            return;
        }
        UserDAO usrdao = new UserDAO();
        // Call addUser function
        boolean userAdded = usrdao.addUser(username, password, email, role, firstName, lastName, phoneNumber);

        if (!userAdded) {
            response.setContentType("text/html");
            request.setAttribute("message", "<b>Failed to register user.</b>");
            // Forward the request to the login.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/users_new.jsp");
            dispatcher.forward(request, response);
            // response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to register user.");
            return;
        }

        // Simulate getting the user's ID (replace with actual logic to get user ID from database)
        int userId = 1; // Example user ID

        // Handle role-specific fields
        if ("patient".equalsIgnoreCase(role)) {
            try {
                // Convert dob to java.sql.Date
                Date dateOfBirth = Date.valueOf(dob);
                
                PatientDAO pDao = new PatientDAO();
                // Call addPatient method
                boolean patientAdded = pDao.addPatient(userId, dateOfBirth, gender, address);

                if (!patientAdded) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add patient details.");
                    return;
                }
            } catch (IllegalArgumentException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format for DOB.");
                return;
            }
        } else if ("doctor".equalsIgnoreCase(role)) {
            
            DoctorDAO dDao = new DoctorDAO();
            // Call addDoctor method

            boolean doctorAdded = dDao.addDoctor(userId, speciality, qualifications);

            if (!doctorAdded) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add doctor details.");
                return;
            }
        }

        // Respond with success message
        // response.getWriter().write("User registered successfully.");
        response.setContentType("text/html");
        request.setAttribute("message", "<b>User Registered successfully</b>");
        // Forward the request to the login.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users_list.jsp");
        dispatcher.forward(request, response);
        // response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to register user.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        request.setAttribute("message", "<b>add new user</b>");
        // Forward the request to the login.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("../../users_new.jsp");
        dispatcher.forward(request, response);
    }
}
