package com.shan.crudtestproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shan.crudtestproject.entity.Employee;

    @Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}