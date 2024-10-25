package com.example.servlets;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.servicios.ServicioConsumoRest;
import com.example.servicios.ServicioConsumoRestImpl;
import com.example.tallerrest.model.BicicletaBorrDTO;
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
@WebServlet("/jsp/metodosREST/svRecogerBiciCliente")
public class ServletRecogerBiciCliente extends HttpServlet {
	
	Logger logger = LoggerFactory.getLogger(ServicioConsumoRestImpl.class);
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRecogerBiciCliente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numSerie = request.getParameter("numSerie");
		
		BicicletaBorrDTO bici = new BicicletaBorrDTO(numSerie);
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicioConsumoRest servicioConsumoRest = (ServicioConsumoRest) appCtx.getBean("servicioConsumoRest");
		
		RespuestaServicio rs = servicioConsumoRest.peticionesPostPut("PUT", "http://localhost:8080/tallerREST/recogerBiciCliente", bici);
		
        if (rs != null) {
            HttpSession session = request.getSession();
            session.setAttribute("respuesta", rs);
    		
    		response.sendRedirect("../ventanaResultado.jsp");
        } else {
        	//TODO redirigir a ventana de error
        }
	}
}
