//Import statements
import java.util.ArrayList;
import java.util.Random;

//Manages creation, termination, and scheduling of processes
public class Scheduler {
    
    //Store processes 
    private ArrayList<Process> processes; 
    //Random number generator 
    private Random rng; 
    //ProcessID Generator/Manager 
    private ProcessIDManager processIDManager;  
    //CPU object 
    private CPU cpu;

    //Default constructer that creates a basic scheduler object
    public Scheduler() { 
        processes = new ArrayList<Process>();
        rng = new Random(); 
        processIDManager = new ProcessIDManager(); 
        cpu = new CPU();
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
            //Create a new process
            Process process = new Process(randomNumberThreads, processID); 
            //Set a random priority level
            int randomPriority = rng.nextInt(3); 
            switch(randomPriority) {
                case 0: 
                    process.setPriority("Low");
                    break;
                case 1: 
                    process.setPriority("Medium");
                    break;
                case 2: 
                    process.setPriority("High"); 
                    break;                
            } 
            //Add the process to the scheduler
            processes.add(process); 
            System.out.println("Process Created Successfully. Process ID: " + process.getProcessID() + " --> " + process.getNumberThread() + " Threads");
        }
    } 

    //Method that randomly terminates a process 
    public void terminateRamdonProcesses() {  
        int terminateProcess; 
        //If there are no processes return a message
        if(processes.size() == 0) {
            System.out.println("There are no Processes to Terminate.");
        } 
        else {
            //Select a random process to terminate
            terminateProcess = rng.nextInt(processes.size()); 
            //Notify the processIDManager of the terminate process so that the processID can be reused
            processIDManager.deleteProcessID(processes.get(terminateProcess).getProcessID()); 
            System.out.println("Process Terminated Successfully. Process ID: " + processes.get(terminateProcess).getProcessID());
            //Remove the process from the scheduler
            processes.remove(terminateProcess); 
        }
    } 

    //Implements the round robin scheduling algorithm 
    public void roundRobin() {
        //Rotate different processes in and out of the CPU
    }

}
