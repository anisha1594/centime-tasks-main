package com.centime.tasks.tasksmainservice.task2.model;

import java.util.List;

public class NestedNameResponse {
    private List<SubClass> subClasses;

    public NestedNameResponse(List<SubClass> subClasses) {
        this.subClasses = subClasses;
    }

    public List<SubClass> getSubClasses() {
        return subClasses;
    }

    @Override
    public String toString() {
        return "NestedNameResponse{" +
                "subClasses:" + subClasses +
                '}';
    }

    public static class SubClass {
        private Long id;
        private Long parentId;
        private String name;
        private String color;
        private List<SubClass> subClasses;

        public SubClass(Long id, Long parentId, String name, String color, List<SubClass> subClasses) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
            this.color = color;
            this.subClasses = subClasses;
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

        public List<SubClass> getSubClasses() {
            return subClasses;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setSubClasses(List<SubClass> subClasses) {
            this.subClasses = subClasses;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "SubClass{" +
                    "id:" + id +
                    ", parentId:" + parentId +
                    ", name:'" + name + '\'' +
                    ", subClasses:" + subClasses +
                    '}';
        }
    }
}
