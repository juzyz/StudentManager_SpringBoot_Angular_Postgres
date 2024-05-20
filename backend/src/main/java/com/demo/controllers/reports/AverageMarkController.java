package com.demo.controllers.reports;

import com.demo.entities.Student;
import com.demo.services.AverageMarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SortedMap;

@RestController
@RequestMapping("/api/v1/report")
@CrossOrigin(origins = "http://localhost:4200")
public class AverageMarkController {

    private final AverageMarkService averageMarkService;

    public AverageMarkController(AverageMarkService averageMarkService) {
        this.averageMarkService = averageMarkService;
    }

    @GetMapping("getStudentsByMarkRange/{minMark}/{maxMark}")
    public List<Student> getPresentStudents(@PathVariable String minMark, @PathVariable String maxMark) {
        SortedMap studentMap = averageMarkService.getStudentsByMarkRange(Double.valueOf(minMark), Double.valueOf(maxMark));
        return  studentMap.values().stream().toList();
    }
}
