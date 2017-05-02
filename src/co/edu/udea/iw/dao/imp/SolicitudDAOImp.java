package co.edu.udea.iw.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements all the methods defined in the interface SolicitudDAO
 * @author juan.sanchezc@udea.edu.co
 */
public class SolicitudDAOImp implements SolicitudDAO{
	
	private SessionFactory sessionFactory;

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
	public Boolean createSolicitud(Solicitud solicitud) throws ExceptionHandler {
		Boolean noError = false;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(solicitud);
			noError = true;
			
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error inserting a new solicitud", e);
		}
		return noError;
	}

	@Override
	public Solicitud getById(String id) throws ExceptionHandler {
		Session session = null;
		Solicitud solicitud = null;
		try {
			session = sessionFactory.getCurrentSession();
			solicitud = (Solicitud)session.get(Solicitud.class, id);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error getting solicitud by id", e);
		}
		return solicitud;
	}

	@Override
	public List<Solicitud> getByEmpleado(int id) throws ExceptionHandler {
		Session session = null;
		List<Solicitud> solicitudList = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Solicitud.class).add(Restrictions.like("empleadoAsignado", id));
			solicitudList = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error getting solicitud list by id empleado", e);
		}
		return solicitudList;
	}

	@Override
	public List<Solicitud> getALL() throws ExceptionHandler {
		Session session = null;
		List<Solicitud> solicitudList = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Solicitud.class);
			solicitudList = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error getting all solicitud list", e);
		}
		return solicitudList;
	}

	@Override
	public void updateSolicitud(Solicitud solicitud) throws ExceptionHandler {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.update(solicitud);
			
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error updating the solicitud", e);
		}
		
	}

}
