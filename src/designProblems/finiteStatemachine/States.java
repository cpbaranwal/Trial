package designProblems.finiteStatemachine;

enum States implements IState
{
	INIT{
		@Override
		public IState next(ContextObj obj) {
			System.out.println("current state: INIT");
			char ch = obj.read();
			switch(ch)
			{
				case 'a' : return A;
				default : return FinalStates.Failed;
			}
		}
	},
	A{
		@Override
		public IState next(ContextObj obj) {
			System.out.println("current state: A");
			char ch = obj.read();
			switch(ch)
			{
				case 'a' : return A;
				case 'b' : return B;
				case 'c' : return C;
				default : return FinalStates.Failed;
			}
		}
	},
	B{
		@Override
		public IState next(ContextObj obj) {
			System.out.println("current state: B");
			char ch = obj.read();
			switch(ch)
			{
				case 'b' : return B;
				case 'c' : return C;
				default : return FinalStates.Failed;
			}
		}
	},
	C{
		@Override
		public IState next(ContextObj obj) {
			System.out.println("current state: C");
			char ch = obj.read();
			switch(ch)
			{
				case 'c' : return C;
				case ContextObj.END : return FinalStates.Passed;
				default : return FinalStates.Failed;
			}
		}
	},
	;

	@Override
	abstract public IState next(ContextObj obj) ;

}

