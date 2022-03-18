//Formula1ChampionshipManager class maintains a number of drivers and cars

package RacingCarChampionship;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {

    //Create an ArrayList object
    public static ArrayList<Formula1Driver> championshipDriversList = new ArrayList<>();  //All driver details


    //This method is used to add new driver into the championship program.
    @Override
    public void newDriver() {
        System.out.println("\n\t\t....Add New Driver to the Race....\n");

        // creating empty strings
        String driverName = "";
        String driverTeam = "";
        String driverLocation = "";

        //calling the constructor and creating the new driver object
        Formula1Driver newDrivers = new Formula1Driver(driverName, driverTeam, driverLocation, 0, 0, 0,0,0);

        Scanner userInput = new Scanner(System.in); //System.in is a standard input stream

        System.out.print("Enter Driver Name : ");  //Ask the driver name
        driverName = userInput.nextLine();         // Read user input
        newDrivers.setDriverName(driverName);

        System.out.print("Enter Driver Team : ");  //Ask the driver team
        driverTeam = userInput.nextLine();         // Read user input
        while (true) {
            if (checkTeamName(driverTeam)) {
                System.out.println("This team is already added to the race! Please enter the different team name.");
                System.out.print("Enter Driver Team : "); //Ask the driver team
                driverTeam = userInput.nextLine();        // Read user input
            } else {
                break;
            }
        }
        newDrivers.setDriverTeam(driverTeam);

        System.out.print("Enter Driver Location : "); //Ask the driver location
        driverLocation = userInput.nextLine();        // Read user input
        newDrivers.setDriverLocation(driverLocation);

        System.out.println("'" + driverName + "'" + " driver successfully added to the " + "'" + driverTeam + "'" + " team.");

        //add the created new driver object to the arraylist (driver detail arraylist)
        championshipDriversList.add(newDrivers);

        System.out.println("---------------------------------------------------------------------------");
    }

    //This method is used to check the driver team name already added or not
    public static boolean checkTeamName(String driverTeamName) {
        for (int count = 0; count < championshipDriversList.size(); count++) {
            if (championshipDriversList.get(count).getDriverTeam().equals(driverTeamName)) { //check the team name
                return true; //return true, because driver team name already added arraylist
            }
        }
        return false; //return false, because driver team name is not in the arraylist
    }


    //This method is used to delete the driver
    @Override
    public void deleteDriver() {
        System.out.println("\n\t\t....Delete a Driver and the Team....");

        Scanner userInput = new Scanner(System.in); //System.in is a standard input stream

        boolean found = false;  //creating boolean variable
        String userInputName;   //creating string variable

        System.out.print("\nEnter the driver name you want to delete :");  //Ask the driver name
        userInputName = userInput.nextLine();                              // Read user input

        //if the arraylist is empty display no drivers in the championship
        if (championshipDriversList.isEmpty()) {
            System.out.println("\n\tNo drivers in the racing car championship!");
        } else {
            for (int count = 0; count < championshipDriversList.size(); count++) {
                if (championshipDriversList.get(count).getDriverName().equals(userInputName)) { //check the driver name
                    found = true;
                    championshipDriversList.remove(count); //remove the driver
                    System.out.println("\n\tDriver " + userInputName + " successfully deleted.");
                    break;
                }
            }
            //if the driver name is not found display this driver not in the championship
            if (!found) {
                System.out.println("\n\t" + "'" + userInputName + "'" + " this driver is not in the racing car championship!!");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }


    //This method is used to change the driver
    @Override
    public void changeDriver() {
        System.out.println("\n\t\t....Change the driver for an existing constructor team....");

        //creating string variable
        String userInputTeam;
        String userInputName;

        Scanner userInput = new Scanner(System.in); //System.in is a standard input stream

        boolean found = false;  //creating boolean variable

        System.out.print("\nEnter the team name you want to change the driver :"); //Ask the team name
        userInputTeam = userInput.nextLine();                                      // Read user input

        //if the arraylist is empty display Can't find the team.
        if (championshipDriversList.isEmpty()) {
            System.out.println("\n\tCan't find the team " + userInputTeam + "!");
        } else {
            System.out.print("Enter the driver name you want to add " + "'" + userInputTeam + "'" + " team :"); //Ask the driver name
            userInputName = userInput.nextLine();     // Read user input

            for (int count = 0; count < championshipDriversList.size(); count++) {
                if (championshipDriversList.get(count).getDriverTeam().equals(userInputTeam)) { //check the driver team name
                    found = true;
                    championshipDriversList.get(count).setDriverName(userInputName); //change the driver name
                    System.out.println("Team " + userInputTeam + "'s driver successfully changed to the " + userInputName);
                }
            }
            //if the driver team name is not found display Can't find the team
            if (!found) {
                System.out.println("\n\tCan't find the teammmmmm!");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }


    //This method is used to display the various statistics for a selected existing driver.
    @Override
    public void displayExistingDriver() {
        System.out.println("\n\t\t...Display statistics for a selected existing driver...");

        String userInputName;  //creating string variable

        Scanner userInput = new Scanner(System.in); //System.in is a standard input stream

        boolean found = false;  //creating boolean variable

        System.out.print("\nEnter the driver name to see the detail :"); //Ask the driver name
        userInputName = userInput.nextLine();                            // Read user input

        //if the arraylist is empty display no drivers in the championship
        if (championshipDriversList.isEmpty()) {
            System.out.println("\n\tNo drivers in the racing car championship!");
        } else {
            for (int count = 0; count < championshipDriversList.size(); count++) {
                if (championshipDriversList.get(count).getDriverName().equals(userInputName)) { //check the driver name
                    found = true;
                    System.out.println("Driver Name         : " + championshipDriversList.get(count).getDriverName());
                    System.out.println("Driver Team         : " + championshipDriversList.get(count).getDriverTeam());
                    System.out.println("Driver Location     : " + championshipDriversList.get(count).getDriverLocation());
                    System.out.println("Number of Races     : " + championshipDriversList.get(count).getNumberOfRaces());
                    System.out.println("Total points        : " + championshipDriversList.get(count).getNumberOfPoints());
                    System.out.println("First positions     : " + championshipDriversList.get(count).getFirstPosition());
                    System.out.println("Second positions    : " + championshipDriversList.get(count).getSecondPosition());
                    System.out.println("Third positions     : " + championshipDriversList.get(count).getThirdPosition());
                }
            }
            //if the driver name is not found display this driver not in the championship
            if (!found) {
                System.out.println("\n\t" + userInputName + " driver is not in the racing car championship.");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }


    //This method is used to display the Formula 1 Driver Table (all drivers)
    @Override
    public void driverTable() {

        //if the arraylist is empty display no drivers in the championship
        if (championshipDriversList.isEmpty()) {
            System.out.println("\n\tNo drivers in the racing car championship!");
            System.out.println("---------------------------------------------------------------------------");
        } else {
            //Sorting the points
            championshipDriversList.sort(Comparator.comparing(formula1Driver -> formula1Driver.getNumberOfPoints())); //https://dzone.com/articles/sorting-java-arraylist

            System.out.println("\n\t\t\t\t\t\t\t\t...All Drivers Details...\n");

            System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println(" Driver_Name          Team           Location       Race_Count      Points      First      Second      Third");
            System.out.println("--------------------------------------------------------------------------------------------------------------");
            for (int count = championshipDriversList.size() - 1; count >= 0; count--) {
                System.out.format("%8s %16s %18s %12d %13d %11d %11d %11d",
                        championshipDriversList.get(count).getDriverName(),
                        championshipDriversList.get(count).getDriverTeam(),
                        championshipDriversList.get(count).getDriverLocation(),
                        championshipDriversList.get(count).getNumberOfRaces(),
                        championshipDriversList.get(count).getNumberOfPoints(),
                        championshipDriversList.get(count).getFirstPosition(),
                        championshipDriversList.get(count).getSecondPosition(),
                        championshipDriversList.get(count).getThirdPosition());
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------------------------");
            }
        }
    }


    //This method is used to add race
    @Override
    public void completedRace() {
        System.out.println("\n\t\t....Add Completed Race Details....\n");

        //creating variables
        String userInputName;
        int driverPosition = 0;
        int win = 0;

        boolean found = false;  //creating boolean variable

        Scanner userInput = new Scanner(System.in);  //System.in is a standard input stream

        //get the race held date
        System.out.print("Enter Race Completed Date(dd/mm/yyyy) : ");  //Ask the race held date
        String userInputDate = userInput.nextLine();                   // Read user input

        //all drivers name
        System.out.println("\t Drivers Names who Participated in this Race");
        if (!championshipDriversList.isEmpty()) {
            for (int count = 0; count < championshipDriversList.size(); count++) {
                //display the all drivers who participated in the race
                System.out.print("| " + championshipDriversList.get(count).getDriverName() + " |    ");
            }
        } else {
            System.out.println("No Drivers!!");
        }

        System.out.print("\n\nEnter the Driver Name to add position :");  //Ask the driver name
        userInputName = userInput.next();                                 // Read user input

        for (int count = 0; count < championshipDriversList.size(); count++) {
            if (userInputName.equals(championshipDriversList.get(count).getDriverName())) {
                driverPosition = count;
                found = true;
                System.out.print("Enter the position driver won in race (1-10) :"); //Ask the driver position
                win = userInput.nextInt();                                          // Read user input

                //count the number of races (each driver)
                //the number of races participated so far in the season
                int race = championshipDriversList.get(count).getNumberOfRaces();
                int raceCount = race + 1;
                championshipDriversList.get(count).setNumberOfRaces(raceCount);
            }
        }
        if (!found) {
            System.out.println("Can't find the driver name!!");
        }

        //Calculate and update the positions and points
        if (win == 1) {
            int one = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsOne = one + 25;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsOne);

            //calculate and update the first positions
            int firstPlace = championshipDriversList.get(driverPosition).getFirstPosition();
            int positionOne = firstPlace + 1;
            championshipDriversList.get(driverPosition).setFirstPosition(positionOne);
        } else if (win == 2) {
            int two = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsTwo = two + 18;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsTwo);

            //calculate and update the second positions
            int secondPlace = championshipDriversList.get(driverPosition).getSecondPosition();
            int positionTwo = secondPlace + 1;
            championshipDriversList.get(driverPosition).setSecondPosition(positionTwo);
        } else if (win == 3) {
            int three = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsThree = three + 15;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsThree);

            //calculate and update the third positions
            int thirdPlace = championshipDriversList.get(driverPosition).getThirdPosition();
            int positionThree = thirdPlace + 1;
            championshipDriversList.get(driverPosition).setThirdPosition(positionThree);
        } else if (win == 4) {
            int four = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsFour = four + 12;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsFour);
        } else if (win == 5) {
            int five = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsFive = five + 10;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsFive);
        } else if (win == 6) {
            int six = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsSix = six + 8;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsSix);
        } else if (win == 7) {
            int seven = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsSeven = seven + 6;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsSeven);
        } else if (win == 8) {
            int eight = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsEight = eight + 4;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsEight);
        } else if (win == 9) {
            int nine = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsNine = nine + 2;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsNine);
        } else if (win == 10) {
            int ten = championshipDriversList.get(driverPosition).getNumberOfPoints();
            int pointsTen = ten + 1;
            championshipDriversList.get(driverPosition).setNumberOfPoints(pointsTen);
        }
        System.out.println("\n---------------------------------------------------------------------------");
    }


    /*This method is used to save all the information into a file
        http://www.beginwithjava.com/java/file-input-output/writing-text-file.html
        https://www.homeandlearn.co.uk/java/write_to_textfile.html
        https://www.codegrepper.com/code-examples/java/java+write+to+file
    */
    @Override
    public void storeProgramDataIntoFile() throws Exception{
        System.out.println("\n\t...Store Race Data Into File...");

        // Open the file.
        //creating a new FileWriter object with the name file
        FileWriter file = new FileWriter("ChampionshipData.txt",false);
        PrintWriter files = new PrintWriter(file);

        for (int count = 0; count < championshipDriversList.size(); count++) {
            //getting all the details and each element is separated by using "|"
            String line = championshipDriversList.get(count).getDriverName() +"|"+
                    championshipDriversList.get(count).getDriverTeam()+"|"+
                    championshipDriversList.get(count).getDriverLocation()+"|"+
                    championshipDriversList.get(count).getNumberOfPoints()+"|"+
                    championshipDriversList.get(count).getNumberOfRaces()+"|"+
                    championshipDriversList.get(count).getFirstPosition()+"|"+
                    championshipDriversList.get(count).getSecondPosition()+"|"+
                    championshipDriversList.get(count).getThirdPosition();
            files.println(line); //printing the string to the file (as new line)
        }
        // Close the file.
        files.close();

        System.out.println("Data have been saved successfully.");
        System.out.println("---------------------------------------------------------------------------");
    }


    /*This method is used to Resume or recover the previous state of the program
        https://docs.oracle.com/javase/tutorial/essential/io/file.html
        https://www.baeldung.com/java-file-to-arraylist
     */
    @Override
    public void loadProgramData()throws FileNotFoundException{

        System.out.println("\n\t...Resume/recover the previous state of the program...");

        boolean found = false; //creating boolean variable

        if (found == false){
            File file = new File("ChampionshipData.txt"); //create file object
            Scanner readFile = new Scanner(file);

            while (readFile.hasNextLine()) {
                //reading the file line by line
                String lines = readFile.nextLine();
                //splitting the line by "|" & extracting elements
                String[] elements = lines.split("\\|");

                //creating a driver object from the extracted data
                Formula1Driver driver = new Formula1Driver(elements[0],elements[2],elements[1],
                        Integer.parseInt(elements[4]),Integer.parseInt(elements[3]),Integer.parseInt(elements[5]),
                        Integer.parseInt(elements[6]),Integer.parseInt(elements[7]));

                //adding the created object into the arraylist
                championshipDriversList.add(driver);
            }
            found = true;
            System.out.println("Successfully read the file.");
        } else {
            System.out.println("You have already restored the information!");
        }
        System.out.println("---------------------------------------------------------------------------");
    }
}
