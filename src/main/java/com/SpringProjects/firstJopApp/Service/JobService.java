package com.SpringProjects.firstJopApp.Service;

import com.SpringProjects.firstJopApp.Models.Job;
import com.SpringProjects.firstJopApp.Repository.JopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    //private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JopRepo jopRepo;
    public JobService(JopRepo jopRepo) {
        this.jopRepo = jopRepo;
    }

    /*private Long nextId = 1L;*/
    public List<Job> findAllJobs(){

        return jopRepo.findAll();
    }
    public void addJob(Job job){
        /*job.setId(nextId++);*/
        jopRepo.save(job);
    }

    public Job findJobById(Long id) {
        return jopRepo.findById(id).orElse(null);
    }

    public Boolean deleteJobById(Long id) {
        try {
            jopRepo.deleteById(id);
            return true;
        }catch (Exception e ){
            return false;
        }

    }

    public boolean updateById(Long id ,Job updated ) {
        Optional<Job> jobOptional = jopRepo.findById(id);
        if (jobOptional.isPresent()){
            Job j = jobOptional.get();
            j.setTitle(updated.getTitle());
            j.setLocation(updated.getLocation());
            j.setDescription(updated.getDescription());
            j.setMinSalary(updated.getMinSalary());
            j.setMaxSalary(updated.getMaxSalary());
            jopRepo.save(j);
            return true;
            }

        return false;
    }
}
