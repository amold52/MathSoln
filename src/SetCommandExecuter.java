
public class SetCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumParams() != 1) {
			throw new IllegalStateException("Command can't be executed!");
		}
		if(state.getNumOperands() < 1) {
			throw new IllegalStateException("No value to set");
		}
		state.setVar(state.takeParam(), state.takeOperand());
		state.setPrintCommand(false);
		return 0;
	}

}
