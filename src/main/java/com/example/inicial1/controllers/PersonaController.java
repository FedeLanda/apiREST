package com.example.inicial1.controllers;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.services.PersonaServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
//@RequestMapping(path="api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona,PersonaServicesImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(("{\"error \":  \"" + e.getMessage()+" \" }"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(("{\"error \":  \"" + e.getMessage()+" \" }"));
        }
    }
//  @Autowired
//PersonaServices servicio;
//private PersonaServicesImpl personaServicesImpl;

//public PersonaController(PersonaServicesImpl personaServicesImpl){
//
//    this.personaServicesImpl = personaServicesImpl;
//}

//    @GetMapping("")
//    public ResponseEntity<?> getAll(){
//        try{
//            return ResponseEntity.status(HttpStatus.OK).
//                    body(personaServicesImpl.findAll());
//                    //body("Busqué todos los datos");
//        }
//        catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente más tarde\"}");
//        }
//    }




}