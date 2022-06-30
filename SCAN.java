import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
public class SCAN {
    final int size = 8;
    final int disk_size = 200;
     
    public void calculate(ArrayList<Station> arr, int head, String direction)
    {
        int totalDistance = 0;
        int distance, cur_track;
        Vector<Integer> left = new Vector<Integer>(),
                        right = new Vector<Integer>();
        Vector<Integer> seek_sequence = new Vector<Integer>();
     
        // appending end values
        // which has to be visited
        // before reversing the direction
        if (direction == "left")
            left.add(0);
        else if (direction == "right")
            right.add(disk_size - 1);
     
        for (int i = 0; i < size; i++)
        {
            if (arr.get(i).getDistance() < head)
                left.add(arr.get(i).getDistance());
            if (arr.get(i).getDistance() > head)
                right.add(arr.get(i).getDistance());
        }
     
        // sorting left and right vectors
        Collections.sort(left);
        Collections.sort(right);
     
        // run the while loop two times.
        // one by one scanning right
        // and left of the head
        int run = 2;
        while (run-- >0)
        {
            if (direction == "left")
            {
                for (int i = left.size() - 1; i >= 0; i--)
                {
                    cur_track = left.get(i);
     
                    // appending current track to seek sequence
                    seek_sequence.add(cur_track);
     
                    // calculate absolute distance
                    distance = Math.abs(cur_track - head);
     
                    // increase the total count
                    totalDistance += distance;
     
                    // accessed track is now the new head
                    head = cur_track;
                }
                direction = "right";
            }
            else if (direction == "right")
            {
                for (int i = 0; i < right.size(); i++)
                {
                    cur_track = right.get(i);
                     
                    // appending current track to seek sequence
                    seek_sequence.add(cur_track);
     
                    // calculate absolute distance
                    distance = Math.abs(cur_track - head);
     
                    // increase the total count
                    totalDistance += distance;
     
                    // accessed track is now new head
                    head = cur_track;
                }
                direction = "left";
            }
        }
     
        System.out.print("Total distance  = "
                            + totalDistance + "\n");
     
        System.out.print("The sequence of the track point is" + "\n");
     
        for (int i = 0; i < seek_sequence.size(); i++)
        {
            for(int j = 0; j < seek_sequence.size(); j++){
                if(seek_sequence.get(i) == arr.get(j).getDistance()){
                    System.out.printf("%d. Kolej %s with distance %d km\n",i+1,arr.get(j),arr.get(j).getDistance());
                }
            }
        }
    }  
}
