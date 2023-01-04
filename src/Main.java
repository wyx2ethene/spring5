import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        String s = "name " + list + "score";
        System.out.println(s);
        System.out.println("Hello world!");
    }
}