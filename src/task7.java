import java.util.*;

public class task7 {
    public static StringBuilder sb = new StringBuilder();
    public static int startIndex = 0;
    public static int endIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String equation = sc.nextLine();
        sb.append(equation);
        String currentEquation;
        while((currentEquation = findBracketsEquation(sb)).length() > 0){
            //System.out.println(currentEquation);
            String[] equationParams = currentEquation.split(" ");
            Double result = switchEquation(equationParams[1],equationParams[0],equationParams[2]);

            sb.replace(startIndex-1,endIndex+1,result.toString());
            startIndex = 0;
            endIndex = 0;
        }
        List<String> operands = Arrays.stream(sb.toString().split(" ")).toList();
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i< operands.size();i++){
            if(operands.get(i).contains("^")){
                String[] splitPowerOperand = operands.get(i).split("\\^");
                double operandA = Double.parseDouble(splitPowerOperand[0]);
                double operandB = Double.parseDouble(splitPowerOperand[1]);
                Double result = grading(operandA,operandB);
                resultList.add(result.toString());
            }else{
                resultList.add(operands.get(i));
            }
        }
        operands = new ArrayList<>();

        List<String> result = new ArrayList<>();
        for(int i = 0; i < resultList.size();i++){
           if(resultList.get(i).equals("*") || resultList.get(i).equals("/")){
               String currentOperation = resultList.get(i);
               String lastEl = result.get(result.size()-1);
               String next = resultList.get(i+1);
               Double resultValue = switchEquation(currentOperation, lastEl,next);
               result.remove(result.get(result.size()-1));
               result.add(resultValue.toString());
               i++;

           }else{
               result.add(resultList.get(i));
           }
        }
        List<String> newResult = new ArrayList<>();

        for(int i = 0; i < result.size();i++){
            if(result.get(i).equals("+") || result.get(i).equals("-")){
                String currentOperation = result.get(i);
                String lastEl = newResult.get(newResult.size()-1);
                String next = result.get(i+1);
                Double resultValue = switchEquation(currentOperation, lastEl,next);
                newResult.remove(newResult.get(newResult.size()-1));
                newResult.add(resultValue.toString());
                i++;

            }else{
                newResult.add(result.get(i));
            }
        }
        newResult.forEach(r -> System.out.print(Float.parseFloat(r) + " "));
    }
    public static double switchEquation(String mark,String leftOperand, String rightOperand){
        double a = Double.parseDouble(leftOperand);
        double b = Double.parseDouble(rightOperand);
        double result = 0;
        switch (mark){
            case "+":
                result = sum(a,b);
                break;
            case "-":
                result = subtraction(a,b);
                break;
            case "*":
                result = multiplication(a,b);
                break;
            case "/":
                result = division(a,b);
                break;
            case "^":
                result = grading(a,b);
                break;
        }
        return result;
    }
    public static String findBracketsEquation(StringBuilder sb){
        String result = "";

        for (int i = 0; i < sb.length(); i++)
        {
            if(sb.charAt(i) == '('){
                startIndex = i + 1;
            }
            if(sb.charAt(i) == ')'){
                endIndex = i;
                break;
            }
        }
        result = sb.subSequence(startIndex,endIndex).toString();
        return result;
    }

    public static double sum(double a, double b){
        return a + b;
    }
    public static double subtraction(double a, double b){
        return a - b;
    }
    public static double multiplication(double a, double b){
        return a * b;
    }
    public static double division(double a, double b){
        return a / b;
    }
    public static double grading(double a, double b){
        return Math.pow(a,b);
    }
}
