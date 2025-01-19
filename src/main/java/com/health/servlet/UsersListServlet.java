package com.health.servlet;

import java.io.IOException;
import java.util.List;

import com.health.dao.UserDAO;
import com.health.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        request.setAttribute("message", "<b>Welcome, "+session.getAttribute("email")+"</b>");
        // Forward the request to the login.jsp page
        UserDAO dao = new UserDAO();
        List<User> users = dao.getAllUsers();
        request.setAttribute("users", users);
        System.out.println(users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../../users_list.jsp");
        dispatcher.forward(request, response);
    }
}
