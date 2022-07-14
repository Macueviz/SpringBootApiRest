package com.prueba.controller;

import com.prueba.entities.Gadgets;
import com.prueba.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
// Atributos
    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
// Constructores

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    // CRUD sobre la entidad Laptop

    // Buscar todos los gadgets (lista de gadgets)
    @GetMapping("/api/laptop/gadgets")
    public List<Gadgets> findAll() {
        return laptopRepository.findAll();
    }


    // buscar un solo gadget en base de datos segund ID
    @GetMapping("/api/laptop/gadgets/{id}")
    public ResponseEntity<Gadgets> findOneById(@PathVariable Long id){

        Optional<Gadgets> laptopOpt = laptopRepository.findById(id);

        // Option 1
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
        // Option 2
//      return laptopOpt.orElse(null);
//      return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());  PROG FUNCIONAL

    }
    // Crear un nuevo libro en base de de datos
    @PostMapping("/api/laptop/gadgets")
    public ResponseEntity<Gadgets> create(@RequestBody Gadgets gadget){
        if (gadget.getId() !=null){
            log.warn("Trying to create a book with Id");
            return ResponseEntity.badRequest().build();
        }
        Gadgets result = laptopRepository.save(gadget);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/laptop/gadgets")
    public ResponseEntity<Gadgets> update(@RequestBody Gadgets gadget){
        if (gadget.getId() ==null){
            log.warn("Trying to update a non existent gadget");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(gadget.getId())) {
            log.warn("Trying to update a non existent gadget");
            return ResponseEntity.notFound().build();
        }
        // Proceso de actualización
        Gadgets result = laptopRepository.save(gadget);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptop/gadgets/{id}")
    public ResponseEntity<Gadgets> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)) {
            log.warn("Trying to update a non existent gadget");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptop/gadgets")
    public ResponseEntity<Gadgets> deleteAll(){

        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
