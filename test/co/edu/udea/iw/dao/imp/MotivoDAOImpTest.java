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

import co.edu.udea.iw.dao.MotivoDAO;
import co.edu.udea.iw.dto.Motivo;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Test methods for MotivoDAOImp
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class MotivoDAOImpTest {
	@Autowired
	MotivoDAO motivoDAO;

	/**
	 * Test method for {@link co.edu.udea.iw.dao.imp.MotivoDAOImp#getByCodigo(java.lang.String)}.
	 */
	@Test
	public void testGetByCodigo() {
		Motivo motivo = null;
		try {
			motivo = motivoDAO.getByCodigo("ms");
			assertTrue(motivo != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
