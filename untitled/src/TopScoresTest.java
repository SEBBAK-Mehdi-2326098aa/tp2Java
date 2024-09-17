
public class TopScoresTest {

    public static void main(String[] args) {
        TopScores topScores = new TopScores();
        
        topScores.addScore(100);
        topScores.addScore(200);
        topScores.addScore(150);
        topScores.addScore(250);
        topScores.addScore(300);
        topScores.addScore(50);
        topScores.addScore(175);
        topScores.addScore(125);
        topScores.addScore(225);
        topScores.addScore(275);
        topScores.addScore(350);
        
        System.out.println("Top scores après ajout :");
        topScores.printScores();
        
        topScores.removeScore(150);
        
        System.out.println("Top scores après suppression de 150 :");
        topScores.printScores();
    }
}
