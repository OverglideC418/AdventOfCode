import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Day5Puzzle {
    public static void main(String[] args) throws FileNotFoundException{
        FileInputStream fileInput = new FileInputStream("input5.txt");
        Scanner scnr = new Scanner(fileInput);
        ArrayList<ArrayList<Character>> list = makeArray(scnr);

        scnr.nextLine();
        scnr.nextLine();

        printList(list);
        ArrayList<ArrayList<Character>> recievedList = nextAction(scnr, list);
        boolean runNextAction = true;
        try {
            if(recievedList.get(0).get(0) == '!'){
                runNextAction = false;
            } else { 
                runNextAction = true;
            }
        } catch (Exception exception) {
            runNextAction = true;
        }
        while(runNextAction){
            recievedList = nextAction(scnr, list);
            try {
                if(recievedList.get(0).get(0) == '!'){
                    runNextAction = false;
                } else { 
                    runNextAction = true;
                }
            } catch (Exception exception) {
                runNextAction = true;
            }
        }
        System.out.println("Final List: ");
        printList(recievedList);
    }

    public static void printList(ArrayList<ArrayList<Character>> list){
        for(int i = 0; i < list.size(); ++i){
            System.out.print("Index: " + (i + 1) + " ");
            for (int j = 0; j < list.get(i).size(); ++j){
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<ArrayList<Character>> makeArray(Scanner scnr){
        ArrayList<String> inputStrings = new ArrayList<String>();
        ArrayList<ArrayList<Character>> outputList = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < 9; ++i){
            ArrayList<Character> nextList = new ArrayList<Character>();
            outputList.add(nextList);
        }
        for(int i = 0; i < 8; ++i){
            inputStrings.add(0, scnr.nextLine());
        }
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 8; ++j){
                if(inputStrings.get(j).charAt(i*4 + 1) == ' '){
                    break;
                } else {
                    outputList.get(i).add(inputStrings.get(j).charAt(i*4 + 1));
                }
            }
        }

        //first index (i) is column number, second index (j) is location in list


        return outputList;
    }

    public static ArrayList<ArrayList<Character>> nextAction(Scanner scnr, ArrayList<ArrayList<Character>> list){
        if(!scnr.hasNext()){
            ArrayList<Character> tempList = new ArrayList<Character>(Arrays.asList('!'));
            ArrayList<ArrayList<Character>> tempOutput = new ArrayList<ArrayList<Character>>(Arrays.asList(tempList));
            return tempOutput;
        }
        String nextInstruction = scnr.nextLine().replace(" ", "").replace("move", "").replace("from", " ").replace("to", " ");
        Scanner dataFinder = new Scanner(nextInstruction);
        int numCrates = dataFinder.nextInt();
        int startColumn = dataFinder.nextInt() - 1;
        int endColumn = dataFinder.nextInt() - 1;
        dataFinder.close();
        for(int i = 0; i < numCrates; ++i){
            list.get(endColumn).add(list.get(endColumn).size() - i, list.get(startColumn).get(list.get(startColumn).size() - 1));
            list.get(startColumn).remove(list.get(startColumn).size() - 1);
        }
        printList(list);

        return list;
    }

    /* 
     * make a 2D char array
     * grab the first 8 lines and store them in variables
     * and an ArrayList of 8 Strings, adding each new string at index 0
     * 
     * loop 9 times{
     * for (length of StringsList)
        * if StringsList.get(i).(charAt i*4 + 1 != ' '), then List.get(i).add(charAt i*4 + 1)
        * else break;
     * 
     * 
     * 
     * }
     * ---------------------------
     * numCrates, startColumn, endColumn
     * for numCrates{ 
     * add to outputList.get(endColumn).add(outputlist.get(startColumn).get(outputlist.get(startColumn).size() - 1))
     * outputList.get(startColumn).remove(outputlist.get(startColumn).size() - 1))
     * }
     * 
     * 
     * 
     * 
     * 
     * 
     */

}
