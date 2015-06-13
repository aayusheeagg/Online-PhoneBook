
package com.addressapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Contacts extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         String action = request.getParameter("action");
          HttpServletResponse hres = (HttpServletResponse)response;
        HttpServletRequest hreq = (HttpServletRequest)request;
        HttpSession session = hreq.getSession();
         if(session.getAttribute("userName")==null)
            hres.sendRedirect("login.jsp");
        else{        
        if(action.equals("add")){
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/addContact.jsp");
            view.forward(request, response);
        }else if(action.equals("view")){
            String userName=session.getAttribute("userName").toString();
            List list = HibManager.getAllContacts(userName);           
            request.setAttribute("list", list);            
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/viewContact.jsp");
            view.forward(request, response);
        }else if(action.equals("contact")){
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/ContactUs.jsp");
            view.forward(request, response);
        }else if(action.equals("changepass")){
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/changePassword.jsp");
            view.forward(request, response);
        }else if(action.equals("editContact")){
            String userName=session.getAttribute("userName").toString();
            String mobileNumber=request.getParameter("mobile");
            ContactInfo s=HibManager.getContact(mobileNumber,userName);
            request.setAttribute("s", s);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/editContact.jsp");
            view.forward(request, response);
        }else if(action.equals("deleteContact")){
            String userName=session.getAttribute("userName").toString();
            String[] selectedItems=request.getParameterValues("check");
            for(String item :selectedItems){
                HibManager.deleteContact(item,userName);
            } 
            List list = HibManager.getAllContacts(userName);          
            request.setAttribute("list", list);            
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/viewContact.jsp");
            view.forward(request, response);
        }
        
    }
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
