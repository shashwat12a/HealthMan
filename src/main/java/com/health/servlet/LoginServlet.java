package com.health.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.health.dao.UserDAO;
import com.health.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    private static final String VALID_USERNAME = "admin@admin.com";
    private static final String VALID_PASSWORD = "password123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        request.setAttribute("message", "<b>Hello User, login to access the dashboard</b>");
        // Forward the request to the login.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }


    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {

    //     // Retrieve parameters from the login form
    //     String username = request.getParameter("email");
    //     String password = request.getParameter("password");

    //     // Verify credentials
    //     if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
    //         // If login is successful, redirect to a welcome page
    //         HttpSession session = request.getSession(true);
    //         session.setAttribute("email", username);  
    //         response.sendRedirect("users/list/");
    //     } else {
    //         // If login is failed, show an error message
    //         response.setContentType("text/html");
    //         request.setAttribute("message", "<b>Wrong Email or password</b>");
    //         // Forward the request to the login.jsp page
    //         RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
    //         dispatcher.forward(request, response);

    //     }
    // }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Fetch user details from the database
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            HttpSession session = request.getSession(true);
            session.setAttribute("email", user.getEmail());
            session.setAttribute("role", user.getRole());

            // Redirect based on user role
            if ("Admin".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("users/list/");
            } else if ("Doctor".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("patients/list_patients");
            } else if ("Patient".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("appointments/add");
            } else {
                session.invalidate();
                request.setAttribute("message", "<b>Unauthorized role</b>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            // Login failed
            request.setAttribute("message", "<b>Invalid email or password</b>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}