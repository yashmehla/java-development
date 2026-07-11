import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEx {
    public static void main(String args[]){
        List<String> names = Arrays.asList("Yash", "Mbappe", "Ronaldo", "Messi");
        Optional<String> name = names.stream()
                .filter(n -> n.contains("a"))
                .findFirst();
        System.out.println(name);

    }
}
