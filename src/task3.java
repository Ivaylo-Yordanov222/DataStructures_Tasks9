import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCities = sc.nextInt();
        List<Integer> distances = new ArrayList<>();
        List<Integer> foods = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < numberOfCities; i++) {
            String[] row = sc.nextLine().split(" ");
            int distanceToNextCity = Integer.parseInt(row[0]);
            int foodForDay = Integer.parseInt(row[1]);
            distances.add(distanceToNextCity);
            foods.add(foodForDay);
        }
        int sumOfCitiesLengthInDays = distances.stream()
                .reduce(0, Integer::sum);
        int sumOfNecessaryFoodForTrip = foods.stream()
                .reduce(0, Integer::sum);
        if (sumOfNecessaryFoodForTrip < sumOfCitiesLengthInDays) {
            System.out.println("NO");
            return;
        }
        int restFood = 0;
        int cityCount = 1;
        int currentIndex = 0;
        while (currentIndex != numberOfCities - 1) {
            for (int i = 0; i < numberOfCities; i++) {
                currentIndex = i;
                int currentDistanceToNextCity = distances.get(i);
                int currentFood = foods.get(i);
                restFood = restFood + (currentFood - currentDistanceToNextCity);
                if (restFood < 0) {
                    restFood = 0;
                    distances.add(distances.remove(0));
                    foods.add(foods.remove(0));
                    cityCount++;
                    break;
                }
            }
        }
        System.out.println(cityCount);
    }
}
