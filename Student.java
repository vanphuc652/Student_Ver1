
package Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person implements IPerson{
    private float GPA;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, float GPA, String major) {
        super (id, fullName, dateOfBirth);
        this.GPA = GPA;
        this.major = major;
    }

    public Student() {
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("ID: ");
            String id = scanner.nextLine();
            setId(id);
            System.out.println("Full name: ");
            String fullName = scanner.nextLine();
            setFullName(fullName);
            System.out.println("Date of birth: ");
            String dateOfBirthString = scanner.nextLine();
            try {
                Date dateOfBirth = sdf.parse(dateOfBirthString);
                setDateOfBirth(dateOfBirth);
            } catch (Exception e) {
                System.out.println("Wrong format");
            }
            System.out.println("GPA: ");
            float GPA = Float.parseFloat(scanner.nextLine());
            setGPA(GPA);
            System.out.println("Major: ");
            String major = scanner.nextLine();
            setMajor(major);
        } catch (Exception e) {
            System.out.println("N/A");
        }
        
    }
    
    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDateOfBirth = sdf.format(getDateOfBirth());
        System.out.println("ID: " + this.getId());
        System.out.println("Full name: " + this.getFullName());
        System.out.println("Date of birth: " + formattedDateOfBirth);
        System.out.println("GPA: " + this.getGPA());
        System.out.println("Major: " + this.getMajor());
    }
}
