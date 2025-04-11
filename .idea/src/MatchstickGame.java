import javax.swing.JOptionPane;


public class MatchstickGame {
    private int matchsticks;

    public MatchstickGame(int initialMatchsticks) {
        this.matchsticks = initialMatchsticks;

        // GAME LOOP WHOOM
        while (true) {
            playerTurn();
            if (matchsticks == 0) {
                showMessage("Computer won!!");
                break;
            }

            computerTurn();
            if(matchsticks <= 0) {
                showMessage("You won!");
                break;
            }
        }
    }

    private void playerTurn() {
        int taken = readValidInput("YOUR TURN : How many matchsticks do you want to take? (1-3) (Theres " + matchsticks + " left)");
        if (taken > matchsticks) {
            showMessage("You can't take more than what's left");
            playerTurn();
        } else {
            matchsticks -= taken;
            showMessage("You took " + taken + " matchsticks. You have " + matchsticks + " left");
        }
    }

    private void computerTurn () {
        int taken = calculateComputerMove();
        matchsticks -= taken;
        showMessage("Computer takes " + taken + " matchsticks. You have " + matchsticks + " left");


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
                showMessage("You cant leave the game like this");
                showMessage("We aint raising a quitter here");
                showMessage("You aint ever gonna get outta here AHAHHA");
                showMessage(" AHAAAAAAAAAAAAAAAAAAAAAAAAAHAHHAAH");
                continue;

                /*showMessage("Game cancelled, goodbye get cancerd");
                System.exit(0);*/
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
