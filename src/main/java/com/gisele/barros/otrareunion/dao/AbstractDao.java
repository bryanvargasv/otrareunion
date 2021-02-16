package com.gisele.barros.otrareunion.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.gisele.barros.otrareunion.utiles.EntityManagerUtil;


public abstract class AbstractDao<T> implements IDao<T> {
	
	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	private Class<T> clazz;
	
	@Override
	public Optional<T> get(int id) {
		
		return Optional.ofNullable(this.getEntityManager().find(this.clazz, id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		String sqlString = "FROM " + clazz.getName();
		Query query =getEntityManager().createQuery(sqlString);		
		return query.getResultList();
	}

	@Override
	public void save(T t) {
		this.executeInsideTransaction(entityManager -> entityManager.persist(t) );
		
	}

	@Override
	public void update(T t) {
		this.executeInsideTransaction(entityManager -> entityManager.merge(t) );
		
	}

	@Override
	public void delete(T t) {
		this.executeInsideTransaction(entityManager -> entityManager.remove(t) );
		
	}
	public void setClazz (Class<T> clazz) {
		this.clazz = clazz;
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			action.accept(getEntityManager());
			tx.commit();
		}catch (RuntimeException e) {
			tx.rollback();
			throw e;
			// TODO: handle exception
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	

}
