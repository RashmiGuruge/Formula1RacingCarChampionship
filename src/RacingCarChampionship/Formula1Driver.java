package RacingCarChampionship;

/*How many first position, second positions and third positions an instance of it has achieved in the season.
The number of points that a driver currently has.
The number of races participated so far in the season.*/

import java.util.Collections;

public class Formula1Driver extends Driver implements Comparable <Formula1Driver> {

    public Formula1Driver(String driverName, String driverLocation, String driverTeam, int numOfRaces, int numOfPoints,int firstPositions,
        int secondPositions, int thirdPositions) {
            this.driverName = driverName;
            this.driverLocation = driverLocation;
            this.driverTeam = driverTeam;
            this.firstPosition = firstPositions;
            this.secondPosition = secondPositions;
            this.thirdPosition = thirdPositions;
            this.numberOfPoints = numOfPoints;
            this.numberOfRaces = numOfRaces;
        }

    //https://www.youtube.com/watch?v=5gzayWys06o&t=257s
        static int a = -1;
    static int b = 1;
    static int e = 0;

    //begins with the least or smallest and ends with the greatest or largest
    public static void ascending() {
        a = 1;
        b = -1;
        Collections.sort(Formula1ChampionshipManager.championshipDriversList);
        GUI.table();
        a = -1;
        b = 1;
    }

    //begins with the greatest or largest and ends with the least or smallest
    public static void descending() {
        a = -1;
        b = 1;
        Collections.sort(Formula1ChampionshipManager.championshipDriversList);
        GUI.table();
    }

    public static void firstPositionDescending() {
        e = 1;
        Collections.sort(Formula1ChampionshipManager.championshipDriversList);
        GUI.table();
        e = 0;
    }


    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfRaces() {
        return this.numberOfRaces;
    }

    public int getNumberOfPoints() {
        return this.numberOfPoints;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void setFirstPosition(int positionOne) {
        this.firstPosition++;
    }

    public void setSecondPosition(int positionTwo) {
        this.secondPosition++;
    }

    public void setThirdPosition(int positionThree) {
        this.thirdPosition++;
    }

    public int getFirstPosition() {
        return this.firstPosition;
    }

    public int getSecondPosition() {
        return this.secondPosition;
    }

    public int getThirdPosition() {
        return this.thirdPosition;
    }

    public String getDate(String date) {
        return this.date;
    }


    //https://www.youtube.com/watch?v=5gzayWys06o&t=257s
    @Override
    public int compareTo(Formula1Driver o) {
        if (e == 0) {
            if (o.numberOfPoints == numberOfPoints) {
                if (!(firstPosition <= o.firstPosition)) {
                    return a;
                } else if (o.firstPosition > numberOfPoints) {
                    return b;
                } else {
                    return 0;
                }
            } else if (numberOfPoints > o.numberOfPoints) {
                return a;
            } else return b;
        } else {
            if (o.firstPosition == firstPosition) {
                return 0;
            }else if (!(firstPosition <= o.firstPosition)){
                return a;
            }else {
                return b;
            }
        }
    }

}


