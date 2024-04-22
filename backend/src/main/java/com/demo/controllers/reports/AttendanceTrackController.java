package com.demo.controllers.reports;


import com.demo.entities.reports.AttendanceTrack;
import com.demo.entities.Student;
import com.demo.services.AttendTrackService;
import com.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin(origins = "http://localhost:4200")
public class AttendanceTrackController {
    HashMap<LocalDate, LinkedList<AttendanceTrack>> reportData = new HashMap<>();

    @Autowired
    AttendanceTrackController(StudentService studentService, AttendTrackService attendTrackService) {
        this.studentService = studentService;
        this.attendTrackService = attendTrackService;
    }


    StudentService studentService;
    AttendTrackService attendTrackService;

    @PostMapping("addTrack/{date}")
    public void addNewAttendanceTrack(@PathVariable LocalDate date, @RequestBody AttendanceTrack attendanceTrack) {
        LinkedList<AttendanceTrack> attendanceList = reportData.get(date);
        if (attendanceList == null) {
            attendanceList = new LinkedList<>();
            reportData.put(date, attendanceList);
        }  // need to add check if AttendanceTrack is already added for given empId or re-write to use HashSet
        attendanceList.add(attendanceTrack);
    }

    @DeleteMapping("clearData")
    public void clearRepostData() {
        reportData.clear();
    }

    @GetMapping("getPresentStudents/{stringDate}")
    public List<Student> getPresentStudents(@PathVariable String stringDate) {
        LocalDate date = prepareData(stringDate);
        List<AttendanceTrack> atList = reportData.get(date).stream()
                .filter(aTrack -> aTrack.getIsPresent())
                .collect(Collectors.toList());
        return atList.stream()
                .map(atTr -> studentService.getStudentById(atTr.getId().getStudentId()))
                .collect(Collectors.toList());
    }

    @GetMapping("getAbsentStudents/{stringDate}")
    public List<Student> getAbsentStudents(@PathVariable String stringDate) {
        LocalDate date = prepareData(stringDate);
        List<AttendanceTrack> atList = reportData.get(date).stream()
                .filter(aTrack -> !aTrack.getIsPresent())
                .collect(Collectors.toList());
        return atList.stream()
                .map(atTr -> studentService.getStudentById(atTr.getId().getStudentId()))
                .collect(Collectors.toList());
    }

    @PutMapping("updateAbsentEmployees/{date}/")
    public void updateAbsentStudents(@PathVariable String date, @RequestBody AttendanceTrack attendanceTrack) {
        reportData.get(date)
                .stream()
                .filter(aTrack -> aTrack.getId().getStudentId().equals(attendanceTrack.getId().getStudentId()))
                .findFirst()
                .ifPresent(updatedTrack -> updatedTrack.setIsPresent(attendanceTrack.getIsPresent()));
    }


    private LocalDate prepareData(String stringDate) {
        if (reportData.isEmpty()) {
            retrievedDataFromDB();
        }
        DateTimeFormatter df = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MM-dd-yyyy")
                .toFormatter(Locale.ENGLISH);
        return LocalDate.parse(stringDate, df);
    }

    private void retrievedDataFromDB() {
        List<AttendanceTrack> allAttendTracks = attendTrackService.getAllAttendTracks();
        for (AttendanceTrack track : allAttendTracks) {
            LinkedList<AttendanceTrack> trackList = reportData.get(track.getId().getDate());
            if (reportData.get(track.getId().getDate()) == null) {
                trackList = new LinkedList<>();
                reportData.put(track.getId().getDate(), trackList);
            }
            trackList.add(track);
        }
    }


}