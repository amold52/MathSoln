
import java.lang.Math;
public class PowerCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumOperands() < 2) {
			throw new IllegalStateException("Not enough operands for power calculation. Minimum operands is 2 but found only " + state.getNumOperands());
		}
		
		double firstOpnd = state.takeOperand();
		double secondOpnd = state.takeOperand();
		double result = Math.pow(secondOpnd, firstOpnd);
		state.addOperand(result);
		state.setPrintCommand(true);
		return result;
	}

}
