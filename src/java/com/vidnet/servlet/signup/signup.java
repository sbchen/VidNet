/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.servlet.signup;

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
public class signup extends HttpServlet {

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
    
    //constants
    String dest = "/About.jsp";
    
    //temporary working variables
    User tempUser;
    
    //models with business functions
    UserModel userModel;
    
    //other helpers
    RequestDispatcher requestDispatch;
    int tempIndex;
    String tempStr;
    
    //session
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //initialize userModel
        userModel = new UserModel();
        
        //retrieve session
        session = request.getSession();
        
        //intialize RequestDispatcher
        requestDispatch = getServletContext().getRequestDispatcher(dest);
        
        //attemp to sign up
        tempUser = userModel.Signup(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
        
        if (tempUser != null) {
            session.setAttribute("user", tempUser);
            session.setAttribute("userid", "" + tempUser.getUserID());
            session.setAttribute("username", tempUser.getUsername());
            session.setAttribute("email", tempUser.getEmail());
            requestDispatch.forward(request, response);
        } else {
            session.setAttribute("user", null);
            session.setAttribute("userid", -1);
            session.setAttribute("username", " ");
            session.setAttribute("email", " ");
            session.setAttribute("Authenticated", false);
            PrintWriter out = response.getWriter();
            out.println("<h1>Sign up information is invalid!</h1>");
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
//            out.println("<title>Servlet signup</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
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
