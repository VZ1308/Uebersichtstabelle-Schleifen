import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Eingabe und Überprüfung des unteren Preislimits
        double unteresLimit = getValidDouble(scanner, "Bitte geben Sie das untere Preislimit ein: ");

        // Eingabe und Überprüfung des oberen Preislimits
        double oberesLimit;
        while (true) {
            oberesLimit = getValidDouble(scanner, "Bitte geben Sie das obere Preislimit ein: ");
            if (oberesLimit > unteresLimit) {
                break;
            } else {
                System.out.println("Fehler: Das obere Preislimit muss größer als das untere Preislimit sein.");
            }
        }
        
        double preisSchrittweite = (oberesLimit - unteresLimit) / 10;
        int[] stueckzahlen = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Ausgabe der Kopfzeile für Einzelpreise
        System.out.print("Stk/Einzelpreis\n");
        for (int i = 0; i <= 10; i++) {
            double einzelPreis = unteresLimit + i * preisSchrittweite;
            System.out.printf("     %.2f\t", einzelPreis);
        }
        System.out.println();

        // Ausgabe der Tabelle
        for (int stueck : stueckzahlen) {
            System.out.print(stueck + "\t");
            for (int i = 0; i <= 10; i++) {
                double einzelPreis = unteresLimit + i * preisSchrittweite;
                double gesamtPreis = einzelPreis * stueck;
                System.out.printf("%.2f\t\t", gesamtPreis);
            }
            System.out.println();
        }

        scanner.close();
    }

    // Methode zur Validierung der Eingabe eines gültigen Double-Werts
    public static double getValidDouble(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                scanner.nextLine(); // Puffer leeren
                return number;
            } else {
                System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine(); // Ungültige Eingabe aus dem Puffer entfernen
            }
        }
    }
}
