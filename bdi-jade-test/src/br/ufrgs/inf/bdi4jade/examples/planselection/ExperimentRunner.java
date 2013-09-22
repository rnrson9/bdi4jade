/**
 * 
 */
package br.ufrgs.inf.bdi4jade.examples.planselection;

import jade.BootProfileImpl;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.PlatformController;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import br.ufrgs.inf.bdi4jade.event.GoalEvent;
import br.ufrgs.inf.bdi4jade.event.GoalFinishedEvent;
import br.ufrgs.inf.bdi4jade.event.GoalListener;
import br.ufrgs.inf.bdi4jade.examples.AgentStarter;

/**
 * @author ingrid
 * 
 */
public class ExperimentRunner implements GoalListener {

	public static final int ITERATIONS = 5;

	public static void main(String[] args) {
		ExperimentRunner runner = new ExperimentRunner();
		runner.run();
	}

	private ProfileImpl bootProfile;
	private int iteration;
	private final Log log;
	private jade.core.Runtime runtime;

	private final TransportationAgent transportationAgent;

	public ExperimentRunner() {
		PropertyConfigurator.configure(AgentStarter.class
				.getResource("log4j.properties"));
		this.log = LogFactory.getLog(this.getClass());

		List<String> params = new ArrayList<String>();
		params.add("-gui");
		params.add("-detect-main:false");

		log.info("Plataform parameters: " + params);

		this.bootProfile = new BootProfileImpl(params.toArray(new String[0]));

		this.runtime = jade.core.Runtime.instance();
		PlatformController controller = runtime
				.createMainContainer(bootProfile);

		this.transportationAgent = new TransportationAgent();
		try {
			AgentController ac = ((AgentContainer) controller).acceptNewAgent(
					transportationAgent.getClass().getSimpleName(),
					transportationAgent);
			ac.start();
		} catch (Exception e) {
			log.error(e);
		}

		this.iteration = 0;
	}

	@Override
	public void goalPerformed(GoalEvent event) {
		if (event instanceof GoalFinishedEvent
				&& event.getGoal() instanceof TransportationGoal) {
			if (iteration < ITERATIONS) {
				run();
			} else {
				log.info("Iterations finished!!");
				log.info(((GenericValueFunction<?>) transportationAgent
						.getRootCapability().getBeliefBase()
						.getBelief(TransportationAgent.SATISFACTION).getValue())
						.stats());
			}
		}
	}

	public void run() {
		transportationAgent.updatedPreferences();
		transportationAgent.addGoal(new TransportationGoal(), this);
		iteration++;
	}

}
