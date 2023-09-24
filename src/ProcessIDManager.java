//Import statements
import java.util.Stack; 

//A class that uses a stack to manage the ProcessIDs 
//Assigns processes a int value in ascending order and reuses terminated process IDs 
public class ProcessIDManager {
    
    //Instance variables 
    private int lastProcessID; 
    private Stack<Integer> processIDs; 
    private int processID;

    //Default constructor for the ProcessIDManager 
    public ProcessIDManager() {
        lastProcessID = 0;
        processIDs = new Stack<>(); 
    } 

    //Generates a ProcessID
    public int generateProcessID() { 
        //If the stack is empty set processID to the next available int 
        if(processIDs.isEmpty()) {
            processID = ++lastProcessID;
        } 
        //If ints have been pushed onto the stack pop the top value from the stack 
        else {
            processID = processIDs.pop();
        }
        //Return the generated processID 
        return processID;
    } 

    //Delete a specific processID and push it onto the stack for reuse 
    public void deleteProcessID(int deleteProcessID) {
        //Make sure the processID has actually been assigned 
        if(deleteProcessID > 0) {
            processIDs.push(deleteProcessID);
        } 
        //Error message if the processID is not assigned 
        else {
            System.out.println("Invalid ID: " + deleteProcessID);
        }
    } 

    //Return the current processID for debugging
    public int getProcessID() {
        return processID; 
    }

}