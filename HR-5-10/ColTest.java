import java.util.ArrayList;
import java.util.Collection;

public class ColTest {
    public static void main(String[] args) {
        Collection<Integer> nums = new<Integer> ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
