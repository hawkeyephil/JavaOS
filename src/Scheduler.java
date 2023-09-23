import java.util.ArrayList;
import java.util.Random;

public class Scheduler {
    
    //store processes 
    private ArrayList<Process> processes; 
    //random number generator 
    private Random rng;

    public Scheduler() {
        processes = new ArrayList<Process>();
        rng = new Random(); 
        createProcesses(5);
        //create processes for 10 minutes 
        //terminate the processes for 10 minutes 
    }

    //Method that creates a specified number of processes 
    //Each process creates random number of threads between 3 and 40
    public void createProcesses(int numberProcesses) {
        for(int i = 0; i < numberProcesses; i++) {
            int randomNumberThreads = rng.nextInt(38) + 3;
            Process process = new Process(randomNumberThreads); 
            processes.add(process); 
            System.out.println("A Process was Successfully Created with " + process.getNumberThread() + " Threads.");
        }
    } 

    //Method that randomly terminates a process 
    public void terminateProcesses() {
        processes.remove(0);
    }

}
