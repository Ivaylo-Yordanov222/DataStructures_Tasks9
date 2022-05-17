import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        String sentence = sc.nextLine().toLowerCase();
        String[] wordsArray = sentence.split(" ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String[] keyValue = sc.nextLine().toLowerCase().split(" ");
            map.put(keyValue[0],keyValue[1]);
        }
        sc.close();
        System.out.println();
        StringBuilder result = new StringBuilder();
        for(String word : wordsArray){
            if(map.containsKey(word)){
                result.append(map.get(word)).append(" ");
            }else{
                result.append(word).append(" ");
            }
        }
        System.out.println(result);
    }
}
