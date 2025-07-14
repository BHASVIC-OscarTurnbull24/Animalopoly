import java.util.Scanner;

public class Board {
    private String[][] board = new String[26][3]; //Declares the board as a 2D array of Strings
    private boolean passedStart; //Declares the passedStart attribute as a boolean
    private Animal[] animalArray = new Animal[24];

    public Board(int numberOfPlayers, Animal[] theAnimalArray) { //The constructor for the Board class
        switch (numberOfPlayers) { //Switch statement which begins the game with a different number of players depending on how many are in the game
            case 2:
                board[0][0] = "1,2"; //If there are 2 players, inserts player numbers 1 and 2 into the player positions column of the start space in the board array
                break;
            case 3:
                board[0][0] = "1,2,3"; //If there are 3 players, inserts player numbers 1, 2 and 3 into the player positions column of the start space in the board array
                break;
            case 4:
                board[0][0] = "1,2,3,4"; //If there are 4 players, inserts player numbers 1, 2, 3 and 4 into the player positions column of the start space in the board array
                break;
            default:
                System.out.println("Invalid number of player's entered");
                break;
        }
        System.out.println(board[0][0]);


        for (int i = 0; i < 26; i++) { //Iterates through all spaces in the board to initialise their space type
            if (i == 0) { // The first space is the start space so gains the space type Special and the name Start
                board[i][1] = "Special";
                board[i][2] = "Start";
            } else if (i == 13) { // The thirteenth space is the miss a turn space so gains the space type Special and the name Start
                board[i][1] = "Special";
                board[i][2] = "Miss a turn";
            } else { //All other spaces are animal spaces so gain the space type Board.Animal and the name will be the specific animal name
                board[i][1] = "Board.Animal";
                if (i < 13) { //
                    int index = i - 1;
                    board[i][2] = theAnimalArray[index].getName();
                } else {
                    int index = i - 2;
                    board[i][2] = theAnimalArray[index].getName();
                }
            }
        }
        passedStart = false;
        animalArray = theAnimalArray;
    }

    public void movePlayer(Player currentPlayer, int numberOfSpaces) {
        passedStart = false; //Initialises passedStart as false as the player has not yet passed start
        int position = currentPlayer.getPosition(); //Gets the position of the space the player already was on
        String playersOnSpace = board[position][0]; //Gets the current players string from the board from the space the player is on
        int indexOfPlayer = playersOnSpace.indexOf(Integer.toString(currentPlayer.getPlayerNumber())); //Gets the index of the current player's player number in the string

        if (indexOfPlayer != 0) { //If the index is not 0 which means that the player's number is not the first in the list so the comma before it must be deleted as well
            deleteElement(playersOnSpace, indexOfPlayer - 1); //deletes the comma before the player number
            indexOfPlayer--;
            deleteElement(playersOnSpace, indexOfPlayer); //deletes the player number
        } else if (playersOnSpace.length() > 1) { //the player's player number is the first in the list but it is not the only one in the list
            deleteElement(playersOnSpace, indexOfPlayer + 1); //deletes comma after the player number
            deleteElement(playersOnSpace, indexOfPlayer); //deletes the player number
        } else { //the player's player number is the only one in the list so there are also no commas
            deleteElement(playersOnSpace, indexOfPlayer); //deletes the player number
        }

        board[position][0] = playersOnSpace; //Updates the board to match the updated string

        position += numberOfSpaces; //adds the dice roll to the player position

        if (position > 25) { //if the position is greater than 25 then they have looped around the board and passed Start so their position must be set back to 0
            position -= 26;
            passedStart = true;
        }

        int length;
        playersOnSpace = board[position][0]; //gets the current players string for the new board position
        if(playersOnSpace == null){
            length = 0;
        }
        else {
            length = playersOnSpace.length();
        }



        if (length > 0) { //if the length is greater than 0 then there is multiple player on the space so the new player number must be added with a comma
            playersOnSpace = playersOnSpace.concat("," + Integer.toString(currentPlayer.getPlayerNumber()));
        } else { // if the length is 0 then the player number can be added by itself
            playersOnSpace = Integer.toString(currentPlayer.getPlayerNumber());
        }

        board[position][0] = playersOnSpace; //updates the position on the board

        currentPlayer.setPosition(position); //set's the player position attribute in the player to the new updated position


        if (board[position][1].equals("Board.Animal")) { //if the player lands on an animal space
            if (passedStart == true) { //if the player passed start add 500 to money
                currentPlayer.addMoney(500);
            }

            Animal currentAnimal = null;
            for (int j = 0; j < 24; j++) { //Loops through the animal array and find the animal which is the same as the one which has been landed on
                if (animalArray[j].getName().equals(board[position][2])) {
                    currentAnimal = animalArray[j];
                }
            }

            assert currentAnimal != null;
            currentAnimal.landed(currentPlayer); //does the landed method in the animal object which asks does the relevant actions
        } else if (board[position][2].equals("Start")) { //if the player lands on the start space add 1000 to their money
            currentPlayer.addMoney(1000);
        } else { //if they did not land on a start or animal space then they must have landed on a miss a turn space
            if (passedStart == true) { //if they passed start add 500 to their money
                currentPlayer.addMoney(500);
            }
            currentPlayer.setMissingTurn(true); //since they landed on a miss a turn space then do the missNextTurn method inside of the player object
        }


    }

    private void deleteElement(String players, int index) {
        players = players.substring(0, index) + players.substring(index + 1);

    }
}


