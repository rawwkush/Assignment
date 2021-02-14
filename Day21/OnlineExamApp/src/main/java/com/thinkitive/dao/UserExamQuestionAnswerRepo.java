package com.thinkitive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thinkitive.model.userExamQuestionAnswer;

public interface UserExamQuestionAnswerRepo extends JpaRepository<userExamQuestionAnswer, Long> {
	
	@Query("from userExamQuestionAnswer where userId=?1 and examId=?2")
	public List<userExamQuestionAnswer> findByuserAndExamId(Long id,Long examid);
}

//select * from exam_question_answer_table where user_id=1 and exam_id=1 