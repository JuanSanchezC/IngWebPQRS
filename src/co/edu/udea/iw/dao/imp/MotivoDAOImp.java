package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.MotivoDAO;
import co.edu.udea.iw.dto.Motivo;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
  * Implements the methos defined by the interface MotivoDAO
  * @author juan.sanchezc@udea.edu.co
  * @author oran.jimenez@udea.edu.co
  */
public class MotivoDAOImp implements MotivoDAO{
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
	public Motivo getByCodigo(String codigo) throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<Motivo> motivoList = new ArrayList<Motivo>();
		Motivo motivo = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Motivo.class).add(Restrictions.eq("codigo", codigo));
			motivoList = criteria.list();
			motivo = motivoList.get(0);
			
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error while consulting motivo by code", e);
		}
		return motivo;
	}

}
