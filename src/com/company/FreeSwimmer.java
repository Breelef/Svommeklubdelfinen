package com.company;

public class FreeSwimmer extends Member {
    private String type;
    public FreeSwimmer(String name, int age, int CPR, boolean status, String type){
        super(name, age, CPR, status);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
