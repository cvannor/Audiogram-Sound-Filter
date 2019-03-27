/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Curtis Vannor <cvannor@uab.edu>
 * 
 */
@MultipartConfig
@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
public class FileUploadServlet extends HttpServlet {
    RequestDispatcher dispatcher;
    
    private final static Logger LOGGER = 
            Logger.getLogger(FileUploadServlet.class.getCanonicalName());

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    // Create path components to save the file
    final String path = "C:\\Users\\cvannor\\Documents\\NetBeansProjects\\ARDSProject\\uploads";
    /*final String path = request.getParameter("destination");*/
    final Part filePart = request.getPart("file");
    final String fileName = getFileName(filePart);
    /*final String fileShort = shortenFileName(fileName);*/
    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 

    OutputStream out = null;
    InputStream filecontent = null;
    final PrintWriter writer = response.getWriter();

    try {
        out = new FileOutputStream(new File(path + File.separator + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        
        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[]{fileName, path});
        String  fpath = path + File.separator + fileName;
        request.setAttribute("filePath", fpath);
        dispatcher = getServletContext().getRequestDispatcher("/InputParams.jsp");
        dispatcher.forward(request, response);
        
    } catch (FileNotFoundException fne) {
        fne.printStackTrace();
        writer.println("You either did not specify a file to upload or are "
                + "trying to upload a file to a protected or nonexistent "
                + "location. Please go back and try again.");
        writer.println("<br/> ERROR: " + fne.getMessage());



        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", new Object[]{fne.getMessage()});
    } finally {
        if (out != null) {
            out.close();
        }
        if (filecontent != null) {
            filecontent.close();
        }
        if (writer != null) {
            writer.close();
        }
    }
    
}

private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
            
        }
    }
    return null;
}

private String shortenFileName(final String name) {
    //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
 
    return name.substring(name.lastIndexOf("\\"));
            
   
  
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
