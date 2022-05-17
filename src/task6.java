import java.util.*;

public class task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();

        String commandRow;
        while(!((commandRow = sc.nextLine()).trim().equals("END"))) {
            String[] row = commandRow.trim().split(" ");
            String command = row[0];
            switch (command) {
                case "PUSH":
                    stack.push(Integer.parseInt(row[1]));
                    break;
                case "MAX":
                    stack.max();
                    break;
                case "POP":
                    stack.pop();
            }
        }
        sc.close();
        Collections.reverse(stack.getList());
        stack.getList().forEach(num -> System.out.print(num + " "));
    }
}
