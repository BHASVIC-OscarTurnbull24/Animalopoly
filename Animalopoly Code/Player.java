public class Player {

    private char piece;
    private int playerNumber;
    private int money;
    private boolean missingTurn;
    private int boardPosition;
    private String playerColour;
    private String name;

    public Player(char thePiece, int thePlayerNumber, String theColour, String theName){
        piece = thePiece;
        playerNumber = thePlayerNumber;
        playerColour = theColour;
        name = theName;
        money = 1500;
        missingTurn = false;
        boardPosition = 0;
    }

    public void addMoney(int addedMoney){
        money += addedMoney;
    }

    public void subtractMoney(int subtractedMoney){
        money -= subtractedMoney;
    }

    public int getMoney(){
        return money;
    }

    public int getPosition(){
        return boardPosition;
    }

    public void setPosition(int newPosition){
        boardPosition = newPosition;
    }

    public void setMissingTurn(boolean newValue){
        missingTurn = newValue;
    }

    public boolean checkMissingTurn(){
        return missingTurn;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public boolean checkBankrupt(){
        if(money <0){
            return false;
        }
        return true;
    }


}
