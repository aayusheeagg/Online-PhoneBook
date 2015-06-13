package com.addressapp;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class validate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean logout=true;
        boolean status=false;
        boolean login=false;
        
        request.setAttribute("logout",logout);
        request.setAttribute("status",status);
        request.setAttribute("status",status); 
        
        String action = request.getParameter("action");
        if (action.equals("login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("pass");
            login=true;
            request.setAttribute("login",login);
            request.setAttribute("userName", userName);
            String name = DBManager.login(userName, password);
            if(name!=null) status=true;
            if (status) {
                HttpSession session = request.getSession();
                session.setAttribute("status", status);
                session.setAttribute("userName",name);
                request.setAttribute("userName",name);
                request.setAttribute("status",status);                
                RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("status",status);
                 RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                view.forward(request, response);
            }
        } else if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            logout=true;
            login=false;
            request.setAttribute("logout",logout);
            request.setAttribute("login",login);
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
        }
         if (action.equals("changepass")) {
            String userName= request.getParameter("userName");
            String passwordold = request.getParameter("currentpass");
            String passwordnew = request.getParameter("newpass");
            String passwordconfirm = request.getParameter("confirmpass");
            
            if(passwordnew.equals(passwordconfirm))
            {
            HttpSession session = request.getSession();
            boolean changed=DBManager.changepasswd(userName,passwordold,passwordnew);
            session.invalidate();
            logout=true;
            login=false;
            request.setAttribute("logout",logout);
            request.setAttribute("login",login);
            request.setAttribute("changed",changed);             
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
            }
            else
            {
              boolean wrong=true;
              request.setAttribute("wrong",wrong);
             RequestDispatcher view = request.getRequestDispatcher("user/changePassword.jsp");
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
