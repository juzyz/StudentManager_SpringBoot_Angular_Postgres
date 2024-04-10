package com.demo.controllers.reports;


import com.demo.entities.reports.AttendanceTrack;
import com.demo.entities.Student;
import com.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin(origins = "http://localhost:4200")
public class AttendanceTrackerController {
    HashMap<String, LinkedList<AttendanceTrack>> reportData = new HashMap<>();

//    @Bean
//    CommandLineRunner reportCommandLineRunner() {
//        return args -> {
//            AttendanceTrack aTrack1 = new AttendanceTrack(
//                    1l,
//                    true
//            );
//
//            AttendanceTrack aTrack2 = new AttendanceTrack(
//                    1l,
//                    false
//            );
//
//            AttendanceTrack aTrack3 = new AttendanceTrack(
//                    2l,
//                    true
//            );
//            AttendanceTrack aTrack4 = new AttendanceTrack(
//                    2l,
//                    false
//            );
//
//
//            LinkedList attendanceList1 = new LinkedList<>();
//            attendanceList1.addAll(List.of(aTrack1, aTrack3));
//            reportData.put("12-12-2023", attendanceList1);
//            LinkedList attendanceList2 = new LinkedList<>();
//            attendanceList2.addAll(List.of(aTrack2));
//            reportData.put("12-11-2023", attendanceList2);
//        };
//    }

    @Autowired
    StudentService studentService;

    @PostMapping("addTrack/{date}")
    public void addNewAttendanceTrack(@PathVariable String date, @RequestBody AttendanceTrack attendanceTrack) {
        LinkedList<AttendanceTrack> attendanceList = reportData.get(date);
        if (attendanceList == null) {
            attendanceList = new LinkedList<>();
            reportData.put(date, attendanceList);
        }  // need to add check is AttendanceTrack is already added for given empId or re-write to use HashSet
        attendanceList.add(attendanceTrack);
    }

    @DeleteMapping("clearData")
    public void clearRepostData() {
        reportData.clear();
    }

    @GetMapping("getPresentStudents/{date}")
    public List<Student> getPresentStudents(@PathVariable String date) {
        int df =5;
//        return reportData.get(date).stream().filter(aTrack -> aTrack.getIsPresent()).collect(Collectors.toList());
        List<AttendanceTrack> atList = reportData.get(date).stream()
                .filter(aTrack -> aTrack.getIsPresent())
                .collect(Collectors.toList());
        return atList.stream()
//                .map(atTr -> studentService.getStudentById(atTr.getStudentId()))
                .map(atTr -> studentService.getStudentById(atTr.getId().getStudentId()))
                .collect(Collectors.toList());
    }

    @GetMapping("getAbsentStudents/{date}")
    public List<Student> getAbsentStudents(@PathVariable String date) {
        List<AttendanceTrack> atList = reportData.get(date).stream()
                .filter(aTrack -> !aTrack.getIsPresent())
                .collect(Collectors.toList());
        return atList.stream()
                .map(atTr -> studentService.getStudentById(atTr.getId().getStudentId()))
                .collect(Collectors.toList());
//        return null;
    }

    @PutMapping("updateAbsentEmployees/{date}/")
    public void updateAbsentStudents(@PathVariable String date, @RequestBody AttendanceTrack attendanceTrack) {
        reportData.get(date)
                .stream()
                .filter(aTrack -> aTrack.getId().getStudentId().equals(attendanceTrack.getId().getStudentId()))
                .findFirst()
                .ifPresent(updatedTrack -> updatedTrack.setIsPresent(attendanceTrack.getIsPresent()));
    }
}