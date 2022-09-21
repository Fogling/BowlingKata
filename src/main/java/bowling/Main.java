package bowling;

public class Main {
    public static void main(String[] args) {
        CountingSystem countingSystem = new CountingSystem();

        countingSystem.calcGameScore("X 3/ 5- 7/ -2 33 X X 4- 6/ X");
        countingSystem.calcGameScore("2/ X -- 4/ 5- X 34 71 5/ X 3/");
        countingSystem.calcGameScore("-- -- -- -- -- -- -- -- -- --");
        countingSystem.calcGameScore("X X X X X X X X X X X X");

        //countingSystem.calcGameScore("HIER WUNSCHBAHN EINFÜGEN");
        //countingSystem.calcGameScore("HIER WUNSCHBAHN EINFÜGEN");
    }
}
