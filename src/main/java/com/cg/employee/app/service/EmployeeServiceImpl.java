package com.cg.employee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.app.dao.EmployeeDao;
import com.cg.employee.app.pojo.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public void saveEmployee(Employee employee) {
		 employeeDao.saveEmployee(employee);
	}

}
