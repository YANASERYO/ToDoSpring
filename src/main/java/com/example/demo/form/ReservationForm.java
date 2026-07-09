package com.example.demo.form;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



public class ReservationForm {
	@NotBlank(message = "タスク名称は必須です")
	private String taskName;
	
	@NotBlank(message = "タスク内容は必須です")
	private String taskCotents;
	
	@NotNull(message = "タスク期限は必須です")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate taskLimitdate;
	
	@NotBlank(message = "タスク変更日時は必須です")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime taskUpdate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime taskDelete;
	
	@NotBlank(message = "タスク担当者は必須です")
	private String taskUser;
	
	@NotBlank(message = "タスク状況は必須です")
	private String taskStatus;
	
	@NotBlank(message = "ユーザーIDは必須です")
	private String userId;
	
	public String getTaskName() { return taskName; }
	public void setTaskName(String taskName) { this.taskName = taskName; }
	public String getTaskCotents() { return taskCotents; }
	public void setTaskCotents(String taskCotents) { this.taskCotents = taskCotents; }
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
	
	




