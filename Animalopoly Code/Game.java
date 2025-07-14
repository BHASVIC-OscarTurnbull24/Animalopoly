import java.util.Scanner;

public class Game {


    private Animal[] animalArray = new Animal[24];
    private Player[] playerArray = new Player[4];
    private int numberOfPlayers;
    private Dice dice;
    private Board board;
    private Cards cards;

    public Game(){
        //Initialise animal array
        for(int i=0;i<24;i++){    //Very basic initialisation of the array just sets the animal's name to a number
            String strI = Integer.toString(i);
            animalArray[i] = new Animal(strI);
        }
        //end initialisation of animal array
        Scanner inputter = new Scanner(System.in);
        numberOfPlayers = -1;
        while(numberOfPlayers < 2 || numberOfPlayers > 4) { //Repeats until a valid number of players is entered
            System.out.println("Please input the number of players (2-4 players allowed)"); //Asks the player how many players are in the game

            String numberOfPlayersStr = inputter.nextLine();  //Takes the player's input as a string
            numberOfPlayers = Integer.parseInt(numberOfPlayersStr); //casts the string to an integer
        }


        if(numberOfPlayers == 2) {
            System.out.println("PLAYER 1: Please input the piece you want to use");
            char Player1Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 1: Please input the colour you want to use");
            String Player1Colour = inputter.nextLine();

            System.out.println("PLAYER 1: Please input the name you want to use");
            String Player1Name = inputter.nextLine();

            Player player1 = new Player(Player1Piece, 1, Player1Colour, Player1Name);


            System.out.println("PLAYER 2: Please input the piece you want to use");
            char Player2Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 2: Please input the colour you want to use");
            String Player2Colour = inputter.nextLine();

            System.out.println("PLAYER 2: Please input the name you want to use");
            String Player2Name = inputter.nextLine();

            Player player2 = new Player(Player2Piece, 2, Player2Colour, Player2Name);
            playerArray = new Player[]{player1, player2};

        }
          else if(numberOfPlayers == 3) {
            System.out.println("PLAYER 1: Please input the piece you want to use");
            char Player1Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 1: Please input the colour you want to use");
            String Player1Colour = inputter.nextLine();

            System.out.println("PLAYER 1: Please input the name you want to use");
            String Player1Name = inputter.nextLine();

            Player player1 = new Player(Player1Piece, 1, Player1Colour, Player1Name);


            System.out.println("PLAYER 2: Please input the piece you want to use");
            char Player2Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 2: Please input the colour you want to use");
            String Player2Colour = inputter.nextLine();

            System.out.println("PLAYER 2: Please input the name you want to use");
            String Player2Name = inputter.nextLine();

            Player player2 = new Player(Player2Piece, 2, Player2Colour, Player2Name);

            System.out.println("PLAYER 3: Please input the piece you want to use");
            char Player3Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 3: Please input the colour you want to use");
            String Player3Colour = inputter.nextLine();

            System.out.println("PLAYER 3: Please input the name you want to use");
            String Player3Name = inputter.nextLine();

            Player player3 = new Player(Player3Piece, 3, Player3Colour, Player3Name);
            playerArray = new Player[]{player1, player2, player3};
        }
            else if(numberOfPlayers == 4) {
            System.out.println("PLAYER 1: Please input the piece you want to use");
            char Player1Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 1: Please input the colour you want to use");
            String Player1Colour = inputter.nextLine();

            System.out.println("PLAYER 1: Please input the name you want to use");
            String Player1Name = inputter.nextLine();

            Player player1 = new Player(Player1Piece, 1, Player1Colour, Player1Name);


            System.out.println("PLAYER 2: Please input the piece you want to use");
            char Player2Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 2: Please input the colour you want to use");
            String Player2Colour = inputter.nextLine();

            System.out.println("PLAYER 2: Please input the name you want to use");
            String Player2Name = inputter.nextLine();

            Player player2 = new Player(Player2Piece, 2, Player2Colour, Player2Name);

            System.out.println("PLAYER 3: Please input the piece you want to use");
            char Player3Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 3: Please input the colour you want to use");
            String Player3Colour = inputter.nextLine();

            System.out.println("PLAYER 3: Please input the name you want to use");
            String Player3Name = inputter.nextLine();

            Player player3 = new Player(Player3Piece, 3, Player3Colour, Player3Name);

            System.out.println("PLAYER 4: Please input the piece you want to use");
            char Player4Piece = inputter.next().charAt(0);

            System.out.println("PLAYER 4: Please input the colour you want to use");
            String Player4Colour = inputter.nextLine();

            System.out.println("PLAYER 4: Please input the name you want to use");
            String Player4Name = inputter.nextLine();

            Player player4 = new Player(Player4Piece, 4, Player4Colour, Player4Name);
            playerArray = new Player[]{player1, player2, player3, player4};
        }

            else{
            System.out.println("Invalid number of players");
        }


        board = new Board(numberOfPlayers, animalArray);  //Instantiates a board object with the animal array and number of player's as parameters
        dice = new Dice();
        cards = new Cards();

        int i = 0;

        while(numberOfPlayers >= 1){
            takePlayerTurn(playerArray[i],i);
            i++;
            if(i >= numberOfPlayers){
                i = 0;
            }

        }


        }



    public void takePlayerTurn(Player currentPlayer, int index){
        if(!currentPlayer.checkMissingTurn()) {
            int diceRoll = dice.diceRoll();
            board.movePlayer(currentPlayer, diceRoll);
            if (currentPlayer.checkBankrupt()) {
                numberOfPlayers--;
                for(int i=index;i<numberOfPlayers;i++){
                    if(i <= numberOfPlayers -1){
                        playerArray[i] = playerArray[i+1];
                    }
                    else{
                        playerArray[i] = null;
                    }
                }


            }
        }
        else{
            currentPlayer.setMissingTurn(false);
        }
    }





}
