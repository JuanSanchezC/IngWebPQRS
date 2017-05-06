/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.EmpleadoDAO;
import co.edu.udea.iw.dto.Empleado;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements the methods defined in EmpleadoDAO
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class EmpleadoDAOImp implements EmpleadoDAO{
	SessionFactory sessionFactory;
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Empleado getById(int id) throws ExceptionHandler {
		Session session = null;
		Empleado empleado = null;
		try {
			session = sessionFactory.getCurrentSession();
			empleado = (Empleado) session.get(Empleado.class, id);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consulting the Empleado", e);
		}
		return empleado;
	}

}
