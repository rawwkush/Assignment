package com.thinkitive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "option_table")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long optionId;
	private Long questionId;
	private int optionNumber;
	private String optionTitle;
	
	public Option() {
	}

	public Option(Long optionId, Long questionId, int optionNumber, String optionTitle) {
		super();
		this.optionId = optionId;
		this.questionId = questionId;
		this.optionNumber = optionNumber;
		this.optionTitle = optionTitle;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public int getOptionNumber() {
		return optionNumber;
	}

	public void setOptionNumber(int optionNumber) {
		this.optionNumber = optionNumber;
	}

	public String getOptionTitle() {
		return optionTitle;
	}

	public void setOptionTitle(String optionTitle) {
		this.optionTitle = optionTitle;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((optionId == null) ? 0 : optionId.hashCode());
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
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
		Option other = (Option) obj;
		if (optionId == null) {
			if (other.optionId != null)
				return false;
		} else if (!optionId.equals(other.optionId))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", questionId=" + questionId + ", optionNumber=" + optionNumber
				+ ", optionTitle=" + optionTitle + "]";
	}
	
}
