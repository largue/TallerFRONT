/**
 * 
 */
package com.example.servicios;

import com.example.tallerrest.model.RespuestaServicio;

/**
 * 
 */
public interface ServicioConsumoRest {

	public RespuestaServicio llamadaServicioRest(String verbo, String uri, Object objetoEntrada);
}
