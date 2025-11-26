import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Person {
    protected String name;
    public Person() {}
    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;
    public Student() {
    }

    public Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public void inputDetails(Scanner sc) {
        System.out.print("Enter Roll No: ");
        this.rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Course: ");
        this.course = sc.nextLine();

        while (true) {
            System.out.print("Enter Marks (0–100): ");
            this.marks = sc.nextDouble();
            if (this.marks >= 0 && this.marks <= 100) {
                break;
            } else {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
            }
        }
        calculateGrade();
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------");
    }

    public void calculateGrade() {
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 80) {
            grade = 'B';
        } else if (marks >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int choice;
        do {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number (1–3).");
                System.out.print("Enter your choice: ");
                sc.next();
            }

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n--- Add New Student ---");
                    Student s = new Student();
                    s.inputDetails(sc);
                    students.add(s);
                    System.out.println("Student added successfully!\n");
                    break;
                case 2:
                    System.out.println("\n--- Displaying All Students ---");
                    if (students.isEmpty()) {
                        System.out.println("No student records found.\n");
                    } else {
                        for (Student st : students) {
                            st.displayDetails();
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nExiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select 1, 2, or 3.\n");
            }
        } while (choice != 3);
        sc.close();
    }
}
