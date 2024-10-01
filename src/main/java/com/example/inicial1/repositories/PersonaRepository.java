package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
//    boolean existByDni(int dni);
//
    @Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List <Persona> search (@Param("filtro") String filtro);

    @Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page <Persona> search (@Param("filtro") Pageable pageable);


    @Query(
            value="SELECT * FROM persona WHERE persona.nombre LIKE %:fltro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List <Persona> searchNativo (@Param("filtro") String filtro);
    @Query(
            value="SELECT * FROM persona WHERE persona.nombre LIKE %:fltro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo (String filtro, @Param("filtro") Pageable pageable);

}