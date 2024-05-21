
package com.SpringBoot.Tkd.repository;

import com.SpringBoot.Tkd.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IinstructorRepository extends JpaRepository<Instructor, Long>{
    
}
