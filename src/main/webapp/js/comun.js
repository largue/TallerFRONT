/**
 * Función para los campos de entrada de datos numéricos
 */
function soloNumeros(value) {
	return document.getElementById("numSerie").value = value.replace(/[^\d]/,'');
}