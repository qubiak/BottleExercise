package ButelkaCwiczenie;

	public class ButelkaCwiczenie {
	private double ileLitrow;
	final double maxPojemnosc = 50;

	ButelkaCwiczenie(double ileLitrow){
		this.ileLitrow = ileLitrow;
		}

	double getileLitrow(){
	return ileLitrow;
	}

	void wlej(double ilosc){
            if (czyDaSieWlac(ilosc)){
                this.ileLitrow += ileLitrow;
            }
        }
        
        void wylej(double ilosc){
            if(czyDaSieWylac(ilosc)){
                this.ileLitrow -= ileLitrow;
                System.out.println("wylałem " + ilosc + " w butelce pozostało " + ileLitrow);
                
            }
        }
        
        boolean czyDaSieWlac (double ilosc){
            if (ilosc + ileLitrow > maxPojemnosc){
                System.out.println("Nie da się wlać tyle. maksymalna pojemność butelki to " +maxPojemnosc);
                return false;
            } 
            else {
                return true;
                        }
            }
        
        
        boolean czyDaSieWylac (double ilosc){
            if (ilosc < ileLitrow){
                return true;
            }
            else {
                System.out.println("Nie da się tyle wylać, w butelce jest tylko " + ileLitrow +" jednostek płynu");
                return false;
            }
            }
        
        void przelej (double ilosc, ButelkaCwiczenie gdziePrzelac){
            if (czyDaSieWylac(ilosc) && gdziePrzelac.czyDaSieWlac(ilosc)){
                this.ileLitrow -= ilosc;
                gdziePrzelac.ileLitrow += ilosc;
            }
        }
        public static void main(String[] args){
            
            ButelkaCwiczenie[] butelkaCwiczenie = new ButelkaCwiczenie[50];
        int a = 0;
        while (a < butelkaCwiczenie.length) {
            butelkaCwiczenie[a] = new ButelkaCwiczenie(a);
            a++;
        }

        System.out.println("Przed przelaniem");
        System.out.println(butelkaCwiczenie[20].getileLitrow());
        System.out.println(butelkaCwiczenie[40].getileLitrow());

        butelkaCwiczenie[20].przelej(15, butelkaCwiczenie[40]);

        System.out.println("Po przelaniu");
        System.out.println(butelkaCwiczenie[20].getileLitrow());
        System.out.println(butelkaCwiczenie[40].getileLitrow());
    }
}
        
        