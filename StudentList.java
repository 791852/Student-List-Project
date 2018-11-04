/**
 *Veronica Pratt
 */
import java.util.Scanner;
import java.util.ArrayList;
public class StudentList
{
    ArrayList<Student> studList;
    public StudentList(){
        studList = new ArrayList<Student>();;
    }
    public static int menuNumber(){
        Scanner in = new Scanner(System.in);
        int returnVar = in.nextInt();
        return returnVar;
    }
    public void parseUserInput(String name, Student student){
        String fn = "";
        String mn = "";
        String ln = "";
        int i = name.indexOf(" "); //sets number equal to index of first space
        int j = name.indexOf(" ", i+1); //sets number equal to index of second space
        if(name.indexOf(",") == -1){ //checks to see if there is no comma, so First Middle Last
            fn = name.substring(0, i);
            mn = name.substring(i+1, j);
            ln = name.substring(j+1);
        }else{ //if there is a comma
            if(j == -1){ // if there is no second space, so Last, First
                ln = name.substring(0, i-1);
                fn = name.substring(i+1);
            }else{ //if there is a second space, so Last, First Middle
                ln = name.substring(0, i-1);
                j = name.indexOf(" ", i+1);
                fn = name.substring(i+1, j);
                mn = name.substring(j+1);
            }
        }
        student.setfirstName(fn);
        student.setmiddleName(mn);
        student.setlastName(ln);
    }
    public void addStudenttoList(String name, int num, double GPA){
        Student student = new Student("Bob", 0, 0.00);
        studList.add(student); //this adds a student to the list as a placeholder
        parseUserInput(name, studList.get(studList.size()-1)); //this calls the parseUserInput to see what name they want to enter
        System.out.println("Please enter your student's student number"); //then this sets the student's number
        Scanner scannerNumber = new Scanner(System.in);
        int numberEntered = scannerNumber.nextInt();
        student.setstuNumber(numberEntered);
        System.out.println("Please enter your student's GPA"); //this sets the student's gpa
        Scanner scannerGPA = new Scanner(System.in);
        double GPAentered = scannerGPA.nextDouble();
        student.setGPA(GPAentered);
    }
    public String deleteStudent(){
        System.out.println("Enter 1 if you want to enter a student number"); //checks whether they want to enter a name or number
        System.out.println("Enter 2 if you want to enter a student's last name");
        Scanner scanner = new Scanner(System.in);
        int menuVarOne = scanner.nextInt();
        if(menuVarOne == 1){
            System.out.println("Please enter their student number");
            Scanner scanner2 = new Scanner(System.in);
            int numberEntered = scanner2.nextInt(); //sets an int equal to the number they enter
            for(int i = 0; i<studList.size(); i++){ //looks over the array list
                if(studList.get(i).getstuNumber() == numberEntered){ //checks to see where that number exists and removes that object
                    studList.remove(i);
                }
            }
        }else{
            System.out.println("Please enter the student's last name");
            Scanner scanner2 = new Scanner(System.in);
            String nameEntered = scanner2.nextLine(); //sets Sting equal to the name they enter
            for(int i = 0; i<studList.size(); i++){
                if(studList.get(i).getlastName() == nameEntered){ //checks array for where that name exists and removes that object in the space
                    studList.remove(i);
                }
            }
        }
        return "The student has been deleted"; //then the code confirms that the student has been deleted
    }
    public String editStudentList(){
        System.out.println("Enter 1 if you want to enter a student number");
        System.out.println("Enter 2 if you want to enter a student's last name");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt(); //this creates an int equal to the number a person enters
        if(input==1){ //this is if they decide to enter a student's student number
            System.out.println("Please enter their number");
            Scanner scanner2 = new Scanner(System.in);
            int numberEntered = scanner2.nextInt();
            for(int i = 0; i<studList.size(); i++){ //this for loop iterates of the Array List
                if(studList.get(i).getstuNumber() == numberEntered){ // then at each index, it checks whether there is a student with that number
                    //if there is a student with that number, then this happens
                    System.out.println("Enter 1 to change first name");
                    System.out.println("Enter 2 to change middle name");
                    System.out.println("Enter 3 to change last name");
                    System.out.println("Enter 4 to change their number");
                    System.out.println("Enter 5 to change their GPA");
                    int numberEntered2 = scanner2.nextInt();
                    if(numberEntered2 == 1){ //all these if statements check to see what the user wants to do, and then does the thing
                        System.out.println("Enter their new first name");
                        Scanner firstScanner = new Scanner(System.in);
                        String studentFirstName = firstScanner.nextLine(); //this sets a string equal to the name the user inputs
                        studList.get(i).setfirstName(studentFirstName); //this sets the student's name at that index to that string
                    }
                    if(numberEntered2 == 2){ //all of these following if statements do basically the same this as the first one
                        //in which they set a varibale equal to whatever the user inputs 
                        //and then sets part of the student object at a certain index to that
                        System.out.println("Enter their new middle name");
                        Scanner middleScanner = new Scanner(System.in);
                        String studentMiddleName = middleScanner.nextLine();
                        studList.get(i).setmiddleName(studentMiddleName);
                    }
                    if(numberEntered2 == 3){
                        System.out.println("Enter their new last name");
                        Scanner lastScanner = new Scanner(System.in);
                        String studentLastName = lastScanner.nextLine();
                        studList.get(i).setlastName(studentLastName);
                    }
                    if(numberEntered2 == 4){
                        System.out.println("Now type in their new student number");
                        Scanner numInputScanner = new Scanner(System.in);
                        int stuNumIn = numInputScanner.nextInt();
                        studList.get(i).setstuNumber(stuNumIn);
                    }
                    if(numberEntered2 == 5){
                        System.out.println("Now type in their GPA");
                        Scanner GPAInputScanner = new Scanner(System.in);
                        double stuGPAIn = scanner.nextDouble();
                        studList.get(i).setGPA(stuGPAIn);
                    }
                    System.out.println("It has been changed");
                }
            }
        }else{ //now this does the same thing as above, but is for when the user enters a last name
            System.out.println("Please enter their last name");
            Scanner scanner2 = new Scanner(System.in);
            String nameEnter = scanner2.nextLine(); //this sets a string equal to that last name
            for(int i = 0; i<studList.size(); i++){ //this iterates over the Array List
                if(studList.get(i).getlastName().equals(nameEnter)){ //checks each index for the last name
                    System.out.println("Enter 1 to change first name"); //this is the exact same as before
                    System.out.println("Enter 2 to change middle name");
                    System.out.println("Enter 3 to change last name");
                    System.out.println("Enter 4 to change their number");
                    System.out.println("Enter 5 to change their GPA");
                    int numberEnter2 = scanner2.nextInt();
                    if(numberEnter2 == 1){ 
                        System.out.println("Enter their new name");
                        Scanner firstScanner = new Scanner(System.in);
                        String studentFirstName = firstScanner.nextLine();
                        studList.get(i).setfirstName(studentFirstName);
                    }
                    if(numberEnter2 == 2){
                        System.out.println("Enter their new name");
                        Scanner middleScanner = new Scanner(System.in);
                        String studentMiddleName = middleScanner.nextLine();
                        studList.get(i).setmiddleName(studentMiddleName);
                    }
                    if(numberEnter2 == 3){
                        System.out.println("Enter their new name");
                        Scanner lastScanner = new Scanner(System.in);
                        String studentLastName = lastScanner.nextLine();
                        studList.get(i).setlastName(studentLastName);
                    }
                    if(numberEnter2 == 4){
                        System.out.println("Now type in their student number");
                        Scanner numInputScanner = new Scanner(System.in);
                        int stuNumIn = numInputScanner.nextInt();
                        studList.get(i).setstuNumber(stuNumIn);
                    }
                    if(numberEnter2 == 5){
                        System.out.println("Now type in their GPA");
                        Scanner GPAInputScanner = new Scanner(System.in);
                        double stuGPAIn = GPAInputScanner.nextDouble();
                        studList.get(i).setGPA(stuGPAIn);
                    }
                    System.out.println("It has been changed");
                }
            }
        }
        return "The student has now been edited!";
    }
    public String clearList(){
        studList.clear(); //this clears the list, it is very straightfor
        return "You have cleared the list";
    }
    public String printList(){
        System.out.println("\u000c"); //this clears the screen so the list shows up independently of other stuff
        int index = 0;
        while(index < studList.size()){ //this while loop iterates over the Array List
            System.out.print(studList.get(index).getfullName()+" "); //at each index, it will print the student's information
            System.out.print(studList.get(index).getGPA()+" ");
            System.out.println(studList.get(index).getstuNumber()); 
            index += 1;
        }
        return "The list has been printed above";
    }
    public String printStudent(){
        System.out.println("Please press 1 to enter the student's number or 2 to enter their name");
        Scanner scanner = new Scanner(System.in);
        int menuInput = scanner.nextInt();
        if(menuInput==1){ //if they want to find a student with their student number
            System.out.println("Please enter the student number of the student you wish to print");
            Scanner numberScanner = new Scanner(System.in);
            int numberInput = numberScanner.nextInt();
            for(int i = 0; i < studList.size(); i++){ //this iterates over the array list
                if(studList.get(i).getstuNumber() == numberInput){ //this checks each index for a student with that student number
                    System.out.print(studList.get(i).getfullName() + " "); //once it finds the student, it prints their information
                    System.out.print(studList.get(i).getGPA() + " ");
                    System.out.println(studList.get(i).getstuNumber());
                }
            }
        }else{ //this does the same as above but with last names instead of student numbers
            System.out.println("Please enter the last name of the student you wish to print");
            Scanner nameScanner = new Scanner(System.in);
            String nameInput = nameScanner.nextLine();
            for(int i = 0; i < studList.size(); i++){
                if(studList.get(i).getlastName() == nameInput){
                    System.out.print(studList.get(i).getfullName() + " ");
                    System.out.print(studList.get(i).getGPA() + " ");
                    System.out.println(studList.get(i).getstuNumber());
                }
            }
        }
        return "The student has been printed above";
    }
    public String filterStudentSearch(){
        System.out.println("Please enter 1 if you want to sort by student number or 2 to sort by GPA");
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int count = 0; //this counter is to check whether a student with the given parameters exists
        if(inputNum == 1){ //this is if they enter a student number
            System.out.println("Please enter the student number by which you wish to filter the list");
            Scanner numScanner = new Scanner(System.in);
            int stuNumInput = numScanner.nextInt();
            for(int i = 0; i < studList.size(); i++){ //iterates over the Array List
                if(studList.get(i).getstuNumber() <= stuNumInput){ //checks each the student number at index 
                    //i.e. if each student has the student number or a student number less than that
                    System.out.print(studList.get(i).getfullName() + " "); //prints each student's information
                    System.out.print(studList.get(i).getGPA() + " ");
                    System.out.println(studList.get(i).getstuNumber());
                    count += 1; //counts how many students had a number <= the given one
                } 
            }
        }
        if(inputNum == 2){ //this does the same for GPA
            System.out.println("Please enter the student's GPA by which you wish to filter the list");
            Scanner numScanner = new Scanner(System.in);
            double GPAInput = numScanner.nextDouble();
            for(int i = 0; i < studList.size(); i++){
                if(studList.get(i).getGPA() <= GPAInput){
                    System.out.print(studList.get(i).getfullName() + " ");
                    System.out.print(studList.get(i).getGPA() + " ");
                    System.out.println(studList.get(i).getstuNumber());
                    count +=1; //counts how many students had a GPA <= the given one
                } 
            }
        }
        if(count == 0){ //this is in the case of when no student fits the parameters given by the user 
            return "I'm sorry, but no such student exists";
        }
        return "The list has been filtered";
    }
} 