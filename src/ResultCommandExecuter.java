
public class ResultCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		
		if(state.getNumOperands()==0){
			state.setPrintCommand(true);
			return 0;
		}
		state.setPrintCommand(true);
		return state.oprandPeek();
		
	}

}
