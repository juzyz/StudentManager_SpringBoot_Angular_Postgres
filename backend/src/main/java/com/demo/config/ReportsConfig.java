package com.demo.config;

import com.demo.entities.reports.AttendanceTrack;
import com.demo.repositories.AttendTrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class ReportsConfig {
    @Bean
    CommandLineRunner reportCommandLineRunner(AttendTrackRepository attendTrackRepository) {
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

            attendTrackRepository.saveAll(List.of(aTrack1, aTrack2, aTrack3, aTrack4));
        };
    }

}
