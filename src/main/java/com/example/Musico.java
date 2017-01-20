package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by manu on 19/1/17.
 */
@Entity
public class Musico {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String instrumento;

    public Musico() {
    }

    public Musico(String nombre, String instrumento) {
        this.nombre = nombre;
        this.instrumento = instrumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String toString() {
        return "Musico{" +
                "nombre='" + nombre + '\'' +
                ", instrumento='" + instrumento + '\'' +
                '}';
    }
}
