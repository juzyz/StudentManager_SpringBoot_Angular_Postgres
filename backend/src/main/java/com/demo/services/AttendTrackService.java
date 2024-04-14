package com.demo.services;

import com.demo.entities.Student;
import com.demo.entities.reports.AttendanceTrack;
import com.demo.exeptions.BadRequestException;
import com.demo.repositories.AttendTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendTrackService {
    private final AttendTrackRepository attendTrackRepository;

    @Autowired
    public AttendTrackService(AttendTrackRepository attendTrackRepository) {
        this.attendTrackRepository = attendTrackRepository;
    }

    public List<AttendanceTrack> getAllAttendTracks() {
        return attendTrackRepository.findAll();
    }

    public void addNewAttendTrack (AttendanceTrack attendanceTrack){
        Optional<AttendanceTrack> opAttTrack = attendTrackRepository.findById(attendanceTrack.getId());
        if (opAttTrack.isPresent()) {
            throw new BadRequestException( "Track for student " +attendanceTrack.getId().getStudentId()
                    + " for date "+attendanceTrack.getId().getDate() +" has already existed.");
        }
        AttendanceTrack opAttendTrack = attendTrackRepository.save(attendanceTrack);
    }
}
