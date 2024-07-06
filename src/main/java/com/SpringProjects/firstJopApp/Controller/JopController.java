package com.SpringProjects.firstJopApp.Controller;

import com.SpringProjects.firstJopApp.Models.Job;
import com.SpringProjects.firstJopApp.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

@RestController
public class JopController {
    @Autowired
    private JobService jobService;
    public JopController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAllJob(){
        return new ResponseEntity<>(jobService.findAllJobs(),HttpStatus.OK) ;
    }
    @PostMapping("/addJobs")
    public ResponseEntity<String> addJobs(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("The jod added successfully  ",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id){
        Job job = jobService.findJobById(id);
        if(job!=null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean del = jobService.deleteJobById(id); ;
        if (del){
            return new ResponseEntity<>("The job deleted successfully",HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/updateJobs/{id}")
/*
    @RequestMapping(value ="/updateJobs/{id}", method = RequestMethod.PUT)
*/
    public ResponseEntity<String> updateJob(@PathVariable Long id ,@RequestBody Job updated){
        boolean upd = jobService.updateById(id,updated); ;
        if (upd){
            return new ResponseEntity<>("the Job update successfully " ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
