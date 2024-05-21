
package com.SpringBoot.Tkd.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlumnoDTO {
    
    private String nombreApellidoAlum;
    private String graduacionAlu;
    private String nombreApellidoInst;
    private String graduacionInst;

    public AlumnoDTO() {
    }

    public AlumnoDTO(String nombreApellidoAlum, String graduacionAlu, String nombreApellidoInst, String graduacionInst) {
        this.nombreApellidoAlum = nombreApellidoAlum;
        this.graduacionAlu = graduacionAlu;
        this.nombreApellidoInst = nombreApellidoInst;
        this.graduacionInst = graduacionInst;
    }
    
}
