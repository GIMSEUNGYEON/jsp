package enumPck;
import java.util.Optional;
import java.util.stream.Stream;


public enum Operator {
	PLUS("+"),MINUS("-"),MULTIPLY("*"),DIVIDE("/");
	
	private String operatorName;
	
	public String getOperatorName() {
		return operatorName;
	}
	private Operator(String operatorName) {
		this.operatorName = operatorName;
	}
	
   public static Operator findOperator(String oper) {
	      final String Operator=oper.toUpperCase();
	      return Stream.of(values())
	         .filter(c->Operator.contains(c.name()))
	         .findFirst()
	         .orElse(null);
	   }
	   public static String findOperName(String oper) {
	      return findOperator(oper).getOperatorName();
	      
	   }
	
	public static int calculate(String operator,int leftOp,int rightOp) {
		int result=0;
		for(Operator tmp:values()) {
			if(operator.equals(tmp.name())) {
				result=calculateAct(tmp,leftOp,rightOp);
			}
		}
		return result;
	}
	
	private static int calculateAct(Operator tmp,int leftOp,int rightOp) {
		String resultOperator=tmp.name();
		System.out.println(resultOperator);
		int result=0;
		if(resultOperator.equals("PLUS")) {
			result=leftOp+rightOp;
		}else if(resultOperator.equals("MINUS")) {
			result=leftOp-rightOp;
		}else if(resultOperator.equals("MULTIPLY")) {
			result=leftOp*rightOp;
		}else if(resultOperator.equals("DIVIDE")) {
			result=leftOp/rightOp;
		}
		return result;
	}
}
