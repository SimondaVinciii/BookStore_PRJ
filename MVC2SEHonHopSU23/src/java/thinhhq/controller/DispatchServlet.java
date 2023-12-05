/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thinhhq.util.MyApplicationConstants;

/**
 *
 * @author ANDIM
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

//    private final String SEARCH_PRODUCT_CONTROLLER = "SearchProductServlet";
//    private final String LOGIN_PAGE = "login.html";
//    private final String LOGIN_PAGE = "";
//    private final String LOGIN_CONTROLLER = "LoginServlet";
//    private final String LOGIN_CONTROLLER = "LoginServlet";
//    private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastNameServlet";
//      private final String SEARCH_LASTNAME_CONTROLLER = "searchController";
//    private final String DELETE_ACCOUNT = "DeleteAccountServlet";
//    private final String UPDATE_ACCOUNT = "UpdateServlet";
//    private final String START_UP_SERVLET = "StartUpServlet";
//    private final String ADD_ITEM_TO_CART_CONTROLLER = "AddItemToCartServlet";
//    private final String VIEW_ITEM_PAGE = "viewCart.jsp";
//    private final String REMOVE_ITEMS_FROM_CART = "RemoveItemsFromCartServlet";
//    private final String CREATE_NEW_ACCOUNT = "CreateAccountServlet";
//    private final String CHECK_OUT_CART = "CheckOutServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Which button did user click?
        String button = request.getParameter("btAction");
        //1. Get context scope
        ServletContext context = this.getServletContext();

        //2. Get siteMaps
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");
        //3. Use SiteMaps to get value of key 
        String url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.LOGIN_PAGE);

        try {
            if (button == null) { //trigger welcome file
//                url = START_UP_SERVLET;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.START_UP_CONTROLLER);
            } else if (button.equals("Login")) { // user click login
//                url = LOGIN_CONTROLLER;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.LOGIN_CONTROLLER);
            } else if (button.equals("Search")) {
//                url = SEARCH_LASTNAME_CONTROLLER;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.SEARCH_LASTNAME_CONTROLLER);
            } else if (button.equals("delete")) {
//                url = DELETE_ACCOUNT;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.DELETE_ACCOUNT_CONTROLLER);
            } else if (button.equals("Update")) {
//                url = UPDATE_ACCOUNT;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.UPDATE_ACCOUNT_CONTROLLER);

            } else if (button.equals("Add to your Cart")) {
//                url = ADD_ITEM_TO_CART_CONTROLLER;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.ADD_ITEM_TO_CART_CONTROLLER);
            } else if (button.equals("View your Cart")) {
//                url = VIEW_ITEM_PAGE;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.VIEW_ITEM_PAGE);
            } else if (button.equals("Remove Selected Items")) {
//                url = REMOVE_ITEMS_FROM_CART;

                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.REMOVE_ITEMS_FROM_CART);
            } else if (button.equals("Create New Account")) {
//                url = CREATE_NEW_ACCOUNT;
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.CREATE_NEW_ACCOUNT);
            } else if (button.equals("LogOut")) {
                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.LOG_OUT_CONTROLLER);
//            } else if (button.equals("SearchProduct")) {
////                url = siteMaps.getProperty(MyApplicationConstants.DispathFeature.SEARCH_PRODUCT_CONTROLLER);
//                url = SEARCH_PRODUCT_CONTROLLER;
            }

        } finally {
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
//***welcome-file trong web.xml phải là URL-pattern của servlet điều phối
//1. tạo điều phối, trung gian
//2. tạo view để add chức năng ra màn hình (login.html) action trong form phải là thằng điều phối ở b1 (lấy URL-pattern của nó)
//3. map tính năng vào trong điều phối đó (copy value của button và paste vào trong) dòng 27
//  dòng 27 là tạo URL trên dòng 15 trc
//  sau đó lấy URL đã tạo đặt thành tên của servlet chức năng ở b4
//4. tạo servlet chức năng
//5. tạo model (new obj, call method)
//6. nếu model có dữ liệu thì tạo DTO
