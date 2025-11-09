import java.util.Scanner;

/**
 * VendingMachine.java
 * Programme simple pour simuler le fonctionnement d'un distributeur automatique.
 * Conçu pour être compréhensible par un débutant.
 */
public class VendingMachine {

    // Données du distributeur (produits, prix et stock)
    static String[] products = {"Eau", "Soda", "Chips", "Chocolat"};
    static double[] prices = {5.0, 8.0, 12.0, 15.0};
    static int[] stock = {10, 5, 7, 3};

    // Scanner partagé pour la lecture depuis la console
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue au Distributeur Automatique !");
        boolean running = true;

        // Boucle principale du menu
        while (running) {
            showMenu();
            int choice = readInt("Choix (1-3) : ");

            switch (choice) {
                case 1:
                    afficherProduits();
                    break;
                case 2:
                    acheterProduit();
                    break;
                case 3:
                    System.out.println("Merci et à bientôt !");
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide. Choisissez 1, 2 ou 3.");
            }

            System.out.println(); // ligne vide pour aérer
        }

        sc.close();
    }

    // Affiche le menu principal
    public static void showMenu() {
        System.out.println("=== Distributeur Automatique ===");
        System.out.println("1. Afficher les produits");
        System.out.println("2. Acheter un produit");
        System.out.println("3. Quitter");
    }

    // Affiche la liste des produits, leurs prix et le stock restant
    public static void afficherProduits() {
        System.out.println("\nProduits disponibles :");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s (%.0f MAD) - Stock : %d%n",
                    i + 1, products[i], prices[i], stock[i]);
        }
    }

    // Processus d'achat
    public static void acheterProduit() {
        afficherProduits();
        int choixProduit = readInt("Entrez le numéro du produit (1-" + products.length + ") : ");

        // Validation du choix
        if (choixProduit < 1 || choixProduit > products.length) {
            System.out.println("Produit invalide !");
            return;
        }

        int index = choixProduit - 1;

        // Vérification du stock
        if (!verificationDuStock(index)) {
            System.out.println("Produit en rupture de stock !");
            return;
        }

        System.out.printf("Prix du produit : %.0f MAD%n", prices[index]);
        double montantInsere = readDouble("Entrez le montant inséré (MAD) : ");

        // Vérifier le montant
        if (!verificationDuPrix(index, montantInsere)) {
            double manque = prices[index] - montantInsere;
            System.out.printf("Montant insuffisant ! Il manque %.0f MAD%n", manque);
            return;
        }

        // Décrémenter le stock
        stock[index]--;

        // Calculer et afficher la monnaie rendue si nécessaire
        double monnaie = monnaieRendue(montantInsere, prices[index]);

        System.out.println("\nAchat réussi !");
        System.out.printf("Vous avez acheté : %s%n", products[index]);
        if (monnaie > 0.0) {
            System.out.printf("Votre monnaie : %.0f MAD%n", monnaie);
        }
    }

    // Vérifie s'il y a du stock pour l'index donné
    public static boolean verificationDuStock(int index) {
        return stock[index] > 0;
    }

    // Vérifie si le montant inséré est suffisant
    public static boolean verificationDuPrix(int index, double montant) {
        return montant >= prices[index];
    }

    // Calcule la monnaie rendue
    public static double monnaieRendue(double montant, double prixProduit) {
        return montant - prixProduit;
    }

    // Lit un entier (avec message) et gère les erreurs d'entrée
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    // Lit un double (avec message) et gère les erreurs d'entrée
    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre (ex : 10 ou 10.5).");
            }
        }
    }
}
