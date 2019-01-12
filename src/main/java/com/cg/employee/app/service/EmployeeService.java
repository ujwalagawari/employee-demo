package com.cg.employee.app.service;
import org.springframework.stereotype.Service;

import com.cg.employee.app.pojo.Employee;

@Service
public interface EmployeeService {

	void saveEmployee(Employee employee);

}
