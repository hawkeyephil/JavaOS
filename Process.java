//Import statements 
import java.util.ArrayList;

//Basic class that represents a process object 
public class Process { 
    //Instance variables --> Components of a process 
    private ArrayList program;
    private String state; 
    private String input; 
    private String output; 
    private String priority; 
    private ArrayList memory; 

    //Default constructor that makes an empty process 
    public Process() {
        program = new ArrayList();
        state = "";
        input = "";
        output = ""; 
        priority = ""; 
        memory = new ArrayList(); 
    } 

    //Paramaterized constructor that makes a process with specific information 
    public Process(ArrayList program, String state, String input, String output, String priority, ArrayList memory) {
        this.program = program; 
        this.state = state;
        this.input = input; 
        this.output = output; 
        this.priority = priority; 
        this.memory = memory; 
    }

}
