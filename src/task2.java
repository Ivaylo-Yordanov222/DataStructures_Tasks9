import java.util.*;

public class task2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] values = sc.nextLine().split(" ");
        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);
        Set<Integer> setN = new HashSet<>();
        Set<Integer> setM = new HashSet<>();
        fillData(n,setN);
        fillData(m,setM);
        int result = 0;
        if(n >= m){
            setN.retainAll(setM);
            result = setN.size();
        }
        else{
            setM.retainAll(setN);
            result = setM.size();
        }
        if(result <= 0){
            System.out.println("NO");
        }
        else{
            if(n >= m){
                setN.forEach(number-> System.out.print(number + " "));
            }else{
                setM.forEach(number-> System.out.print(number + " "));
            }
        }
    }
    public static void fillData(int n, Set<Integer> set){
        for (int i = 0; i < n; i++){
            int currentNumber = sc.nextInt();
            set.add(currentNumber);
        }
    }
}
