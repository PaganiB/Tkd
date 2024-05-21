
package com.SpringBoot.Tkd.service;

import com.SpringBoot.Tkd.dto.AlumnoDTO;
import com.SpringBoot.Tkd.dto.AlumnoDTO2;
import com.SpringBoot.Tkd.model.Alumno;
import com.SpringBoot.Tkd.repository.IAlumnoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService implements IAlumnoService{
    
    //inyeccion de dependencias
    @Autowired
    private IAlumnoRepository alumnoRepo;

    @Override
    //metodo que devuelve la lista de alumnos registrados
    public List<Alumno> getAlumnos() {
        List<Alumno> listaAlumnos = alumnoRepo.findAll();
        
        return listaAlumnos;
    }

    @Override
    //metodo que devuelve al almno que coincide con la id enviada como parametro
    public Alumno findAlumno(Long id_alumno) {
        Alumno alumno = alumnoRepo.findById(id_alumno).orElse(null);
        
        return alumno;
    }

    @Override
    //metodo que crea la entidad
    public void saveAlumno(Alumno alumno) {
        alumnoRepo.save(alumno);
    }

    @Override
    //metodo que borra la entidad creada enviando como parametro su id
    public void deleteAlumno(Long id_alumno) {
        alumnoRepo.deleteById(id_alumno);
    }

    @Override
    //metodo para editar la entidad ya existente
    public void editAlumno(Alumno alumno) {
        this.saveAlumno(alumno);
    }

    @Override
    public List<AlumnoDTO> getAlumnosDTO() {
        //se crea una lista del tipo Alumno, donde se obtendran los datos para el DTO
        List<Alumno> listaAlumnos = this.getAlumnos();
        //se crea otra lista que sera donde se guardaran los datos necesarios y la que se devolverá en la solicitud
        List<AlumnoDTO> listaAlumInst = new ArrayList<AlumnoDTO>();
        //se crea un objeto AlumnoDTO que será el que se agrega en la lista 'listaAlumInst'
        //la que contendrá los datos a retornar
        AlumnoDTO alumnoInstr = new AlumnoDTO();
        
        for(Alumno alumno : listaAlumnos){
            alumnoInstr.setNombreApellidoAlum(alumno.getNombreApellido());
            alumnoInstr.setGraduacionAlu(alumno.getGraduacion());
            alumnoInstr.setNombreApellidoInst(alumno.getInstructor().getNombreApellido());
            alumnoInstr.setGraduacionInst(alumno.getInstructor().getGraduacion());
            
            listaAlumInst.add(alumnoInstr);
            alumnoInstr = new AlumnoDTO();//reseteo
        }
        
        return listaAlumInst;
    }

    @Override
    public AlumnoDTO getAlumnoDTO(Long id_alumno) {
        Alumno alumno = alumnoRepo.findById(id_alumno).orElse(null);
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        
        alumnoDTO.setNombreApellidoAlum(alumno.getNombreApellido());
        alumnoDTO.setGraduacionAlu(alumno.getGraduacion());
        alumnoDTO.setNombreApellidoInst(alumno.getInstructor().getNombreApellido());
        alumnoDTO.setGraduacionInst(alumno.getInstructor().getGraduacion());
        
        return alumnoDTO;
    }

    @Override
    public void graduar(Long id_alumno) {
        Alumno alum = this.findAlumno(id_alumno);
        
        alum.graduar();
    }
    
    
}
