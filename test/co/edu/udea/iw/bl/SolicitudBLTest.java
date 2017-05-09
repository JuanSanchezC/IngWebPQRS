/**
 * 
 */
package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.TiempoRespuesta;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Tests for {@link SolicitudBL}
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class SolicitudBLTest {
	@Autowired
	SolicitudBL solicitudBL;
	
	/**
	 * Test method for {@link SolicitudBL#createSolicitud(java.lang.String, java.util.Date, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateSolicitud() {
		try {
			solicitudBL.createSolicitud("queja", new Date(), "centro", "devuelvanme la plata", 
					"juan.algo@gamin.com", "ms", null);
			assertTrue(true);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#getById(int)}.
	 */
	@Test
	public void testGetById() {
		Solicitud solicitud = null;
		try {
			solicitud = solicitudBL.getById(3);
			assertTrue(solicitud != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#getByEmpleado(int)}.
	 */
	@Test
	public void testGetByEmpleado() {
		List<Solicitud> solicitudList = new ArrayList<Solicitud>();
		try {
			solicitudList = solicitudBL.getByEmpleado(1);
			assertTrue(solicitudList.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#makeRespuesta(int, java.lang.String)}.
	 */
	@Test
	public void testMakeRespuesta() {
		try {
			solicitudBL.makeRespuesta(1, "No nos importa lo que dice");
			assertTrue(true);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#asignSolicitud(int, int)}.
	 */
	@Test
	public void testAsignSolicitud() {
		try {
			solicitudBL.asignSolicitud(1, 2);
			assertTrue(true);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#setSatisfaccion(int, int)}.
	 */
	@Test
	public void testSetSatisfaccion() {
		try {
			solicitudBL.asignSolicitud(1, 4);
			assertTrue(true);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#getByNoAnswered()}.
	 */
	@Test
	public void testGetByNoAnswered() {
		List<Solicitud> solicitudList = new ArrayList<Solicitud>();
		try {
			solicitudList = solicitudBL.getByNoAnswered();
			assertTrue(solicitudList.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#getByAnswered()}.
	 */
	@Test
	public void testGetByAnswered() {
		List<Solicitud> solicitudList = new ArrayList<Solicitud>();
		try {
			solicitudList = solicitudBL.getByAnswered();
			assertTrue(solicitudList.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#getByDateRange(java.util.Date, java.util.Date, java.lang.String)}.
	 */
	@Test
	public void testGetByDateRange() {
		String nameDate = "fechaCreacion";		
		Date initDate = new GregorianCalendar(2017, 4, 4, 0, 0, 0).getTime();
		Date finDate = new GregorianCalendar(2017, 4, 5, 0, 0, 0).getTime();
		List<Solicitud> solicitudList = new ArrayList<Solicitud>();
		try {
			solicitudList = solicitudBL.getByDateRange(initDate, finDate, nameDate);
			assertTrue(solicitudList.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#getTiemposRespuesta(java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testGetTiemposRespuesta() {
		Date initDate = new GregorianCalendar(2017, 4, 4, 0, 0, 0).getTime();
		Date finDate = new GregorianCalendar(2017, 4, 9, 0, 0, 0).getTime();
		List<TiempoRespuesta> respuestaList = new ArrayList<TiempoRespuesta>();
		try {
			respuestaList = solicitudBL.getTiemposRespuesta(initDate, finDate);
			assertTrue(respuestaList.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link SolicitudBL#isAnswered(int)}.
	 */
	@Test
	public void testIsAnswered() {		
		try {
			boolean answered = solicitudBL.isAnswered(3);
			assertTrue(answered);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
