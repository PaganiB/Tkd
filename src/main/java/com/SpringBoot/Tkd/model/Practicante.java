//Clase practicante que representa cualquier practicante inscripto en la organización 
package com.SpringBoot.Tkd.model;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public class Practicante {
    
    //Todos los practicantes, tanto alumnos como instructores cuentan con sus propios datos:
    //nombre, apellido, dni, edad, fecha de nacimiento y graduacion(cinturon)
    private String nombreApellido;
    private String dni;
    private LocalDate fechaNac;
    private String graduacion;

    public Practicante(String nombreApellido, String dni, LocalDate fechaNac, String graduacion) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.graduacion = graduacion;
    }

    public Practicante() {
    }

    public String graduar(){
        List<String> nivelesGraduacion = Arrays.asList("10 gup", "9 gup", "8 gup", "7 gup", "6 gup", "5 gup", "4 gup",
                                                         "3 gup", "2 gup", "1 gup", "I Dan", "II Dan", "III Dan", "IV Dan",
                                                         "V Dan", "VI Dan", "VII Dan", "VIII Dan", "IX Dan");
        
        int indice = nivelesGraduacion.indexOf(this.graduacion);
        
        String respuesta;
        
        if (indice == nivelesGraduacion.size() - 1) {
           respuesta = "El practicante ya ha alcanzado el nivel máximo de graduación.";
        } else {
            this.graduacion = nivelesGraduacion.get(indice + 1);
           respuesta = this.nombreApellido + " ha sido graduado a " + this.graduacion + ".";
        }
        
        return respuesta;
    }
}
