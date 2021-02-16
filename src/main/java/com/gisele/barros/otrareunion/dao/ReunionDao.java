package com.gisele.barros.otrareunion.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.gisele.barros.otrareunion.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion> {
	private final Reunion reunion = new Reunion();

	public ReunionDao() {
		setClazz(Reunion.class);
		reunion.setAsunto("Usted no posee ninguna reunion");
		reunion.setFecha(LocalDateTime.now());
	}

	public Reunion proximaReunion() {
		// sentencia lenguaje hibernate ; para buscar en la base de datos
		// defino la consulta a la base de datos
		String qlString = "FROM " + Reunion.class.getName() + " WHERE fecha > now() order by fecha";
		// creo la consulta a la base de datos
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1);
		// ejcuto la consulta ; casteo a tipo "reunion"
		try {
			return (Reunion) query.getSingleResult();
		} catch (NoResultException nre) {
			return reunion;
		}
	}
	
	public List<Reunion> reunionesManiana() {
		String qlString = "FROM "+ Reunion.class.getName() + " WHERE fecha between ?1 and ?2";
		Query query = getEntityManager().createQuery(qlString);
		LocalDate maniana = LocalDate.now().plus(1, ChronoUnit.DAYS);
		query.setParameter(1, maniana.atStartOfDay());
		query.setParameter(2, maniana.plus(1, ChronoUnit.DAYS).atStartOfDay());
		return query.getResultList();
	}
	
}
