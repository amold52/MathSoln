
public class AddCommandExecutor implements CommandExecuter
{
	public double execute(State state){
		if(state.getNumOperands() < 2) {
			throw new IllegalStateException("Not enough operands for addition. Minimum operands is 2 but found only " + state.getNumOperands());
		}
		
		double firstOpnd = state.takeOperand();
		double secondOpnd = state.takeOperand();
		double result = firstOpnd + secondOpnd;
		state.addOperand(result);
		state.setPrintCommand(true);
		return result;
	}

}
