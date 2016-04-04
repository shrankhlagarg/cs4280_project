/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.web.servlet.hotel;

import hotelBooking.core.domain.Hotel;
import hotelBooking.core.jdbc.HotelDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aksharma2
 */
public class ViewHotel extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            String nextJSP="/Views/User/hotelmgmt.jsp";
            
            String id=request.getParameter("id");
            String radio=request.getParameter("Q2");
            ArrayList<Hotel>hotels=new ArrayList<Hotel>();
            HotelDBHandler db=new HotelDBHandler();
            boolean check=db.checkConnection();
            
            if(check){
                
                if(radio.equals("city"))
                    hotels=db.findHotelByCity(id);
                
                else if(radio.equals("id"))
                    hotels=db.findHotelById(id);
                
                else if(radio.equals("allHotels"))
                    hotels=db.findHotel();
                
            }
              
            request.setAttribute("hotel", hotels);
            
           
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewHotel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nextJSP="/Views/User/hotelmgmt.jsp";
        
        String name="id";
        request.setAttribute("eid", name);
        
       
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
         response.sendRedirect("/Views/User/hotelmgmt.jsp");
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