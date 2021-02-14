package com.thinkitive.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.ExamEnroll;

public interface ExamEnrollRepo extends JpaRepository<ExamEnroll, Long> {

}
