//Clase que representa el modelo Alumno

package com.SpringBoot.Tkd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
//la clase Alumno hereda la clase practicante 
public class Alumno extends Practicante{
    
    //la respectiva id del alumno
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_alumno;
    //cada alumno cuenta con solamente un instructor
    @ManyToOne
    @JoinColumn (name="id_instructor", referencedColumnName = "id_instructor")
    private Instructor instructor;

    public Alumno(Long id_alumno, Instructor id_instructor, String nombreApellido, String dni, LocalDate fechaNac, String graduacion) {
        super(nombreApellido, dni, fechaNac, graduacion);
        this.id_alumno = id_alumno;
        this.instructor = id_instructor;
    }
 
    public Alumno() {
    }
    
    
}
