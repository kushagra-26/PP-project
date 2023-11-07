import java.util.Scanner;

public class DatabaseApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        String username;
        
        String password;

        System.out.println("Enter your username: ");
        username = in.nextLine();

        System.out.println("Enter your password: ");
        password = in.nextLine();

        if (isValidLogin(username, password)) {
           
            System.out.println("Login successful!");
           
            runApp();
        } 
        else {
            System.out.println("Invalid login. Exiting...");
        }
    }

    private static boolean isValidLogin(String username, String password) {
       
        return username.equals("admin") && password.equals("password");
    }

    private static void runApp() {
       
        System.out.println("Enter the number of students to enroll: ");
        
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        
        Student[] students = new Student[numOfStudents];

        for (int n = 0; n < numOfStudents; n++) {
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
        }
        boolean showStudents = true;

        while (showStudents) {
           
            System.out.println("Options:");
            System.out.println("1. Show all students");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            
            int choice = in.nextInt();

            switch (choice) {
                
                case 1:
                    for (int n = 0; n < numOfStudents; n++) {
                        System.out.println(students[n].toString());
                    }
                    break;
               
                case 2:
                    showStudents = false;
                    System.out.println("Exiting the Student Database App.");
                    break;
                
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static class Student {
        String firstName;
        String lastName;
        int gradeYear;
        String studentID;
        String courses;
        int tuitionBalance;
        
        static int costOfCourse = 600;
        static int id = 1000;

        public Student() {
            Scanner in = new Scanner(System.in);

            System.out.println("Enter student first name: ");
            this.firstName = in.nextLine();

            System.out.println("Enter student last name: ");
            this.lastName = in.nextLine();

            System.out.println("1. First year ");
            System.out.println("2. Second year ");
            System.out.println("3. Third year ");
            System.out.println("4. Fourth year ");
           
            this.gradeYear = in.nextInt();
            
            setStudentID();
            System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
        }

        private void setStudentID() {
           
            id++;
            
        this.studentID = gradeYear + "" + id;
        }

        public void enroll() {
            System.out.println("Courses available are-");

            System.out.println("Maths - MA1 [$600]");
            System.out.println("Electronics - EC2 [$600]");
            System.out.println("Chemistry - CH3 [$600]");
            System.out.println("Physics - PH4 [$600]");
            System.out.println("English - EN5 [$600]");
            System.out.println("Programming - PP6 [$600]");
            System.out.println("Civil - CV7 [$600]");
            System.out.println("************PLEASE ENTER CODE GIVEN AFTER SUBJECT************");

            do {
                System.out.print("Enter courses to enroll (Q to quit): ");


                Scanner in = new Scanner(System.in);
                String course = in.nextLine();
                
                if (!course.equals("Q")) {
                    courses = courses + "\n" + course;
                    tuitionBalance = tuitionBalance + costOfCourse;
                } 
                else {
                    break;
                }
            } while (true);

            System.out.println("Enrolled in: " + courses);
        }

        public void viewBalance() {
            System.out.println("Your balance is $" + tuitionBalance);
        }

        public void payTuition() {
           
            viewBalance();
            System.out.print("Enter your payment: $");

            Scanner in = new Scanner(System.in);
            int payment = in.nextInt();
            
            tuitionBalance = tuitionBalance - payment;
           
            System.out.println("Thank you for your payment of $" + payment);
            viewBalance();
        }

        public String toString() {
          
            return "Name: " + firstName + " " + lastName +
                    "\nGrade level: " + gradeYear +
                    "\nStudent ID: " + studentID +
                    "\nCourses Enrolled:" + courses +
                    "\nBalance: $" + tuitionBalance;
        }
    }
}
