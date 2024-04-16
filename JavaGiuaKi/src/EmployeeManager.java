import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();
    private static final String FILE_PATH = "employees.txt";

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(int id, Employee updatedEmployee) {
        employees.set(id, updatedEmployee);
    }

    public void deleteEmployee(int id) {
        employees.remove(id);
    }

    public void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to show.");
        } else {
            System.out.println("Showing all employees:");
            for (Employee employee : employees) {
                employee.showInfo();
            }
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee employee : employees) {
                writer.write(employee.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) {
                    System.out.println("Invalid data format: " + line);
                    continue;
                }
                int id = Integer.parseInt(parts[0]);
                String fullName = parts[1];
                String birthDay = parts[2];
                String phone = parts[3];
                String email = parts[4];
                String employeeType = parts[5];

                if ("Experience".equals(employeeType) && parts.length >= 8) {
                    int expInYear = Integer.parseInt(parts[6]);
                    String proSkill = parts[7];
                    Experience experience = new Experience(id, fullName, birthDay, phone, email, expInYear, proSkill);
                    employees.add(experience);
                } else if ("Fresher".equals(employeeType) && parts.length >= 9) {
                    String graduationDate = parts[6];
                    String graduationRank = parts[7];
                    String education = parts[8];
                    Fresher fresher = new Fresher(id, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
                    employees.add(fresher);
                } else if ("Intern".equals(employeeType) && parts.length >= 9) {
                    String majors = parts[6];
                    String semester = parts[7];
                    String universityName = parts[8];
                    Intern intern = new Intern(id, fullName, birthDay, phone, email, majors, semester, universityName);
                    employees.add(intern);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
