
import java.util.Scanner;
public class HOUS {




    // mettre à jour le stock

    public static int updateStock(int StockActuel, int quantiteVendue) {



        return StockActuel - quantiteVendue;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(" Déposez le prix ");
        int MonneyDonné= scan.nextInt();
        int prix= 10;
        int restantRendu= (MonneyDonné-prix);
        int restantCmplter=(prix-MonneyDonné);

        if (MonneyDonné> prix){
            System.out.println(" Attendez, je te rends:"+ restantRendu +"Dh");
        }
        else if (MonneyDonné<prix){
            System.out.println(" Montant n'est pas suffissant, il reste:"+ restantCmplter +"Dh");
        }
           else {
            System.out.println(MonneyDonné+"est exact attendez votre produit");
        }
        int stockInitial = 25;
        int ajout = 20;

        int stockFinal = updateStock(stockInitial, ajout);

        System.out.println("Stock mis à jour : " + stockFinal);



    }

//    Calcul du rend du monnai



}



