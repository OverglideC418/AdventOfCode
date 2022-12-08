import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Day4Puzzle {
    public static void main(String[] args) throws FileNotFoundException{
        FileInputStream fileInput = new FileInputStream("input4.txt");
        Scanner scnr = new Scanner(fileInput);
        int totalPairs = 0;
        int recievedInput = isNextContained(scnr);
        while(recievedInput > -1){
            totalPairs += recievedInput;
            recievedInput = isNextContained(scnr);
        }
        System.out.println(totalPairs);
    }
        /*grab line,
         * find and replace - and , with spaces
         * use nextInt() to grab each number
         * is f1 - 1 < s1 && f2 + 1 > s2? Return 1
         * else if 
         * is s1 - 1 < f1 && s2 + 1 > f2? Return 1
         * else
         * Return 0
         */

    //puzzle2
    public static int isNextContained(Scanner scnr){
        if(!scnr.hasNext()){
            return -1;
        }
        String inputString = scnr.nextLine();
        inputString = inputString.replace('-', ' ').replace(',', ' ');
        Scanner inputScanner = new Scanner(inputString);
        int elf1Low = inputScanner.nextInt();
        int elf1High = inputScanner.nextInt();
        int elf2Low = inputScanner.nextInt();
        int elf2High = inputScanner.nextInt();
        inputScanner.close();
        if(elf1Low - 1 < elf2Low && elf1High + 1 > elf2High){
            return 1;
        } else if (elf2Low - 1 < elf1Low && elf2High + 1 > elf1High){
            return 1;
        } else if (elf2Low - 1 < elf1Low && elf2High + 1 > elf1Low){
            return 1;
        } else if (elf2Low - 1 < elf1High && elf2High + 1 > elf1High){
            return 1;
        } else if (elf1Low - 1 < elf2Low && elf1High + 1 > elf2Low){
            return 1;
        } else if (elf1Low - 1 < elf2High && elf1High + 1 > elf2High){
            return 1;
        } 
        return 0;
    }

    //puzzle1
    /*public static int isNextContained(Scanner scnr){
        if(!scnr.hasNext()){
            return -1;
        }
        String inputString = scnr.nextLine();
        inputString = inputString.replace('-', ' ').replace(',', ' ');
        Scanner inputScanner = new Scanner(inputString);
        int elf1Low = inputScanner.nextInt();
        int elf1High = inputScanner.nextInt();
        int elf2Low = inputScanner.nextInt();
        int elf2High = inputScanner.nextInt();
        inputScanner.close();
        if(elf1Low - 1 < elf2Low && elf1High + 1 > elf2High){
            return 1;
        } else if (elf2Low - 1 < elf1Low && elf2High + 1 > elf1High){
            return 1;
        }
        return 0;
    }*/
}
