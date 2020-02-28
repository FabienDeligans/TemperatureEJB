/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import conv.Convertir;
import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class SrvlTemperature extends HttpServlet {

    private Convertir convertir;
    public String erreur; 

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
        double resultat;
        try {
            Context ctx = new InitialContext();
            convertir = (Convertir) ctx.lookup("java:global/TemperatureWeb/Convertir");
            String demande = request.getParameter("cbChoix");            
            if (demande.equals("cf")) {
                resultat = CelsiusToFahrenheit(request);                
            } else {
                resultat = FahrenheitToCelsius(request);                
            }
            request.setAttribute("degre", request.getParameter("degre"));
            request.setAttribute("resultat", resultat);
        } catch (Exception e) {
            erreur = e.getMessage();            
        } finally {
            request.setAttribute("erreur", erreur);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");            
            dsp.forward(request, response);
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

    private double CelsiusToFahrenheit(HttpServletRequest request) throws Exception{

        double resultat = 0; 
        double tempC = 0; 
        
        try {
            tempC = Double.parseDouble(request.getParameter("degre")); 
            resultat = convertir.ConvertirCelciusToFahrenheit(tempC); 
            return resultat; 
            
        } catch (Exception e) {
            throw e; 
        }
    }

    private double FahrenheitToCelsius(HttpServletRequest request) throws Exception{
        
        double resultat = 0; 
        double tempF = 0; 
        
        try {
            tempF = Double.parseDouble(request.getParameter("degreé")); 
            resultat = convertir.convertirFahrenheitToCelcius(tempF); 
            return resultat; 
            
        } catch (Exception e) {
            throw e; 
        }
    }

}
