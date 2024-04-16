import java.util.Scanner;

public abstract class Employee implements IEmployee {
	protected int id;
	protected String fullName;
	protected String birthDay;
	protected String phone;
	protected String email;
	protected String employeeType;
	protected static int employeeCount = 0;

	public Employee(int id, String fullName, String birthDay, String phone, String email, String employeeType) {
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
		employeeCount++;
	}

	@Override
	public void showInfo() {
		System.out.println("ID: " + id);
		System.out.println("Full Name: " + fullName);
		System.out.println("Birth Day: " + birthDay);
		System.out.println("Phone: " + phone);
		System.out.println("Email: " + email);
		System.out.println("Employee Type: " + employeeType);
	}

	public static int getEmployeeCount() {
		return employeeCount;
	}
	public String toFileString() {
		return id + "," + fullName + "," + birthDay + "," + phone + "," + email + "," + employeeType;
	}
}