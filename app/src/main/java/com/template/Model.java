package com.template;

public class Model {
    String name;
    String record;
    int idImage;

    public Model(String name, String record, int idImage) {
        this.idImage = idImage;
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return this.idImage;
    }

    public void setImage(int idImage) {
        this.idImage = idImage;
    }

    public String getRecord() {
        return this.record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
