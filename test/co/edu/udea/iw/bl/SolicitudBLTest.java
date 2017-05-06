/**
 * 
 */
package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Test methods for {@link SolicitudBL}
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
	 * Test method for {@link SolicitudBL#sendEmail(int)}
	 */
	@Test
	public void testSendEmail(){
		try {
			solicitudBL.sendEmail(1);
			assertTrue(true);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	

}
