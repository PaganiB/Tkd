
package com.SpringBoot.Tkd.service;

import com.SpringBoot.Tkd.dto.AlumnoDTO;
import com.SpringBoot.Tkd.dto.AlumnoDTO2;
import com.SpringBoot.Tkd.dto.InstructorDTO;
import com.SpringBoot.Tkd.model.Alumno;
import com.SpringBoot.Tkd.model.Instructor;
import com.SpringBoot.Tkd.repository.IAlumnoRepository;
import com.SpringBoot.Tkd.repository.IinstructorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService implements IinstructorService{
    
    //inyeccion de dependencias
    @Autowired
    private IinstructorRepository instRepo;
    
    @Override
    //metodo que devuelve una lista con todas las entidades 'Instructor' existente
    public List<Instructor> getInstructores() {
        List<Instructor> listaInstructores = instRepo.findAll();
        
        return listaInstructores;
    }

    @Override
    //metodo que segun la id enviada como parametro devuelve la entidad que coincida, en caso de que no coincida con ninguna
    //se devolverá un valor nulo, indicando la inexistencia del mismo
    public Instructor findInstructor(Long id_instructor) {
        Instructor instructor = instRepo.findById(id_instructor).orElse(null);
        
        return instructor;
    }

    @Override
    //metodo que crea una entidad
    public void saveInstructor(Instructor instructor) {
        instRepo.save(instructor);
    }

    @Override
    //metodo que borra una entidad existente
    public void deleteInstructor(Long id_instructor) {
        instRepo.deleteById(id_instructor);
    }

    @Override
    //metodo para editar una entidad existente
    public void editInstructor(Instructor instructor) {
        this.saveInstructor(instructor);
    }

    @Override
    public List<InstructorDTO> getInstructoresDTO() {
        
        //se obtiene la lista de instructores
        List<Instructor> listaInstructores = this.getInstructores();
        // se crea una lista donde se agregaran los datos para el DTO de instructor
        List<InstructorDTO> listaInstrDTO = new ArrayList<InstructorDTO>();
        //instancia de objeto InstructorDTO
        InstructorDTO instructorDTO = new InstructorDTO();
        //se crea una nueva lista con objetos AlumnoDTO2 que contiene solamente nombreApellido y graduacion
        List<AlumnoDTO2> listaAlumDTO2 = new ArrayList<AlumnoDTO2>();
        //instancia de un nuevo objeto AlumnoDTO2
        AlumnoDTO2 alumnoDTO2 = new AlumnoDTO2();
        //se recorren todos los instructores
        for(Instructor instructor : listaInstructores){
            //lista de alumnos del instructor
            List<Alumno> listaAlumnos = instructor.getListaAlumnos();
            //se guarda el nombre del instructor en el dto
            instructorDTO.setNombreApellidoInstr(instructor.getNombreApellido());
            //se guarda la graduacion del instructor en el dto
            instructorDTO.setGraduacionInst(instructor.getGraduacion());
            //se recorre la lista de alumnos del instructor
            for(Alumno alum : listaAlumnos){
                    //se guarda el nombre y apellido del alumno
                    alumnoDTO2.setNombreApellido(alum.getNombreApellido());
                    //se guarda la graduacion del alumno
                    alumnoDTO2.setGraduacion(alum.getGraduacion());
                    //se añade el objeto alumnoDTO2 a la lista de alumnos
                    listaAlumDTO2.add(alumnoDTO2);
                    //se crea otro objeto AlumnoDTO2 donde se guardara otro alumno
                    alumnoDTO2 = new AlumnoDTO2();
                    //se guarda la lista de alumnos del instructor
                    instructorDTO.setListaAlumnos(listaAlumDTO2);
                
            }
            //se añade a la lista de instructorDTO un objeto instructorDTO
            listaInstrDTO.add(instructorDTO);
            //se crea un nuevo objeto InstructorDTO para agregarlo luego en la lista
            instructorDTO = new InstructorDTO();
        }
        
        return listaInstrDTO;
    }

    @Override
    public InstructorDTO getInstructorDTO(Long id_intructor) {
        Instructor instructor = instRepo.findById(id_intructor).orElse(null);
        InstructorDTO instructorDTO = new InstructorDTO();
        
        instructorDTO.setNombreApellidoInstr(instructor.getNombreApellido());
        instructorDTO.setGraduacionInst(instructor.getGraduacion());
        
        //if(instructor.getInstructor().getId_instructor() != null){
            instructorDTO.setNombreApellidoInstructorMayor(instructor.getInstructor().getNombreApellido());
            instructorDTO.setGraduacionInstructorMayor(instructor.getInstructor().getGraduacion());
        /*}
        else{
            instructorDTO.setNombreApellidoInstructorMayor("No existente");
            instructorDTO.setGraduacionInstructorMayor("No existente");
        }*/
        
        
        List<AlumnoDTO2> listaAlumDTO2 = new ArrayList<AlumnoDTO2>();
        AlumnoDTO2 alumnoDTO2 = new AlumnoDTO2();
        List<Alumno> listaAlumnos = instructor.getListaAlumnos();
        for(Alumno alumno : listaAlumnos){
            alumnoDTO2.setNombreApellido(alumno.getNombreApellido());
            alumnoDTO2.setGraduacion(alumno.getGraduacion());
            
            listaAlumDTO2.add(alumnoDTO2);
            //se crea otro objeto AlumnoDTO2 donde se guardara otro alumno
            alumnoDTO2 = new AlumnoDTO2();
            
        }
        instructorDTO.setListaAlumnos(listaAlumDTO2);
        
        return instructorDTO;
    }

    @Override
    public void graduar(Long id_instructor) {
        Instructor instructor = this.findInstructor(id_instructor);
        
        instructor.graduar();
    }
    
}
