package com.centime.tasks.tasksmainservice.task2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NAMES")
public class Name {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "PARENT_ID")
    private Long parentId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "COLOR")
    private String color;

    public Name() {
    }

    public Name(Long id, Long parentId, String name, String color) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
