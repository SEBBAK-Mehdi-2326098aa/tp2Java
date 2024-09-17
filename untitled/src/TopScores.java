
import java.util.LinkedList;

public class TopScores {
    private static final int MAX_SCORES = 10;
    private LinkedList<Integer> scores;

    public TopScores() {
        this.scores = new LinkedList<>();
    }

    public void addScore(int score) {
        if (scores.size() < MAX_SCORES) {
            scores.add(score);
            scores.sort((a, b) -> b - a); // Trier en ordre décroissant
        } else if (score > scores.getLast()) {
            scores.removeLast();
            scores.add(score);
            scores.sort((a, b) -> b - a); // Trier en ordre décroissant
        }
    }

    public boolean removeScore(int score) {
        return scores.remove((Integer) score);
    }

    public void printScores() {
        System.out.println("Top Scores:");
        for (int score : scores) {
            System.out.println(score);
        }
    }

    public static void main(String[] args) {
        TopScores topScores = new TopScores();
        
        // Ajouter des scores
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
        
        topScores.printScores();
        
        topScores.removeScore(150);
        
        // Afficher les scores après suppression
        System.out.println("Scores après suppression de 150:");
        topScores.printScores();
    }
}
