import java.util.Scanner;

public class IODemo {
    public static void main(String args[]){
    //     System.out.println("Hello"); 
    //     InputStreamReader in = new InputStreamReader(System.in);
    //     BufferedReader bf = new BufferedReader(in);
    //     System.out.println("Enter a number: ");
    //     int num = Integer.parseInt(bf.readLine());
    //     System.out.println("You have Entered: "+num);
    //     System.out.println("Enter the second Number: ");
    //     long num2 = Long.parseLong(bf.readLine());
    //     System.out.println("The second Number is: " + num2);
    // }

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the Number: ");
    int num1 = sc.nextInt();
    System.out.println("The entered number is: " + num1);
    sc.close();
    }

}
