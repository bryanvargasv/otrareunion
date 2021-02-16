package com.gisele.barros.otrareunion;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.gisele.barros.otrareunion.dao.ReunionDao;
import com.gisele.barros.otrareunion.dominio.Persona;
import com.gisele.barros.otrareunion.dominio.Reunion;

public class App {
	public static void main(String[] args) {

//    	ReunionDao reunionDao = new ReunionDao();
//    	Reunion reunionProxima = reunionDao.proximaReunion();
////    	System.out.println(reunionProxima);
//    	Reunion reunionNueva = new Reunion(LocalDateTime.now().plus(1,ChronoUnit.DAYS), "Reunion pasado mañana");
//    	reunionDao.save(reunionNueva);
////    	System.out.println(reunionDao.proximaReunion());
//    	List<Reunion> listaReuniones = new ArrayList<Reunion>();
//    	listaReuniones = reunionDao.reunionesManiana();
//    	for (Reunion reunion : listaReuniones) {
//			System.out.println(reunion);
//		}

//    	Optional<Reunion> nuevo;
//    	Reunion reunion = new Reunion(new Date(),"dia de los enamorados");
//    	
//    	//nuevo.setFecha(new DateTime("2020-02-14 09:00:00") );
////    	nuevo.setAsunto("Dia de los enamorados");
////    	dao.save(reunion);
//    	
//    	
//        nuevo = dao.get(1);
//        nuevo.get().setAsunto("andate a cagar");
//        dao.update(nuevo.get());
//    
//        
////        dao.delete(nuevo.get());
//   

//    	
////    	Optional<Reunion> registro = dao.get(2);
////        System.out.println( registro.toString());
////        
//        List<Reunion> tabla = dao.getAll();
//        for (Reunion reunion2 : tabla) {
//         
//		System.out.println(reunion2);
//			
//		}
//    	SalaDao salaDao = new SalaDao();
//    	Sala salaUno = new Sala("s9in", "reuniones de ingles", 5);
//        
//    	salaDao.save(salaUno);
//    	System.out.println(salaDao.getAll());
//    	
//    	salaUno.setDescripcion("sala de ingles");
//    	salaDao.update(salaUno);
//    	System.out.println(salaDao.getAll());
//    	
//    	Sala s2 = new Sala("99", "trasero", 1);
//    	salaDao.save(s2);
//    	System.out.println(salaDao.getAll());
//    	salaDao.delete(s2);
//    	
//    	System.out.println(salaDao.getAll());
//    	
//    	ActaDao actaDao = new ActaDao();
//        Acta uno = new Acta("reunion anualada", reunionNueva);
//        actaDao.save(uno);
//        
//      
		ReunionDao reunionDao = new ReunionDao();
		Reunion reunion = new Reunion(LocalDateTime.now(), "Reunion de prog 2");
		Persona per1 = new Persona("a008", "Gisele", "Barros");
		Persona per2 = new Persona("a009", "Bryan", "Vargas");

		Set<Persona> participantes = new HashSet<Persona>();
		// Agregamos los participantes que estaran en la reunion
		participantes.add(per1);
		participantes.add(per2);

		reunion.setParticipantes(participantes);

		reunionDao.save(reunion);

		Set<Reunion> reunionesde1 = new HashSet();
		reunionesde1.add(reunion);

		per1.setReuniones(reunionesde1);

		Reunion reunionDos = new Reunion(LocalDateTime.now(), "otra resunion de test");
		Set<Reunion> reunionesde2 = new HashSet();
		reunionesde2.add(reunion);
		reunionesde2.add(reunionDos);
		Set<Persona> particpanteDos = new HashSet<Persona>();
		particpanteDos.add(per2);
		reunionDos.setParticipantes(particpanteDos);

		per2.setReuniones(reunionesde2);
		reunionDao.save(reunionDos);

	}

	// llamar al metodo get all . insertar actuaizar y borrar
}
