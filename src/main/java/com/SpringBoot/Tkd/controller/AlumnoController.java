//Controller para la entidad Alumno
package com.SpringBoot.Tkd.controller;

import com.SpringBoot.Tkd.dto.AlumnoDTO;
import com.SpringBoot.Tkd.model.Alumno;
import com.SpringBoot.Tkd.model.Instructor;
import com.SpringBoot.Tkd.service.IAlumnoService;
import com.SpringBoot.Tkd.service.IinstructorService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    
    @Autowired
    private IAlumnoService alumnoServ;
    
    @Autowired
    private IinstructorService instServ;
    
    //Metodo POST para crear las entidadades Alumno
    @PostMapping("/crear")
    public String saveAlumno(@Valid @RequestBody Alumno alumno){
        alumnoServ.saveAlumno(alumno);
        //se obtiene el instructor del alumno
        Instructor instructor = instServ.findInstructor(alumno.getInstructor().getId_instructor());
        //se agrega el alumno a la lista del instructor
        instructor.getListaAlumnos().add(alumno);
        //se guarda el cambio realizado
        instServ.saveInstructor(instructor);
        return "Alumno creado";
    }
    
    //Metodo GET para ver la lista de entidades Alumno creadas
    @GetMapping("/ver")
    public List<AlumnoDTO> getAlumnos(){
               
       return alumnoServ.getAlumnosDTO();
    }
    
    //Metodo DELETE para eliminar una entidad Alumno existente
    @DeleteMapping("/borrar/{id_alumno}")
    public String deleteAlumno(@PathVariable Long id_alumno){
        alumnoServ.deleteAlumno(id_alumno);
        
        return "Alumno borrado";
    }
    
    //Metodo GET para obtener una entidad Alumno según la id enviada
    @GetMapping("/ver/{id_alumno}")
    public AlumnoDTO getAlumno(@PathVariable Long id_alumno){
        return alumnoServ.getAlumnoDTO(id_alumno);
    }
    
    //Metodo POST para graduar a un alumno
    @PostMapping("/graduar/{id_alumno}")
    public String graduarAlumno(@PathVariable Long id_alumno){
        Alumno alum = alumnoServ.findAlumno(id_alumno);
        
        alum.graduar();
        alumnoServ.saveAlumno(alum);
        return alum.getNombreApellido() + " ha sido graduado a " + alum.getGraduacion() + ".";
    }
    
    //Metodo PUT para editar una entidad Alumno
    @PutMapping("/editar")
    public AlumnoDTO editAlumno(@RequestBody Alumno alumno){
        alumnoServ.editAlumno(alumno);
        
        return alumnoServ.getAlumnoDTO(alumno.getId_alumno());
    }
}
