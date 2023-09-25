//Basic CPU object that "runs" a process by specifing the Process ID  
public class CPU {

    //The Process ID of the running process 
    private int processID;

    //Creates a CPU object with no processes running 
    public CPU() {
        processID = 0;
    } 

    //Sets or moves a process with a specified ID into the CPU
    public void setProcessID(int processID) {
        this.processID = processID;
    } 

    //Returns the Process ID of the current process running in the CPU
    public int getProcessID() {
        return processID;
    }

}
