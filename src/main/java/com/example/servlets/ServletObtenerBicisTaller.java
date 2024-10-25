package com.example.servlets;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.servicios.ServicioConsumoRest;
import com.example.tallerrest.model.BicicletaDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletTaller
 */
@WebServlet("/svObtenerBicisTaller")
public class ServletObtenerBicisTaller extends HttpServlet {
	
	Logger logger = LoggerFactory.getLogger(ServletObtenerBicisTaller.class);
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletObtenerBicisTaller() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numSerie = request.getParameter("numSerie");
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicioConsumoRest servicioConsumoRest = (ServicioConsumoRest) appCtx.getBean("servicioConsumoRest");
		
		List<BicicletaDTO> listaBicis = servicioConsumoRest.peticionGetBicisTaller("http://localhost:8080/tallerREST/obtenerBicisTaller");
        
        if (listaBicis != null) {
            HttpSession session = request.getSession();
            
            if (StringUtils.isNotBlank(numSerie)) {
            	listaBicis.forEach(bici -> {
        			if (bici.getNumSerie() == Integer.valueOf(numSerie).intValue()) {
        				session.setAttribute("numSerie", numSerie);
        				session.setAttribute("estadoReparacion", bici.getEstadoReparacion());
        			}
        		});	
            	
            	response.sendRedirect(request.getContextPath() + "/jsp/metodosREST/actualizarEstadoReparacion.jsp");
            } else {
            	session.setAttribute("listaBicis", listaBicis);
    		
            	response.sendRedirect(request.getContextPath() + "/jsp/ventanaBicisTaller.jsp");
            }
        } else {
        	//TODO redirigir a ventana de error
        }
	}
}
