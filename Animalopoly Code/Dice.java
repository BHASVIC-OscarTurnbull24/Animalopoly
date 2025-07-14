import java.util.Random;


class Dice{

    //DECLARING VARIABLES

    private int dice1Val;
    private int dice2Val;
    private int totalDice;
    private boolean isDouble;


    public int diceRoll(){

        //METHOD TO ROLL DICE

        //generating random numbers, and assigning them to attributes
        dice1Val = (int) (Math.random() * 7);
        dice2Val = (int) (Math.random() * 7);

        //adding the dice together and returning this value
        totalDice = dice1Val + dice2Val;
        return totalDice;
    }

    public boolean checkDouble(int dice1, int dice2){

        //METHOD TO CHECK IF THE DICE ROLL ID A DOUBLE

        //initial declaration of the dice not being doubled
        isDouble = false;

        //checking if the dices have the same value
        if(dice1 == dice2){

            //set isDouble to true if they are the same value, and returning this attribute
            isDouble = true;
        }
        return isDouble;
    }




}