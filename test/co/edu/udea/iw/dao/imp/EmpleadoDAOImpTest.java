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

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Tests for methods of {@link EmpleadoDAOImp}
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfiguration.xml")
public class EmpleadoDAOImpTest {
	@Autowired
	EmpleadoDAO empleadoDAO;

	/**
	 * Test method for {@link EmpleadoDAOImp#getById(int)}.
	 */
	@Test
	public void testGetById() {
		Empleado empleado = null;
		try {
			empleado = empleadoDAO.getById(2);
			assertTrue(empleado != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
