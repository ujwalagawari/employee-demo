/**
 * 
 */
package com.cg.employee.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.employee.app.dao.sql.SQLDatabase;
import com.cg.employee.app.pojo.Employee;

/**
 * @author ugawari
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate template;

	public void saveEmployee(Employee employee) {
		 template.update(SQLDatabase.getInstance().saveEmployee(),
				 employee.getEmpId(), employee.getEmpName(), employee.getSalary());
	}

}
