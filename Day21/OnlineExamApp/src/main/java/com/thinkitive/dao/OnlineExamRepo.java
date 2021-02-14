package com.thinkitive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.Online_Exam;

public interface OnlineExamRepo  extends JpaRepository<Online_Exam, Long> {

}
