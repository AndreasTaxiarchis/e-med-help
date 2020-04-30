package com.example.e_med_help.dtos;

import java.io.Serializable;

public class PrescriptionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public PrescriptionEntity() {
    }

    public PrescriptionEntity(int id, String name) {
        this.id = id;
        this.name = name;
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
}
