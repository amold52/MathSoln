
public class DumpCommandExecuter implements CommandExecuter {

	@Override
	public double execute(State state) {
		if(state.getNumOperands() < 1) {
			throw new IllegalStateException("Error! No Operand Found");
		}
		System.out.print(">> ");
		for(int i = 0; i<state.getNumOperands(); i++) {
			//System.out.print(+state.oprandPeek(i)+"  ");
		}
		System.out.println();
		state.setPrintCommand(false);
		return 0;
	}

}
