
package com.SpringBoot.Tkd.service;

import com.SpringBoot.Tkd.dto.InstructorDTO;
import com.SpringBoot.Tkd.model.Instructor;
import java.util.List;


public interface IinstructorService {
    
    public List<Instructor> getInstructores();
    
    public Instructor findInstructor(Long id_instructor);
    
    public void saveInstructor(Instructor instructor);
    
    public void deleteInstructor(Long id_instructor);
    
    public void editInstructor(Instructor instructor);
    
    public List<InstructorDTO> getInstructoresDTO();
    
    public InstructorDTO getInstructorDTO(Long id_intructor);
    
    public void graduar(Long id_instructor);
}
