package RacingCarChampionship;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        String choice;

        // Create a Formula1ChampionshipManager object
        Formula1ChampionshipManager raceManager = new Formula1ChampionshipManager();        //https://www.w3schools.com/java/java_interface.asp (Interface)

        System.out.println("\n**********************************************************************************************");
        System.out.println("\n\t\t\t......Welcome To The Formula 1 Racing Car Championship Programme......\n");
        System.out.println("**********************************************************************************************");

        //Display the user options
        while (true){
            System.out.println("\n\t\t\tUser Options\n");
            System.out.println("\tOption 1  - Add new driver to the race");
            System.out.println("\tOption 2  - Delete driver and the team");
            System.out.println("\tOption 3  - Change the driver for an existing constructor team");
            System.out.println("\tOption 4  - Display the various statistics for a selected existing driver");
            System.out.println("\tOption 5  - View all drivers stats");
            System.out.println("\tOption 6  - Add completed race");
            System.out.println("\tOption 7  - Store program data into file");
            System.out.println("\tOption 8  - Resume the previous state of the program");
            System.out.println("\tOption 9  - Open GUI");
            System.out.println("\tOption 10 - Exit");

            System.out.print("\nPlease Enter your Option : ");  //Ask the user option

            Scanner userChoice = new Scanner(System.in); //creating a scanner object to read input
            choice = userChoice.nextLine();  //read the user option

            if (choice.equals("1")) {
                raceManager.newDriver();
            } else if (choice.equals("2")) {
                raceManager.deleteDriver();
            } else if (choice.equals("3")) {
                raceManager.changeDriver();
            } else if (choice.equals("4")) {
                raceManager.displayExistingDriver();
            } else if (choice.equals("5")) {
                raceManager.driverTable();
            } else if (choice.equals("6")) {
                raceManager.completedRace();
            } else if (choice.equals("7")) {
                try {
                    //calling method to save the detail
                    raceManager.storeProgramDataIntoFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice.equals("8")) {
                try {
                    //calling method to load the detail
                    raceManager.loadProgramData();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (choice.equals("9")) {
                GUI.table();
            } else if (choice.equals("10")) {
                System.out.println("\n\t.....You have exited the Program.....");
                System.exit(0);
            } else {
                System.out.println("\n\t....Not a Valid Option! Please Try Again....\n");
            }
        }
    }
}

