public class AppFacto {
    public int Compute(String type, String name, String beverage, String size, String dessert, String dsize, String coffee) {
        // prix total à payer pour le client
        int total = 0;

        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (type == null || name == null || type.isEmpty() || name.isEmpty()) return -1;

        // Calculer le prix de base selon le type de repas
        total += getBasePrice(type);

        // Calculer le prix de la boisson
        total += getBeveragePrice(size);

        // Calculer le prix du dessert
        total += getDessertPrice(dsize, size, type);

        // Vérifier la condition spéciale pour l'assiette, taille moyenne, dessert normal et café
        if (type.equals("assiette") && size.equals("moyen") && dsize.equals("normal") && coffee.equals("yes")) {
            System.out.print(" avec café offert!");
        } else {
            // Assume coffee costs 1 unit, adding to the total only if coffee is not included
            if (!coffee.equals("yes")) {
                total += 1;
            }
        }

        return total;
    }


    private int getBasePrice(String type) {
        if (type.equals("assiette")) {
            return 15;
        } else {
            return 10;
        }
    }

    private int getBeveragePrice(String size) {
        switch (size) {
            case "petit":
                return 2;
            case "moyen":
                return 3;
            case "grand":
                return 4;
            default:
                return 0;
        }
    }

    private int getDessertPrice(String dsize, String size, String type) {
        int dessertPrice = 0;

        if (dsize.equals("normal")) {
            dessertPrice = 2;
        } else {
            dessertPrice = 4;
        }

        if (type.equals("assiette")) {
            if (size.equals("moyen") && dsize.equals("normal")) {
                System.out.print("Prix Formule Standard appliquée ");
                return 3; // Reset to standard price
            } else if (size.equals("grand") && dsize.equals("special")) {
                System.out.print("Prix Formule Max appliquée ");
                return 6; // Reset to max price
            }
        } else {
            if (size.equals("moyen") && dsize.equals("normal")) {
                System.out.print("Prix Formule Standard appliquée ");
                return 3; // Reset to standard price
            } else if (size.equals("grand") && dsize.equals("special")) {
                System.out.print("Prix Formule Max appliquée ");
                return 6; // Reset to max price
            }
        }

        return dessertPrice;
    }

}
