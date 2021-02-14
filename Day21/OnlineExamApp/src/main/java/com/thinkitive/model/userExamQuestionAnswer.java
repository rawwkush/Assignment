package com.thinkitive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_question_answer_table")
public class userExamQuestionAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userExamQuestionAnswerId;
	private Long userId;
	private Long examId;
	private Long questionId;
	private int userAnswerOption;
	private int marks;
	
	public userExamQuestionAnswer() {
	}
	
	public userExamQuestionAnswer(Long userExamQuestionAnswerId, Long userId, Long examId, Long questionId,
			int userAnswerOption, int marks) {
		super();
		this.userExamQuestionAnswerId = userExamQuestionAnswerId;
		this.userId = userId;
		this.examId = examId;
		this.questionId = questionId;
		this.userAnswerOption = userAnswerOption;
		this.marks = marks;
	}

	public Long getUserExamQuestionAnswerId() {
		return userExamQuestionAnswerId;
	}

	public void setUserExamQuestionAnswerId(Long userExamQuestionAnswerId) {
		this.userExamQuestionAnswerId = userExamQuestionAnswerId;
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

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public int getUserAnswerOption() {
		return userAnswerOption;
	}

	public void setUserAnswerOption(int userAnswerOption) {
		this.userAnswerOption = userAnswerOption;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userExamQuestionAnswerId == null) ? 0 : userExamQuestionAnswerId.hashCode());
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
		userExamQuestionAnswer other = (userExamQuestionAnswer) obj;
		if (userExamQuestionAnswerId == null) {
			if (other.userExamQuestionAnswerId != null)
				return false;
		} else if (!userExamQuestionAnswerId.equals(other.userExamQuestionAnswerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "userExamQuestionAnswer [userExamQuestionAnswerId=" + userExamQuestionAnswerId + ", userId=" + userId
				+ ", examId=" + examId + ", questionId=" + questionId + ", userAnswerOption=" + userAnswerOption
				+ ", marks=" + marks + "]";
	}
}
