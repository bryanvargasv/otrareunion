package com.gisele.barros.otrareunion.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	public static EntityManager  getEntityManager() {
		//COnfogurar el proveedor de persistencia de la base de datos
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
//	public static void main(String[] args) {
//		EntityManager manager = EntityManagerUtil.getEntityManager();
//		System.out.println("EntityManager class ==>"+ manager.getClass().getCanonicalName());
//		
//	}


}
