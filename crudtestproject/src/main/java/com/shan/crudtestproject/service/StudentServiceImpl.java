package com.shan.crudtestproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shan.crudtestproject.entity.Student;
import com.shan.crudtestproject.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public Student save(Student student) {
		Student createResponse = studentRepository.save(student);
		return createResponse;
	}

	@Transactional
	public Student update(Student student) {
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}

	@Transactional
	public Student get(Long id) {
		Optional<Student> response = studentRepository.findById(id);
		Student getResponse = response.get();
		return getResponse;
	}

	@Transactional
	public void delete(Student student) {
		studentRepository.delete(student);
	}
}
