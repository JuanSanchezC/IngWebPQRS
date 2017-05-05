/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.FacturaDAO;
import co.edu.udea.iw.dto.Factura;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements the methods defined in the interface FacturaDAO
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class FacturaDAOImp implements FacturaDAO{
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
	public Factura getById(int id) throws ExceptionHandler {
		Session session = null;
		Factura factura = null;
		try {
			session = sessionFactory.getCurrentSession();
			factura = (Factura) session.get(Factura.class, id);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consulting the Factura", e);
		}
		return factura;
	}

}
