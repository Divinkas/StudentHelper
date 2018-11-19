package com.example.divin.studenthelper.mvp.model.Data;

public class Rozklad {
    private int id;
    private int kodDay;
    private int kodNamePredm;
    private int kodTypeZn;
    private int kodPara;
    private int kodCategoryStudents;
    private String auditoriya;
    private boolean isActive;

    public Rozklad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKodDay() {
        return kodDay;
    }

    public void setKodDay(int kodDay) {
        this.kodDay = kodDay;
    }

    public int getKodNamePredm() {
        return kodNamePredm;
    }

    public void setKodNamePredm(int kodNamePredm) {
        this.kodNamePredm = kodNamePredm;
    }

    public int getKodTypeZn() {
        return kodTypeZn;
    }

    public void setKodTypeZn(int kodTypeZn) {
        this.kodTypeZn = kodTypeZn;
    }

    public int getKodPara() {
        return kodPara;
    }

    public void setKodPara(int kodPara) {
        this.kodPara = kodPara;
    }

    public int getKodCategoryStudents() {
        return kodCategoryStudents;
    }

    public void setKodCategoryStudents(int kodCategoryStudents) {
        this.kodCategoryStudents = kodCategoryStudents;
    }

    public String getAuditoriya() {
        return auditoriya;
    }

    public void setAuditoriya(String auditoriya) {
        this.auditoriya = auditoriya;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
