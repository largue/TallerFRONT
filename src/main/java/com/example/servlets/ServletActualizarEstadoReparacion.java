package com.example.servlets;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.servicios.ServicioConsumoRest;
import com.example.tallerrest.model.BicicletaModDTO;
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
@WebServlet("/jsp/metodosREST/svActualizarEstadoReparacion")
public class ServletActualizarEstadoReparacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarEstadoReparacion() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numSerie = request.getParameter("numSerie");
		String estadoReparacion = request.getParameter("estadoReparacion");
		
		BicicletaModDTO bici = new BicicletaModDTO(numSerie, estadoReparacion);
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicioConsumoRest servicioConsumoRest = (ServicioConsumoRest) appCtx.getBean("servicioConsumoRest");
		
		RespuestaServicio rs = servicioConsumoRest.peticionesPostPut("PUT", "http://localhost:8080/tallerREST/actualizarEstadoReparacion", bici);
        
        if (rs != null) {
            HttpSession session = request.getSession();
            session.setAttribute("respuesta", rs);
    		
    		response.sendRedirect("../ventanaResultado.jsp");
        } else {
        	//TODO redirigir a ventana de error
        }
	}
}
