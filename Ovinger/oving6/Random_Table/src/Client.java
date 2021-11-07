import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input how many numbers you want to generate");
        int size = in.nextInt();
        Table table = new Table(size);

        table.getTable();
        table.display();

        System.out.println(table);
        System.out.println(table.toString());
    }
}
