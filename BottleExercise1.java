package bottleexercise1;

public class BottleExercise1 {

    /**
     * made by qubiak 
     * 
     * The program transfers liquid from one bottle to another,
     * checking if it is pospible, if it does not inform about the reason.
     */
    
    private double HowMenyLiters;
    final double maxLiters = 50;

    BottleExercise1(double HowManyLiters) {
        this.HowMenyLiters = HowManyLiters;
    }

    double getHowManyLiters() {
        return HowMenyLiters;
    }

    void PutIn(double Quantity) {
        if (CanIPutIn(Quantity)) {
            this.HowMenyLiters += HowMenyLiters;
        }
    }

    void PutOut(double Quantity) {
        if (CanIPutOut(Quantity)) {
            this.HowMenyLiters -= HowMenyLiters;
            System.out.println("Transfer " + Quantity + ". Left in the bottle " + HowMenyLiters);
        }
    }

    boolean CanIPutIn(double Quantity) {
        if (Quantity + HowMenyLiters > maxLiters) {
            System.out.println("I can't transfer. Maximum capacity of the bottle is " + maxLiters);
            return false;
        } else {
            return true;
        }
    }

    boolean CanIPutOut(double Quantity) {
        if (Quantity < HowMenyLiters) {
            return true;
        } else {
            System.out.println("I can't transfer, in the bottle are only " + HowMenyLiters + " liters");
            return false;
        }
    }

    void Transfer(double Quantity, BottleExercise1 WhereTransfer) {
        if (CanIPutOut(Quantity) && WhereTransfer.CanIPutIn(Quantity)) {
            this.HowMenyLiters -= Quantity;
            WhereTransfer.HowMenyLiters += Quantity;
        }
    }

    public static void main(String[] args) {
        BottleExercise1[] bottleExercise1 = new BottleExercise1[50];
        int a = 0;
        while (a < bottleExercise1.length) {
            bottleExercise1[a] = new BottleExercise1(a);
            a++;
        }

        System.out.println("Beafore transfer");
        System.out.println(bottleExercise1[10].getHowManyLiters());
        System.out.println(bottleExercise1[35].getHowManyLiters());

        bottleExercise1[10].Transfer(10, bottleExercise1[35]);

        System.out.println("Afetr transfer");
        System.out.println(bottleExercise1[10].getHowManyLiters());
        System.out.println(bottleExercise1[35].getHowManyLiters());

    }
}
