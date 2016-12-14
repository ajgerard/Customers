/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tholm
 */
public class Calculator {
    
    private int calcID;
    private double assessed;
    private double annual;
    private double monthly;
    private String type;

    public Calculator(int calcID, double assessed, double annual, double monthly, String type) {
        this.calcID = calcID;
        this.assessed = assessed;
        this.annual = annual;
        this.monthly = monthly;
        this.type = type;
    }
    public Calculator() {
        this.calcID = 0;
        this.assessed = 0;
        this.annual = 0;
        this.monthly = 0;
        this.type = "";
    }

    public int getCalcID() {
        return calcID;
    }

    public void setCalcID(int calcID) {
        this.calcID = calcID;
    }

    public double getAssessed() {
        return assessed;
    }

    public void setAssessed(double assessed) {
        this.assessed = assessed;
    }

    public double getAnnual() {
        return annual;
    }

    public void setAnnual(double annual) {
        this.annual = annual;
    }

    public double getMonthly() {
        return monthly;
    }

    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Calculator{" + "calcID=" + calcID + ", assessed=" + assessed + ", annual=" + annual + ", monthly=" + monthly + ", type=" + type + '}';
    }
    
    
}
