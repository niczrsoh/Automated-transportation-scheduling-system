import java.io.IOException;
import java.util.*;
/*
Automated transport scheduling system
1. Soh Zen Ren A20EC0152
2. Wong Hui Shi A20EC0169
3. Teoh Wei Jian A20EC0229
 */
//Home Page!!
public class Home {
    public static void main(String[] args){
        displaySystem();
        Scanner sc =new Scanner(System.in);
        ArrayList<Station> list= new ArrayList<Station>();
        //current position at the main gate UTM while the driver is stay at Taman Universiti
        int head = 5;
        int choice;
        String[] purposes={"To show the concept of the disk scheduling algorithms and how they are being applied in the real world application.",
        "To compare disk scheduling algorithms that apply the real world application "};
        System.out.println("\033[0;1m" +"System's purposes: ");
        for (int i=0; i<purposes.length; i++)System.out.println(i+1+". "+purposes[i]);
        waitsrc();
        clsr();
        String[] kolejArray={ "KTDI", "KTR", "KTF", "KTC", "KP", "K9K10",
            "KTHO", "KDOJ", "KDSE", "KRP"};
        List<String> kolejList = new ArrayList<String>(Arrays.asList(kolejArray));
        //display list of available colleges in UTM
        System.out.println("---List of colleges in UTM---");
        for (int i=0; i<kolejArray.length; i++)System.out.println(i+1+". "+kolejArray[i]);
        //entering the number colleges that wish to be added
        System.out.print("Number of colleges added: ");
        int num = sc.nextInt();
        //input the college name into the array list
        for(int i=0;i<num;i++){
            String kolej;
            while(true){
            System.out.print("College: ");
            kolej =sc.next().toUpperCase();
            try{
            if(!kolejList.contains(kolej))
                throw new Exception("Does not have this College name! \nKindly enter again!");
                break;}
            catch(Exception e){
                System.out.println(e.getMessage());
            }}
            //add the kolej to the list
            list.add(Station.valueOf(kolej));
        } 
        waitsrc();
        clsr();
       
        String[] choices = {"1. Bus","2. Taxi","3. Exit"};
    while(true) {
        System.out.println("---Please enter the number of transport you want---");
        for(String display: choices) System.out.println(display);
        System.out.print("Enter your choice: ");
        choice=sc.nextInt();
        clsr();
        System.out.println("---Please enter the number of algorithm that you want to calculate---");
        //Making menu and selection 
        switch(choice) {
            case 1:
                String[] busChoices = {"1. SSTF","2. CSCAN"};
                for(String display: busChoices) System.out.println(display);
                System.out.print("Enter your choice: ");
                int bus= sc.nextInt();
                clsr();
                CSCAN cscan = new CSCAN();
                SSTF sstf = new SSTF();
                if(bus==1) sstf.calculate(list, head);
                if(bus==2) cscan.calculate(list, head);
                waitsrc();
                clsr();
                break;
            case 2:
                String[] taxiChoices = {"1. FCFS","2. SCAN"};
                for(String display: taxiChoices) System.out.println(display);
                System.out.print("Enter your choice: ");
                int taxi= sc.nextInt();
                clsr();
                FCFS fcfs = new FCFS();
                SCAN scan = new SCAN();
                if(taxi==1) fcfs.calculate(list, head);
                else if(taxi==2){
                    String direction = "left";
                    scan.calculate(list,head,direction);
                } 
                waitsrc();
                clsr();
                break;
            case 3:
                System.exit(0);
        }
    }
 
    }
    public static void clsr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
              new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
              Runtime.getRuntime().exec("clear");
          } catch (IOException | InterruptedException ex) {
          }
    }
    public static void waitsrc() {
        // System wait in java
        System.out.println("Press Enter key to continue...");
            try
            {
                System.in.read();
                System.in.read();
            }  
            catch(Exception e)
            {} 
      }
      public static void displaySystem() {
        System.out.println("=========================================================");
        System.out.println("\tAUTOMATED TRANSPORTATION SCHEDULING SYSTEM");
        System.out.println("=========================================================");
      }
}
