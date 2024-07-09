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
public class GetCases extends HttpServlet {

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jis?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "lucky@3904");
            Statement st = conn.createStatement();
            String getQ = "select * from case_details";
            ResultSet resultSet = st.executeQuery(getQ);
            String res = "";
            while (resultSet.next()) {
                String column1 = resultSet.getString("cin");
                String column2 = resultSet.getString("def_name");
                String column3 = resultSet.getString("def_address");
                String column4 = resultSet.getString("crime_type");
                String column5 = resultSet.getString("com_date");
                String column6 = resultSet.getString("com_location");
                String column7 = resultSet.getString("arr_off_name");
                String column8 = resultSet.getString("arr_date");
                String column9 = resultSet.getString("hearing_date");
                String column10 = resultSet.getString("vacant_date");
                String column11 = resultSet.getString("reason");
                String column12 = resultSet.getString("new_hear_date");
                String column13 = resultSet.getString("hearing_details");
                String column14 = resultSet.getString("judge_name");
                String column15 = resultSet.getString("pp");
                String column16 = resultSet.getString("starting_date");
                String column17 = resultSet.getString("end_date");
                String column18 = resultSet.getString("status");
                
                res = res + column1 + "|" + column2 + "|" + column3 + "|" + column4 + "|" + column5 + "|" + column6 + "|" + column7 + "|" + column8 + "|" + column9 + "|" + column10 + "|" + column11 + "|" + column12 + "|" + column13 + "|" + column14 + "|" + column15 + "|" + column16 + "|" + column17 + "|" + column18 + "+";
               
            }
            out.println(res);
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
