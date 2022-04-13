public class Calculator {
    public static Double calculate(Double operant1, Double operant2, String operators) throws Exception {
        if (operators.equals("add")) {
            return operant1 + operant2;
        } else if (operators.equals("minus")) {
            return operant1 - operant2;
        } else if (operators.equals("mul")) {
            return operant1 * operant2;
        } else {
            if(operant2 == 0){
                throw new Exception("You might try to div to 0, try another number");
            }
            return operant1 / operant2;
        }
    }
}
