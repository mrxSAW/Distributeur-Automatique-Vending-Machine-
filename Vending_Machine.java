
static String[] products = {"Eau","Soda","Chips","Chocolat"};
static double[] prix = {5.0,8.0,12.0,15.0};
static int[] stock = {10,5,7,3};
static Scanner sc = new Scanner(System.in);

public static boolean vérification_du_stock(int index){
    if (index >= 0 && index < stock.length) {
        return stock[index] > 0;
    }
    return false;
        }
public static boolean vérification_du_prix(int index, double montant){
    if (index >= 0 && index < prix.length) {
        return montant >= prix[index];
    }
    return false;
}
public static void menu(){
    System.out.println( "=== Distributeur Automatique ===");
    System.out.println( "\t 1. Afficher les produits");
    System.out.println( "\t 2. Acheter un produit");
    System.out.println("\t 3. Quitter\n\n" );
}
public static short get_choice(String message){
    System.out.print(message + " ");
    short choice = sc.nextShort();
    return choice;
}
public static void products(){
    System.out.println("Produits disponibles :");
    System.out.println("\t1. Eau (5 MAD) - Stock : 10");
    System.out.println("\t2. Soda (8 MAD) - Stock : 5");
    System.out.println("\t3. Chips (12 MAD) - Stock : 7");
    System.out.println("\t4. Chocolat (15 MAD) - Stock : 3");
}
public static double monnaieRendue(double montant, double prixProduit) {
    return montant - prixProduit;
}
public static void acheter() {

    int choixProduit = get_choice("Entrez le numéro du produit (1-4) :");

    if (choixProduit < 1 || choixProduit > products.length) {
        System.out.println("Produit invalide !");
        return;
    }

    int index = choixProduit - 1;

    if (!vérification_du_stock(index)) {
        System.out.println("Produit en rupture de stock !");
        return;
    }

    System.out.printf("Prix du produit : %.0f MAD\n", prix[index]);
    double montant = get_choice("Entrez le montant inséré (MAD) :");

    if (!vérification_du_prix(index, montant)) {
        System.out.printf("Montant insuffisant ! Il manque %.0f MAD\n",
                prix[index] - montant);
        return;
    }


    stock[index]--;
    double monnaie = monnaieRendue(montant, prix[index]);

    System.out.println("\nAchat réussi !");
    System.out.printf("Vous avez acheté : %s\n", products[index]);
    if (monnaie > 0) {
        System.out.printf("Votre monnaie : %.0f MAD\n", monnaie);
    }
}
void main() {
    boolean continuer = true;

    System.out.println("Bienvenue au Distributeur Automatique !");

    while (continuer) {
        menu();
        int choix = get_choice("Choisissez une option :");

        switch (choix) {
            case 1:
                products();
                break;

            case 2:
                acheter();
                break;

            case 3:
                System.out.println("\nMerci et à bientôt !");
                continuer = false;
                break;

            default:
                System.out.println("Option invalide ! Choisissez 1, 2 ou 3.");
        }
    }

    sc.close();

}

