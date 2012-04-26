/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vidnet.servlet.upload;

import com.vidnet.db.User;
import com.vidnet.db.Video;
import com.vidnet.db.VideoModel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author SC
 */
public class VidUploadServlet extends HttpServlet {

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        File file;
        int nextVideoID;
        int maxFileSize = 100000 * 1024;
        int maxMemSize = 100000 * 1024;
        String filePath = getInitParameter("diskpath");
        String title = request.getParameter("title");
        String desc = request.getParameter("desc");
        String dest = "/Profile.jsp";
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher(dest);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        VideoModel videoModel = new VideoModel();
        
        //Verify the content type
        String contentType = request.getContentType();
        if (contentType.contains("multipart/form-data")) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            //location to save data that is larger than maxMemSize
            factory.setRepository(new File("C:\\VidNet\\Temp"));
            
            //create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            //set maximum file size to be uploaded
            upload.setSizeMax(maxFileSize);
            try {
                //parse the request to get file items
                List fileItems = upload.parseRequest(request);
                
                //process the uploaded file items
                Iterator i = fileItems.iterator();
                FileItem fi;
                String fieldName;
                String fileName;
                
                //set the filepath
//                filePath += user.getUsername() + "\\";
                
                //set the filename
                nextVideoID = videoModel.NextVideoID();
                fileName = user.getUsername() + nextVideoID;
                
                while (i.hasNext()) {
                    fi = (FileItem)i.next();
                    if (!fi.isFormField()) {
                        //check if directory exists. if it doesn't, make the directory
                        file = new File(filePath);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        
                        //write the file
                        file = new File(filePath + fileName);
                        fi.write(file);
                        
                        //store file in the database
                        videoModel.Upload(nextVideoID, title, desc, "Uploads/" + fileName, user.getUserID());
                    } else {
                        fieldName = fi.getFieldName();
                        if (fieldName.equals("title")) {
                            title = fi.getString();
                        } else if (fieldName.equals("desc")) {
                            desc = fi.getString();
                        }
                    }
                }
                
                LinkedList<Video> userVidList = videoModel.getVideos(user);
                session.setAttribute("userVidList", userVidList);
                rd.forward(request, response);
                
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet VidUploadServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet VidUploadServlet at " + request.getContextPath() + "</h1>");
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
