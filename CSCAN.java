import java.util.*;

// CSCAN Disk Scheduling algorithm
public class CSCAN {
    private int totalDistance =0;
    // Assume the longest distance is 15
    static int distance_max = 15;

    CSCAN(){}

    public void calculate(ArrayList<Station> arr, int head){
        int distance, track;

        Vector<Integer> left = new Vector<Integer>();
        Vector<Integer> right = new Vector<Integer>();
        Vector<Integer> seek_sequence = new Vector<Integer>();

        // add the end values for the left and right side before the bus reversing the direction
        left.add(0);
        right.add(distance_max-1);

        // find the distance that shorter than the current distance and add into left vector
        // find the distance that greater than the current distance and add into right vector
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getAddress() < head)
                left.add(arr.get(i).getAddress());
            if(arr.get(i).getAddress() > head)
                right.add(arr.get(i).getAddress());   
        }

        // sort left and right vectors
        Collections.sort(left);
        Collections.sort(right);

        // first serve the passengers on the right side of the head
        for(int i = 0; i < right.size(); i++){
            track = right.get(i);
            seek_sequence.add(track);
            distance = Math.abs(track-head);
            totalDistance += distance;
            head = track;
        }

        // set the head to 0 once reached the right end to jump to the left end
        head = 0;

        // add the bus travel distance form the end point to the start point
        totalDistance += (distance_max - 1);

        // serve the left passengers
        for(int i = 0; i < left.size(); i++){
            track = left.get(i);
            seek_sequence.add(track);
            distance = Math.abs(track-head);
            totalDistance += distance;
            head = track;
        }

        System.out.println("Total distance = " + totalDistance);
        System.out.println("The sequence of the track point is ");

        int k =1;
        for(int i = 0; i < seek_sequence.size(); i++){
            for(int j = 0; j < arr.size(); j++){
                if(seek_sequence.get(i) == arr.get(j).getAddress()){
                    System.out.printf("%d. Kolej %s with distance %d km\n",k,arr.get(j),arr.get(j).getAddress());
                    k++;
                }
            }
        }
    }
}
