package bottleexercise2;

public class BottleExercise2 {

    /**
     * made by qubiak
     *
     * The program transfers liquid from one bottle to another, checking if it
     * is pospible, If need program reduces quantiti of fluid in two cases -
     * when it is to much or not enough.
     *
     */
    private double HowMenyLiters;
    final double maxLiters = 50;

    BottleExercise2(double HowManyLiters) {
        this.HowMenyLiters = HowManyLiters;
    }

    double getHowManyLiters() {
        return HowMenyLiters;
    }

    double HowMuchLeft() {
        double HowMuchLeft = maxLiters - this.getHowManyLiters();
        return HowMuchLeft;
    }

    boolean PutIn(double Quantity) {
        if (this.HowMenyLiters + Quantity <= maxLiters) {
            this.HowMenyLiters += Quantity;
            return true;
        } else {
            System.out.println("Not enought space in the bottle to pour everything, I only poured " + this.HowMuchLeft());
            this.HowMenyLiters += this.HowMuchLeft();
            return false;
        }
    }

    boolean PutOut(double Quantity) {
        if (Quantity <= this.HowMenyLiters) {
            this.HowMenyLiters -= Quantity;
            return true;
        } else {
            System.out.println("Not enought liquid in the bottle, I only poutrd " + this.HowMenyLiters);
            this.HowMenyLiters -= HowMenyLiters;
            return false;
        }
    }

    boolean HowMuchCanBePouren(double Quantity) {
        if (Quantity + HowMenyLiters > maxLiters) {
            return false;
        } else {
            return true;
        }
    }

    void Transfer(double Quantity, BottleExercise2 WhereTransfer) {
        if (Quantity <= WhereTransfer.HowMuchLeft()) {
            if (Quantity <= this.HowMenyLiters) {
                System.out.println("Transfer " + Quantity);
                this.PutOut(Quantity);
                WhereTransfer.PutIn(Quantity);
            } else {
                System.out.println("Transfer only " + this.HowMenyLiters + " not enought liquit to transfer more");
                double HowManyTransfer = this.HowMenyLiters;
                this.PutOut(HowManyTransfer);
                WhereTransfer.PutIn(HowManyTransfer);
            }
        } else {
            if (Quantity <= this.HowMenyLiters) {
                this.PutOut(WhereTransfer.HowMuchLeft());
                WhereTransfer.PutIn(this.HowMuchLeft());
            } else {
                System.out.println("Can't transfer everything from the bottle. Transfer only " + WhereTransfer.HowMuchLeft());
                this.PutOut(WhereTransfer.HowMuchLeft());
                WhereTransfer.PutIn(WhereTransfer.HowMuchLeft());
            }
        }
    }

    public static void main(String[] args) {
        BottleExercise2[] bottleExercise2 = new BottleExercise2[50];
        int a = 0;
        while (a < bottleExercise2.length) {
            bottleExercise2[a] = new BottleExercise2(a);
            a++;
        }

        System.out.println("Beafore transfer");
        System.out.println(bottleExercise2[10].getHowManyLiters());
        System.out.println(bottleExercise2[35].getHowManyLiters());

        bottleExercise2[10].Transfer(10, bottleExercise2[35]);

        System.out.println("Afetr transfer");
        System.out.println(bottleExercise2[10].getHowManyLiters());
        System.out.println(bottleExercise2[35].getHowManyLiters());

    }
}
