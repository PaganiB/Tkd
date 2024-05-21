//Clase correspondiente al Instructor
package com.SpringBoot.Tkd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Instructor extends Practicante{
    
    //Datos similares al alumno
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_instructor;
    @OneToMany
    private List<Alumno> listaAlumnos;
    //los instructores tambien deben tener un instructor mayor
    @OneToOne
    @JoinColumn (name="id_instructorMayor", referencedColumnName = "id_instructor")
    private Instructor instructor;
    private String celular;
    private String dojang;

    public Instructor() {
    }

    public Instructor(Long id_instructor, List<Alumno> listaAlumnos, Instructor id_instructorMayor, String celular, String dojang, String nombreApellido, String dni, LocalDate fechaNac, String graduacion) {
        super(nombreApellido, dni, fechaNac, graduacion);
        this.id_instructor = id_instructor;
        this.listaAlumnos = listaAlumnos;
        this.instructor = instructor;
        this.celular = celular;
        this.dojang = dojang;
    }


}
