
package com.SpringBoot.Tkd.controller;

import com.SpringBoot.Tkd.dto.InstructorDTO;
import com.SpringBoot.Tkd.model.Alumno;
import com.SpringBoot.Tkd.model.Instructor;
import com.SpringBoot.Tkd.service.IinstructorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    
    //Inyeccion de dependecias
    @Autowired
    private IinstructorService instServ;
    
    
    //Metodo POST para crear la entidad Instructor
    @PostMapping("/crear")
    public String saveInstructor(@RequestBody Instructor instructor){
        instServ.saveInstructor(instructor);
        
        return "Instructor creado";
    }
    
    //Metodo GET que devuelve la lista de entidades Instructor creadas
    @GetMapping("/ver")
    public List<InstructorDTO> getInstructores(){
        
        return instServ.getInstructoresDTO();
    }
    
    //Metodo DELETE para borrar una entidad Instructor existente
    @DeleteMapping("/borrar/{id_instructor}")
    public String deleteInstructor(@PathVariable Long id_instructor){
        instServ.deleteInstructor(id_instructor);
        
        return "Instructor borrado";
    }
    
    //Metodo GET que devuelve una entidad Instructor segun la id enviada
    @GetMapping("/ver/{id_instructor}")
    public InstructorDTO getInstructor(@PathVariable Long id_instructor){
        
         return instServ.getInstructorDTO(id_instructor);
    }
    
    //Metodo POST que gradua a la entidad Instructor, segun la id enviada
    @PostMapping("/graduar/{id_instructor}")
    public String graduarInstructor(@PathVariable Long id_instructor){
        Instructor instructor = instServ.findInstructor(id_instructor);
        
        instructor.graduar();
        instServ.saveInstructor(instructor);
        
        return instructor.getNombreApellido() + " ha sido graduado a " + instructor.getGraduacion() + ".";
    }
    
    //Metodo PUT para editar una entidad Instructor
    @PutMapping("/editar/")
    public InstructorDTO editInstructor(@RequestBody Instructor instructor){
        instServ.editInstructor(instructor);
        
        return instServ.getInstructorDTO(instructor.getId_instructor());
    }
}
