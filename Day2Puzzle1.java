import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Day2Puzzle1 {
    public static void main(String[] args) throws FileNotFoundException{
        FileInputStream fileInput = new FileInputStream("input2.txt");
        Scanner scnr = new Scanner(fileInput);
        String output = "";
        int totalPoints = 0;
        int returnedValue = nextMove(scnr, output);
        while(returnedValue > -1){
            totalPoints += returnedValue;
            System.out.println(" Current Score: " + totalPoints);
            returnedValue = nextMove(scnr, output);
        }
 
        
        System.out.println(totalPoints);
        scnr.close();

    }


    public static int nextMove(Scanner scnr, String outputString){
        int returnNumber = 0;    
        if(scnr.hasNext()){
            while(true){
                String inputString = scnr.nextLine();
                char opponent = inputString.charAt(0);
                char goal = inputString.charAt(2);
                int opponentNum = 0;
                int goalNum = 0;

                switch(opponent){
                    case 'A': opponentNum = 1;
                        break;
                    case 'B': opponentNum = 2;
                        break;
                    case 'C': opponentNum = 3;
                        break;
                }
                switch(goal){
                    case 'X': goalNum = 1;
                        break;
                    case 'Y': goalNum = 2;
                        break;
                    case 'Z': goalNum = 3;
                        break;
                }
                outputString += "Input: " + inputString + ". Goal: " + goal + goalNum + ". Opponent: " + opponent + opponentNum + ". ";

                //puzzle2
                if(goalNum == 3){
                    switch(opponentNum){
                        case 1: return 2 + 6; 
                        case 2: return 3 + 6; 
                        case 3: return 1 + 6; 
                    }
                } else if(goalNum == 2){
                    return opponentNum + 3;
                } else if(goalNum == 1){
                    switch(opponentNum){
                        case 1: return 3; 
                        case 2: return 1; 
                        case 3: return 2; 
                    }
                }

                //puzzle1
                /*if(playerNum == opponentNum){
                    outputString += "Draw.";
                    System.out.print(outputString);
                    return playerNum + 3;
                } else if (playerNum == 1 && opponentNum == 3){
                    outputString += "Player Wins.";
                    System.out.print(outputString);
                    return playerNum + 6;
                } else if (playerNum == 2 && opponentNum == 1){
                    outputString += "Player Wins.";
                    System.out.print(outputString);
                    return playerNum + 6;
                } else if (playerNum == 3 && opponentNum == 2){
                    outputString += "Player Wins.";
                    System.out.print(outputString);
                    return playerNum + 6;
                } else {
                    outputString += "Opponent Wins.";
                    System.out.print(outputString);
                    return playerNum;
                }*/
            }
        } else {
            if(returnNumber == 0){
                return -1;
            }
        }
        return returnNumber;
    }
}
