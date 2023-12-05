/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thinhhq.model.tblProductDAO;
import thinhhq.model.tblProductDTO;

/**
 *
 * @author ANDIM
 */
@WebServlet(name = "SearchProductServlet", urlPatterns = {"/SearchProductServlet"})
public class SearchProductServlet extends HttpServlet {
private final String SEARCH_PRODUCT_PAGE = "shopping.html";
private final String RESULT_PRODUCT_PAGE = "shopping.jsp";

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
        String searchValue = request.getParameter("searchProduct");
        String url = "";
        
        try  {
          if(searchValue == null) {
              tblProductDAO dao = new tblProductDAO();
              dao.allProDuct();
              
              List<tblProductDTO> result = dao.getAllproductList();
              request.setAttribute("ALL_P", result);
              url = RESULT_PRODUCT_PAGE;
          } else {
              tblProductDAO dao = new tblProductDAO();
              dao.searchProDuct(searchValue);
              List<tblProductDTO> result = dao.getSearchList();
              request.setAttribute("SEACH_P", result);
              url = RESULT_PRODUCT_PAGE;
          }
           
        } catch (SQLException ex) {
            log("Exception _ SQL " + ex.getMessage());
    } catch (NamingException ex) {
         log("Exception _ Naming " + ex.getMessage());
    } finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
