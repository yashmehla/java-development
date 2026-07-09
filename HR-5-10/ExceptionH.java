public class ExceptionH{
    public static void main(String args[]){
        int i=2;
        int j=0;
        String str=null;
        int[] nums = new int[5];
        try{
            j=18/i;
            nums[0]=10;
            nums[4]=20;
            str.length();
        }
        catch(ArithmeticException e){
            System.out.println("Something went wrong");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bound");
        }
        catch(RuntimeException e){
            System.out.println("Some ting wong");
        }
        System.out.println(j);
        System.out.println("Bye");

    }
}