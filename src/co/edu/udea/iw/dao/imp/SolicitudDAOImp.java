package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Empleado;
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
	public void createSolicitud(Solicitud solicitud) throws ExceptionHandler {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(solicitud);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error inserting a new solicitud", e);
		}		
	}

	@Override
	public Solicitud getById(int id) throws ExceptionHandler {
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
		List<Solicitud> solicitudList = new ArrayList<Solicitud>();
		Criteria criteria = null;
		Empleado empleado = new Empleado();
		empleado.setId(id);
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Solicitud.class).add(Restrictions.eq("empleadoAsignado", empleado));
			solicitudList =  criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error getting solicitud list by id empleado", e);
		}
		return solicitudList;
	}

	@Override
	public List<Solicitud> getALL() throws ExceptionHandler {
		Session session = null;
		List<Solicitud> solicitudList = new ArrayList<Solicitud>();
		Criteria criteria = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Solicitud.class);
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
			session.saveOrUpdate(solicitud);
			
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error updating the solicitud", e);
		}
		
	}

	@Override
	public List<Solicitud> getByNoAnswered() throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<Solicitud> soList = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criterion criterion1 = Restrictions.isNull("respuesta");
			Criterion criterion2 = Restrictions.isEmpty("respuesta");
			criteria = session.createCriteria(Solicitud.class).add(Restrictions.or(criterion1, criterion2));
			soList = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("ERROR CONSULTING LIST OF SOLICITUD", e);
		}
		return soList;
	}

	@Override
	public List<Solicitud> getByAnswered() throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<Solicitud> soList = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criterion criterion1 = Restrictions.isNotNull("respuesta");
			Criterion criterion2 = Restrictions.isNotEmpty("respuesta");
			criteria = session.createCriteria(Solicitud.class).add(Restrictions.or(criterion1, criterion2));
			soList = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("ERROR CONSULTING LIST OF SOLICITUD", e);
		}
		return soList;
	}

	@Override
	public List<Solicitud> getByDateRange(Date initDate, Date finDate, String nameDate) throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<Solicitud> soList = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Solicitud.class).add(Restrictions.between(nameDate, initDate, finDate));
			soList = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("ERROR CONSULTING LIST OF SOLICITUD", e);
		}
		return soList;
	}

	@Override
	public List<Solicitud> getByDateRangeAnswered(Date initDate, Date finDate) throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<Solicitud> soList = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criterion criterion1 = Restrictions.isNotNull("respuesta");
			Criterion criterion2 = Restrictions.isNotEmpty("respuesta");
			criteria = session.createCriteria(Solicitud.class).add(Restrictions.or(criterion1, criterion2)).
					add(Restrictions.between("fechaRespuesta", initDate, finDate));
			soList = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("ERROR CONSULTING LIST OF SOLICITUD", e);
		}
		return soList;
	}

}
