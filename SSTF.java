import java.util.ArrayList;
public class SSTF {
    // Calculates difference of each
    // track number with the head position
    // Calculates difference of each
    // track number with the head position
    public void calculateDifference(ArrayList<Station> queue,
                                        int head, node diff[])
                                         
    {
        for (int i = 0; i < diff.length; i++)
            diff[i].distance = Math.abs(queue.get(i).getAddress() - head);
    }
 
    // find unaccessed track
    // which is at minimum distance from head
    public int findMin(node diff[])
    {
        int index = -1, minimum = Integer.MAX_VALUE;
 
        for (int i = 0; i < diff.length; i++) {
            if (!diff[i].accessed && minimum > diff[i].distance) {
                 
                minimum = diff[i].distance;
                index = i;
            }
        }
        return index;
    }
 
    public void calculate(ArrayList<Station> request,int head)
                                                      
    {
        if (request.size() == 0)
            return;
             
        // create array of objects of class node   
        node diff[] = new node[request.size()];
         
        // initialize array
        for (int i = 0; i < diff.length; i++)
         
            diff[i] = new node();
         
        // count total number of seek operation   
        int totalDistance = 0;
         
        // stores sequence in which disk access is done
        int[] seek_sequence = new int[request.size() + 1];
         
        for (int i = 0; i < request.size(); i++) {
             
            seek_sequence[i] = head;
            calculateDifference(request, head, diff);
             
            int index = findMin(diff);
             
            diff[index].accessed = true;
             
            // increase the total count
            totalDistance += diff[index].distance;
             
            // accessed track is now new head
            head = request.get(index).getAddress();
        }
         
        // for last accessed track
        seek_sequence[seek_sequence.length - 1] = head;
         
        System.out.println("Total number of seek operations = "
                                                     + totalDistance);
                                                      
        System.out.println("Seek Sequence is");
        
        Station[] seek = Station.values();
        // print the sequence
        for (int i = 0; i < seek_sequence.length; i++){
            for(int j = 0; j < seek.length; j++){
                if(seek_sequence[i] == seek[j].getAddress()){
                    System.out.printf("%d. Kolej %s with distance %d km\n",i+1,seek[j],seek[j].getAddress());
                    break;
                }
            }
        }
            
    }
}

class node {
     
    // represent difference between
    // head position and track number
    int distance = 0;
     
    // true if track has been accessed
    boolean accessed = false;
}