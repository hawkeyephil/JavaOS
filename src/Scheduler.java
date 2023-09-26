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
            //Set a random priority level
            int randomPriority = rng.nextInt(3); 
            String priority;
            switch(randomPriority) {
                case 0: 
                    priority = "Low";
                    break;
                case 1: 
                    priority = "Medium";
                    break;
                default: 
                    priority = "High"; 
                    break;                
            } 
            //Create a new process
            Process process = new Process(randomNumberThreads, processID, priority);
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
    //The ArrayList is treated like a queue 
    public void roundRobin(double quantum) { 
        //Check if there are any processes to run  
        if(processes.size() != 0) { 
            //Rotate different processes in and out of the CPU 
            //Remove the first element from the ArrayList
            Process cpuProcess = processes.get(0); 
            processes.remove(0);
            //Push that element "onto" the CPU 
            //Change the process ID in the CPU 
            cpu.setProcessID(cpuProcess.getProcessID());
            //Change the state of the process to Running 
            cpuProcess.setState("Running"); 
            //Print the process ID of the running process
            System.out.println("Process ID: " + cpu.getProcessID() + " Running");
            //Wait 
            double endTime = System.currentTimeMillis() + quantum*1000; 
            while(System.currentTimeMillis() < endTime) {
                //Wait the quantum length of time
            }
            //Remove the process from the CPU 
            cpu.setProcessID(0);
            //Change the state of the process to Ready 
            cpuProcess.setState("Ready");
            //Add the element back to the end of the ArrayList (Queue)
            processes.add(cpuProcess);
        } 
        else { 
            //If there are no processes ready return a message
            System.out.println("There are no Processes to Run.");
        }
    } 

}
