
public class ExitCommandExecuter implements CommandExecuter {
	
	public double execute(State state) {
		System.out.println("ProgramQuits");
		state.stopRun();
		state.setPrintCommand(false);
		return 0;
	}

}
