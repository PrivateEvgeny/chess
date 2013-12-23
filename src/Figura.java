import org.eclipse.swt.graphics.Image;

public class Figura extends Chess {

	public int cost;
	public boolean start;
	public boolean color;
	public int x;
	public int y;
	public String coor; // coordinates
	public int n; // number
	public boolean hod[][] = new boolean[14][14];
	public boolean ydar[][] = new boolean[14][14];
	public tipe type;
	public String tipe_st;
	public boolean alive;
	public boolean rules[][][] = new boolean[8][14][14];
	public boolean ruleH[][][] = new boolean[8][14][14];
	public Image im;

	void move(int k, int l) {

	}

	void pre_move() {

	}

	interface tipe {
		void hh();

	}

	public class peshka implements tipe {

		peshka() {
			System.out.println("Создали пешку");
		}

		public void hh() {
			Possible.peshka(x, y, start);

		}
	}

	public class tura implements tipe {
		tura() {
			hod[1][0] = true;
			hod[2][0] = true;
			hod[3][0] = true;
			hod[4][0] = true;
			hod[5][0] = true;
			hod[6][0] = true;
			hod[7][0] = true;
			hod[8][0] = true;
			hod[9][0] = true;
			hod[10][0] = true;
			hod[11][0] = true;
			hod[12][0] = true;
			hod[13][0] = true;
			hod[0][0] = true;

			hod[0][1] = true;
			hod[0][2] = true;
			hod[0][3] = true;
			hod[0][4] = true;
			hod[0][5] = true;
			hod[0][6] = true;
			hod[0][7] = true;
			hod[0][8] = true;
			hod[0][9] = true;
			hod[0][10] = true;
			hod[0][11] = true;
			hod[0][12] = true;
			hod[0][13] = true;
			hod[0][0] = true;

			ydar[1][0] = true;
			ydar[2][0] = true;
			ydar[3][0] = true;
			ydar[4][0] = true;
			ydar[5][0] = true;
			ydar[6][0] = true;
			ydar[7][0] = true;
			ydar[8][0] = true;

			ydar[0][1] = true;
			ydar[0][2] = true;
			ydar[0][3] = true;
			ydar[0][4] = true;
			ydar[0][5] = true;
			ydar[0][6] = true;
			ydar[0][7] = true;
			ydar[0][8] = true;

		}

		public void hh() {
			Possible.tura(x, y);

		}
	}

	class kon implements tipe {

		public void hh() {
			Possible.kon(x, y);

		}
	}

	class slon implements tipe {

		public void hh() {
			Possible.slon(x, y);

		}
	}

	class ferz implements tipe {

		public void hh() {
			Possible.slon(x, y);
			Possible.tura(x, y);

		}
	}

	class king implements tipe {

		public void hh() {
			Possible.king(x, y);

		}
	}

	Figura(int aa, int ab, boolean colo, String type_i) {
		ChessImages.load(display);
		start = true;
		x = aa;
		y = ab;
		tipe_st = type_i;

		color = colo;
		if (type_i.equals("peshka")) {
			type = new peshka();
			cost = 100;
			if (color == false) {
				im = ChessImages.BPeshka;
			} else
				im = ChessImages.WPeshka;
		}

		if (type_i.equals("tura")) {
			type = new tura();
			cost = 450;

			if (color == false) {

				im = ChessImages.BTura;
			} else
				im = ChessImages.WTura;
		}

		if (type_i == "kon") {
			type = new kon();
			cost = 300;
			if (color == false) {
				im = ChessImages.BKon;
			} else
				im = ChessImages.WKon;
		}

		if (type_i == "slon") {
			type = new slon();
			cost = 300;
			if (color == false) {
				im = ChessImages.BSlon;
			} else
				im = ChessImages.WSlon;
		}
		if (type_i == "ferz") {
			type = new ferz();
			cost = 950;
			if (color == false) {
				im = ChessImages.BFerz;
			} else
				im = ChessImages.WFerz;
		}
		if (type_i == "king") {
			type = new king();
			cost = 2000;
			if (color == false) {
				im = ChessImages.BKing;
			} else
				im = ChessImages.WKing;
		}

		alive = true;
	}

}
