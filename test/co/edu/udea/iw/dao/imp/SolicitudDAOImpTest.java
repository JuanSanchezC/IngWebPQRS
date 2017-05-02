
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.dto.Filial;
import co.edu.udea.iw.dto.Motivo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements test fot the implementation of SolicitudDAO
 * @author juan.sanchezc@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class SolicitudDAOImpTest {
	@Autowired
	SolicitudDAO solicitudDAO;

	@Test
	public void testCreateSolicitud() {
		Solicitud solicitud = null;
		Empleado empleadoAsignado = null;
		Filial filial = null;
		TipoSolicitud tipoSolicitud = null;
		Motivo motivo = null;
		try {
			empleadoAsignado = new Empleado();
			filial = new Filial();
			tipoSolicitud = new TipoSolicitud();
			motivo = new Motivo();
			empleadoAsignado.setId(1);
			filial.setId(1);
			tipoSolicitud.setId(1);
			motivo.setId(2);
			
			solicitud = new Solicitud();
			solicitud.setId(1);
			solicitud.setFechaCrecion(new Date());
			solicitud.setDescripcion("Me tienen mamado!!");
			solicitud.setCorreo("juatoco@udea.edu.co");
			solicitud.setFilial(filial);
			solicitud.setEmpleadoAsignado(empleadoAsignado);
			solicitud.setTipoSolicitud(tipoSolicitud);
			solicitud.setMotivo(motivo);
			solicitud.setFechaAsignacion(new Date());			
			
			assertTrue(solicitudDAO.createSolicitud(solicitud));
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
