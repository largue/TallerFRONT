package com.example.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.example.taller.model.RespuestaServicio;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletTaller
 */
@WebServlet("/jsp/metodosREST/ServletTaller")
public class ServletTaller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTaller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numSerie = request.getParameter("numSerie");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("numSerie", numSerie);
		
		RestTemplate plantilla = new RestTemplate();
		String resultadoJSON = plantilla.getForObject("http://localhost:8080/tallerREST/recogerBiciCliente?numSerie={numSerie}", String.class, params);
        
        ObjectMapper objectMapper = new ObjectMapper();
        RespuestaServicio rs = objectMapper.readValue(resultadoJSON, RespuestaServicio.class);
        
        HttpSession session = request.getSession();
        session.setAttribute("respuesta", rs);
		
		response.sendRedirect("../ventanaResultado.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
