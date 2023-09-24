//Import statements
import java.util.ArrayList;
import java.util.Random;

public class Scheduler {
    
    //Store processes 
    private ArrayList<Process> processes; 
    //Random number generator 
    private Random rng; 
    //ProcessID Generator/Manager 
    private ProcessIDManager processIDManager;

    //Default constructer that creates a basic scheduler object
    public Scheduler() {
        processes = new ArrayList<Process>();
        rng = new Random(); 
        processIDManager = new ProcessIDManager(); 
        //Debugging
        createRandomProcesses();
        terminateRamdonProcesses(); 
        //create processes for 10 minutes 
        //terminate the processes for 10 minutes 
    }

    //Method that creates at between 5 and 10 processes with unique process IDs
    //Each process creates random number of threads between 3 and 40
    public void createRandomProcesses() { 
        //Generate a random number of processes to be created between 5 and 10
        int numberProcesses = rng.nextInt(6) + 5;
        //Create the specified number of processes
        for(int i = 0; i < numberProcesses; i++) {
            //Generate a random number of threads to be created between 3 and 40
            int randomNumberThreads = rng.nextInt(38) + 3; 
            //Generate a processID for the process
            int processID = processIDManager.generateProcessID();
            //Create and add the process to the scheduler 
            Process process = new Process(randomNumberThreads, processID); 
            processes.add(process); 
            System.out.println("A Process was Successfully Created with " + process.getNumberThread() + " Threads");
            System.out.println("The Process ID is: " + process.getProcessID());
        }
    } 

    //Method that randomly terminates a process 
    public void terminateRamdonProcesses() { 
        //Select a random process to terminate
        int terminateProcess = rng.nextInt(processes.size()); 
        //Notify the processIDManager of the terminate process so that the processID can be reused
        processIDManager.deleteProcessID(processes.get(terminateProcess).getProcessID()); 
        //Remove the process from the scheduler
        processes.remove(terminateProcess);
    }

}
