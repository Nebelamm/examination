package com.neu.edu.domain;

public class Subject {

    private Integer subjcet_id;
    private String name;
    private Integer teacher_id;

    public Integer getSubjcet_id() {
        return subjcet_id;
    }

    public void setSubjcet_id(Integer subjcet_id) {
        this.subjcet_id = subjcet_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }
}
