/**
 * 
 */
package com.example.servicios;

import java.util.List;

import com.example.tallerrest.model.BicicletaDTO;
import com.example.tallerrest.model.RespuestaServicio;

/**
 * 
 */
public interface ServicioConsumoRest {

	public RespuestaServicio peticionesPostPut(String verbo, String uri, Object objetoEntrada);
	
	public List<BicicletaDTO> peticionGetBicisTaller(String uri);
}
