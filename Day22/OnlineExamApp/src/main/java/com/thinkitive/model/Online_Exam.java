package com.thinkitive.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thinkitive.enums.ExamStatus;

@Entity
@Table(name = "online_exam_table")
public class Online_Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long examId;
	private Long teacherId;
	private String examTitle;
	private LocalDateTime examTime;
	private LocalTime examDuration;
	private int examTotalQuestion;
	private int markForRightAnswer;
	private int markForWrongAnswer;
	private ExamStatus examStatus;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> que;

	public Online_Exam() {
		
	}

	public Online_Exam(Long examId, Long teacherId, String examTitle, LocalDateTime examTime, LocalTime examDuration,
			int examTotalQuestion, int markForRightAnswer, int markForWrongAnswer, ExamStatus examStatus,
			List<Question> que) {
		super();
		this.examId = examId;
		this.teacherId = teacherId;
		this.examTitle = examTitle;
		this.examTime = examTime;
		this.examDuration = examDuration;
		this.examTotalQuestion = examTotalQuestion;
		this.markForRightAnswer = markForRightAnswer;
		this.markForWrongAnswer = markForWrongAnswer;
		this.examStatus = examStatus;
		this.que = que;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public LocalDateTime getExamTime() {
		return examTime;
	}

	public void setExamTime(LocalDateTime examTime) {
		this.examTime = examTime;
	}

	public LocalTime getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(LocalTime examDuration) {
		this.examDuration = examDuration;
	}

	public int getExamTotalQuestion() {
		return examTotalQuestion;
	}

	public void setExamTotalQuestion(int examTotalQuestion) {
		this.examTotalQuestion = examTotalQuestion;
	}

	public int getMarkForRightAnswer() {
		return markForRightAnswer;
	}

	public void setMarkForRightAnswer(int markForRightAnswer) {
		this.markForRightAnswer = markForRightAnswer;
	}

	public int getMarkForWrongAnswer() {
		return markForWrongAnswer;
	}

	public void setMarkForWrongAnswer(int markForWrongAnswer) {
		this.markForWrongAnswer = markForWrongAnswer;
	}

	public ExamStatus getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(ExamStatus examStatus) {
		this.examStatus = examStatus;
	}

	public List<Question> getQue() {
		return que;
	}

	public void setQue(List<Question> que) {
		this.que = que;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examId == null) ? 0 : examId.hashCode());
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
		Online_Exam other = (Online_Exam) obj;
		if (examId == null) {
			if (other.examId != null)
				return false;
		} else if (!examId.equals(other.examId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Online_Exam [examId=" + examId + ", teacherId=" + teacherId + ", examTitle=" + examTitle + ", examTime="
				+ examTime + ", examDuration=" + examDuration + ", examTotalQuestion=" + examTotalQuestion
				+ ", markForRightAnswer=" + markForRightAnswer + ", markForWrongAnswer=" + markForWrongAnswer
				+ ", examStatus=" + examStatus + ", que=" + que + "]";
	}
}
