package com.theironyard.novauc.entities;


import javax.persistence.*;

/**
 * Created by souporman on 3/17/17.
 */

@Entity
@Table(name = "citizendata")
public class CitizenData {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String state;

    @Column(nullable = false)
    boolean nraBool;

    @Column(nullable = false)
    boolean threatBool;

    @Column(nullable = false)
    int iq;

    public CitizenData() {
    }

    public CitizenData(String name, String state, boolean nraBool, boolean threatBool, int iq) {
        this.name = name;
        this.state = state;
        this.nraBool = nraBool;
        this.threatBool = threatBool;
        this.iq = iq;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isNraBool() {
        return nraBool;
    }

    public void setNraBool(boolean nraBool) {
        this.nraBool = nraBool;
    }

    public boolean isThreatBool() {
        return threatBool;
    }

    public void setThreatBool(boolean threatBool) {
        this.threatBool = threatBool;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
