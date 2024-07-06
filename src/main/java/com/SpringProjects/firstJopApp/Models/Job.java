package com.SpringProjects.firstJopApp.Models;

import jakarta.persistence.*;

@Entity
//@Table(name = "job_table")
public class Job {
    // Att
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String location;
    private String description;
    private String minSalary;
    private String maxSalary;

    // Constructor
    // we need when we work with JPA
    public Job() {
    }

    public Job(long id, String title, String location, String description, String minSalary, String maxSalary) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
    // setter and getter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }
}




