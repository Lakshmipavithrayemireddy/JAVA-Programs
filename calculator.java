import java.util.*;
class Main
{
    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the operation you want to perform:");
        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Multiplication");
        System.out.println("4.Division");
        System.out.println("5. Remainder");
        int op=sc.nextInt();
        System.out.println("enter the values a:");
        double a=sc.nextDouble();
        System.out.println("enter the values b:");
        double b=sc.nextDouble();
        switch(op)
        {
            case 1:
                System.out.println(a+b);
                break;
            case 2:
                System.out.println(a-b);
                break;
            case 3:
                System.out.println(a*b);
                break;
            case 4:
                System.out.println(a/b);
                break;
            case 5:
                System.out.println(a%b);
                break;
            default:
            System.out.println("invalid operator");
        }
        
    }
}
