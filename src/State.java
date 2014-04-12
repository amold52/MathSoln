import java.util.Stack;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class State {
	
	private Stack<Double> operandStack;
	private boolean running, printOperand;
	private HashMap<String, Double> variableMap;
	private Queue<String> parameterQueue;
	
	public State() {
		operandStack = new Stack<Double>();
		parameterQueue = new LinkedBlockingQueue<String>();
		variableMap = new HashMap<String, Double>();
		running = true;
		printOperand = true;
	}		
	
	public double takeOperand() {
		double out = operandStack.pop();
		return out;
	}
	
	public int getNumOperands() {
		return operandStack.size();
	}
	
	public void addOperand(double opnd){
		operandStack.push(opnd);
	}
	
	public boolean isRun() {
		return running;
	}
	
	public void stopRun() {
		running = false;
	}
	
	public void setPrintCommand(boolean Sign) {
		printOperand = Sign;
	}
	
	public boolean isPrint() {
		return printOperand;
	}
	
	public double oprandPeek() {
		return operandStack.peek();	
	}
	
	public void addParameter(String Parameter) {
		parameterQueue.add(Parameter);
	}
	
	public void setVar(String name, double value) {
		variableMap.put(name, value);
	}
	
	public String takeParam() {
		return parameterQueue.poll();
	}
	
	public int getNumParams(){
		 return parameterQueue.size();
	}
	
	public boolean checkVaraibleMap(String key) {
		return variableMap.containsKey(key);
	}
	public double getMapVar(String key) {
		return variableMap.get(key);
	}
	
	public void deleteVariable(String varName) {
		variableMap.remove(varName);
	}

}
