//Import statements 
import java.util.ArrayList;  

//Basic class that represents a process object 
public class Process { 
    //Instance variables --> Components of a process 
    private ArrayList<Thread> program;
    private String state; 
    private String input; 
    private String output; 
    private String priority; 
    private ArrayList memory; 
    private int processID;

    //Default constructor that makes an empty process 
    public Process() {
        program = new ArrayList<Thread>(); 
        //Creates and Adds an empty thread to the empty process 
        Thread thread = new Thread();
        program.add(thread);
        state = "";
        input = "";
        output = ""; 
        priority = ""; 
        memory = new ArrayList(); 
    } 

    //Paramaterized constructor that makes an empty process with a specified number of threads 
    public Process(int numberThreads, int processID) {
        program = new ArrayList<Thread>();
        for(int i = 0; i < numberThreads; i++) { 
            //Creates and Adds an empty thread to the empty process
            Thread thread = new Thread();
            program.add(thread);
        }  
        state = "";
        input = "";
        output = ""; 
        priority = ""; 
        memory = new ArrayList(); 
        this.processID = processID;
    }

    //Paramaterized constructor that makes a process with specific information 
    public Process(ArrayList<Thread> program, String state, String input, String output, String priority, ArrayList memory, int processID) {
        this.program = program; 
        this.state = state;
        this.input = input; 
        this.output = output; 
        this.priority = priority; 
        this.memory = memory; 
        this.processID = processID;
    } 

    //Returns the number of threads that a process has
    public int getNumberThread() {
        int numberThreads = program.size();
        return numberThreads;
    } 

    //Returns the processID value 
    public int getProcessID() { 
        return processID;
    }

}
