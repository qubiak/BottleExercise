package bottleexercise3;

/**
 * made by qubiak
 *
 * The program transfers liquid from one bottle to another using Exception
 *
 */
class NotEnoughtWater extends Exception {

    public NotEnoughtWater(String string) {
        super(string);
    }
}

public class BottleExercise3 {

    private double HowManyLiters;

    BottleExercise3(double HowManyLiters) {
        this.HowManyLiters = HowManyLiters;
    }

    double getHowManyLiters() {
        return HowManyLiters;
    }

    void PutIn(double Quantity) {
        this.HowManyLiters += Quantity;
    }

    void PutOut(double Quantity) throws NotEnoughtWater {
        if (Quantity < HowManyLiters) {
            this.HowManyLiters -= Quantity;
            System.out.println("I pourded out " + Quantity + " in bottle remainded " + HowManyLiters);
        } else {
            throw new NotEnoughtWater("Not Enought Water");
        }
    }

    void transfer(double HowMany, BottleExercise3 WhereTransfer) throws NotEnoughtWater {
        this.PutOut(HowMany);
        WhereTransfer.PutIn(HowMany);
    }

    public static void main(String[] args) {
        BottleExercise3[] bottleExercise3 = new BottleExercise3[50];
        int a = 0;
        while (a < bottleExercise3.length) {
            bottleExercise3[a] = new BottleExercise3(a);
            a++;
        }

        System.out.println("Beafore transfer");
        System.out.println(bottleExercise3[20].getHowManyLiters());
        System.out.println(bottleExercise3[40].getHowManyLiters());

        try {
            bottleExercise3[20].transfer(5, bottleExercise3[40]);
        } catch (NotEnoughtWater ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Afetr transfer");
        System.out.println(bottleExercise3[20].getHowManyLiters());
        System.out.println(bottleExercise3[40].getHowManyLiters());

    }

}
