import java.util.ArrayList;
import java.util.Iterator;

public class Possible extends Figuras {
	static int z = 0;
	static int c = 0;
	static boolean prohod = true;
	

	public static void nullMassive(ArrayList<Figuras.hod_poss> list_hod) {
		list_hod.clear();

	}

	static void peshka(int x, int y, boolean start) {
		int u = 0;
		int o = 0;
		if (coord[x][y] != null) {
			if (!coord[x][y].color && coord[x][y].color==false) {
				z = x + 1;
				o = y + 1;
				if(start)	u= x+2; else u=x+1;	
			} else {
				z = x - 1;
				o = y + 1;
			if(start)	u= x-2; else u=x-1;
			}
		}

		c = y;

		if (z < 8 & c < 8 & z > -1 & c > -1 & pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));
		if (start & u < 8 & c < 8 & u > -1 & c > -1 & pusto(z, c)
				& pusto(u, c))
			if (x==1 | x==6 )list_hod.add(new hod_poss(x, y, u, c));

		if (z < 8 & o < 8 & pusto(z, o) == false & z>-1 & o>-1)
			
			if (mogno_bit(x, y, z, o))
				list_hod.add(new hod_poss(x, y, z, o));

		if (z < 8 & y - 1 > -1 & pusto(z, y - 1) == false)
			if (mogno_bit(x, y, z, y - 1))
				list_hod.add(new hod_poss(x, y, z, y - 1));
		// print_possible();

	}

	static void slon(int x, int y) {
		// System.out.println("Proverjaem slon");

		int k = 0;
		int l = 0;
		int j = 0;
		prohod = true;

		// +1 +1
		z = 0;
		c = 0;
		k = 7 - x;
		l = 7 - y;

		if (k >= l)
			j = l;
		else
			j = k;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = i + x;
			c = i + y;
			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );
			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// +1 -1
		z = 0;
		c = 0;
		k = 7 - x;
		l = Math.abs(y);
		prohod = true;

		if (k >= l)
			j = l;
		else
			j = k;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = i + x;
			c = y - i;

			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );

			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// -1 -1
		z = 0;
		c = 0;
		k = x;
		l = Math.abs(y);
		prohod = true;

		if (k >= l)
			j = l;
		else
			j = k;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = x - i;
			c = y - i;

			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );

			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// -1 +1
		z = 0;
		c = 0;
		k = x;
		l = Math.abs(7 - y);
		prohod = true;

		if (k >= l)
			j = l;
		else
			j = k;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = x - i;
			c = y + i;

			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );

			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

	}

	static void king(int x, int y) {

		z = x + 1;
		c = y + 1;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x;
		c = y + 1;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x - 1;
		c = y + 1;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x + 1;
		c = y;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x - 1;
		c = y;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x + 1;
		c = y - 1;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x;
		c = y - 1;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

		z = x - 1;
		c = y - 1;
		if (mogno_bit(x, y, z, c) | pusto(z, c))
			list_hod.add(new hod_poss(x, y, z, c));

	}

	static void tura(int x, int y) {
		int k = 0;
		int l = 0;
		int j = 0;
		prohod = true;

		// +1 0
		z = 0;
		c = 0;
		k = 7 - x;
		l = y;
		prohod = true;

		j = k;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = i + x;
			c = y;
			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );
			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// -1 0
		z = 0;
		c = 0;
		k = x;
		l = y;
		prohod = true;
		j = k;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = x - i;
			c = y;
			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );
			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// /

		// 0 +1
		z = 0;
		c = 0;
		k = x;
		l = 7 - y;
		prohod = true;
		j = l;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = x;
			c = y + i;
			// System.out.println("pusto: " + z+ " "+ c +" " + pusto(z,c) );
			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// -1 0
		z = 0;
		c = 0;
		k = x;
		l = y;
		prohod = true;
		j = l;
		// System.out.println("x=" + k + " y=" + l+ " j=" + j);

		for (int i = 1; i < j + 1; i++) {
			z = x;
			c = y - i;
			// System.out.println("ladya : pusto: " + z+ " "+ c +" " +
			// pusto(z,c) );
			if (mogno_bit(x, y, z, c))
				list_hod.add(new hod_poss(x, y, z, c));
			if (!pusto(z, c))
				prohod = false;
			if (prohod == false)
				break;
			if (prohod)
				list_hod.add(new hod_poss(x, y, z, c));
		}

	}

	static void kon(int x, int y) {
		// +2 +1
		int c = 0;
		int z = 0;
		if (x + 2 < 8 & x + 2 > -1 & y + 1 < 8 & y + 1 > -1) {
			z = x + 2;
			c = y + 1;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}
		// +2 -1
		if (x + 2 < 8 & x + 2 > -1 & y - 1 < 8 & y - 1 > -1) {
			z = x + 2;
			c = y - 1;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}
		// -2 -1
		if (x - 2 < 8 & x - 2 > -1 & y - 1 < 8 & y - 1 > -1) {
			z = x - 2;
			c = y - 1;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}
		// -2 +1
		if (x - 2 < 8 & x - 2 > -1 & y + 1 < 8 & y + 1 > -1) {
			z = x - 2;
			c = y + 1;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}

		// //

		// +1 +2
		if (x + 1 < 8 & x + 1 > -1 & y + 2 < 8 & y + 2 > -1) {
			z = x + 1;
			c = y + 2;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}
		// +1 -2
		if (x + 1 < 8 & x + 1 > -1 & y - 2 < 8 & y - 2 > -1) {
			z = x + 1;
			c = y - 2;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}
		// -1 -2
		if (x - 1 < 8 & x - 1 > -1 & y - 2 < 8 & y - 2 > -1) {
			z = x - 1;
			c = y - 2;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}
		// -1 +2
		if (x - 1 < 8 & x - 1 > -1 & y + 2 < 8 & y + 2 > -1) {
			z = x - 1;
			c = y + 2;

			if (mogno_bit(x, y, z, c) | pusto(z, c))
				list_hod.add(new hod_poss(x, y, z, c));
		}

	}

	static boolean pusto(int x, int y) {
		if (x > -1 & y > -1 & x < 8 & y < 8) {
			if (coord[x][y] == null)
				return true;
			else
				return false;
		} else
			return false;

	}

	static boolean mogno_bit(int x, int y, int k, int z) {
		if (x > -1 && y > -1 && x < 8 && y < 8 && k > -1 && z > -1 && k < 8
				&& z < 8 && coord[k][z] != null && coord[x][y]!=null) {
//System.out.println(x +" " + y);			
//System.out.println(coord[k][z]);
//System.out.println(coord[x][y]);

			if (coord[x][y].color != coord[k][z].color & (coord[k][z] != null))
				return true;
			else
				return false;
		} else
			return false;

	}

	static void print_possible(ArrayList<Figuras.hod_poss> b) {
		Iterator i = b.iterator();
		while (i.hasNext()) {
			hod_poss h = (hod_poss) i.next();
			System.out
					.println(h.xOld + " " + h.yOld + "  - " + h.x + " " + h.y +" " + h.ocenka);

		}
	}

}
