package DZ6;

public class TestDZ6 {
    public static void main(String[] args) {
        String path = "files/words.txt";
        HandlerText hy = new HandlerText(path);

        hy.showAllWordAndCount();
        System.out.println("__________________________-");
        hy.showMaxCountWord();
    }
}
