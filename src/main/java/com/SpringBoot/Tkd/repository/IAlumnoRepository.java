
package com.SpringBoot.Tkd.repository;

import com.SpringBoot.Tkd.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long>{
    
}
