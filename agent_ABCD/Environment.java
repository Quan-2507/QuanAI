package agent_ABCD; 

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";
	
	private int score = 0; // performance measure

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState, LocationState locDState) {
	    envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		this.agent=agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroNment state when agent do an action
	public EnvironmentState executeAction(Action action) {
	    // existing logic
	    String agentLocation = envState.getAgentLocation();
	    if (action.equals(MOVE_RIGHT) && (LOCATION_A.equals(agentLocation) || LOCATION_C.equals(agentLocation))) {
	        envState.setAgentLocation(agentLocation.equals(LOCATION_A) ? LOCATION_B : LOCATION_D);
	        score -= 10;
	    }
	    else if (action.equals(MOVE_LEFT) && (LOCATION_B.equals(agentLocation) || LOCATION_D.equals(agentLocation))) {
	        envState.setAgentLocation(agentLocation.equals(LOCATION_B) ? LOCATION_A : LOCATION_C);
	        score -= 10;
	    }
	    // additional logic for UP and DOWN
	    else if (action.equals(MOVE_UP) && (LOCATION_C.equals(agentLocation) || LOCATION_D.equals(agentLocation))) {
	        envState.setAgentLocation(agentLocation.equals(LOCATION_C) ? LOCATION_A : LOCATION_B);
	        score -= 10;
	    } else if (action.equals(MOVE_DOWN) && (LOCATION_A.equals(agentLocation) || LOCATION_B.equals(agentLocation))) {
	        envState.setAgentLocation(agentLocation.equals(LOCATION_A) ? LOCATION_C : LOCATION_D);
	        score -= 10;
	    } else if (action.equals(SUCK_DIRT)) {
	        envState.setLocationState(agentLocation, LocationState.CLEAN);
	        score += 500;
	    } else {
	        score -= 100; // agent can't move
	    }
	    return envState;
	}
	
	public int getScore() {
	    return score;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent is in.
	public Percept getPerceptSeenBy() {
		// TODO
		String agentLocation = envState.getAgentLocation();
	    LocationState locationState = envState.getLocationState(agentLocation);
	    return new Percept(agentLocation, locationState);
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
