package com.shan.crudtestproject.service;

import org.springframework.stereotype.Component;

import com.shan.crudtestproject.entity.Student;

@Component
public interface StudentService {

	public Student save(Student student);
	public Student update(Student student);
	public Student get(Long id);
	public void delete(Student student);
}
