import java.util.*;

public class VendingMachine {

    static String[] products = {"Eau", "Soda", "Chips", "Chocolat"};
    static double[] prices = {5.0, 8.0, 12.0, 15.0};
    static int[] stock = {10, 5, 7, 3};

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue au Distributeur Automatique !");
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n=== Menu ===");
                System.out.println("1. Afficher les produits");
                System.out.println("2. Acheter un produit");
                System.out.println("3. Quitter");

                int choice = readInt("Choix (1-3) : ");

                switch (choice) {
                    case 1 -> afficherProduits();
                    case 2 -> acheterProduit();
                    case 3 -> {
                        System.out.println("Merci et à bientôt !");
                        running = false;
                    }
                    default -> System.out.println("Option invalide !");
                }
            } catch (Exception e) {
                System.out.println("Une erreur est survenue : " + e.getMessage());
            }
        }
        sc.close();
    }

    public static void afficherProduits() {
        System.out.println("\nProduits disponibles :");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " (" + prices[i] + " MAD) - Stock : " + stock[i]);
        }
    }

    public static void acheterProduit() {
        try {
            afficherProduits();
            int choix = readInt("Numéro du produit (1-" + products.length + ") : ");

            if (choix < 1 || choix > products.length) {
                System.out.println("Produit invalide !");
                return;
            }

            int index = choix - 1;

            if (stock[index] == 0) {
                System.out.println("Produit en rupture de stock !");
                return;
            }

            System.out.println("Prix : " + prices[index] + " MAD");
            double montant = readDouble("Montant inséré : ");

            if (montant < prices[index]) {
                System.out.println("Montant insuffisant ! Il manque " + (prices[index] - montant) + " MAD");
                return;
            }

            stock[index]--;
            double monnaie = montant - prices[index];

            System.out.println("\nAchat réussi !");
            System.out.println("Vous avez acheté : " + products[index]);
            if (monnaie > 0) {
                System.out.println("Votre monnaie : " + monnaie + " MAD");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'achat : " + e.getMessage());
        }
    }

    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Entrez un entier.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Entrez un nombre.");
            }
        }
    }
}
