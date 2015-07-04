package designProblems.finiteStatemachine;


/**
 * 
 * @author chandan
 * 
 * Finite State machine is a problem derived from Automata which means "self-acting" .
 * In FSM, there are a number of STATES through which TRANSITION happens on a CONTEXT object.
 * Finally the proces ends in computing a result.
 * For example: FSM can be used to detect  whether a given string satsifies a given Regex.
 *  e.g. regex =  ^(a+)(b*)(c*)$   , String = "aabbbc"   // should satisfy
 *       regex =  ^(a+)(b*)(c*)$   , String = "aabbbcb"   // should NOT satisfy
 *       
 *       Finite State machine consists of 3 components majorly:
 *       i.  State :  a. Init State  2. Final States   3. Intermediary States
 *       ii. Transition : logic to switch between states
 *       iii.Context Object .  ( here.it will be a given input string )
 *
 */

//Note: this FSM has been written only for regex: ^(a+)(b*)(c*)$
public class FiniteStateMachine {

	public static void main(String[] args) 
	{
		String str = "abbbccc";
		compute(str);
	}
	
	//Transition logic
	private static void compute(String str)
	{
		
		ContextObj obj = new ContextObj(str);
		IState state=null;
		for( state=States.INIT; !(state instanceof IFinalState); state=state.next(obj) )
			;  //do nothing, let the computation be auto-complete/automate
				
		if(state == FinalStates.Passed)//can use switch instead of if/else if there are many possible final states
			System.out.println("the given string: "+str+"  matches the expression...");
		else
			System.out.println("the given string: "+str+"  failed to match the expression...");
	}

}
