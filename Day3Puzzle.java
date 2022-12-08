import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Day3Puzzle {
    public static void main(String[] args) throws FileNotFoundException{
        FileInputStream fileInput = new FileInputStream("input3.txt");
        Scanner scnr = new Scanner(fileInput);
        int priority = 0;
        int returnedValue = nextBag(scnr);
        while(returnedValue > -1){
            priority += returnedValue;
            returnedValue = nextBag(scnr);
        }
 
        System.out.println("Output: " + priority);
        scnr.close();
    }

    public static int nextBag(Scanner scnr){
        if(scnr.hasNext()){
            char sameCharacter = '_';

            //puzzle2
            String bag1Contents = scnr.nextLine();
            String bag2Contents = scnr.nextLine();
            String bag3Contents = scnr.nextLine();

            for(int i = 0; i < bag1Contents.length(); ++i){
                if(bag2Contents.contains("" + bag1Contents.charAt(i)) && bag3Contents.contains("" + bag1Contents.charAt(i))){
                    sameCharacter = bag1Contents.charAt(i);
                    break;
                }
            }



            //puzzle1
            /*String bagContents = scnr.nextLine();
            String pocket1 = bagContents.substring(0, bagContents.length() / 2);
            String pocket2 = bagContents.substring(bagContents.length() / 2, bagContents.length());
            
            
            for(int i = 0; i < pocket1.length(); ++i){
                if(pocket2.contains("" + pocket1.charAt(i))){
                    sameCharacter = pocket1.charAt(i);
                    break;
                }
            }*/


            if((int)sameCharacter > 96){
                System.out.println((int)sameCharacter - 96);
                return (int)sameCharacter - 96;
            } else {
                System.out.println((int)sameCharacter - 38);
                return (int)sameCharacter - 38;
            }
        } else {
            return -1;
        }
    }
}
