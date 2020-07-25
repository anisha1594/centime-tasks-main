package com.centime.tasks.tasksmainservice.task1.model;

import javax.validation.constraints.NotBlank;

public class FullName {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "SurName is mandatory")
    private String surName;

    public FullName(@NotBlank(message = "Name is mandatory") String name, @NotBlank(message = "SurName is mandatory") String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
