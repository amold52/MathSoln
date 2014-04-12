
public class SubtractionCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumOperands() < 2) {
			throw new IllegalStateException("Not enough operands for subtraction. Minimum operands is 2 but found only " + state.getNumOperands());
		}
		
		double firstOpnd = state.takeOperand();
		double secondOpnd = state.takeOperand();
		double result = secondOpnd - firstOpnd;
		state.addOperand(result);
		state.setPrintCommand(true);
		return result;
	}

}
