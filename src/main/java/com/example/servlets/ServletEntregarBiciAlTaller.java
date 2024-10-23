package com.example.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.tallerrest.model.BicicletaAltaDTO;
import com.example.tallerrest.model.RespuestaServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
		
		RestTemplate plantilla = new RestTemplate();

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(bici);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
		
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);
		String resultadoJSON = plantilla.postForObject("http://localhost:8080/tallerREST/entregarBiciAlTaller", entity, String.class);
		
        ObjectMapper objectMapper = new ObjectMapper();
        RespuestaServicio rs = objectMapper.readValue(resultadoJSON, RespuestaServicio.class);
        
        HttpSession session = request.getSession();
        session.setAttribute("respuesta", rs);
		
		response.sendRedirect("../ventanaResultado.jsp");
	}
}
