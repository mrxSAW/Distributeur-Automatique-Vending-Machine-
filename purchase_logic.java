public class Main {
   static  int[] stocks = {10,5,7,3};

    public static Boolean vérification_du_stock( int stock , int produitindex){
      return stock > stocks[produitindex] || stock <= 0 ? false: true;
    }

    public static boolean vérification_du_prix( int prix , int produitprix ){
        return  prix == produitprix ? true : false;
    }




    public static void main(String[] args) {



    }
}