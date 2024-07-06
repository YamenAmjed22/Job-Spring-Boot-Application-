package com.SpringProjects.firstJopApp.Service;

import com.SpringProjects.firstJopApp.Models.Company;
import com.SpringProjects.firstJopApp.Repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;
    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    // Methods
    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }
    public void addCompany(Company newCompany){
        companyRepo.save(newCompany);
    }
    public Boolean updateCompany(Long id , Company updatedCompany){
        Optional<Company> comp = companyRepo.findById(id);
        if (comp.isPresent()){
            Company company = comp.get();

            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepo.save(company);
            return true ;
        }
        return false;
    }
    public Boolean deleteCompanyById(Long id){
        if (companyRepo.existsById(id)){

            companyRepo.deleteById(id);
            return true ;
        }
        return false ;
    }
    public Company getCompanyById(Long id){

        return companyRepo.findById(id).orElse(null);

    }

}
