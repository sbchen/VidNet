/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.servlet.login;

import com.vidnet.db.User;
import com.vidnet.db.UserModel;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SC
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //temporary working variables
    User tempUser;
    
    //models with business functions
    UserModel userModel = new UserModel();
    
    //other helpers
    RequestDispatcher requestDispatch;
    String dest = "/About.jsp";
    int tempUserID;
    
    //session
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //retrieve session
        session = request.getSession();
        
        //intitialize RequestDispatcher
        requestDispatch = getServletContext().getRequestDispatcher(dest);
        
        //authenticate
        tempUser = userModel.Login(request.getParameter("email"), request.getParameter("pass"));
        
        if (tempUser != null) {
            session.setAttribute("user", tempUser);
            session.setAttribute("Authenticated", true);
            requestDispatch.forward(request, response);
        } else {
            session.setAttribute("user", null);
            session.setAttribute("Authenticated", false);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Incorrect username/password combination!</h1>");
            out.close();
        }
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
