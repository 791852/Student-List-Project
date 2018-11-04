/**
 * Veronica Pratt
 */
import java.util.Scanner;
public class Student extends StudListRunner
{
    private String firstName; //declaring the variables for each student object
    private String middleName;
    private String lastName;
    private int stuNumber;
    private double GPA;
    public Student(String name, int number, double gpa){
        firstName = ""; //initializing the varibles for each student object
        middleName = "";
        lastName = "";
        stuNumber = 0;
        GPA = 0.00;
    }
    public void setfirstName(String sn){ //creating setters and getters for each part of the student object I will need to access
        firstName = sn;
    }
    public void setmiddleName(String sn){
        middleName = sn;
    }
    public void setlastName(String sn){
        lastName = sn;
    }
    public String getlastName(){
        return lastName;
    }
    public String getfullName(){
        return lastName + ", " + firstName + " " + middleName;
    }
    public void setGPA(double sn){
        GPA = sn;
    }
    public double getGPA(){
        return GPA;
    }
    public void setstuNumber(int sn){
        stuNumber = sn;
    }
    public int getstuNumber(){
        return stuNumber;
    }
} 