import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
public class SCAN {
    final int size = 20;
    final int disk_size = 200;
     
    public void calculate(ArrayList<Station> arr, int head, String direction)
    {
        int totalDistance = 0;
        int distance, cur_track;
        Vector<Integer> left = new Vector<Integer>(),
                        right = new Vector<Integer>();
        Vector<Integer> seek_sequence = new Vector<Integer>();
        Vector<Integer> seek_distance = new Vector<Integer>();
        
        // Declaring ANSI_RESET so that we can reset the color
        final String ANSI_RESET = "\u001B[37m";
        // Declaring the background color
        final String ANSI_GREEN_BACKGROUND = "\u001B[32m";
        
        // appending end values
        // which has to be visited
        // before reversing the direction
        if (direction == "left")
            left.add(0);
        else if (direction == "right")
            right.add(disk_size - 1);
     
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i).getAddress() < head)
                left.add(arr.get(i).getAddress());
            if (arr.get(i).getAddress() > head)
                right.add(arr.get(i).getAddress());
        }
     
        // sorting left and right vectors
        Collections.sort(left);
        Collections.sort(right);
     
        // run the while loop two times.
        // one by one scanning right
        // and left of the head
        int run = 2;
        while (run-- > 0)
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
                    seek_distance.add(distance);
                    
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
                    seek_distance.add(distance);
     
                    // increase the total count
                    totalDistance += distance;
     
                    // accessed track is now new head
                    head = cur_track;
                }
                direction = "left";
            }
        }
        
        System.out.print("Total distance  = "
                            + ANSI_GREEN_BACKGROUND  + totalDistance + ANSI_RESET +"\n");
        
        System.out.print("**Assume that distance between address'number' is 1km**\n");

        System.out.print("The sequence of the track point is" + "\n");
        
        int count =1;
        for (int i = 0; i < seek_sequence.size(); i++)
        {
            for(int j = 0; j < arr.size(); j++){
                if(seek_sequence.get(i) == arr.get(j).getAddress()){
                    System.out.printf("%d. Kolej %s at address'%s %d %s'\n",count++,arr.get(j),ANSI_GREEN_BACKGROUND,seek_sequence.get(i),ANSI_RESET);
                }
            }
        }
    }  
}
