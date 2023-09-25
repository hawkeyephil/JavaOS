import java.util.Random;

//Creates a simulation and runs it for a specified amount of time
public class Simulation {

    //Instance variables
    private Scheduler scheduler;
    private Random rng; 
    private double end; 
    private double runtimeMinutes;

    //Creates a simulation
    public Simulation(double runtimeMinutes) {
        scheduler = new Scheduler();
        rng = new Random();
        end = System.currentTimeMillis() + runtimeMinutes * 60000; 
        this.runtimeMinutes = runtimeMinutes;
        runSimulation(runtimeMinutes);
    } 

    //Runs the simulation
    public void runSimulation(double runtime) { 
        while(System.currentTimeMillis() < end) { 
            //Random value that determines if a process will be created or terminated
            int prng = rng.nextInt(8); 
            //Create 5 to 10 processes
            if(prng == 0) {
                scheduler.createRandomProcesses();
            } 
            //Terminate a random process
            else {
                scheduler.terminateRamdonProcesses();
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

}
