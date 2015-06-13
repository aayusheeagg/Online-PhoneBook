
package com.addressapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditContact extends HttpServlet {

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
            String Category= request.getParameter("category");
            
            ContactInfo s= new ContactInfo(Name, MobileNumber, Email, DateOfBirth, City, Gender, Category, userName);
            HibManager.updateContact(s);
            List list = HibManager.getAllContacts(userName);           
            request.setAttribute("list", list);            
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/viewContact.jsp");
            view.forward(request, response);
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
