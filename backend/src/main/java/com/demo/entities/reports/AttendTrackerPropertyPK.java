package com.demo.entities.reports;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class AttendTrackerPropertyPK implements Serializable {

    private LocalDate date;
    private Long studentId;

    public AttendTrackerPropertyPK(){}
    public AttendTrackerPropertyPK(LocalDate date, Long studentId) {
        this.date = date;
        this.studentId = studentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
