package com.capgemini.sessionschedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.sessionschedule.beans.ScheduledSessions;

public interface SessionScheduledao extends JpaRepository<ScheduledSessions, Integer>{

	
}
