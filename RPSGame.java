
public class RPSGame implements Game
{
    // instance variables - replace the example below with your own
    Player pOne;
    Player pTwo;
    int numPlayers;
   

    /**
     * Constructor for objects of class RPS
     */
    public RPSGame()
    {
        // initialise instance variables
        numPlayers = determineNumberPlayers();
        
        playGame();
    }
    
    
    public void playGame() {
        setPlayers();
        while(continueGame()) {
            pOne.setChoice(pOne.getCPU());
            pTwo.setChoice(pTwo.getCPU());
            int win  = comparePlayers(pOne, pTwo);
            //Print results
            System.out.println(pOne+ "\n" + pTwo); //toString in RPSPlayer
            
            updateScore(win);
            System.out.println("The score for " + pOne.getName() + " is: " + pOne.getScore());
            System.out.println("The score for " + pTwo.getName() + " is: " + pTwo.getScore());
            System.out.println();
        }
        System.out.println();
        System.out.println("Thank you for playing.  The final score is: \n" + pOne.getName() + ":\t" + pOne.getScore());
        System.out.println(pTwo.getName()+ ": \t" + pTwo.getScore());
        
    }
    
    public void setPlayers() {
        
         if (numPlayers == 1) {
            pOne = new RPSPlayer(false); //human player
            pTwo = new RPSPlayer(true); //cpu
        }
        else {
            pOne = new RPSPlayer(false); //human player 1
            pTwo = new RPSPlayer(false); //human player 2
        }
    }
    
     /**
     * Returns 1 or 2 based on how many players are playing RPS
     */
    public int determineNumberPlayers() {
        System.out.println("How many players: ");
        numPlayers = scan.nextInt();
        return numPlayers;
    }
    
    /**
     * Compare player values and return 1 for p1 win, 0 for tie & -1 for loss
     */
    public int comparePlayers(Player p1, Player p2) {
        if(pOne.getChoice().equals(pTwo.getChoice())) {
            //tie
            return 0;
        }
        else if(pOne.getChoice().equals("rock") && pTwo.getChoice().equals("scissors")) {
            return 1;
        }
        else if(pOne.getChoice().equals("rock") && pTwo.getChoice().equals("paper")) {
            return 2;
        }
        else if(pOne.getChoice().equals("paper") && pTwo.getChoice().equals("scissors")) {
            return 2;
        }
        else if(pOne.getChoice().equals("paper") && pTwo.getChoice().equals("rock")) {
            return 1;
        }
        else if(pOne.getChoice().equals("scissors") && pTwo.getChoice().equals("rock")) {
            return 2;
        }
        else if(pOne.getChoice().equals("scissors") && pTwo.getChoice().equals("paper")) {
            return 1;
        }
        else {
            return 0;
        }
    }
    
    /**
     * Update score based on who wins. Winner will be 1 for player 1 win, 0 for tie and -1 for player 2 win
     */
    public void updateScore(int winner) {
       
    }
    
    /**
     * Ask to continue and return true for yes
     */
    public boolean continueGame() {
        
        return false;
    }

}
