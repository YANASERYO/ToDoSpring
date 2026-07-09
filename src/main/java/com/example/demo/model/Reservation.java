package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
	
	private String taskName;
	private String taskContents;
	private LocalDate taskLimitdate;
	private LocalDateTime taskUpdate;
	private LocalDateTime taskDelete;
	private String taskUser;
	private String taskStatus;
	private String userId;

//	引数なしのコンストラクタ
	public Reservation() {
	}

	public Reservation(String taskName, String taskContents, LocalDate taskLimitdate, LocalDateTime taskUpdate, LocalDateTime taskDelete, String taskUser, String taskStatus, String userId) {
	    this.taskName = taskName;
	    this.taskContents = taskContents;
	    this.taskLimitdate = taskLimitdate;
	    this.taskUpdate = taskUpdate;
	    this.taskDelete = taskDelete;
	    this.taskUser = taskUser;
	    this.taskStatus = taskStatus;
	    this.userId = userId;
	}

	public String getTaskName() { return taskName; }
	public void setTaskName(String taskName) { this.taskName = taskName; }
	public String getTaskContents() { return taskContents; }
	public void setTaskContents(String taskContents) { this.taskContents = taskContents; }
	public LocalDate getTaskLimitdate() { return taskLimitdate; }
	public void setTaskLimitdate(LocalDate taskLimitdate) { this.taskLimitdate = taskLimitdate; }
	public LocalDateTime getTaskUpdate() { return taskUpdate; }
	public void setTaskUpdate(LocalDateTime taskUpdate) { this.taskUpdate = taskUpdate; }
	public LocalDateTime getTaskDelete() { return taskDelete; }
	public void setTaskDelete(LocalDateTime taskDelete) { this.taskDelete = taskDelete; }
	public String getTaskUser() { return taskUser; }
	public void setTaskUser(String taskUser) { this.taskUser = taskUser; }
	public String getTaskStatus() { return taskStatus; }
	public void setTaskStatus(String taskStatus) { this.taskStatus = taskStatus; }
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }
}