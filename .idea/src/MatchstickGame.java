import javax.swing.JOptionPane;


public class MatchstickGame {
    private int matchsticks;

    public MatchstickGame(int initialMatchsticks) {
        this.matchsticks = initialMatchsticks;
    }

    private void playerTurn() {

    }

    private void computerTurn () {

    }

    private int calculateComputerMove() {               //simple modulo calc, determines how many matchsticks computer yoinks
        int move = matchsticks % 4;
        if (move == 0 || move > 3) move = 3;
        return move;
    }

    private int readValidInput(String message) {        //handles the input and validates it (exception handling man)
        while(true) {
            String input = JOptionPane.showInputDialog(null, message);
            if (input == null) {
                showMessage("You cancelled the input, Try again :)");
                continue;
            }
            try {
                int value = Integer.parseInt(input);
                if (value >=1 && value <= 3) return value;
                else showMessage("Please, I beg you. You had ONE job.. Enter a number between 1 and 3");
            } catch (NumberFormatException e) {
                showMessage("Not a valid number man, try again");
            }
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        new MatchstickGame(18);
    }

}
