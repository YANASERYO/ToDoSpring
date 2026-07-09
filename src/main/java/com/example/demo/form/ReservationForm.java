package com.example.demo.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



public class ReservationForm {
	@NotBlank(message = "タスク名称は必須です")
	private String taskName;
	
	@NotBlank(message = "タスク内容は必須です")
	private String taskContents;
	
	@NotNull(message = "タスク期限は必須です")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate taskLimitdate;
	
	@NotBlank(message = "タスク担当者は必須です")
	private String taskUser;
	
	@NotBlank(message = "タスク状況は必須です")
	private Integer taskStatus;

	
	public String getTaskName() { return taskName; }
	public void setTaskName(String taskName) { this.taskName = taskName; }
	public String getTaskCotents() { return taskContents; }
	public void setTaskCotents(String taskCotents) { this.taskContents = taskCotents; }
	public LocalDate getTaskLimitdate() { return taskLimitdate; }
	public void setTaskLimitdate(LocalDate taskLimitdate) { this.taskLimitdate = taskLimitdate; }

	public String getTaskUser() { return taskUser; }
	public void setTaskUser(String taskUser) { this.taskUser = taskUser; }
	public Integer getTaskStatus() { return taskStatus; }
	public void setTaskStatus(Integer taskStatus) { this.taskStatus = taskStatus; }


}
	
	




