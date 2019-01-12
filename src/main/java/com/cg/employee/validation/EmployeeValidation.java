package com.cg.employee.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cg.employee.app.pojo.Employee;

/**
 * @author ugawari
 */
@Component
public class EmployeeValidation implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		
		if(employee.getEmpName().length() < 2) {
			errors.rejectValue("empName", "empname.length", "Employee Name must have 2 characters.");
		}
		if(employee.getSalary() < 1000) {
			errors.rejectValue("salary", "salary.minimum", "Salary must be higher than 1000.");
		}
	}

}
