//----------------------------------------------------------------------------
// Copyright (C) 2011  Ingrid Nunes
// 
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
// 
// To contact the authors:
// http://inf.ufrgs.br/prosoft/bdi4jade/
//
//----------------------------------------------------------------------------

package bdi4jade.core;

import jade.core.AID;
import jade.lang.acl.ACLMessage;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import bdi4jade.belief.Belief;
import bdi4jade.event.GoalListener;
import bdi4jade.goal.Goal;
import bdi4jade.goal.Softgoal;

/**
 * This interfaces represents a BDIAgent that has a current set of goals, which
 * can be selected to become intentions, that is, to tried to be achieved by
 * means of the selection and execution of plans. It has a behavior that runs
 * the BDI-interpreter.
 * 
 * @author Ingrid Nunes
 */
public interface BDIAgent {

	/**
	 * Adds a new goal to this agent to be achieved.
	 * 
	 * @param dispatcher
	 *            the capability that dispatched this goal.
	 * @param goal
	 *            the goal to be achieved.
	 * 
	 * @return true if the goal was added, false otherwise.
	 */
	public boolean addGoal(Capability dispatcher, Goal goal);

	/**
	 * Adds a new goal to this agent to be achieved and adds a listener to
	 * observe events related to this goal.
	 * 
	 * @param dispatcher
	 *            the Capability that dispatched this goal.
	 * @param goal
	 *            the goal to be achieved.
	 * @param goalListener
	 *            the listener to be notified about this goal events.
	 * 
	 * @return true if the goal was added, false otherwise.
	 */
	public boolean addGoal(Capability dispatcher, Goal goal,
			GoalListener goalListener);

	/**
	 * Adds a new goal to this agent to be achieved.
	 * 
	 * @param goal
	 *            the goal to be achieved.
	 * 
	 * @return true if the goal was added, false otherwise.
	 */
	public boolean addGoal(Goal goal);

	/**
	 * Adds a new goal to this agent to be achieved and adds a listener to
	 * observe events related to this goal.
	 * 
	 * @param goal
	 *            the goal to be achieved.
	 * @param goalListener
	 *            the listener to be notified.
	 * 
	 * @return true if the goal was added, false otherwise.
	 */
	public boolean addGoal(Goal goal, GoalListener goalListener);

	/**
	 * Adds a listener to be notified when about goal events.
	 * 
	 * @param goalListener
	 *            the listener to be notified.
	 */
	public void addGoalListener(GoalListener goalListener);

	/**
	 * Adds a new softgoal to this agent.
	 * 
	 * @param softgoal
	 *            the softgoal to be pursued.
	 */
	public void addSoftgoal(Softgoal softgoal);

	/**
	 * Checks if this agent is able to process the given message.
	 * 
	 * @param msg
	 *            the message to be checked.
	 * @return true if this agent is able to handle the message.
	 */
	public boolean canHandle(ACLMessage msg);

	/**
	 * Drops a given goal of this agent, which means setting it as no longer
	 * desired. If the goal is not part of the agent's current goals, no action
	 * is performed.
	 * 
	 * @param goal
	 *            the goal to be dropped.
	 */
	public void dropGoal(Goal goal);

	/**
	 * Drops a given softgoal of this agent. If the softgoal is not part of the
	 * agent's current softgoals, no action is performed.
	 * 
	 * @param softgoal
	 *            the softgoal to be dropped.
	 */

	public void dropSoftoal(Softgoal softgoal);

	/**
	 * Returns the id of this agent.
	 * 
	 * @return the agent id.
	 */
	public AID getAID();

	/**
	 * Returns all capabilities that are part of this agent. This included all
	 * capabilities composed or associated with other capabilities.
	 * 
	 * @return the capabilities.
	 */
	public Collection<Capability> getAllCapabilities();

	/**
	 * Returns a collection of all beliefs from all capabilities of this agent.
	 * It may have two equivalent beliefs, i.e. beliefs with the same name.
	 * 
	 * @return the collection of all beliefs of this agent.
	 */
	public Collection<Belief<?, ?>> getBeliefs();

	/**
	 * Returns all goal listeners.
	 * 
	 * @return the goalListeners.
	 */
	public List<GoalListener> getGoalListeners();

	/**
	 * Gets all goals of this agent. This goals are the ones in the goal set and
	 * the ones that are trying to be achieve in intentions.
	 * 
	 * @return the set of goals.
	 */
	public Set<Goal> getGoals();

	/**
	 * Returns all agent intentions, which are goals that this agent is
	 * committed to achieve.
	 * 
	 * @return the intentions.
	 */
	public Set<Intention> getIntentions();

	/**
	 * Gets all softgoals of this agent.
	 * 
	 * @return the set of softgoals.
	 */
	public Set<Softgoal> getSoftgoals();

	/**
	 * Removes a goal listener, so it will not be notified about the goal events
	 * anymore.
	 * 
	 * @param goalListener
	 *            the goal listener to be removed.
	 */
	public void removeGoalListener(GoalListener goalListener);

	/**
	 * Restarts the agent in case its reasoning cycle is in the blocked state.
	 */
	public void restart();

}
