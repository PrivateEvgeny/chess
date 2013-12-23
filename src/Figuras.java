import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Figuras {

	static ArrayList<Figura> list = new ArrayList<Figura>();
	static Figura coord[][] = new Figura[8][8];
	static ArrayList<hod_poss> list_hod = new ArrayList<hod_poss>();
	
	

	static class hod {
		int x = 0;
		int y = 0;
		int xNew = 0;
		int yNew = 0;
	
		Figura figura;
		Figura ydar;

		hod(int g, int h, int e, int f) {
			// if (coord[x][y]!=null){

			x = g;
			y = h;
			xNew = e;
			yNew = f;

			figura = coord[x][y];
			figura.x = xNew;
			figura.y = yNew;
			figura.start = false;
			if (coord[xNew][yNew] != null) {
				ydar = coord[xNew][yNew];
				ydar.alive = false;
				list.remove(ydar);

			}
			coord[x][y] = null;
			coord[xNew][yNew] = figura;

			// } else {System.out.print("net figury!");}

		}

	}

	static class hod_poss {
		int x = 0;
		int y = 0;

		int xOld = 0;
		int yOld = 0;
		double delta =0;
		double ocenka =0;
		
		Double getOcenka(){
			return ocenka;
		}
		hod_poss(int k, int z, int g, int h) {

			x = g;
			y = h;
			xOld = k;
			yOld = z;
		}
		
		hod_poss(int k, int z, int g, int h, double o) {

			x = g;
			y = h;
			xOld = k;
			yOld = z;
			ocenka = o;
		}
		

	}

	static void initStart() {

		list.add(coord[1][0] = new Figura(1, 0, false, "peshka"));
		list.add(coord[1][1] = new Figura(1, 1, false, "peshka"));
		list.add(coord[1][2] = new Figura(1, 2, false, "peshka"));
		list.add(coord[1][3] = new Figura(1, 3, false, "peshka"));
		list.add(coord[1][4] = new Figura(1, 4, false, "peshka"));
		list.add(coord[1][5] = new Figura(1, 5, false, "peshka"));
		list.add(coord[1][6] = new Figura(1, 6, false, "peshka"));
		list.add(coord[1][7] = new Figura(1, 7, false, "peshka"));

		list.add(coord[6][0] = new Figura(6, 0, true, "peshka"));
		list.add(coord[6][1] = new Figura(6, 1, true, "peshka"));
		list.add(coord[6][2] = new Figura(6, 2, true, "peshka"));
		list.add(coord[6][3] = new Figura(6, 3, true, "peshka"));
		list.add(coord[6][4] = new Figura(6, 4, true, "peshka"));
		list.add(coord[6][5] = new Figura(6, 5, true, "peshka"));
		list.add(coord[6][6] = new Figura(6, 6, true, "peshka"));
		list.add(coord[6][7] = new Figura(6, 7, true, "peshka"));

		list.add(coord[7][7] = new Figura(7, 7, true, "tura"));
		list.add(coord[7][0] = new Figura(7, 0, true, "tura"));
		list.add(coord[7][1] = new Figura(7, 1, true, "kon"));
		list.add(coord[7][6] = new Figura(7, 6, true, "kon"));
		list.add(coord[7][2] = new Figura(7, 2, true, "slon"));
		list.add(coord[7][5] = new Figura(7, 5, true, "slon"));
		list.add(coord[7][4] = new Figura(7, 4, true, "king"));
		list.add(coord[7][3] = new Figura(7, 3, true, "ferz"));

		list.add(coord[0][7] = new Figura(0, 7, false, "tura"));
		list.add(coord[0][0] = new Figura(0, 0, false, "tura"));
		list.add(coord[0][1] = new Figura(0, 1, false, "kon"));
		list.add(coord[0][6] = new Figura(0, 6, false, "kon"));
		list.add(coord[0][2] = new Figura(0, 2, false, "slon"));
		list.add(coord[0][5] = new Figura(0, 5, false, "slon"));
		list.add(coord[0][4] = new Figura(0, 4, false, "king"));
		list.add(coord[0][3] = new Figura(0, 3, false, "ferz"));
	};

	static void allMoves(boolean white, ArrayList<Figura> list, ArrayList<Figuras.hod_poss> a) {
		//System.out.print("Generate color: " + white);
		Possible.nullMassive(a);
		Iterator itFigura = list.iterator();
		Figura f;
		hod_poss h;
		while (itFigura.hasNext()) {
			f = (Figura) itFigura.next();
			if (f.color == white) {
				f.type.hh();
			}

		}
		//System.out.println(white);
		//Possible.print_possible();
	}

}
