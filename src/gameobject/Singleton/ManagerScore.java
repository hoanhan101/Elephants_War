package gameobject.Singleton;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerScore {
    private static ManagerScore ourInstance = new ManagerScore();
    private static int Score1;
    private static int Score2;

    public static int getScore2() {
        return Score2;
    }

    public static void setScore2(int score2) {
        Score2 = score2;
    }

    public static int getScore1() {
        return Score1;
    }

    public static void setScore1(int score1) {
        Score1 = score1;
    }

    public static ManagerScore getInstance() {
        return ourInstance;
    }

    private ManagerScore() {
    }
}
