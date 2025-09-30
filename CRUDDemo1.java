import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Emp {
    private int empNo;
    private String ename;
    private float sal;

    public Emp(int empNo, String ename, float sal) {
        this.empNo = empNo;
        this.ename = ename;
        this.sal = sal;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "[EmpNo=" + empNo + ", Name=" + ename + ", Salary=" + sal + "]";
    }
}

public class CRUDDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Emp> database = new HashMap<>();

        int opt;
        do {
            System.out.println("\n========= Employee Management =========");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            opt = scan.nextInt();
            scan.nextLine(); // consume newline

            switch (opt) {
                case 1 -> {
                    System.out.print("Enter Employee No: ");
                    int empNo = scan.nextInt();
                    scan.nextLine();

                    if (database.containsKey(empNo)) {
                        System.out.println(" Employee with this number already exists!");
                        break;
                    }

                    System.out.print("Enter Employee Name: ");
                    String ename = scan.nextLine();

                    System.out.print("Enter Salary: ");
                    float sal = scan.nextFloat();

                    Emp e1 = new Emp(empNo, ename, sal);
                    database.put(empNo, e1);
                    System.out.println(" Employee added successfully!");
                }

                case 2 -> {
                    System.out.print("Enter Employee No to find: ");
                    int empNo = scan.nextInt();
                    Emp e1 = database.get(empNo);
                    if (e1 != null)
                        System.out.println(" Found: " + e1);
                    else
                        System.out.println(" Employee not found!");
                }

                case 3 -> {
                    System.out.print("Enter Employee No to update: ");
                    int empNo = scan.nextInt();
                    scan.nextLine();
                    Emp e1 = database.get(empNo);

                    if (e1 != null) {
                        System.out.println("Current: " + e1);
                        System.out.println("What do you want to update?");
                        System.out.println("1. Name");
                        System.out.println("2. Salary");
                        System.out.println("3. Both");
                        System.out.print("Choose option: ");
                        int opt2 = scan.nextInt();
                        scan.nextLine();

                        switch (opt2) {
                            case 1 -> {
                                System.out.print("Enter new name: ");
                                e1.setEname(scan.nextLine());
                                System.out.println(" Name updated!");
                            }
                            case 2 -> {
                                System.out.print("Enter new salary: ");
                                e1.setSal(scan.nextFloat());
                                System.out.println(" Salary updated!");
                            }
                            case 3 -> {
                                System.out.print("Enter new name: ");
                                e1.setEname(scan.nextLine());
                                System.out.print("Enter new salary: ");
                                e1.setSal(scan.nextFloat());
                                System.out.println(" Name & Salary updated!");
                            }
                            default -> System.out.println(" Invalid option!");
                        }
                    } else {
                        System.out.println(" Employee not found!");
                    }
                }

                case 4 -> {
                    System.out.print("Enter Employee No to delete: ");
                    int eno = scan.nextInt();
                    if (database.remove(eno) != null)
                        System.out.println(" Deleted successfully!");
                    else
                        System.out.println(" Employee not found!");
                }

                case 5 -> {
                    if (database.isEmpty()) {
                        System.out.println(" No employees found.");
                    } else {
                        System.out.println("\n All Employees:");
                        for (Map.Entry<Integer, Emp> entry : database.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                }

                case 6 -> System.out.println(" Exiting... Goodbye!");

                default -> System.out.println("Invalid option!");
            }

        } while (opt != 6);

        scan.close();
    }
}