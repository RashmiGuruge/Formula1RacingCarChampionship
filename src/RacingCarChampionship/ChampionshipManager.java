package RacingCarChampionship;

import java.io.FileNotFoundException;

public interface ChampionshipManager {          //https://www.w3schools.com/java/java_interface.asp

    // interface method (does not have a body)
    void newDriver();
    void deleteDriver();
    void changeDriver();
    void displayExistingDriver();
    void driverTable();
    void completedRace();
    void storeProgramDataIntoFile() throws Exception;
    void loadProgramData()throws FileNotFoundException;
}
