import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new employee");
            System.out.println("2. Show all employees");
            System.out.println("3. Save to file");
            System.out.println("4. Load from file");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewEmployee(manager, scanner);
                    break;
                case 2:
                    manager.showAllEmployees();
                    break;
                case 3:
                    manager.saveToFile();
                    break;
                case 4:
                    manager.loadFromFile();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewEmployee(EmployeeManager manager, Scanner scanner) {
        System.out.println("Select employee type:");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Intern");
        System.out.print("Your choice: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter birth day: ");
        String birthDay = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        switch (typeChoice) {
            case 1:
                System.out.print("Enter years of experience: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter professional skill: ");
                String proSkill = scanner.nextLine();
                manager.addEmployee(new Experience(Employee.getEmployeeCount() + 1, fullName, birthDay, phone, email, expInYear, proSkill));
                Experience.Employee_count();
                break;
            case 2:
                System.out.print("Enter graduation date: ");
                String graduationDate = scanner.nextLine();
                System.out.print("Enter graduation rank: ");
                String graduationRank = scanner.nextLine();
                System.out.print("Enter education: ");
                String education = scanner.nextLine();
                manager.addEmployee(new Fresher(Employee.getEmployeeCount() + 1, fullName, birthDay, phone, email, graduationDate, graduationRank, education));
                Fresher.Employee_count();
                break;
            case 3:
                System.out.print("Enter majors: ");
                String majors = scanner.nextLine();
                System.out.print("Enter semester: ");
                String semester = scanner.nextLine();
                System.out.print("Enter university name: ");
                String universityName = scanner.nextLine();
                manager.addEmployee(new Intern(Employee.getEmployeeCount() + 1, fullName, birthDay, phone, email, majors, semester, universityName));
                Intern.Employee_count();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println("Employee added successfully.");
    }
}