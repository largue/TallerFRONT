/**
 * @author Javier
 * @since 21-10-2024
 */
package com.example.servicios;

import java.util.List;

import com.example.tallerrest.model.BicicletaDTO;
import com.example.tallerrest.model.RespuestaServicio;

/**
 * Servicio para el consumo del servicio REST /tallerREST
 */
public interface ServicioConsumoRest {

	/**
	 * Método para las llamadas POST y PUT del servicio REST /tallerREST
	 * @param verbo
	 * @param uri
	 * @param objetoEntrada
	 * @return RespuestaServicio
	 * @throws Exception
	 */
	public RespuestaServicio peticionesPostPut(String verbo, String uri, Object objetoEntrada) throws Exception;
	
	/**
	 * Método que recupera todas las bicis del sistema invocando al servicio REST /tallerREST
	 * @param uri
	 * @return List<BicicletaDTO>
	 * @throws Exception
	 */
	public List<BicicletaDTO> peticionGetBicisTaller(String uri) throws Exception;
}
