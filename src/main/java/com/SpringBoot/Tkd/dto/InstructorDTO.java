
package com.SpringBoot.Tkd.dto;

import com.SpringBoot.Tkd.model.Alumno;
import com.SpringBoot.Tkd.model.Instructor;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InstructorDTO {
    
    private String nombreApellidoInstr;
    private String graduacionInst;
    private String nombreApellidoInstructorMayor;
    private String graduacionInstructorMayor;
    private List<AlumnoDTO2> listaAlumnos;

    public InstructorDTO(String nombreApellidoInstr, String graduacionInst, String nombreApellidoInstructorMayor, String graduacionInstructorMayor, List<AlumnoDTO2> listaAlumnos) {
        this.nombreApellidoInstr = nombreApellidoInstr;
        this.graduacionInst = graduacionInst;
        this.nombreApellidoInstructorMayor = nombreApellidoInstructorMayor;
        this.graduacionInstructorMayor = graduacionInstructorMayor;
        this.listaAlumnos = listaAlumnos;
    }

    public InstructorDTO() {
    }
    
}
