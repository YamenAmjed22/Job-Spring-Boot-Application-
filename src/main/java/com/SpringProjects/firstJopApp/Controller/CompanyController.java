package com.SpringProjects.firstJopApp.Controller;

import com.SpringProjects.firstJopApp.Models.Company;
import com.SpringProjects.firstJopApp.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAllCompany")
    public ResponseEntity<List<Company>> findAllCompany(){
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK) ;
    }
    @PostMapping("/addNewCompany")
    public ResponseEntity<String> addNewCompany(@RequestBody Company newCompany){
        companyService.addCompany(newCompany);
        return new ResponseEntity<>("The new company added successfully ",HttpStatus.CREATED);

    }
    @PutMapping("/updateCompany/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id , @RequestBody Company updatedCompany){
        Boolean updated = companyService.updateCompany(id,updatedCompany);
        if (updated){
            return new  ResponseEntity<>("The Company was updated successfully " , HttpStatus.OK);
        }
        return new  ResponseEntity<>("The Company was not updated" , HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        if (companyService.deleteCompanyById(id)){
            return new ResponseEntity<>("The company was deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("wasn't find the company",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/companyById/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id){
        if (companyService.getCompanyById(id) != null) {
            return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
