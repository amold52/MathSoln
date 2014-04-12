import java.util.Arrays;
import java.util.List;

public class Parser {
	 public static Command getCommand(String commandStr) {
		 if(variableCheck(commandStr)) {
			 commandStr = commandStr.substring(0, commandStr.indexOf(","));
		 }
		 return Command.getByStr(commandStr);
	 }
	 
	 public static double getOperand(String s){
		 try {
			 return Double.parseDouble(s);
		 } catch(NumberFormatException inputNotDouble) {
			 throw new IllegalArgumentException("Given string " + s + " is not a valid operand.");
		 }
	 }
	 
	 public static List<String> getParameters(String cmdStr) {
		 String[] params = cmdStr.split(",");
		 List<String> paramList = Arrays.asList(params);
		 return paramList.subList(1, paramList.size());
	 }
	 
	 public static boolean variableCheck(String commandStr) {
		 if(commandStr.contains(",")) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }
}
