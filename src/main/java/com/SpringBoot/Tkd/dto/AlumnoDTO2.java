
package com.SpringBoot.Tkd.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlumnoDTO2 {
    
    private String nombreApellido;
    private String graduacion;

    public AlumnoDTO2() {
    }

    public AlumnoDTO2(String nombreApellido, String graduacion) {
        this.nombreApellido = nombreApellido;
        this.graduacion = graduacion;
    }
    
}
