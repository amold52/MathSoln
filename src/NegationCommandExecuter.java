
public class NegationCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumOperands() < 1) {
			throw new IllegalStateException("Not enough operands for negation calculation. Minimum operands is 1 but found only " + state.getNumOperands());
		}
		
		double firstOpnd = state.takeOperand();
		state.addOperand(-firstOpnd);
		state.setPrintCommand(true);
		return -firstOpnd;
	}

}
