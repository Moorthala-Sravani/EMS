package demo.EMS;

public interface EmployeeDaoInterface {
//create Employee
	public void createEmployee(Employee emp) throws Exception;

	// show All Employee
	public void showAllEmployee();

	// show employee based on id
	public void showEmployeeBasedOnID(int id);

	// update employee
	public void updateEmployee(int id, String name);

	// delete employee
	public void deleteEmployee(int id);
}
