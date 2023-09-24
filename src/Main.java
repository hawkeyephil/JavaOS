
//Main class 
public class Main {
    //A scheduler object 
    private static Scheduler scheduler; 

    //Main method 
    public static void main(String[] args) { 
        //Creates a scheduler object that runs for 10 minutes
        scheduler = new Scheduler(10); 
    }
}
