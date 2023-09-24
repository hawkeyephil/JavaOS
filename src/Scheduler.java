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
    //Time value to manage scheduler runtime 
    private double end;

    //Default constructer that creates a basic scheduler object
    public Scheduler(double runtimeMinutes) { 
        processes = new ArrayList<Process>();
        rng = new Random(); 
        processIDManager = new ProcessIDManager(); 
        end = System.currentTimeMillis() + runtimeMinutes * 60000; 

        //Until the specified time is up continue to create and terminate processes at random
        while(System.currentTimeMillis() < end) {
            int prng = rng.nextInt(8); 
            //Create 5 to 10 processes
            if(prng == 0) {
                createRandomProcesses();
            } 
            //Terminate a random process
            else {
                terminateRamdonProcesses();
            } 

            //Pause the while loop for 0 to 3 seconds to make it easier to read the console 
            try {
                Thread.sleep(rng.nextInt(4)*1000); 
            } 
            catch(InterruptedException e) { 
                e.printStackTrace();
            }
        } 
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

}
