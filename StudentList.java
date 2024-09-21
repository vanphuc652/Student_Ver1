
package Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class StudentList {
    private ArrayList <Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent (Student student) {
        studentList.add(student);
    }
    
    public void updateStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                Scanner scanner = new Scanner(System.in);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    System.out.println("Enter the ID to search: ");
                    System.out.print("ID: " + student.getId());
                    System.out.print("New full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("New date of birth (dd/MM/yyyy): ");
                    Date dateOfBirth;
                    try {
                        dateOfBirth = sdf.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    }
                    System.out.print("New GPA: ");
                    float GPA;
                    try {
                        GPA = Float.parseFloat(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid GPA format.");
                    }
                    System.out.print("New major: ");
                    String major = scanner.nextLine();

                    System.out.println("Student added successfully.");
                } catch (Exception e) {
                    System.out.println("N/A");
                }
            }
        }   
    }
    
    public void deleteStudentById(String id) {
        for (Student student : studentList) {
            studentList.removeIf(studentList -> studentList.getId().equals(id));
        }
        System.out.println("Deleted");
    }
    
    public void displayAllStudent() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println();
        }
    }
    
    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGPA() > topStudent.getGPA()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}
    