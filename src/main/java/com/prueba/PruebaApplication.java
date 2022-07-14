package com.prueba;

import com.prueba.entities.Gadgets;
import com.prueba.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(PruebaApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// CRUD
		//Crear gadget
		Gadgets gadgets = new Gadgets(null, "Mouse", "Logitech", 25, 9.99, true);
		Gadgets gadgets2 = new Gadgets(null, "Keyboard", "Logitech", 100, 12.99, true);
		//Almacenar un gadget
		repository.save(gadgets);
		repository.save(gadgets2);
		//Recuperar todos los gadget
		System.out.println("Cuantos gadgets hay guardados " + repository.findAll().size());

		//Borrar un gadget
		//repository.deleteById(1L);
	}

}
