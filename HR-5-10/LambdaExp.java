@FunctionalInterface
interface A{
    int add(int i, int j);
}

public class LambdaExp{
    public static void main(String args[]){
        A obj = (i,j) -> i+j;
        int res=obj.add(5,10);
        System.out.println("Result: "+res);
    }
}