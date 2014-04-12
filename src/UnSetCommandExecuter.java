
public class UnSetCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumParams() != 1) {
			throw new IllegalStateException("Command can't be executed!");
		}
		String strParam = state.takeParam();
		
		if(state.checkVaraibleMap(strParam)) {
			throw new IllegalArgumentException("No such Varaible found!");
		}
		state.deleteVariable(strParam);
		state.setPrintCommand(false);
		return 0;
	}

}
