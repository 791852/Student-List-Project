import java.util.Scanner;
import java.util.ArrayList;
/**
 * Veronica Pratt
 */
public class StudListRunner 
{
    public static void main(){
        StudentList studentListObject = new StudentList(); //this creates a new object to work with
        Student student = new Student("p", 7, 0.00); //this creats a new student object to work with
        int loopEnd = 1;
        Scanner in = new Scanner(System.in); //this creates a scanner to check which number people enter
        while(loopEnd != 0){
            System.out.println("\n");
            System.out.println("Welcome to my StudentList Project");
            System.out.println("To add a student, enter 1");
            System.out.println("To delete a student, enter 2");
            System.out.println("To edit the StudentList, enter 3");
            System.out.println("To clear the list, enter 4");
            System.out.println("To print the list, enter 5");
            System.out.println("To print a Student, enter 6");
            System.out.println("To filter the list, enter 7");
            System.out.println("To exit this program, enter 0");
            int input = studentListObject.menuNumber(); //this sets a variable equal to the number the user inputs
            if(input == 0){ //these if statements all check for what number the user inputs, and then does the requested method
                loopEnd = 0;
            }
            if(input ==1){
                System.out.println("Please enter the name of the student you wish to add");
                String name = in.nextLine();
                int num = student.getstuNumber();
                double GPA = student.getGPA();
                studentListObject.addStudenttoList(name,num, GPA);
            }
            if(input == 2){
                System.out.print(studentListObject.deleteStudent());
            }
            if(input == 3){
                System.out.print(studentListObject.editStudentList());
            }
            if(input == 4){
                System.out.print(studentListObject.clearList());
            }
            if(input == 5){
                System.out.print(studentListObject.printList());
            }
            if(input == 6){
                System.out.print(studentListObject.printStudent());
            }
            if(input == 7){
                System.out.print(studentListObject.filterStudentSearch());
            }
        }
    }
} 