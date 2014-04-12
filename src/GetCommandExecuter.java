
public class GetCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumParams() != 1) {
			throw new IllegalStateException("Command can't be executed!");
		}
		String strParam = state.takeParam();
		
		if(state.checkVaraibleMap(strParam)) {
			double variable = state.getMapVar(strParam);
			state.setPrintCommand(true);
			state.addOperand(variable);
			return variable;
		}
		else {
			throw new IllegalArgumentException("No such Varaible found!");
		}
		
	}

}
