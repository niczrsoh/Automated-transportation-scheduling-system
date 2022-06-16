# Automated-transportation-scheduling-system

Group Members
1. Soh Zen Ren A20EC0152
2. Wong Hui Shi A20EC0169
3. Teoh Wei Jian A20EC0229


In this project, our group is going to propose an Automated Transportation Scheduling System. We will be using Java language for our program. This system will implement disk scheduling algorithms. The algorithms are First Come First Serve(FCFS), Circular SCAN(CSCAN), Shortest Seek Time First(SSTF), SCAN. In the real world, the most important to ensure the success of a transportation system is the passengers’ satisfaction. The aim for the system is to overcome the congestion problems on the road and help the user to choose the most suitable public transport. Furthermore, the targeted users are passengers. In this system, there are two types of vehicles which are taxi and bus.
For the taxi, there are two algorithms used which are the First Come First Serve (FCFS) and SCAN algorithm. For the FCFS, it will be applied for the passengers who need a transportation from one place to another place directly without any other stops in between. Booking will be prioritised based on their booking time. The passengers who have an earlier booking will be served first. For example, the first passenger will be the first to have the service provided. On the other hand, the last passenger will be the last to have the service. 
For the SCAN algorithm, it applied for the passengers who were willing to share a car with other passengers to increase the efficiency of taxi to serve passengers. The first passenger will be sent to the destination. If there are any booking requests in between, the taxi will accept the request, make a stop and fetch the passengers. 
For the bus, there are also two algorithms used which are the Shortest Seek Time First (SSTF) and Circular SCAN(CSCAN) algorithm. For the SSTF, it will be applied for the passengers who need transportation from one place to another and can accept there are several stops in the journey. Booking will be served based on the departure address or arrival address of the passengers. For example, the passengers who have the shortest distance with the current position of the bus will be served first. They can book the bus and the bus will have a system to detect and calculate the shortest distance based on the passengers’ list. The list will be updated immediately once there are new bookings and will be sorted based on the shortest distance.
For the CSCAN algorithm, it also applied for the passengers who need transportation from one place to another and can accept there are several stops in the journey. The bus will send the passengers from a fixed starting stop to the other ends. In between, the bus will accept any booking request on one side. Therefore the bus can serve all the requests more uniformly.
