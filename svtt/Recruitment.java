/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.svtt;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Recruitment implements Serializable{

    private String recruimentCode;
    private String position;
    private String recruimentPackage;
    private int number = 0;

    public Recruitment() {
    }

    /**
     *
     * @param recruimentCode
     * @param position
     * @param recruimentPackage
     * @param number
     */
    public Recruitment(String recruimentCode, String position, String recruimentPackage, int number) {
        this.recruimentCode = recruimentCode;
        this.position = position;
        this.recruimentPackage = recruimentPackage;
        this.number = number;
    }

    public String getRecruimentCode() {
        return recruimentCode;
    }

    public void setRecruimentCode(String recruimentCode) {
        this.recruimentCode = recruimentCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRecruimentPackage() {
        return recruimentPackage;
    }

    public void setRecruimentPackage(String recruimentPackage) {
        this.recruimentPackage = recruimentPackage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Recruiment{" + "recruimentCode=" + recruimentCode + ", position=" + position + ", recruimentPackage=" + recruimentPackage + ", number=" + number + '}';
    }

}
