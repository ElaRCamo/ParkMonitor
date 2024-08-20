package com.grammer.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import com.grammer.entity.InicioAuxiliar;

public class InicioAuxiliarDaoImpl {

	public void getInicioAuxiliar() {
		
		SessionFactory factory = null;
		Session session = null;
		@SuppressWarnings("unused")
		List<InicioAuxiliar> list = new ArrayList<InicioAuxiliar>();
		try {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(InicioAuxiliar.class)
					.buildSessionFactory();
			session = factory.getCurrentSession();
			session.beginTransaction();
			String sql = " from InicioAuxiliar ";
			list = session.createQuery(sql, InicioAuxiliar.class).getResultList();
			session.flush();
			session.getTransaction().commit();
			
			if (null != session && session.isOpen()) {
				session.close();
			}
			if (null != factory && factory.isOpen()) {
				factory.close();
			}
		} catch (HibernateException he) {
			if (null != session && session.isOpen()) {
				session.close();
			}
			if (null != factory && factory.isOpen()) {
				factory.close();
			}
			he.printStackTrace();
		} catch (Exception e) {
			if (null != session && session.isOpen()) {
				session.close();
			}
			if (null != factory && factory.isOpen()) {
				factory.close();
			}
			e.printStackTrace();
		} finally {
			
		}
	}
}