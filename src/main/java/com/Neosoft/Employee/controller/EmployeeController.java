package com.Neosoft.Employee.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Neosoft.Employee.entity.Employee;
import com.Neosoft.Employee.service.EmployeeService;


@RestController
@RequestMapping("Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/registeruser")
	public ResponseEntity<Employee> registeruser(@RequestBody @Valid Employee e){
		Employee register = service.register(e);
		
		return new ResponseEntity<Employee>(register,HttpStatus.CREATED);
	}
	@GetMapping("/getuser")
	public ResponseEntity<List<Employee>> getuser(Employee e){
		List<Employee> user = service.getUser(e);
		ResponseEntity<List<Employee>> re= new ResponseEntity<List<Employee>>(user,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getuserp")
	public ResponseEntity<List<Employee>> getuserp(Employee e){
		List<Employee> user = service.getUserp(e);
		ResponseEntity<List<Employee>> re= new ResponseEntity<List<Employee>>(user,HttpStatus.OK);
		return re;
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> update(@RequestBody Employee e,@PathVariable("id") Integer id){
		service.update(e, id);
		ResponseEntity<Employee> re= new ResponseEntity<Employee>(e,HttpStatus.CREATED);
		return re;
	}
	@GetMapping("/sortbydobandjoiningdate/{dob}/{joiningdate}")
	public ResponseEntity<List<Employee>> SortByDobandJoiningDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date dob,
			  @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date joiningdate){
		List<Employee> sortbydodandjoingdate = service.sortbydodandjoingdate(dob, joiningdate);
	return ResponseEntity.ok(sortbydodandjoingdate);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		service.delete(id);
		ResponseEntity re= new ResponseEntity<>(HttpStatus.ACCEPTED); 
		return re;
	}

}
