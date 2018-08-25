package com.capgemini.sessionschedule.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScheduledSessions {
	
	@Id
	private int id;
	private String name;
	private int duration;
	private String faculty;
	private String mode1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getMode1() {
		return mode1;
	}
	public void setMode1(String mode1) {
		this.mode1 = mode1;
	}
	public ScheduledSessions(int id, String name, int duration, String faculty, String mode1) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.faculty = faculty;
		this.mode1 = mode1;
	}
	public ScheduledSessions() {
		
	}
	@Override
	public String toString() {
		return "ScheduledSessions [id=" + id + ", name=" + name + ", duration=" + duration + ", faculty=" + faculty
				+ ", mode1=" + mode1 + "]";
	}
	public ScheduledSessions(int id) {
		super();
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduledSessions other = (ScheduledSessions) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

	
	
}