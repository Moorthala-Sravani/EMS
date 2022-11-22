package demo.EMS;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		EmployeeDaoInterface dao = new EmployeeDaoImpl();
		System.out.println("Welcome to Employee Management Application");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Add Employee\n" + "2.Show All Employee\n" + "3.Show Employee based on id \n"
					+ "4.Update the employee \n " + "5.Delete the employee\n");
			System.out.println("Enter choice:");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				System.out.println("Enter name: ");
				String name = sc.next();
				System.out.println("Enter salary");
				double salary = sc.nextDouble();
				System.out.println("Enter age");
				int age = sc.nextInt();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showAllEmployee();
				break;
			case 3:
				System.out.println("Enter id to show the details");
				int empid = sc.nextInt();
				dao.showEmployeeBasedOnID(empid);
			case 4:
				System.out.println("Enter id to update the details");
				int empid1 = sc.nextInt();
				System.out.println("Enter the new name");
				String name1 = sc.next();
				dao.updateEmployee(empid1, name1);
				break;
			case 5:
				System.out.println("Enter the id to delete");
				id = sc.nextInt();
				dao.deleteEmployee(id);
				break;
			case 6:
				   System.out.println("Thank you for using our Application !!!");
                   System.exit(0);
			default:
				System.out.println("Enter Valid choice!");
				break;
			}
		} while (true);
	}
}
