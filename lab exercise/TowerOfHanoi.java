public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 2; // Number of disks
        char source = 'A', auxiliary = 'B', destination = 'C';

        System.out.println("Steps to solve Tower of Hanoi with 2 disks:");
        towerOfHanoi(n, source, auxiliary, destination);
    }

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
}
