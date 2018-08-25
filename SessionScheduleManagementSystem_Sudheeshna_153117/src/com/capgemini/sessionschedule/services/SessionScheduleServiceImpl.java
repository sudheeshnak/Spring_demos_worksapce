package com.capgemini.sessionschedule.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.sessionschedule.beans.ScheduledSessions;
import com.capgemini.sessionschedule.repo.SessionScheduledao;

@Component(value="sessionservice")
public class SessionScheduleServiceImpl implements SessionScheduleService {

	@Autowired
	private SessionScheduledao repo;
	
	@Override
	public ArrayList<ScheduledSessions> printSessions() {
		
		return (ArrayList<ScheduledSessions>) repo.findAll();
	}

}
