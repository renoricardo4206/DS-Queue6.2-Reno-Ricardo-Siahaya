import java.util.*;

public class DiamondHeights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input 
        System.out.println("Masukkan jumlah Pengunjung : ");
        int totalVisitors = scanner.nextInt();
        scanner.nextLine(); // buang sisa newline setelah nextInt()

        // Validasi jumlah pengunjung: 1 < n < 1000
        if (totalVisitors <= 1 || totalVisitors >= 1000) {
            System.out.println("Invalid: jumlah pengunjung harus antara 2 dan 999");
            scanner.close();
            return;
        }

        System.out.println("Nama pengunjung : ");
        String[] nameList  = scanner.nextLine().split(", ");
        System.out.println("Jumlah uang masing-masing pengunjung: ");
        String[] moneyList = scanner.nextLine().split(", ");

        List<int[]> visitorList = new ArrayList<>();
        List<String> visitorNames = new ArrayList<>();

        for (int i = 0; i < totalVisitors; i++) {
            int money = Integer.parseInt(moneyList[i].trim());
            String name = nameList[i].trim();

            // Validasi jumlah uang: 1 < money < 100
            if (money <= 1 || money >= 100) {
                System.out.println("Invalid: jumlah uang harus antara 2 dan 99");
                scanner.close();
                return;
            }

            visitorNames.add(name);
            visitorList.add(new int[]{i, money});
        }

        visitorList.sort((visitorA, visitorB) -> visitorB[1] - visitorA[1]);

        //Masukkan ke Queue sesuai hasil sorting
        Queue<String> parkQueue = new LinkedList<>();
        for (int[] visitor : visitorList) {
            int originalIndex = visitor[0];
            parkQueue.add(visitorNames.get(originalIndex));
        }

        //  Output
        System.out.println(parkQueue.toString());

        scanner.close();
    }
}