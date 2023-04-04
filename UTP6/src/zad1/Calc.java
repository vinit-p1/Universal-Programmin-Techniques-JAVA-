/**
 *
 *  @author Pahilajani Vinit 
 *
 */

package zad1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Calc {
    HashMap<String, BinaryOperator<BigDecimal>> availableOps = new HashMap<>();

    public String doCalc(String cmd) {
        
    	 availableOps.put("+", (x,y) -> x.add(y).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros());
         availableOps.put("-", (x,y) -> x.subtract(y).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros());
         availableOps.put("*", (x,y) -> x.multiply(y).setScale(7, RoundingMode.HALF_UP).stripTrailingZeros());
         availableOps.put("/", (x, y) -> x.divide(y, 10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
    	
    	String[] splitted = cmd.split("\\s+");
    	
        BigDecimal n1 = new BigDecimal(splitted[0]);
        BigDecimal n2 = new BigDecimal(splitted[2]);
        
        String ops = splitted[1];
        BinaryOperator<BigDecimal> op = availableOps.get(ops);
        if (op == null) {
            return "Invalid command to Calc";
        }
         
        return op.apply(n1, n2) +"" ;
    }
}
