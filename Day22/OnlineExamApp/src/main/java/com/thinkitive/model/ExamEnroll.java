package com.thinkitive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thinkitive.enums.attendanceStatus;

@Entity
@Table(name = "exam_enroll_table")
public class ExamEnroll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userExamEnrollId;
	private Long userId;
	private Long examId;
	private attendanceStatus attendance;
	
	public ExamEnroll() {
	}

	public ExamEnroll(Long userExamEnrollId, Long userId, Long examId, attendanceStatus attendance) {
		super();
		this.userExamEnrollId = userExamEnrollId;
		this.userId = userId;
		this.examId = examId;
		this.attendance = attendance;
	}

	public Long getUserExamEnrollId() {
		return userExamEnrollId;
	}

	public void setUserExamEnrollId(Long userExamEnrollId) {
		this.userExamEnrollId = userExamEnrollId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public attendanceStatus getAttendance() {
		return attendance;
	}

	public void setAttendance(attendanceStatus attendance) {
		this.attendance = attendance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userExamEnrollId == null) ? 0 : userExamEnrollId.hashCode());
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
		ExamEnroll other = (ExamEnroll) obj;
		if (userExamEnrollId == null) {
			if (other.userExamEnrollId != null)
				return false;
		} else if (!userExamEnrollId.equals(other.userExamEnrollId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExamEnroll [userExamEnrollId=" + userExamEnrollId + ", userId=" + userId + ", examId=" + examId
				+ ", attendance=" + attendance + "]";
	}
}
