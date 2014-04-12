
public enum Command {
	
	ADD("ADD", new AddCommandExecutor(), 0),
	MULTIPLY("MUL", new ProductCommandExecutor(), 0),
	SUBTRACTION("SUB", new SubtractionCommandExecuter(), 0),
	POWER("POW", new PowerCommandExecuter(), 0),
	NEGATION("NEG", new NegationCommandExecuter(), 0),
	EXIT("EXT", new ExitCommandExecuter(), 0),
	RESET("RST", new ResetCommandExecuter(), 0),
	RESULT("RES", new ResultCommandExecuter(), 0),
	//DUMP("DUM", new DumpCommandExecuter(), 0),
	SET("SET", new SetCommandExecuter(), 1),
	GET("GET", new GetCommandExecuter(), 1),
	UNSET("UNSET", new UnSetCommandExecuter(), 1);
	
	private String commandStr;
	private CommandExecuter executor;
	private int numParams;
	
	private Command(String cmd, CommandExecuter e, int number) {
		commandStr = cmd;
		executor = e;
		numParams = number;
	}
	
	public String getCommandStr() {
		return commandStr;
	}
	
	public CommandExecuter getExecutor() {
		return executor;
	}
	
	public static Command getByStr(String cmd) {
		for(Command c: Command.values()) {
			if(c.commandStr.equals(cmd)) {
				return c;
			}
		}
		throw new IllegalArgumentException("No command for string " + cmd + " found.");
	}
	
	public int getNumParams() {
		return numParams;
	}

}
