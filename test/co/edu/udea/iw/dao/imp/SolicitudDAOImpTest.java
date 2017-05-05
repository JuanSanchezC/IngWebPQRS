
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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
import co.edu.udea.iw.logs.CustomLogger;


/**
 * Implements test fot the implementation of SolicitudDAO
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class SolicitudDAOImpTest {
	@Autowired
	SolicitudDAO solicitudDAO;
	private Logger logger = CustomLogger.getLogger();
	private Logger log = Logger.getLogger(SolicitudDAOImpTest.class);
	/**
	 * Test for the method createSolicitud() of SolicitudDAOImp 
	 */
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
			solicitud.setFechaCreacion(new Date());
			solicitud.setFechaSuceso(new Date());
			solicitud.setDescripcion("Me tienen mamado!!");
			solicitud.setCorreo("juatoco@udea.edu.co");
			solicitud.setFilial(filial);
			solicitud.setEmpleadoAsignado(empleadoAsignado);
			solicitud.setTipoSolicitud(tipoSolicitud);
			solicitud.setMotivo(motivo);
			solicitud.setFechaAsignacion(new Date());			
			
			solicitudDAO.createSolicitud(solicitud);
			assertTrue(true);
			logger.info("Crea una solicitud satisfactoriamente");
			logger.error("Crea una solicitud satisfactoriamente");
			log.error("esto si funciona");
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			e.printLog();
			log.error("esto no funciona");
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test for the method getById() of SolicitudDAOImp
	 */
	@Test
	public void testGetById(){
		Solicitud solicitud = null;
		try {
			solicitud = solicitudDAO.getById(10);
			assertTrue(solicitud != null);
			logger.info("se ha obtenido una solicitud por su id");
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			e.printLog();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test for the method getByEmpleado() of SolicitudDAOImp
	 */
	@Test
	public void testGetByEmpleado(){
		List<Solicitud> solicitudes = null;		
		try {
			solicitudes = solicitudDAO.getByEmpleado(1);
			assertTrue(solicitudes.size() >= 1);
			logger.info("se ha obtenido una solicitud por empleado");
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			e.printLog();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test for the method getAll() of SolicitudDAOImp
	 */
	@Test
	public void testGetAll(){
		List<Solicitud> solicitudes = null;		
		try {
			solicitudes = solicitudDAO.getALL();
			assertTrue(solicitudes.size() >= 1);
			logger.info("se han obtenido todas las solicitudes");
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			e.printLog();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test for the method updateSolicitud() of SolicitudDAOImp
	 */
	@Test
	public void testUpdateSolicitud(){		
		try {
			Solicitud solicitud = solicitudDAO.getById(2);
			solicitud.setRespuesta("Coma mierda!!");
			solicitudDAO.updateSolicitud(solicitud);
			assertTrue(true);
			logger.info("se ha actualizado la solicitud " + 2);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			e.printLog();
			fail(e.getMessage());
		}
	}

}
