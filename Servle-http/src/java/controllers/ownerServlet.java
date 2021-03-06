/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ownerDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Owner;
import dao.ownerDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronald Galicia
 */
@WebServlet(name = "ownerServlet", urlPatterns = {"/ownerServlet"})
public class ownerServlet extends HttpServlet {

    String action = "";

    ownerDao owDao = new ownerDao();
    ownerDao oDao = new ownerDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Owner owner = new Owner();
            List<Owner> ownerList = new ArrayList();

            //String idOwner = "";

            String strExp = (request.getParameter("optionOwner") == null) ? "0" : request.getParameter("optionOwner");
            int opcion = Integer.parseInt(strExp);
            this.action = (request.getParameter("actionFormHidden") == null) ? "nulo" : request.getParameter("actionFormHidden");

            switch (opcion) {
                case 1:
                    response.sendRedirect("registerOwner.jsp");
                    break;
                case 2:
                    response.sendRedirect("ListAllOwners.jsp");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("La opcion es incorrecta");
                    ;
            }

            switch (this.action) {
                case "register":
                    String nameOwner = request.getParameter("nameOwner");

                    Owner newOwner = new Owner(nameOwner);
                    
                    try {
                        this.owDao.addOwner(newOwner);
                    } catch (Exception ex) {
                        Logger.getLogger(ownerServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
            

                    Owner regNameOwner = new Owner(nameOwner);
                    this.oDao.registerOwner(regNameOwner);
                    response.sendRedirect("index.jsp");
                break;
                case "showOwners":
                    System.out.println("Leeeegggaaa aqukkki");

                break;
                default:
                    System.out.println("el valor es nulo");
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
