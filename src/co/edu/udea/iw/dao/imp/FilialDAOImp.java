/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.FilialDAO;
import co.edu.udea.iw.dto.Filial;
import co.edu.udea.iw.exception.ExceptionHandler;

/**
 * Implements the methods defined in the interface FilialDAO
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class FilialDAOImp implements FilialDAO{
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
	public Filial getByCodigo(String codigo) throws ExceptionHandler {
		Session session = null;
		Criteria criteria = null;
		List<Filial> filialList = null;
		Filial filial = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Filial.class).add(Restrictions.eq("codigo", codigo));
			filialList = criteria.list();
			filial = filialList.get(0);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error occurred while consulting filial", e);
		}
		return filial;
	}

}
