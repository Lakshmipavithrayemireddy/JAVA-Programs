import java.util.*;
class Calculate{
public static void main(String args[])
{
    Scanner in=new Scanner(System.in);
    System.out.println("enter operation:");
    System.out.println("1.addition:");
    System.out.println("2.subtraction");
    System.out.println("3.multiplication");
    System.out.println("4.division");
    int operation=in.nextInt();
    System.out.println("enter number of operands");
    int count=in.nextInt();
    if(count<2)
    {
        System.out.println("enter atleast 2 operands");
        return;
    }
    double[] numbers=new double[count];
    System.out.println("enter numbers");
    for(int i=0;i<count;i++)
    {
        numbers[i]=in.nextDouble();
    }
    double result=numbers[0];
    switch(operation)
    {
        case 1:
        for(int i=1;i<count;i++)
        {
            result+=numbers[i];
        }
        System.out.println("addition="+ result);
        break;
        case 2:
        for(int i=1;i<count;i++)
        {
            result-=numbers[i];
        }
        System.out.println("subtraction="+ result);
        break;
        case 3:
        for(int i=1;i<count;i++)
        {
            result*=numbers[i];
        }   
        System.out.println("multiplication="+ result);
        break;
        case 4:
        for(int i=1;i<count;i++)
        {
        if(numbers[i]==0)
        {
            System.out.println("error");
            return;
        }
        result/=numbers[i];
        }
        System.out.println("addition="+ result);
        break;
        default:
        System.out.println("invalid operation");
    }
    in.close();
  }
}
