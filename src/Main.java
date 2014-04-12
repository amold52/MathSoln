import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	private State state;
	private BufferedReader inputReader;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
	
	public Main() {
		state = new State();
		inputReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void run() {
		while(state.isRun()) {
			try {
				String userInput = readUserInput();
				
				try {
					Command cmd = Parser.getCommand(userInput);
					List<String> params = Parser.getParameters(userInput);
					if(params.size() != cmd.getNumParams()) {
						throw new UnsupportedOperationException("Number of commands is not valid");
					}
					for(String param: params) {
						if(param == null || param.trim().equals("")) {
							throw new UnsupportedOperationException("Invalid parameter name");
						}
						state.addParameter(param.trim());
					}
					double result = cmd.getExecutor().execute(state);
					if(state.isPrint())
						System.out.println("=> " + result);
					continue;
				} catch(IllegalArgumentException inputIsNotCommand) {}
				catch(IllegalStateException notEnoughOpnds) {
					System.err.println("Cannot execute this command in current state.");
					continue;
				} catch(UnsupportedOperationException e) {
					System.err.println(e.getMessage());
					continue;
				}
				
				try {
					double operand = Parser.getOperand(userInput);
					state.addOperand(operand);
					continue;
				} catch(IllegalArgumentException inputIsNotOperand) {}
				
				System.err.println("Invalid input.");
				
			} catch (IOException e) {
				System.err.println("Error in reading input. Please try again!");
			}
		}
	}

	public String readUserInput() throws IOException {
		showPrompt();
		String line = inputReader.readLine();
		return line;
	}

	private void showPrompt() {
		System.out.print("> ");
	}
}
