package com.Neosoft.Employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Neosoft.Employee.entity.Employee;
import com.Neosoft.Employee.repo.EmployeeRepo;
import com.Neosoft.Employee.service.EmployeeService;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = EmployeeApplicationTests.class)
class EmployeeApplicationTests {
	@Mock
	private EmployeeRepo employeerepo;
	@InjectMocks
	private EmployeeService employeeservice = new EmployeeService();

	@Test
	void register() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("satish");
		e.setSurname("kakani");
		e.setDob(new Date(1997, 9, 20));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(70000.00);
		e.setPincode(534447);
		;
		when(employeeservice.register(e)).thenReturn(e);
		Assertions.assertEquals(e, e);
	}

	@Test
	void getUser() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("satish");
		e.setSurname("kakani");
		e.setDob(new Date(1997, 9, 20));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(70000.00);
		e.setPincode(534447);
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("hari");
		e2.setSurname("andheri");
		e2.setDob(new Date(1997, 9, 20));
		e2.setDepartment("software engineer");
		e2.setJoiningdate(new Date(2021, 9, 06));
		e2.setSalary(80000.00);
		e2.setPincode(534447);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		when(employeerepo.findByNameOrSurname("satish","andhari")).thenReturn(list);
		List<Employee> emp = employeeservice.getUser(e);

		Assertions.assertEquals(0, emp.size());
	}
	@Test
	void getUserp() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("satish");
		e.setSurname("kakani");
		e.setDob(new Date(1997, 9, 20));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(70000.00);
		e.setPincode(534447);
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("hari");
		e2.setSurname("andheri");
		e2.setDob(new Date(1997, 9, 20));
		e2.setDepartment("software engineer");
		e2.setJoiningdate(new Date(2021, 9, 06));
		e2.setSalary(80000.00);
		e2.setPincode(500018);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		when(employeerepo.findByNameOrPincode("sai",534447)).thenReturn(list);
		List<Employee> emp = employeeservice.getUserp(e2);

		Assertions.assertEquals(0, emp.size());
	}
	@Test
	void sortbydodandjoingdate() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("satish");
		e.setSurname("kakani");
		e.setDob(new Date(1997, 9, 20));
		e.setDepartment("software engineer");
		e.setJoiningdate(new Date(2021, 9, 06));
		e.setSalary(70000.00);
		e.setPincode(534447);
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("hari");
		e2.setSurname("andheri");
		e2.setDob(new Date(1997, 9, 20));
		e2.setDepartment("software engineer");
		e2.setJoiningdate(new Date(2021, 9, 06));
		e2.setSalary(80000.00);
		e2.setPincode(500018);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		list.add(e2);
		when(employeerepo.findByDobOrJoiningdate(new Date(1997, 9, 20), new Date(2021, 9, 06))).thenReturn(list);
		List<Employee> emp = employeeservice.sortbydodandjoingdate(new Date(1997, 9, 20), new Date(2021, 9, 06));

		Assertions.assertEquals(2, emp.size());
	}
	

}
