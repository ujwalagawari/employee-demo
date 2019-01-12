package com.cg.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.employee.app.pojo.Employee;
import com.cg.employee.app.service.EmployeeService;
import com.cg.employee.validation.EmployeeValidation;

@Controller
@RequestMapping("/employee")
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	
	  @Autowired
	  EmployeeValidation employeeValidation;
	 
	
	/*
	 * @RequestMapping(value="/save", method=RequestMethod.GET) public String
	 * askDetails(Map map) { map.put("employee", new Employee()); return "input"; }
	 */

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String askDetails(Model model) {
		model.addAttribute("employee", new Employee());
		return "input";
	}

	/*
	 * @RequestMapping("/save") public String save(@RequestParam("empId") int empId,
	 * 
	 * @RequestParam("empName") String empName,
	 * 
	 * @RequestParam("salary") double salary, Model model) { Employee employee = new
	 * Employee(empId, empName, salary); model.addAttribute("employee", employee);
	 * return "display"; }
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee, BindingResult result) {
		employeeValidation.validate(employee, result);
		if (result.hasErrors()) {
			return "input";
		}
	    employeeService.saveEmployee(employee);
		return "redirect:returnSave";
	}
	
	@RequestMapping(value = "/returnSave", method = RequestMethod.GET)
	public String display(SessionStatus status) {
		//status.setComplete();
		return "display";
	}
}
