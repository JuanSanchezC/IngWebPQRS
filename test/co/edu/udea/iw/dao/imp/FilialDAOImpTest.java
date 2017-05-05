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

import co.edu.udea.iw.dao.FilialDAO;
import co.edu.udea.iw.dto.Filial;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Test methods for FilialDAOImp
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class FilialDAOImpTest {
	@Autowired
	FilialDAO filialDAO;

	/**
	 * Test method for {@link co.edu.udea.iw.dao.imp.FilialDAOImp#getByCodigo(java.lang.String)}.
	 */
	@Test
	public void testGetByCodigo() {
		Filial filial = null;
		try {
			filial = filialDAO.getByCodigo("centro");
			assertTrue(filial != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
