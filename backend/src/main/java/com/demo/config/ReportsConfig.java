package com.demo.config;

import com.demo.entities.reports.AttendanceTrack;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class ReportsConfig {
    @Bean
    CommandLineRunner reportCommandLineRunner() {
        return args -> {
            AttendanceTrack aTrack1 = new AttendanceTrack(
                    1l,
                    true,
                    LocalDate.of(2024, Month.APRIL, 05)
            );

            AttendanceTrack aTrack2 = new AttendanceTrack(
                    1l,
                    false,
                    LocalDate.of(2024, Month.APRIL, 8)
            );

            AttendanceTrack aTrack3 = new AttendanceTrack(
                    2l,
                    true,
                    LocalDate.of(2024, Month.APRIL, 05)
            );
            AttendanceTrack aTrack4 = new AttendanceTrack(
                    2l,
                    true,
                    LocalDate.of(2024, Month.APRIL, 8)
            );


//            LinkedList attendanceList1 = new LinkedList<>();
//            attendanceList1.addAll(List.of(aTrack1, aTrack3));
//            reportData.put("12-12-2023", attendanceList1);
//            LinkedList attendanceList2 = new LinkedList<>();
//            attendanceList2.addAll(List.of(aTrack2));
//            reportData.put("12-11-2023", attendanceList2);
        };
    }

}
