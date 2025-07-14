public class Animal {
    private String name;

    public Animal(String theName) {
        name = theName;
    }

        public String getName () {
            return name;
        }

        public void landed (Player currentPlayer){
            currentPlayer.addMoney(0);
        }

}