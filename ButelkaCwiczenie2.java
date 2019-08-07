package butelkacwiczenie2;

public class ButelkaCwiczenie2 {

/**
made by qubiak

The program transfers liquid from one bottle to another, checking if it is pospible, 
If need program reduces quantiti of fluid in two cases - when it is to much or not enough. 


*/

	private double ileLitrow;
	final double maxPojemnosc = 50;

	ButelkaCwiczenie2(double ileLitrow){
		this.ileLitrow = ileLitrow;
		}

	double getileLitrow(){
		return ileLitrow;
		}
	double ileZostalo(){
		double ileZostalo = maxPojemnosc - this.getileLitrow();
		return ileZostalo;
		}

	boolean wlej(double ilosc){
		if(this.ileLitrow + ilosc <= maxPojemnosc){
			this.ileLitrow += ilosc;
			return true;
			}
		else{
			System.out.println("Za mało miejsca w butelce by wlać wszystko, przelano tylko " + this.ileZostalo());
			this.ileLitrow += this.ileZostalo();
			return false;
			}
        }
	
	boolean wylej(double ilosc){
		if(ilosc <= this.ileLitrow){
			this.ileLitrow -= ilosc;
			return true;
			}
		else{
			System.out.println("Za mało płynu w butelce, przelano tylko " + this.ileLitrow);
			this.ileLitrow -= ileLitrow;
			return false;
			}
        }
        boolean ileDaSieWlac (double ilosc){
            if (ilosc + ileLitrow > maxPojemnosc){
                return false;
            } 
            else {
                return true;
                        }
            }
	void przelej(double ilosc, ButelkaCwiczenie2 gdziePrzelac){
			if(ilosc <= gdziePrzelac.ileZostalo()){
				if(ilosc <= this.ileLitrow){
                                    System.out.println("przelano "+ilosc);
					this.wylej(ilosc);
					gdziePrzelac.wlej(ilosc);
					}
				else{
                                    System.out.println("przelano tylko " + this.ileLitrow + " za mało płynu by wylać więcej");
                                    double ilePrzelac = this.ileLitrow;
                                    this.wylej(ilePrzelac);
                                    gdziePrzelac.wlej(ilePrzelac);
}
			}
			
			else{
				if(ilosc <= this.ileLitrow){
                                    this.wylej(gdziePrzelac.ileZostalo());
                                    gdziePrzelac.wlej(this.ileZostalo());
				}
				else{
                                    System.out.println("Nie da się wszystkiego wlać do butelki. Przelano tylko " +gdziePrzelac.ileZostalo());
					this.wylej(gdziePrzelac.ileZostalo());
					gdziePrzelac.wlej(gdziePrzelac.ileZostalo());
					}
		}
        }

public static void main(String[] args){
	      ButelkaCwiczenie2[] butelkaCwiczenie2 = new ButelkaCwiczenie2[50];
        int a = 0;
        while (a < butelkaCwiczenie2.length) {
            butelkaCwiczenie2[a] = new ButelkaCwiczenie2(a);
            a++;
        }

        System.out.println("Przed przelaniem");
        System.out.println(butelkaCwiczenie2[10].getileLitrow());
        System.out.println(butelkaCwiczenie2[45].getileLitrow());

        butelkaCwiczenie2[10].przelej(6, butelkaCwiczenie2[45]);

        System.out.println("Po przelaniu");
        System.out.println(butelkaCwiczenie2[10].getileLitrow());
        System.out.println(butelkaCwiczenie2[45].getileLitrow());

	}
}

	

	