package agent_ABCD; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		    // Update the environment initialization
		    Environment env = new Environment(Environment.LocationState.CLEAN, Environment.LocationState.DIRTY, Environment.LocationState.DIRTY, Environment.LocationState.CLEAN);
		    Agent agent = new Agent(new AgentProgram());
		    env.addAgent(agent, Environment.LOCATION_A);
		    env.step(6);

		    System.out.println("Final Score: " + env.getScore());
		}
}
