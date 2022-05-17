import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> numbers = Arrays.stream(scanner.nextLine().trim().split(" ")).toList();
        List<Integer> nums = numbers.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        int rounds = 0;
       for(int i = 0; i < nums.size(); i++){

           int left = nums.get(i);
           int right = nums.get(i+1);

           if(left < right){
               rounds++;
               nums.remove(i + 1);
           }
           if(i + 1 == nums.size()-1){
               break;
           }
       }
       System.out.println(rounds);

    }
}

