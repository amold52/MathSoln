
public class ResetCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		
		while(state.getNumOperands()!=0)
			 state.takeOperand();
		System.out.println(">>Reset done!");
		state.setPrintCommand(false);
		return 0;
	}

}
