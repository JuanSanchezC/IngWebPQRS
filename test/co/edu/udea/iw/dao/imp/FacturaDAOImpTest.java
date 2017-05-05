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

import co.edu.udea.iw.dao.FacturaDAO;
import co.edu.udea.iw.dto.Factura;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Test methods for FacturaDAOImp
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class FacturaDAOImpTest {
	@Autowired
	FacturaDAO facturaDAO;

	/**
	 * Test method for {@link co.edu.udea.iw.dao.imp.FacturaDAOImp#getById(int)}.
	 */
	@Test
	public void testGetById() {
		Factura factura = null;
		try {
			factura = facturaDAO.getById(6);
			assertTrue(factura != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
