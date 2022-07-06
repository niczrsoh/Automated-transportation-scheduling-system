import java.util.ArrayList;

// FCFS Disk Scheduling algorithm
public class FCFS{
    private int totalDistance =0;
FCFS(){}
public void calculate(ArrayList<Station> arr, int head){
    int distance, track;
    for (int i = 0; i < arr.size(); i++)
    {
        track = arr.get(i).getDistance();
        distance = Math.abs(track-head);
        totalDistance += distance;
        head = track;
    }
    System.out.println("Total distance: "+ totalDistance);
    System.out.print("**Assume that distance between address'number' is 1km**\n");
    System.out.println("The sequence of the track point is");
    for (int i = 0; i < arr.size(); i++)System.out.printf("%d. Kolej %s at address'%d'\n",i+1,arr.get(i),arr.get(i).getDistance());
}
}
 