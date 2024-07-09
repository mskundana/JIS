/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucky
 */
public class Add extends HttpServlet {

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
        
        String defName = request.getParameter("defName");
        String defAddress = request.getParameter("defAddress");
        String ctype = request.getParameter("ctype");
        String comDate = request.getParameter("comDate");
        String comLoc = request.getParameter("comLoc");
        String offName = request.getParameter("offName");
        String arrDate = request.getParameter("arrDate");
        String cin = request.getParameter("cin");
        String hearDate = request.getParameter("hearDate");
        String vacSlot = request.getParameter("vacSlot");
        String reason = request.getParameter("reason");
        String newHearDate = request.getParameter("newHearDate");
        String hearDetails = request.getParameter("hearDetails");
        String judgeName = request.getParameter("judgeName");
        String pp = request.getParameter("pp");
        String stDate = request.getParameter("stDate");
        String endDate = request.getParameter("endDate");
        String status = request.getParameter("status");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jis?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "lucky@3904");
            Statement st = conn.createStatement();
            String getQ = "select * from case_details where cin = '" + cin + "'";
            ResultSet res = st.executeQuery(getQ);
            if (!res.first()) {
                String query = "insert into case_details values('" + cin + "','" + defName + "','" + defAddress + "','" + ctype + "','" + comDate + "','" + comLoc + "','" + offName + "','" + arrDate + "','" + hearDate + "','" + vacSlot + "','" + reason + "','" + newHearDate + "','" + hearDetails + "','" + judgeName + "','" + pp + "','" + stDate + "','" + endDate + "','" + status + "');";
                int sts = st.executeUpdate(query);
                if (sts == 1) {
                    out.println("Case Added Successfully!!!");
                } else {
                    out.println("error");
                }
            }else{
                out.println("CIN Already Exists...");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
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
