package agent_AB; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		//Environment with [A=CLEAN, B=DIRTY]
		Environment env = new Environment(Environment.LocationState.CLEAN, 
		Environment.LocationState.DIRTY);
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATION_A);//Add an agent at location A
		env.step(3);

	}
}
