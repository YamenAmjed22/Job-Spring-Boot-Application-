package com.SpringProjects.firstJopApp.Repository;

import com.SpringProjects.firstJopApp.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JopRepo extends JpaRepository<Job,Long> {

}
