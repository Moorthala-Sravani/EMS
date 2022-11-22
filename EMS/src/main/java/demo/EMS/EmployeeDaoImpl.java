package demo.EMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoInterface {
	Connection con;

	public void createEmployee(Employee emp) throws Exception {
		con = DBConnection.createDBConnection();
		String query = "insert into employee values(?,?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			int cnt = ps.executeUpdate();
			if (cnt != 0)
				System.out.println("Employee inserted sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showAllEmployee() {
		try {
			con = DBConnection.createDBConnection();
			String query = "select * from employeedb.employee";
			System.out.println("Employee Details");
			System.out.println("-------------------------");
			System.out.format("%s\t%s\t%s\t%s\t\n", "ID", "Name", "Salary", "Age");
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1), result.getString(2), result.getDouble(3),
						result.getInt(4));
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showEmployeeBasedOnID(int id) {
		try {
			con = DBConnection.createDBConnection();
			String query = "select * from employee where id =" + id;
			System.out.println("Employee Details");
			System.out.println("-------------------------");
			System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1), result.getString(2), result.getDouble(3),
						result.getInt(4));
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateEmployee(int id, String name) {
		try {
			con = DBConnection.createDBConnection();

			String query = "update employeedb.employee set name=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, id);
			int cnt=ps.executeUpdate();
			if(cnt!=0)
				System.out.println("Employee Details updated sucessfully!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public void deleteEmployee(int id) {
		try {
			con =DBConnection.createDBConnection();
			String query = "delete from employeedb.employee where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int cnt=ps.executeUpdate();
			if(cnt!=0)
				System.out.println("Employee Deleted Sucessfully"+id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	public void createEmployee() {
		// TODO Auto-generated method stub

	}

}
