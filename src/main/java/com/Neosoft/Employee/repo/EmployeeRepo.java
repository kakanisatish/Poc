package com.Neosoft.Employee.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Neosoft.Employee.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
 public abstract List<Employee> findByNameOrSurname(String name, String surname);
 public abstract List<Employee> findByNameOrPincode(String name, Integer pincode);
 public abstract List<Employee> findByDobOrJoiningdate(Date dob, Date joiningdate);

}
