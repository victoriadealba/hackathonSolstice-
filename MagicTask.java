import java.util.Scanner;
import java.util.Random;
public class MagicTask {

    public static void breakTime(int nummm) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Break Time! Choose what you would like to see.");
        System.out.println("1. Motivational Quote\n2. Comp Sci Joke");

        int option = scnr.nextInt();

        if (option == 1) {
            if (nummm == 1) {
                System.out.println("It's not whether you get knocked down, it's whether you get up");
            } else if (nummm == 2) {
                System.out.println("Winners are not people who never fail but people who never quit.");
            } else if (nummm == 3) {
                System.out.println("It's on YOU to get YOU where YOU wanna be.");
            }
        }

        if (option == 2) {
            if (nummm == 1) {
                System.out.println("I don’t like computer science jokes....Not one bit.");
            }
            if (nummm == 2) {
                System.out.println("What do you call a creepy computer science teacher? A PDF file.");
            }
        }
        System.out.println("Have a nice break!");
    }

    public static void Menu(){
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Generate a task");
        System.out.println("2. Enter a new task");
        System.out.println("3. See your tasks");
        System.out.println("4. Exit");
    }

    public static void GenerateNewTask(int numTask, String[] tasks){
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        Boolean run = true;

        if (run == true) {
            System.out.println("Here is your task!");
        }

        while(run == true) {
            int n = rand.nextInt(numTask);

            if (tasks[n] != "completed") {
                System.out.println(tasks[n]);
                tasks[n] = "completed";
                run = false;
            }
        }  }

    public static String[] EnterNewTask(int numTask, String[] tasks){
        Scanner scnr = new Scanner(System.in);

        String[] hold = new String[numTask];

        for (int i = 0; i < hold.length - 1; i++) {
            hold[i] = tasks[i];
        }

        System.out.println("What's your new task?");
        String newTask = scnr.next();

        hold[hold.length - 1] = newTask;

        return hold;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! How many tasks do you have today?");

        int numTask = scanner.nextInt();
        int count = 0;

        String[] tasks = new String[numTask];

        System.out.println("Please type in your tasks.");

        for (int i = 0; i < numTask ; i++) {
            int hold = i + 1;
            System.out.println(hold + ".");
            String temp = scanner.next();
            tasks[i] = temp;
        }

        System.out.println("Here are your tasks.");

        for (int i = 0; i < numTask ; i++) {
            System.out.println(tasks[i]);
        }

        boolean run2 = true;
        int nummm = 0;
        while (run2 == true) {
            Menu();

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    count = count + 1;
                    if(count % 3 == 0) {
                        nummm++;
                        if (nummm ==4){
                            nummm = 0;
                        }
                        breakTime(nummm); }
                    if (count >= numTask){
                        System.out.println("Congrats! You are done for the day.");
                        break;
                    }
                    else{
                        GenerateNewTask(numTask, tasks);
                    }
                    break;
                case 2:
                    numTask = numTask + 1;
                    tasks = EnterNewTask(numTask, tasks);
                    break;
                case 3:
                    for (int i = 0; i < numTask ; i++) {
                        System.out.println(tasks[i]); }
                    break;
                case 4:
                    run2 = false;
                    break;

            }
        }

    }
}


