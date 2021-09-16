package com.Neosoft.Employee.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Neosoft.Employee.entity.Employee;
import com.Neosoft.Employee.repo.EmployeeRepo;

@Service 
public class EmployeeService {
	@Autowired
	private EmployeeRepo emprepo;
	

	
	public Employee register(Employee e) {
		emprepo.save(e);
		return e;
	}
	public List<Employee> getUser(Employee e)
	{
		return (List<Employee>) emprepo.findByNameOrSurname(e.getName(),e.getSurname());
	}
	public List<Employee> getUserp(Employee e)
	{
		return (List<Employee>) emprepo.findByNameOrPincode(e.getName(),e.getPincode());
	}
	public void update(Employee e,Integer id) {
		emprepo.save(e);
	}
	public List<Employee> sortbydodandjoingdate(Date dob,Date joiningdate){
	 List<Employee> findByDobOrJoiningdate = emprepo.findByDobOrJoiningdate(dob, joiningdate);
	return findByDobOrJoiningdate;
	}
	public void delete(Integer id) {
		Optional<Employee> employee = emprepo.findById(id);
		if(employee.isPresent()) {
			emprepo.delete(employee.get());
		}else {
			throw new RuntimeException("employee with id is not present"+id);
		}
	}


}
