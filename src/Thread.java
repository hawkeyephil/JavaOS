//Import statements
import java.util.ArrayList;

//Class that represents a basic thread object 
public class Thread {
    
    //Instance variables that represent the components of a thread 
    private ArrayList instructions; 
    private String state; 
    private String priority;

    //Default constructor that creates an empty thread 
    public Thread() {
        instructions = new ArrayList(); 
        state = "";
        priority = ""; 
    }

    //Paramaterized construction that creates a thread with specified components 
    public Thread(ArrayList instructions, String state, String priority) {
        this.instructions = instructions; 
        this.state = state; 
        this.priority = priority; 
    }

}
