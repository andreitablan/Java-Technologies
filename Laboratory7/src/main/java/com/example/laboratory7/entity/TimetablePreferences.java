package com.example.laboratory7.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "timetable_preferences", schema = "public", catalog = "postgres")
public class TimetablePreferences {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "preference_id")
    private int preferenceId;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "registration_number")
    private String registrationNumber;
    @Basic
    @Column(name = "submission_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime submissionDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users usersByUserId;

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceId, content, registrationNumber, submissionDate);
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
