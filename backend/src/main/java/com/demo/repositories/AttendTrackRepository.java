package com.demo.repositories;

import com.demo.entities.reports.AttendTrackerPropertyPK;
import com.demo.entities.reports.AttendanceTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendTrackRepository extends JpaRepository<AttendanceTrack, AttendTrackerPropertyPK> {
}
