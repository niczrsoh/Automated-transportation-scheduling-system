import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
Automated transport scheduling system
1. Soh Zen Ren A20EC0152
2. Wong Hui Shi A20EC0169
3. Teoh Wei Jian A20EC0229
 */
//Home Page!!
public class Home {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        ArrayList<Station> list= new ArrayList<Station>();
        //current position at the main gate UTM while the driver is stay at Taman Universiti
        int head = 5;
        int choice;
        String[] kolejList={ "KTDI", "KTR", "KTF", "KTC", "KP", "K9K10",
            "KTHO", "KDOJ", "KDSE", "KRP"};
        for(int i=0;i<kolejList.length;i++){
            list.add(Station.valueOf(kolejList[i]));
        }
        String[] choices = {"1. Bus","2. Taxi","3. Exit"};
    while(true) {
        for(String display: choices) System.out.println(display);
        System.out.print("Enter your choice: ");
        choice=sc.nextInt();
        clsr();
      
        //Making menu and selection 
        switch(choice) {
            case 1:
                
                break;
            case 2:
                String[] taxiChoices = {"1. FCFS","2. SCAN"};
                for(String display: taxiChoices) System.out.println(display);
                System.out.print("Enter your choice: ");
                int taxi= sc.nextInt();
                clsr();
                FCFS fcfs = new FCFS();
                if(taxi==1) fcfs.calculate(list, head);
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
}
