package com.burritomatic.pos.model;


import java.io.Serializable;

public class Rule implements Serializable{
    private String definition;
    public Rule(String definition){
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
