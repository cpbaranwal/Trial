package designProblems.finiteStatemachine;

public enum FinalStates  implements IFinalState{
	//the next method of these states will never be executed, just defined to adhere with the contract
	Failed{
		public IState next(ContextObj obj){
			System.out.println("current state: Failed");
		 return FinalStates.Failed;
		}	
	},
	Passed{
		public IState next(ContextObj obj){
			System.out.println("current state: Passed");
		 return FinalStates.Passed;
		}	
	}
	;

	@Override
	abstract public IState next(ContextObj obj) ;
	}



interface IFinalState extends IState
{
	//do nothing
}
