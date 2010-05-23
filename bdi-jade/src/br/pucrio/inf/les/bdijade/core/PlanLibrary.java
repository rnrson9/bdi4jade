/*
 * Created on 13/12/2009 01:34:53 
 */
package br.pucrio.inf.les.bdijade.core;

import jade.lang.acl.ACLMessage;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.pucrio.inf.les.bdijade.goal.Goal;
import br.pucrio.inf.les.bdijade.plan.Plan;

/**
 * This class represents the plan library of a capability. It aggregates the
 * plans that can be used to achieve goals.
 * 
 * @author ingrid
 */
// FIXME PlanLibrary - create indexes to optimize plan matches
public class PlanLibrary implements Serializable {

	private static final long serialVersionUID = 3038533629659859857L;

	private Capability capability;
	private final Set<Plan> plans;

	/**
	 * Creates a plan library.
	 */
	public PlanLibrary() {
		this(null);
	}

	/**
	 * Creates a plan library base associated with a capability and adds the
	 * plans in the provided set.
	 * 
	 * @param plans
	 *            the initial plans
	 */
	public PlanLibrary(Set<Plan> plans) {
		this.capability = null;
		this.plans = new HashSet<Plan>();
		if (plans != null) {
			for (Plan plan : plans) {
				addPlan(plan);
			}
		}
		init();
	}

	/**
	 * Adds a plan to the plan library.
	 * 
	 * @param plan
	 *            the plan to be added.
	 */
	public void addPlan(Plan plan) {
		plan.setPlanLibrary(this);
		this.plans.add(plan);
	}

	/**
	 * Returns the set of plans that can achieve the given goal.
	 * 
	 * @param goal
	 *            the goal to be achieved.
	 * @return the set of plans that can achieve the goal.
	 */
	public Set<Plan> canAchievePlans(Goal goal) {
		Set<Plan> plans = new HashSet<Plan>();
		for (Plan plan : this.plans) {
			if (plan.canAchieve(goal)) {
				plans.add(plan);
			}
		}
		return plans;
	}

	/**
	 * Returns true if there is a plan that can process the given message.
	 * 
	 * @param message
	 *            the message to be processed.
	 * @return true if a plan can process the message.
	 */
	public boolean canProcessPlans(ACLMessage message) {
		for (Plan plan : this.plans) {
			if (plan.canProcess(message)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the capability
	 */
	public Capability getCapability() {
		return capability;
	}

	/**
	 * @return the plans
	 */
	public Set<Plan> getPlans() {
		return plans;
	}

	/**
	 * Checks if a plan is part of the plan library.
	 * 
	 * @param plan
	 *            the plan to be checked
	 * @return true if the plan library contains the plan.
	 */
	public boolean hasPlan(Plan plan) {
		return this.plans.contains(plan);
	}

	/**
	 * Initialize the plan library, adding initial plans.
	 */
	protected void init() {
	}

	/**
	 * Removes a plan from the plan library.
	 * 
	 * @param plan
	 *            the plan to be removed.
	 * @return true if the plan was removed.
	 */
	public boolean removePlan(Plan plan) {
		boolean removed = this.plans.remove(plan);
		if (removed) {
			plan.setPlanLibrary(null);
		}
		return removed;
	}

	/**
	 * Sets the capability of this plan library. If the capability was already
	 * set, it throws a {@link RuntimeException}. After setting the capability,
	 * the {@link #init()} method is invoked.
	 * 
	 * @param capability
	 *            the capability to set
	 */
	public void setCapability(Capability capability) {
		if (this.capability != null) {
			throw new RuntimeException(
					"PlanLibrary already binded to another capability!");
		}
		this.capability = capability;
		this.init();
	}

}
