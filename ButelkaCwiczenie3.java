package ButelkaCwiczenie;


/**
made by qubiak

The program transfers liquid from one bottle to another using Exception

*/

class ZaMaloWody extends Exception
{

    public ZaMaloWody(String string) {
        super(string);
    }
    
}


	public class ButelkaCwiczenie {
	private double ileLitrow;

	ButelkaCwiczenie(double ileLitrow){
		this.ileLitrow = ileLitrow;
		}

	double getileLitrow(){
	return ileLitrow;
	}

	void wlej(double ilosc){
            this.ileLitrow += ilosc;
                    }
        
        void wylej(double ilosc) throws ZaMaloWody{
            if(ilosc < ileLitrow)
            {
                this.ileLitrow -= ilosc;
                System.out.println("wylałem " + ilosc + " w butelce pozostało " + ileLitrow); 
            }
            else
                throw new ZaMaloWody("za mało płynu");
        }
        
        
        void przelej (double ilosc, ButelkaCwiczenie gdziePrzelac) throws ZaMaloWody{
            this.wylej(ilosc);
            gdziePrzelac.wlej(ilosc);
        }
        public static void main(String[] args) {
            
            ButelkaCwiczenie[] butelkaCwiczenie = new ButelkaCwiczenie[50];
        int a = 0;
        while (a < butelkaCwiczenie.length) {
            butelkaCwiczenie[a] = new ButelkaCwiczenie(a);
            a++;
        }

        System.out.println("Przed przelaniem");
        System.out.println(butelkaCwiczenie[20].getileLitrow());
        System.out.println(butelkaCwiczenie[40].getileLitrow());

            try {
                butelkaCwiczenie[20].przelej(5, butelkaCwiczenie[40]);
            } catch (ZaMaloWody ex) {
                System.out.println(ex.getMessage());
            }

        System.out.println("Po przelaniu");
        System.out.println(butelkaCwiczenie[20].getileLitrow());
        System.out.println(butelkaCwiczenie[40].getileLitrow());
    }
}
        
        