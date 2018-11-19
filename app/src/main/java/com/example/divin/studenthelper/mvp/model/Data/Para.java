package com.example.divin.studenthelper.mvp.model.Data;

public class Para {
    private int id;
    private int kodPredm;
    private int kodTeacher;
    private String timeStart;
    private String timeEnd;

    public Para() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKodPredm() {
        return kodPredm;
    }

    public void setKodPredm(int kodPredm) {
        this.kodPredm = kodPredm;
    }

    public int getKodTeacher() {
        return kodTeacher;
    }

    public void setKodTeacher(int kodTeacher) {
        this.kodTeacher = kodTeacher;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
