    
class Edit{   
    private int number = 10;
    public int replaceNum(int number){
        System.out.println("Number before Replacement: " + this.number);
        this.number=number;
        return 1;
    }
    
    public int showNum(){
        return number;
    }
}


public class Editint{
    public static void main(String[] args) {
        System.out.println("This is the Edit class.");
        Edit obj = new Edit();
        int newNum = 20;
        obj.replaceNum(newNum);
        System.out.println("Number after Replacement: " + obj.showNum());

    }
}



