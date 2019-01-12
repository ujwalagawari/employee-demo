/**
 * 
 */
package com.cg.employee.app.dao.sql;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author ugawari
 *
 */
public final class SQLDatabase {

	private static SQLDatabase sqlDatabase = new SQLDatabase();

	private SQLDatabase() {
	}

	public static SQLDatabase getInstance() {
		return sqlDatabase;
	}

	public String saveEmployee() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("sql_database");
		return resourceBundle.getString("INSERT_EMPLOYEE");
	}

}
