//information about the driver name, location, team they belong to and various statistics about the drivers
package RacingCarChampionship;


/*The class cannot be used to create objects (To access an abstract class, it must be inherited from another class.)
    https://beginnersbook.com/2013/05/java-abstract-class-method/
*/

abstract class Driver {
    String driverName;
    String driverLocation;
    String driverTeam;
    int numberOfRaces = 0;
    int numberOfPoints = 0;
    int firstPosition;
    int secondPosition;
    int thirdPosition;
    String date;

    public void setDriverName(String driverName){
        this.driverName = driverName;
    }

    public void setDriverTeam(String driverTeam){
        this.driverTeam = driverTeam;
    }

    public void setDriverLocation(String driverLocation){
        this.driverLocation = driverLocation;
    }

    public String getDriverName(){
        return this.driverName;
    }

    public String getDriverLocation(){
        return this.driverLocation;
    }

    public String getDriverTeam(){
        return this.driverTeam;
    }


}
