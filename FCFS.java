import java.util.ArrayList;

// FCFS Disk Scheduling algorithm
public class FCFS{
    private int totalDistance =0;
FCFS(){}
public void calculate(ArrayList<Station> arr, int head){
    int distance, track;

    // Declaring ANSI_RESET so that we can reset the color
    final String ANSI_RESET = "\u001B[37m";
    // Declaring the background color
    final String ANSI_GREEN_BACKGROUND = "\u001B[32m";

    for (int i = 0; i < arr.size(); i++)
    {
        track = arr.get(i).getAddress();
        distance = Math.abs(track-head);
        totalDistance += distance;
        head = track;
    }
    System.out.println("---Public Transportation TAXI using FCFS Alogorithm---");
    System.out.println("**Assume that distance between address'number' is 1km**\n");
    System.out.println("Total distance: "+ ANSI_GREEN_BACKGROUND + totalDistance+  ANSI_RESET);
    System.out.println("\nThe sequence of the track point is");
    for (int i = 0; i < arr.size(); i++)System.out.printf("%d. Kolej %s at address'%s%d%s'\n",i+1,arr.get(i),ANSI_GREEN_BACKGROUND,arr.get(i).getAddress(),ANSI_RESET);
}
}
 