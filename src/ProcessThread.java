//Import statements
import java.util.ArrayList;

//Class that represents a basic thread object 
public class ProcessThread {
    
    //Instance variables that represent the components of a thread 
    private String instructions; 
    private String state; 
    private ArrayList stack;

    //Default constructor that creates an empty thread 
    public ProcessThread() {
        instructions = ""; 
        state = "";
        stack = new ArrayList(); 
    }

    //Paramaterized construction that creates a thread with specified components 
    public ProcessThread(String instructions, String state, ArrayList stack) {
        this.instructions = instructions; 
        this.state = state; 
        this.stack = stack; 
    }

}
