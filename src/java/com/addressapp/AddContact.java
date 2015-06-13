
package com.addressapp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


public class AddContact extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            HttpServletRequest hres=(HttpServletRequest)request;
            HttpSession session=hres.getSession();
            String userName=session.getAttribute("userName").toString();
            String Name= request.getParameter("name");
            String MobileNumber= request.getParameter("mobile");
            String Email= request.getParameter("email");
            Date DateOfBirth= new Date(request.getParameter("dob"));
            String City= request.getParameter("city");
            String Gender= request.getParameter("gender");
            Part p = request.getPart("photo");
            String FileName = getFileName(p);
            String dirName = getServletContext().getRealPath("/");
            String location = dirName+"uploads/"+FileName;
            String Category= request.getParameter("category");
            try{
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream(location);
            int x = is.available();
            byte[] arr = new byte[x];
            is.read(arr);
            fos.write(arr);
            is.close();
            fos.close();
            } catch(Exception ex){
            log(ex.toString());
            }       
            ContactInfo s= new ContactInfo(Name, MobileNumber, Email, DateOfBirth, City, Gender, Category, userName);
            HibManager.addContact(s);
            
            request.setAttribute("added", true);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/addContact.jsp");
            view.forward(request, response);
        
    }      
      private String getFileName(Part p){
        String str = "";
        String value = p.getHeader("content-disposition");
        String[] arr = value.split(";");
        int i = arr[2].indexOf("\"");
        int j = arr[2].lastIndexOf("\"");
        str = arr[2].substring(i+1,j);
        return str;
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
