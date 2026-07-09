package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "taskinfo")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_contents")
    private String taskContents;

    @Column(name = "task_limitdate")
    private LocalDate taskLimitdate;

    @Column(name = "task_update")
    private LocalDateTime taskUpdate;

    @Column(name = "task_delete")
    private LocalDateTime taskDelete;

    @Column(name = "task_user")
    private String taskUser;

    @Column(name = "task_status")
    private boolean taskStatus;

    @Column(name = "user_id")
    private String userId;

    public ReservationEntity() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public boolean getTaskStatus() { return taskStatus; }
    public void setTaskStatus(boolean taskStatus) { this.taskStatus = taskStatus; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}