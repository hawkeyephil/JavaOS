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
            //Random value to determine if an event will happen (slow down console)
            int prng = rng.nextInt(10);
            if(prng == 0) { 
                //Random value that determines if a process will be created or terminated
                prng = rng.nextInt(8); 
                //Create 5 to 10 processes
                if(prng == 0) {
                    scheduler.createRandomProcesses();
                } 
                //Terminate a random process
                else {
                    scheduler.terminateRamdonProcesses();
                }
            } 

            //Rotate processes in CPU using round robin scheduling with a specified quantum
            scheduler.roundRobin(0.1);

        } 
    }

}
