/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.TipoSolicitudDAO;
import co.edu.udea.iw.dto.TipoSolicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements the methos defined in the interface TipoSolicitudDAO
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class TipoSolicitudDAOImp implements TipoSolicitudDAO{
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
	public TipoSolicitud getByName(String name) throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<TipoSolicitud> tipoSolicitudList = null;
		TipoSolicitud tipoSolicitud = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(TipoSolicitud.class).add(Restrictions.eq("nombre", name));
			tipoSolicitudList = criteria.list();
			tipoSolicitud = tipoSolicitudList.get(0);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error occurred while consulting a TipoSolicitud");
		}
		return tipoSolicitud;
	}

}
