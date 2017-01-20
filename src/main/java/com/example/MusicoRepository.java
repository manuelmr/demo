package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by manu on 19/1/17.
 */
@RepositoryRestResource(path = "musicos")
public interface MusicoRepository extends JpaRepository<Musico, Long> {

    @RestResource(path = "by-nombre")
    Collection<Musico> findAllByNombre(@Param("nombre") String nombre);

    @RestResource(path = "by-instrumento")
    Collection<Musico> findAllByInstrumento(@Param("instrumento") String instrumento);
}
