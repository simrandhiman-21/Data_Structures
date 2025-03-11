import java.util.*;

class tourProblem {
    static class PetrolPump {
        int petrol, distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of petrol pumps: ");
        int n = scanner.nextInt();
        PetrolPump[] pumps = new PetrolPump[n];

        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            System.out.print("Petrol at pump " + i + ": ");
            int petrol = scanner.nextInt();
            System.out.print("Distance to next pump from " + i + ": ");
            int distance = scanner.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }

        int start = findStartingPoint(pumps);
        System.out.println(start == -1 ? "No solution" : "Start at pump " + start);
        
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, deficit = 0, surplus = 0;

        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        return (surplus + deficit >= 0) ? start : -1;
    }

}
