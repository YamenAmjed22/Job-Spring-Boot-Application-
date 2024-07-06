package com.SpringProjects.firstJopApp.Repository;

import com.SpringProjects.firstJopApp.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {
}
