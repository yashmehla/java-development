class Hello{
    public static void main(String args[])
    {
        System.out.println("Even or Odd");
        int x = 5;
        int y = 0;

        //if(x%2==0)
        //    y+=20;
        //else
        //   y+=10;
        y=x%2==0?20:10;
        System.out.println(y);
    }
}
