/**
 * @author Javier
 * @since 21-10-2024
 */
package com.example.servlets;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.servicios.ServicioConsumoRest;
import com.example.tallerrest.model.BicicletaAltaDTO;
import com.example.tallerrest.model.RespuestaServicio;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletTaller
 */
@WebServlet("/jsp/metodosREST/svEntregarBiciAlTaller")
public class ServletEntregarBiciAlTaller extends HttpServlet {
	
	Logger logger = LoggerFactory.getLogger(ServletEntregarBiciAlTaller.class);
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEntregarBiciAlTaller() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color = request.getParameter("color");
		String numSerie = request.getParameter("numSerie");
		
		BicicletaAltaDTO bici = new BicicletaAltaDTO(color, numSerie);
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicioConsumoRest servicioConsumoRest = (ServicioConsumoRest) appCtx.getBean("servicioConsumoRest");
		
		try {
			RespuestaServicio rs = servicioConsumoRest.peticionesPostPut("POST", "http://localhost:8080/tallerREST/entregarBiciAlTaller", bici);
	        
	        if (rs != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("respuesta", rs);
	    		
	    		response.sendRedirect("../ventanaResultado.jsp");
	        }
		} catch (Exception e) {
			logger.debug("Error producido en ServletEntregarBiciAlTaller: " + e);
			throw new ServletException();
		}
	}
}
