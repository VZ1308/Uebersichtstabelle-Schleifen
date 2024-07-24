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

        // Berechnung der Schrittweite für den Preis
        double preisSchrittweite = (oberesLimit - unteresLimit) / 10;

        // Ausgabe der nummerierten Liste
        System.out.println("Nummerierte Liste:");
        for (int stueck = 10; stueck <= 100; stueck += 10) {
            double aktuellerPreis = unteresLimit + (stueck / 10 - 1) * preisSchrittweite;
            System.out.printf("Stückzahl: %d - Einzelpreis: %.2f\n", stueck, aktuellerPreis);
        }

        scanner.close();
    }

    // Methode zur Validierung der Double-Eingabe
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
