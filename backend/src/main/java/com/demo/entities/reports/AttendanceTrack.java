package com.demo.entities.reports;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class AttendanceTrack {

    public AttendanceTrack (){}
    public AttendanceTrack (Long studentId, Boolean isPresent, LocalDate date ){
        this.isPresent = isPresent;
        this.id = new AttendTrackerPropertyPK(date, studentId);
    }
    @EmbeddedId
    private AttendTrackerPropertyPK id;

    @Column(nullable = false)
    private Boolean isPresent;

}

