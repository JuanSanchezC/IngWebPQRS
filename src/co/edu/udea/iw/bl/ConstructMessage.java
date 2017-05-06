package co.edu.udea.iw.bl;

/**
 * Constructs message with the response of a solicitud to
 * send a person
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class ConstructMessage {
	public String construcContent(int id, String respuesta){
		String content = "<p><strong>Hola</strong></p>"+
				"<p>"+respuesta+"</p>"+
				"<p><a href=\"localhost:8080/pqrs/servlets/calificacion/?"+id+"=\" "+
				"target=\"_blank\">Encuesta de Satisfacci&oacute;n</a></p>";
		return content;
	}

}
