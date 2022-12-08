import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Day1Puzzle1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInput = new FileInputStream("input.txt");
        Scanner scnr = new Scanner(fileInput);
        int largestCalorieCount = nextElfTotalCalories(scnr);
        int secondLargestCalorieCount = nextElfTotalCalories(scnr);
        int thirdLargestCalorieCount = nextElfTotalCalories(scnr);
        int returnedValue = 0;

        if(largestCalorieCount < secondLargestCalorieCount){
            int tempVar = largestCalorieCount;
            largestCalorieCount = secondLargestCalorieCount;
            secondLargestCalorieCount = tempVar;
        }
        if(largestCalorieCount < thirdLargestCalorieCount){
            int tempVar = largestCalorieCount;
            largestCalorieCount = thirdLargestCalorieCount;
            thirdLargestCalorieCount = tempVar;
        }
        if(secondLargestCalorieCount < thirdLargestCalorieCount){
            int tempVar = secondLargestCalorieCount;
            secondLargestCalorieCount = thirdLargestCalorieCount;
            thirdLargestCalorieCount = tempVar;
        }
 
        while(returnedValue > -1){
            returnedValue = nextElfTotalCalories(scnr);
            if(returnedValue > largestCalorieCount){
                thirdLargestCalorieCount = secondLargestCalorieCount;
                secondLargestCalorieCount = largestCalorieCount;
                largestCalorieCount = returnedValue;
            } else if (returnedValue > secondLargestCalorieCount){
                thirdLargestCalorieCount = secondLargestCalorieCount;
                secondLargestCalorieCount = returnedValue;
            } else if (returnedValue > thirdLargestCalorieCount){
                thirdLargestCalorieCount = returnedValue;
            }
        }
 
        int sum = largestCalorieCount + secondLargestCalorieCount + thirdLargestCalorieCount;
        System.out.println("Largest calorie count: " + largestCalorieCount);
        System.out.println("Sum of top 3 calorie counts: " + sum);
        scnr.close();
    }

    public static int nextElfTotalCalories(Scanner scnr){
        int returnNumber = 0;    
        if(scnr.hasNext()){
            while(true){
                try {
                    returnNumber += Integer.parseInt(scnr.nextLine());
                } catch (Exception numberFormatException) {
                    break;
                }
            }
        } else {
            if(returnNumber == 0){
                return -1;
            }
        }
        return returnNumber;
    }
}
