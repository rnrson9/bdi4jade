/**
 * 
 */
package br.ufrgs.inf.bdi4jade.examples.template;

import br.ufrgs.inf.bdi4jade.softgoal.NamedSoftgoal;
import br.ufrgs.inf.bdi4jade.softgoal.Softgoal;

/**
 * @author ingrid
 * 
 */
public interface Constants {

	// Softgoals
	public static final Softgoal COMFORT = new NamedSoftgoal("COMFORT");
	public static final Softgoal COST = new NamedSoftgoal("COST");
	public static final Softgoal PERFORMANCE = new NamedSoftgoal("PERFORMANCE");
	public static final Softgoal SAFETY = new NamedSoftgoal("SAFETY");
	public static final Softgoal SECURITY = new NamedSoftgoal("SECURITY");

	public static final Softgoal ALL_SOFTGOALS[] = { COMFORT, COST,
			PERFORMANCE, SAFETY, SECURITY };

}
