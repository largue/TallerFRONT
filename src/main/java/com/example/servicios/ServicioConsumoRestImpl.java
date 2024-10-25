/**
 * 
 */
package com.example.servicios;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tallerrest.model.BicicletaAltaDTO;
import com.example.tallerrest.model.BicicletaBorrDTO;
import com.example.tallerrest.model.BicicletaDTO;
import com.example.tallerrest.model.BicicletaModDTO;
import com.example.tallerrest.model.RespuestaServicio;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * 
 */
public class ServicioConsumoRestImpl implements ServicioConsumoRest {
	
	Logger logger = LoggerFactory.getLogger(ServicioConsumoRestImpl.class);
	
	/**
	 * Constructor
	 */
	public ServicioConsumoRestImpl() {
		super();
	}

	@Override
	public RespuestaServicio peticionesPostPut(String verbo, String uri, Object objetoEntrada) {
		Object bici = null;
		RespuestaServicio rs = null;
		CloseableHttpResponse cHttpResp = null;
		
		if (objetoEntrada instanceof BicicletaAltaDTO) {
			bici = (BicicletaAltaDTO) objetoEntrada; 
		} else if (objetoEntrada instanceof BicicletaModDTO) {
			bici = (BicicletaModDTO) objetoEntrada;
		} else if (objetoEntrada instanceof BicicletaBorrDTO) {
			bici = (BicicletaBorrDTO) objetoEntrada;
		}
		
		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(bici);
			
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        if ("POST".equals(verbo)) {
	        	HttpPost postRequest = new HttpPost(uri);
		        postRequest.setHeader("Content-Type", "application/json");
		        postRequest.setHeader("Charset", "UTF-8");
		        postRequest.setEntity(new StringEntity(json, "UTF-8"));
		        
		        cHttpResp = httpClient.execute(postRequest);
	        } else if ("PUT".equals(verbo)) {
	        	HttpPut putRequest = new HttpPut(uri);
		        putRequest.setHeader("Content-Type", "application/json");
		        putRequest.setHeader("Charset", "UTF-8");
		        putRequest.setEntity(new StringEntity(json, "UTF-8"));
		        
		        cHttpResp = httpClient.execute(putRequest);
	        }
	        
	        HttpEntity entity = cHttpResp.getEntity();
	        
	        if (entity != null) {
	            String resultadoJSON = EntityUtils.toString(entity);

	            ObjectMapper objectMapper = new ObjectMapper();
	            rs = objectMapper.readValue(resultadoJSON, RespuestaServicio.class);
	        }
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		return rs;
	}

	@Override
	public List<BicicletaDTO> peticionGetBicisTaller(String uri) {
		List<BicicletaDTO> listaBicis = null;
		CloseableHttpResponse cHttpResp = null;
		
		try {
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        HttpGet getRequest = new HttpGet(uri);
	        getRequest.setHeader("Content-Type", "application/json");
	        getRequest.setHeader("Charset", "UTF-8");
	        
	        cHttpResp = httpClient.execute(getRequest);
	        
	        HttpEntity entity = cHttpResp.getEntity();
	        
	        if (entity != null) {
	            String resultadoJSON = EntityUtils.toString(entity);

	            ObjectMapper objectMapper = new ObjectMapper();
	            listaBicis = objectMapper.readValue(resultadoJSON, new TypeReference<>(){});
	        }
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		return listaBicis;
	}
}
