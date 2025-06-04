import java.util.*;
public class Expression_Calculator 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your expression (e.g., 2+3*7-5*3+6):");
        String input = sc.nextLine().replaceAll("\\s", ""); 

        try {
            double result = evaluateExpression(input);
            System.out.println("Result: " + result);
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid expression. " + e.getMessage());
        }
    }
    public static double evaluateExpression(String expr) 
    {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        while (i < expr.length()) 
        {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch))
            {
                int j = i;
                while (j < expr.length() && (Character.isDigit(expr.charAt(j)) || expr.charAt(j) == '.')) j++;
                double num = Double.parseDouble(expr.substring(i, j));
                numbers.push(num);
                i = j;
            } 
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) 
                {
                    double q = numbers.pop();
                    double p = numbers.pop();
                    char op = operators.pop();
                    numbers.push(applyOp(p, q, op));
                }
                operators.push(ch);
                i++;
            } 
            else
            {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }
        }
        while (!operators.isEmpty())
        {
            double q = numbers.pop();
            double p = numbers.pop();
            char op = operators.pop();
            numbers.push(applyOp(p, q, op));
        }
        return numbers.pop();
    }
    public static int precedence(char op) 
    {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static double applyOp(double p, double q, char op) {
        switch (op)
        {
            case '+': return p + q;
            case '-': return p - q;
            case '*': return p * q;
            case '/':
                if (q == 0) throw new ArithmeticException("Division by zero");
                return p / q;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
