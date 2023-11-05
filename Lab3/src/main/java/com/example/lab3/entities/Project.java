package com.example.lab3.entities;

import java.sql.Date;

/**
 * Project com.example.lab3.entity
 */
public class Project {
    private int id;
    private String name;
    private String category;
    private String description;
    private Date deadline;


    public Project(int id, String name, String category, String description, Date deadline) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public String getIdentifier() {
        return this.toString();
    }

}
