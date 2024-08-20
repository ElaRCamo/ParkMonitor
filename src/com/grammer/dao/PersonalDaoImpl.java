package com.grammer.dao;

import com.grammer.entity.Usuarios;
import com.grammer.entity.Configuraciones;
import com.grammer.entity.Corbatines;
import com.grammer.entity.Telefono;
import com.grammer.entity.BitacoraCambios;
import com.grammer.entity.Otros;
import com.grammer.entity.Lugares;
import com.grammer.entity.Modelos;
import com.grammer.dto.BitacoraDto;
import com.grammer.entity.Areas;
import com.grammer.entity.Bitacora;
import com.grammer.entity.PC;
import com.grammer.entity.Laptop;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonalDaoImpl {
	SessionFactory factory = null;
	Session session = null;
	
	public Usuarios verificacionUsuario(String usuario,String password) {
		Usuarios usuarios = new Usuarios();
		try {
			iniciarSesion(Usuarios.class,"hibernate.cfg.xml");
			String sql = " from Usuarios a where a.usuario like '" + usuario + "' and a.contrasenia like '"+ password +"'";
			usuarios = session.createQuery(sql,Usuarios.class).uniqueResult();
			cerrarSesion();
			} catch (HibernateException he) {
				cerrarExcepciones();
				he.printStackTrace();
				return usuarios;
			} catch (Exception e) {
				cerrarExcepciones();
				e.printStackTrace();
				return usuarios;
			} 
			finally {	
			}
			return usuarios;
	}
	
	public void iniciarSesion(Class<?> clase,String configuracion) {
		factory = null;
		session = null;
		factory = new Configuration()
				.configure(configuracion)
				.addAnnotatedClass(clase)
				.buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
	}
	
	private void cerrarSesion() {
		session.flush();
		session.getTransaction().commit();
		
		if (null != session && session.isOpen()) {
			session.close();
		}
		if (null != factory && factory.isOpen()) {
			factory.close();
		}
	}
	
	private void cerrarExcepciones() {
		if (null != session && session.isOpen()) {
			session.close();
		}
		if (null != factory && factory.isOpen()) {
			factory.close();
		}
	}
	
	//Inserta un nuevo registro en la tabla bitacora
	public boolean crearBitacora(Bitacora registro) {
			
			try {
				iniciarSesion(Bitacora.class,"hibernate.cfg.xml");
				session.save(registro);
				cerrarSesion();
			} catch (HibernateException he) {
				cerrarExcepciones();
				he.printStackTrace();
				return false;
			} catch (Exception e) {
				cerrarExcepciones();
				e.printStackTrace();
				return false;
			} 
			
			finally {
				
			}
			
			return true;
	
	}
	public Laptop getAllPersonalById(String idUser) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Laptop.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Laptop kaizen = new Laptop();
		
		try {
			session.beginTransaction();
			String sql = " from Laptop a where a.idLaptop like '" + idUser + "' ";
			kaizen = session.createQuery(sql,Laptop.class).uniqueResult();
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

		return kaizen;
	}
	
	public boolean actualizarPersonal(Laptop personal) {
			
			SessionFactory factory = null;
			Session session = null;
			try {
				factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Laptop.class)
						.buildSessionFactory();
				session = factory.getCurrentSession();
				session.beginTransaction();
				session.update(personal);
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
				return false;
			} catch (Exception e) {
				if (null != session && session.isOpen()) {
					session.close();
				}
				if (null != factory && factory.isOpen()) {
					factory.close();
				}
				e.printStackTrace();
				return false;
			} 
			
			finally {
				
			}
			
		
			return true;
		}

	public boolean crearPersonalPC(PC personal) {
		
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(PC.class)
					.buildSessionFactory();
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.save(personal);
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
			return false;
		} catch (Exception e) {
			if (null != session && session.isOpen()) {
				session.close();
			}
			if (null != factory && factory.isOpen()) {
				factory.close();
			}
			e.printStackTrace();
			return false;
		} 
		
		finally {
			
		}
		
	
		return true;
	}
	
public boolean crearPersonal(Laptop personal) {
		
		try {
			iniciarSesion(Laptop.class,"hibernate.cfg.xml");
			session.save(personal);
			cerrarSesion();
		} catch (HibernateException he) {
			cerrarExcepciones();
			he.printStackTrace();
			return false;
		} catch (Exception e) {
			cerrarExcepciones();
			e.printStackTrace();
			return false;
		} 
		
		finally {
			
		}
		
		return true;
	}
	

	
	public List<BitacoraDto> consultar() {
	    List<BitacoraDto> registrosParking = new ArrayList<>();
	    String hql = null;
	
	    try {
	        iniciarSesion(BitacoraDto.class,"hibernate.cfg.xml");
	
	        hql = "SELECT DISTINCT new com.grammer.dto.BitacoraDto(" +
	                "B.idRegistro, B.corbatin.idCorbatin, E.descripcion, U.nomina, U.nombre, U.telefono, " +
	                "T.descripcion, V.placas, V.modelo, V.color, " +
	                "B.fechaEntrada, B.horaEntrada, B.fechaSalida, B.horaSalida) " +
	                "FROM Bitacora B " +
	                "JOIN B.corbatin C " +
	                "JOIN C.estatus E " +
	                "JOIN C.vehiculo V " +
	                "JOIN V.tipo T " +
	                "JOIN V.usuario U";
	
	        // Ejecutar la consulta
	        
	        registrosParking = session.createQuery(hql,BitacoraDto.class).list();
			cerrarSesion();
		} catch (HibernateException he) {
			cerrarExcepciones();
			he.printStackTrace();
		} catch (Exception e) {
			cerrarExcepciones();
			e.printStackTrace();
		} finally {
			
		}
		return registrosParking;
	}

	
	

public List<Areas> consultarAreasBase() {
	List<Areas> kaizenList = new ArrayList<Areas>();
	String sql = null;
	try {
		
		iniciarSesion(Areas.class,"hibernate.cfg.xml");
		
		sql = " from Areas order by idArea";
			
		kaizenList = session.createQuery(sql,Areas.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public List<Modelos> consultarModelosBase() {
	List<Modelos> kaizenList = new ArrayList<Modelos>();
	String sql = null;
	try {
		
		iniciarSesion(Modelos.class,"hibernate.cfg.xml");
		
		sql = " from Modelos order by idModelo";
			
		kaizenList = session.createQuery(sql,Modelos.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public List<Lugares> consultarLugarBase() {
	List<Lugares> kaizenList = new ArrayList<Lugares>();
	String sql = null;
	try {
		
		iniciarSesion(Lugares.class,"hibernate.cfg.xml");
		
		sql = " from Lugares order by idLugar";
			
		kaizenList = session.createQuery(sql,Lugares.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public List<Otros> consultarOtros() {
	List<Otros> kaizenList = new ArrayList<Otros>();
	String sql = null;
	try {
		
		iniciarSesion(Otros.class,"hibernate.cfg.xml");
		
		sql = " from Otros where estatus = 1";
			
		kaizenList = session.createQuery(sql,Otros.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public Corbatines getCorbatinById(int id) {
	Corbatines corbatinSeleccionado = new Corbatines();
	try {
		iniciarSesion(Corbatines.class,"hibernate.cfg.xml");
		String sql = " from Corbatines where idCorbatin = '"+id+"'";
		corbatinSeleccionado = session.createQuery(sql,Corbatines.class).uniqueResult();
		cerrarSesion();
		} catch (HibernateException he) {
			cerrarExcepciones();
			he.printStackTrace();
			return corbatinSeleccionado;
		} catch (Exception e) {
			cerrarExcepciones();
			e.printStackTrace();
			return corbatinSeleccionado;
		} 
		finally {	
		}
		return corbatinSeleccionado;
}


public Bitacora getRegistroById(int id) {
	Bitacora registroSeleccionado = new Bitacora();
	try {
		iniciarSesion(Bitacora.class,"hibernate.cfg.xml");
		String sql = " from Bitacora where idRegistro = '"+id+"'";
		registroSeleccionado = session.createQuery(sql,Bitacora.class).uniqueResult();
		cerrarSesion();
		} catch (HibernateException he) {
			cerrarExcepciones();
			he.printStackTrace();
			return registroSeleccionado;
		} catch (Exception e) {
			cerrarExcepciones();
			e.printStackTrace();
			return registroSeleccionado;
		} 
		finally {	
		}
		return registroSeleccionado;
}

public boolean updateRegistroBitacora(Bitacora registro) {
	
	SessionFactory factory = null;
	Session session = null;
	try {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(PC.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(registro);
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
		return false;
	} catch (Exception e) {
		if (null != session && session.isOpen()) {
			session.close();
		}
		if (null != factory && factory.isOpen()) {
			factory.close();
		}
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	

	return true;
}

public List<Laptop> getUsuarioByLaptop() {
	
	List<Laptop> userList = new ArrayList<Laptop>();
	
	try {
		iniciarSesion(Laptop.class,"hibernate.cfg.xml");
		String sql = "from Laptop a order by a.cantidad desc";
		userList = session.createQuery(sql,Laptop.class).setMaxResults(1).getResultList();
		cerrarSesion();
	}catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	}catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} 
	
	finally {
		
	}
	return userList;
}

public boolean crearBitacora(BitacoraCambios personal) {
	
	try {
		iniciarSesion(BitacoraCambios.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean actualizarBitacora(BitacoraCambios personal) {
	
	try {
		iniciarSesion(Laptop.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public List<Areas> consultarAreas() {
	List<Areas> kaizenList = new ArrayList<Areas>();
	String sql = null;
	try {
		
		iniciarSesion(Areas.class,"hibernate.cfg.xml");
		
		sql = " from Areas";
			
		kaizenList = session.createQuery(sql,Areas.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public List<Lugares> consultarLugares() {
	List<Lugares> kaizenList = new ArrayList<Lugares>();
	String sql = null;
	try {
		
		iniciarSesion(Lugares.class,"hibernate.cfg.xml");
		
		sql = " from Lugares";
			
		kaizenList = session.createQuery(sql,Lugares.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public List<Modelos> consultarModelos() {
	List<Modelos> kaizenList = new ArrayList<Modelos>();
	String sql = null;
	try {
		
		iniciarSesion(Modelos.class,"hibernate.cfg.xml");
		
		sql = " from Modelos";
			
		kaizenList = session.createQuery(sql,Modelos.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}
public boolean bajaEstatus(String idLaptop) {
	
	try {

		iniciarSesion(Laptop.class,"hibernate.cfg.xml");
		String sql = "update [DB_InventarioIT].[dbo].[Laptop] set Estatus = 3 where IdLaptop = '"+idLaptop+"'";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		cerrarSesion();
	} 
	
	catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} 
	
	catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} 
	
	finally {
		
	}
	
	return true;
}

public Telefono verificacionTelefono(String serie) {
	Telefono usuarios = new Telefono();
	try {
		iniciarSesion(Telefono.class,"hibernate.cfg.xml");
		String sql = " from Telefono a where a.ime like '" + serie + "'";
		usuarios = session.createQuery(sql,Telefono.class).uniqueResult();
		cerrarSesion();
		} catch (HibernateException he) {
			cerrarExcepciones();
			he.printStackTrace();
			return usuarios;
		} catch (Exception e) {
			cerrarExcepciones();
			e.printStackTrace();
			return usuarios;
		} 
		finally {	
		}
		return usuarios;
}

public boolean crearTelefono(Telefono personal) {
	
	try {
		iniciarSesion(Telefono.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}
public boolean actualizarTelefono(Telefono personal) {
	
	try {
		iniciarSesion(Telefono.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean bajaEstatusTelefonos(String idLaptop) {
	
	try {

		iniciarSesion(Telefono.class,"hibernate.cfg.xml");
		String sql = "update [DB_InventarioIT].[dbo].[Telefonos] set Estatus = 0 where IdTelefono = '"+idLaptop+"'";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		cerrarSesion();
	} 
	
	catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} 
	
	catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} 
	
	finally {
		
	}
	
	return true;
}
public boolean actualizarOtros(Otros personal) {
	
	try {
		iniciarSesion(Otros.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}
public boolean crearOtros(Otros personal) {
	
	try {
		iniciarSesion(Otros.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public Configuraciones verificacionImpresora(String cuenta) {
	Configuraciones usuarios = new Configuraciones();
	try {
		iniciarSesion(Configuraciones.class,"hibernate.cfg.xml");
		String sql = " from Configuraciones a where a.cuenta like '" + cuenta + "'";
		usuarios = session.createQuery(sql,Configuraciones.class).uniqueResult();
		cerrarSesion();
		} catch (HibernateException he) {
			cerrarExcepciones();
			he.printStackTrace();
			return usuarios;
		} catch (Exception e) {
			cerrarExcepciones();
			e.printStackTrace();
			return usuarios;
		} 
		finally {	
		}
		return usuarios;
}

public boolean actualizarConfiguracion(Configuraciones personal) {
	
	try {
		iniciarSesion(Configuraciones.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean crearConfiguracion(Configuraciones personal) {
	
	try {
		iniciarSesion(Configuraciones.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean actualizacionContraseña(String cuenta,String contra) {
	
	try {

		iniciarSesion(Usuarios.class,"hibernate.cfg.xml");
		String sql = "update [DB_InventarioIT].[dbo].[Users] set Password = '"+contra+"' where usuario = '"+cuenta+"'";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		cerrarSesion();
	} 
	
	catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} 
	
	catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean actualizarAreas(Areas personal) {
	
	try {
		iniciarSesion(Areas.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean crearAreas(Areas personal) {
	
	try {
		iniciarSesion(Areas.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean eliminarModelos(Modelos personal) {
	
	try {
		iniciarSesion(Modelos.class,"hibernate.cfg.xml");
		session.delete(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}


public boolean actualizarModelos(Modelos personal) {
	
	try {
		iniciarSesion(Modelos.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}


public boolean crearModelos(Modelos personal) {
	
	try {
		iniciarSesion(Modelos.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean crearLugares(Lugares personal) {
	
	try {
		iniciarSesion(Lugares.class,"hibernate.cfg.xml");
		session.save(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean actualizarLugares(Lugares personal) {
	
	try {
		iniciarSesion(Lugares.class,"hibernate.cfg.xml");
		session.update(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public boolean eliminarLugares(Lugares personal) {
	
	try {
		iniciarSesion(Lugares.class,"hibernate.cfg.xml");
		session.delete(personal);
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
		return false;
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
		return false;
	} 
	
	finally {
		
	}
	
	return true;
}

public List<BitacoraCambios> consultarBitacora() {
	List<BitacoraCambios> kaizenList = new ArrayList<BitacoraCambios>();
	String sql = null;
	try {
		
		iniciarSesion(BitacoraCambios.class,"hibernate.cfg.xml");
		
		sql = " from BitacoraCambios order by fechaCambio";
			
		kaizenList = session.createQuery(sql,BitacoraCambios.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

public List<Telefono> consultarTelefono() {
	List<Telefono> kaizenList = new ArrayList<Telefono>();
	String sql = null;
	try {
		
		iniciarSesion(Telefono.class,"hibernate.cfg.xml");
		
		sql = " from Telefono order by idTelefono";
			
		kaizenList = session.createQuery(sql,Telefono.class).list();
		cerrarSesion();
	} catch (HibernateException he) {
		cerrarExcepciones();
		he.printStackTrace();
	} catch (Exception e) {
		cerrarExcepciones();
		e.printStackTrace();
	} finally {
		
	}
	return kaizenList;
}

	
}


