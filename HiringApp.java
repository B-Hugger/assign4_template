//Assign 4, HiringApp
package assign4_template;

import java.util.*;

public class HiringApp {

    public static void main(String[] args) {

        //Define the data structures for 3 different groups of people:

        //  current employees (those who were hired),
        Deque<Person> currentEmployees = new ArrayDeque<>();
        //  past employees (those who were fired)
        Deque<Person> pastEmployees = new ArrayDeque<>();
        //  new applicants
        Queue<Person> applicants = new ArrayDeque<>();
        //
        //Hint: for queue: Queue<Person>,  ArrayDeque, LinkedList
        //      for stack: Deque<Person>   ArrayDeque, LinkedList
        while(true) {
            //display the menu
            int input = getChoice(); //get the menu choice
            //process user selected service request.
            if(input == 1) {
            applicants.offer(getApplication());
            }
            else if(input == 2) {
                hire(currentEmployees,pastEmployees,applicants);
            }
            else if(input == 3) {
                fire(currentEmployees,pastEmployees,applicants);
            }

            else {
                System.out.println("Thank you for using the manager portal. Have a good day.");
                break;
            }
            //loop until the user decides to quit.
        }
    }

    //other methods for code modularization
    //method for getting user choice
    public static int getChoice() {

        //display the menu
        System.out.print("""
                -------------Welcome to the Manager Portal-----------------
                                Accept Applicant (1)
                                Hire (2)
                                Fire (3)
                                Quit (4)
                -----------------------------------------------------------
                """);
        //get user choice
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        //return user choice as an integer

        return input;
    }

    //method for accepting an applicant and reurn this applicant as a Person object
    public static Person getApplication() {
        Scanner in = new Scanner(System.in);
        //display prompt for user to enter an applicant's name
        //get user input
        System.out.println("Please enter applicant's name");
        String nameInput = in.nextLine();
        //display prompt for user to enter an applicant's degree
        //get user input
        System.out.println("please enter applicant's degree");
        String degreeInput = in.nextLine();
        //display prompt for user to enter an applicant's skill list
        //  (first how many skills, then enter skill one by one)
        //use a loop to get each skill
        System.out.println("please enter number of skills applicant has");
        int Num = in.nextInt();
        List skills = new ArrayList<>();
        for (int i = 1; i <= Num; ++i) {
            System.out.println("Please enter skill #" + i);
            String skill = in.next();
            skills.add(skill);
        }
        //create a Person object using the name, degree, skill list
        //and return this Person object
        return new Person(nameInput, degreeInput, skills);
    }

    //You can either implement hire and fire functionalities in main(...),
    //   or implement them here as separate methods:
    //hire method
    public static void hire(Deque current, Deque past, Queue applicant) {
        if (past.isEmpty()) {
            try {
                current.push(applicant.poll());
                System.out.println("Hired: " + current.peek());
            } catch (Exception E) {
                System.out.println("Error no applicants available to Hire");
            }
        } else {
            System.out.println("Hired: " + past.peek());
            current.push(past.pop());
        }
    }

    //fire method
    public static void fire(Deque current, Deque past, Queue applicant) {

        if(current.isEmpty()) {
            System.out.println("there are no current employees");
        }
        else {
            System.out.println("Fired: " + current.peek());
            past.push(current.pop());
        }
    }
}
