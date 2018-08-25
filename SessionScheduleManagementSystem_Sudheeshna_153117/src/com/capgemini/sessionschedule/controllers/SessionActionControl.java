package com.capgemini.sessionschedule.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.sessionschedule.beans.ScheduledSessions;
import com.capgemini.sessionschedule.services.SessionScheduleService;

@Controller
public class SessionActionControl {
	
	@Autowired
	private SessionScheduleService sessionservice;

	@RequestMapping("/")
	public ModelAndView getAllSession() {
		
		ArrayList<ScheduledSessions> sessions = sessionservice.printSessions();
		return new ModelAndView("ScheduledSessions","scheduled_Sessions",sessions);
		
	}
	
	
}
