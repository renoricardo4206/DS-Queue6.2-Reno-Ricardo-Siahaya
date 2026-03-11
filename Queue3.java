import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        // Panjang queuenya : 5 < n < 20
        if (n <= 5 || n >= 20) {
            System.out.println("Invalid input: queue length must be between 6 and 19");
            sc.close();
            return;
        }

        String[] names = sc.nextLine().split(" ");
        String[] chancesStr = sc.nextLine().split(" ");

        // Jumlah kesempatannya : 1 <= chances <= 10
        Queue<Object[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int chance = Integer.parseInt(chancesStr[i]);
            if (chance < 1 || chance > 10) {
                System.out.println("Invalid input: chances must be between 1 and 10");
                sc.close();
                return;
            }
            queue.add(new Object[]{names[i], chance});
        }

        // Proses queue
        while (!queue.isEmpty()) {
            Object[] student = queue.poll();
            String name = (String) student[0];
            int chances = (int) student[1];

            chances--;

            if (chances > 0) {
                System.out.println(name + "|Try Again|" + chances);
                queue.add(new Object[]{name, chances});
            } else {
                System.out.println(name + "|Get Out|" + chances);
            }
        }

        sc.close();
    }

}
