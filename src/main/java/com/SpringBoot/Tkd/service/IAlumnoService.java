
package com.SpringBoot.Tkd.service;

import com.SpringBoot.Tkd.dto.AlumnoDTO;
import com.SpringBoot.Tkd.model.Alumno;
import java.util.List;


public interface IAlumnoService {
    
    public List<Alumno> getAlumnos();
    
    public Alumno findAlumno(Long id_alumno);
    
    public void saveAlumno(Alumno alumno);
    
    public void deleteAlumno(Long id_alumno);
    
    public void editAlumno(Alumno alumno);
    
    public List<AlumnoDTO> getAlumnosDTO();
    
    public AlumnoDTO getAlumnoDTO(Long id_alumno);
    
    public void graduar(Long id_alumno);
}
