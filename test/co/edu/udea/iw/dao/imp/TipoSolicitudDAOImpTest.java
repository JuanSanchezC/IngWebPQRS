/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.TipoSolicitudDAO;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Test methods for TipoSolicitudDAOImp
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class TipoSolicitudDAOImpTest {
	@Autowired
	TipoSolicitudDAO tipoSolicitudDAO;

	/**
	 * Test method for {@link co.edu.udea.iw.dao.imp.TipoSolicitudDAOImp#getByName(java.lang.String)}.
	 */
	@Test
	public void testGetByCodigo() {
		TipoSolicitud tipoSolicitud = null;
		try {
			tipoSolicitud = tipoSolicitudDAO.getByName("queja");
			assertTrue(tipoSolicitud != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
