package com.health.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.Filter;

import java.io.*;

public class AuthFilter implements Filter {

    // Filter initialization method (not used here, but can be helpful for setup)
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    // Filter method to intercept requests and check for authentication
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the session contains a logged-in user attribute (e.g., username or user object)
        HttpSession session = httpRequest.getSession(false); // false: don't create a new session if one doesn't exist
        boolean isLoggedIn = (session != null && session.getAttribute("email") != null);

        // If the user is not logged in, redirect to the login page
        if (!isLoggedIn) {
            // Redirect the user to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
        } else {
            // If logged in, proceed with the request
            chain.doFilter(request, response);
        }
    }

    // Filter destroy method (can clean up resources if needed)
    @Override
    public void destroy() {
    }
}
