import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;







public class Position extends Figuras {
//
//	static double HOD = 20;
//	static ArrayList<Figuras.hod_poss> b = new ArrayList<Figuras.hod_poss>();
//	static ArrayList<Figura> list = new ArrayList<Figura>();
//	static Figura coor[][] = new Figura[8][8];
//	static double ocenka = 0;
	static int g=1;
	static double HOD = 9;
	 ArrayList<Figuras.hod_poss> b = new ArrayList<Figuras.hod_poss>();
	public ArrayList<Figura> list = new ArrayList<Figura>();
	public Figura coor[][] = new Figura[8][8];
	public double ocenka = 0;
	
	public static Figura temp1;
	public static Figura temp2, temp3, temp4;
	
	static double kol_hod(boolean white, ArrayList<Figuras.hod_poss> b,
			ArrayList<Figura> list){
	
		double res=0;
		double res2 = 1;
		double res3;
	
		Figuras.allMoves(white,  list, b);
		res = b.toArray().length * HOD;

			
		Iterator itFigura = list.iterator();
	
		Figura f;

		while (itFigura.hasNext()) {
			f = (Figura) itFigura.next();

			if (f.color == white) {

				res = res + (double) f.cost;
				if (f.start!=true) res2 = res2 + (double) 15;
				
				if (white ==true) {
					if (f.tipe_st.equals("peshka") ) {
						res = res + 70-f.x *20;
					}
				}
				
				if (white ==false) {
					if (f.tipe_st.equals("peshka") ) {
						res = res+ f.x *20;
						
					}
				}
				
				
			}
		}
			
//////////////////////////////////////
			if (white==true)  white =false;
			else white = true;
			
			Figuras.allMoves(white,  list, b);
			res2 = b.toArray().length * HOD;

Iterator	itFigura2 = list.iterator();
		

			while (itFigura2.hasNext()) {
				f = (Figura) itFigura2.next();

				if (f.color == white) {
					
					res2 = res2 + (double) f.cost;
					if (f.start!=true) res2 = res2 + (double) 15;
					
					if (white ==true) {
						if (f.tipe_st.equals("peshka") ) {
							res = res + 70-f.x *10;
						}
					}
					
					if (white ==false) {
						if (f.tipe_st.equals("peshka") ) {
							res = res+ f.x *10;
						}
					}
					
				}
			
			}
			
		
	//	System.out.println(res + " " +res2);
		return 2+ res-res2;
	}
	
	

	
	

	
	 public class hod {
		int x = 0;
		int y = 0;
		int xNew = 0;
		int yNew = 0;
		boolean wasYdar = false;
	
		Figura figura, temp1, temp2;
		Figura ydar;
		
		
		hod(int g, int h, int e, int f, ArrayList<Figura> list) throws IOException {
			// if (coord[x][y]!=null){
		//	System.out.print(" Hod:" + g +" "+ h +"  - "+ e+ " " + f);
			
			x = g;
			y = h;
			xNew = e;
			yNew = f;

			figura = coord[x][y];
		
			temp1= figura;
			figura.x = xNew;
			figura.y = yNew;
			figura.start = false;
			if (coord[xNew][yNew] != null) {
				ydar = coord[xNew][yNew];
				wasYdar = true;
				temp2=ydar;
				ydar.alive = false;
				list.remove(ydar);

			}
			coord[x][y] = null;
			coord[xNew][yNew] = figura;
		//	Chess.initDoska(false);
		}
		
	
	}
	
	 void posHod (boolean white) throws IOException {
	
		 
		
		 
		 boolean black;
		if (white ==true) black = false; else black = true; 
		b.clear();
		int i=0;
		Figuras.hod_poss a  ;
		coor=Figuras.coord.clone();
		ArrayList<hod_poss> a1= new ArrayList<hod_poss>();
		a1= (ArrayList<hod_poss>) Figuras.list_hod.clone();
		ArrayList<Figura> list_c = (ArrayList<Figura>) Figuras.list.clone();
		ArrayList<Figura> list_s = (ArrayList<Figura>) list.clone();
		
		System.out.println("Vhod: " + Figuras.list.toArray().length);
		
		for (int t =0; t< a1.toArray().length; t++) {
			double o=0;
			temp1=null;
			temp2=null;
			Figuras.hod d;
			int dx=0; int dy=0; int dNy=0; int dNx=0;
			int Dx=0; int Dy=0; int DNy=0; int DNx=0;
			list.clear();
			list = (ArrayList<Figura>) Figuras.list.clone();
			Figuras.coord=coor;
			a= a1.get(t);
			
			
			hod h = new hod(a.xOld, a.yOld, a.x, a.y, list);
			
			nextHod hh = new nextHod();
			
			
			
			ocenka =(Double)		(Position.kol_hod(white, Figuras.list_hod, list))*0.5;
			//list = (ArrayList<Figura>) Figuras.list.clone();
			
			System.out.println(" ");
			System.out.print(a.x + " " + a.y + " sei :" + (int) ocenka );
		
				
			o=(Double)	hh.nextHod(white, coord, list, a1, 2) *0;
			// bylo -1.6
			ocenka= ocenka	+o;
			System.out.print( "otvet:" + (int)o +" "+  hh.hodgetHod().x+ " "
			+	hh.hodgetHod().y	+ " hod 2 r drugoy: ");
			//
			Figuras.allMoves(black, list, Figuras.list_hod);
			nextHod hb = new 
			nextHod();
			o=(Double)	hb.nextAgain2(black, coord, list, a1, 1) *0.4;
			// bulo -2!!
			ocenka= ocenka	+o;
			System.out.print( (int)o +" "+  hb.hodgetHod().x+ " "
			+	hb.hodgetHod().y	+ " hod toige: ");
			
			
			//
			
			
			Figuras.allMoves(black, list, Figuras.list_hod);
			
			o=(Double)	(hb.nextHod(black, coord, Figuras.list, a1, 1)) *0.10;
			
			
			
			
			System.out.print(" " + (int)o + "otevet 2 : ");
			ocenka= ocenka		+ o;
			
			
			
			///// hod 2 ras
			
			dx = hh.hodgetHod().xOld;
			dy = hh.hodgetHod().yOld;
			dNx = hh.hodgetHod().x;
			dNy = hh.hodgetHod().y;
			Figuras.allMoves(black, list, Figuras.list_hod);
			hod q = new hod(dx, dy, dNx, dNy, list);
			
			nextHod hc = new nextHod();
		
			
			
			
			q.temp1.x=dx;
			q.temp1.y=dy;
			q.temp1.start =true;
			if (q.wasYdar) q.temp2.alive =true;
			
			coord[dx][dy] =q.temp1;
			coord[dNx][dNy] =q.temp2;
			
			
			o=(Double)	(hc.nextHod(black, coord, list, Figuras.list_hod, 1)) *1.3;
			//o=  (Double)		(Position.kol_hod(white, Figuras.list_hod, list))*-0.3;
			System.out.print( (int)o + " " + dx +"."+ dy+ "-"+ dNx +"."+ dNy );
			
			ocenka = o +ocenka;
			
			// 3 ras
			
//			Figuras.allMoves(white, list, Figuras.list_hod);
//			Dx = hc.hodgetHod().xOld;
//			Dy = hc.hodgetHod().yOld;
//			DNx = hc.hodgetHod().x;
//			DNy = hc.hodgetHod().y;
//			Figuras.allMoves(white, list, Figuras.list_hod);
//			hod w = new hod(Dx, Dy, DNx, DNy, list);
//			
//			nextHod hv = new nextHod();
//		
//			
//			
//			
//			w.temp1.x=Dx;
//			w.temp1.y=Dy;
//			w.temp1.start =true;
//			if (w.wasYdar) w.temp2.alive =true;
//			
//			coord[Dx][Dy] =w.temp1;
//			coord[DNx][DNy] =w.temp2;
//			
//			
//			o=(Double)	(hv.nextHod(white, coord, list, Figuras.list_hod, 1)) *-1.1;
//			//o=  (Double)		(Position.kol_hod(white, Figuras.list_hod, list))*-0.3;
//			System.out.print(" 3 hoda: " + (int)o + " " + Dx +"."+ Dy+ "-"+ DNx +"."+ DNy );
//			
//			ocenka = o +ocenka;
//			
//			
//			
			
			
			
			/// konec 3 ras
			
			////konec  god 2 ras
			
			
		//	ocenka =  (Double)		(Position.kol_hod(white, Figuras.list_hod, Figuras.list));
		//	ocenka = 1/hh.nextHod(white, coord, list, a1);
			
			
			
			
			
			a.ocenka =ocenka;
			
			Figuras.allMoves(white, list, Figuras.list_hod);
			
			Figuras.coord=coor.clone();
			coord = coor.clone();
			//Possible.print_possible(Figuras.list_hod);
			b.add(a);
			h.temp1.x=a.xOld;
			h.temp1.y=a.yOld;
			h.temp1.start =true;
			if (h.wasYdar) h.temp2.alive =true;
			
			coord[a.xOld][a.yOld] =h.temp1;
			coord[a.x][a.y] =h.temp2;
			
			Figuras.list = (ArrayList<Figura>) list_c.clone();
		
		}
		
		
		//Figuras.allMoves(white, list, Figuras.list_hod);
		Collections.sort((List)b, new Comparator<Figuras.hod_poss>() {

			public int compare(Figuras.hod_poss a1,Figuras.hod_poss a2) {
			return a1.getOcenka().compareTo(a2.getOcenka());
			}
			});
	
			//Possible.print_possible(b);
		//	coord=coor.clone();
		
		//	b.clear();
		
		Figuras.list=(ArrayList<Figura>) list_c.clone();
		list =(ArrayList<Figura>) list_s.clone();
		Possible.print_possible(b);
//		System.out.println("Vyhod: " + Figuras.list.toArray().length);
	}// end pos figura;

	
	
	
	
	
	 public class nextHod{
			
	      ArrayList<Figuras.hod_poss> b = new ArrayList<Figuras.hod_poss>();
			ArrayList<Figura> list = new ArrayList<Figura>();
			Figura coor[][] = new Figura[8][8];
			double ocenka = 0;
			Figuras.hod_poss h; 
			 
			//coor = coord.clone();
			
			
		double	nextHod(boolean white, Figura coor2[][], ArrayList<Figura> list2, ArrayList<hod_poss> a2, int j) throws IOException{
			boolean black;
			
			black=white;
			b.clear();
			if (white == true) white = false ; else white = true;
				Figuras.hod_poss a, c  ;
				coor=coor2.clone();
				
				ArrayList<hod_poss> a1= new ArrayList<hod_poss>();
				Figuras.coord=coor.clone();
				Figuras.allMoves(white, list2, Figuras.list_hod);
				a1= (ArrayList<hod_poss>) Figuras.list_hod.clone();
				
		
				for (int t =0; t< a1.toArray().length; t++) {
					g=j;
					ocenka=0;
					
					list.clear();
					list = (ArrayList<Figura>) list2.clone();
					a= a1.get(t);
					hod e = new hod(a.xOld, a.yOld, a.x, a.y, list);
					Figuras.allMoves(white, list, Figuras.list_hod);
					
					
					if (g>0){
					g=g-1;
					
					//////////////// try
					
					Figuras.allMoves(white, list, Figuras.list_hod);
					nextHod hb = new nextHod();
					
					ocenka= ocenka		-(Double)	(hb.nextHod(white, coord, list, Figuras.list_hod, 0)) *1;
					
					Figuras.allMoves(black, list, Figuras.list_hod);
					
					nextHod he = new nextHod();
					ocenka = ocenka + (Double)		(he.nextHod(black,coord, list, Figuras.list_hod, 0))*0.2;
				
					
				//	System.out.println(hb.hodgetHod().xOld +" "+  hb.hodgetHod().yOld + "  - "+   hb.hodgetHod().x +" "+  hb.hodgetHod().y);
				
					////////////////// try second
					c=hb.hodgetHod();
//					hod f = new hod(hb.hodgetHod().xOld, hb.hodgetHod().yOld, hb.hodgetHod().x, hb.hodgetHod().y, list);
//					Figuras.allMoves(black, list, Figuras.list_hod);
//					
//					ocenka = ocenka+ (Double)		(Position.kol_hod(black, Figuras.list_hod, list))*-0.25;
//					f.temp1.x=c.xOld;
//					f.temp1.y=c.yOld;
//					f.temp1.start =true;
//					if (e.temp2 != null) f.temp2.alive =true;
//					coord[c.xOld][c.yOld] =f.temp1;
//					coord[c.x][c.y] =f.temp2;
					
				  
					//////////////////// conec try
					
					Figuras.allMoves(white, list, Figuras.list_hod);
					} 
					
					 ocenka = ocenka+ (Double)		(Position.kol_hod(white, Figuras.list_hod, list))*0.8;
				//		System.out.println("Berem hod: " +a.xOld + " " + a.yOld + " - "+ a.x + " "+ a.y + " oc:"+ ocenka);
					
					
					a.ocenka =ocenka;
				
					//Possible.print_possible(Figuras.list_hod);
					
					Figuras.coord=coor.clone();
					coord = coor.clone();
					
					b.add(a);
					e.temp1.x=a.xOld;
					e.temp1.y=a.yOld;
					e.temp1.start =true;
					if (e.temp2 != null) e.temp2.alive =true;
					coord[a.xOld][a.yOld] =e.temp1;
					coord[a.x][a.y] =e.temp2;
				//	Figuras.list = (ArrayList<Figura>) a1.clone();
				
					list = (ArrayList<Figura>) list2.clone();
				}
			
				Collections.sort((List)b, new Comparator<Figuras.hod_poss>() {

					public int compare(Figuras.hod_poss a1,Figuras.hod_poss a2) {
					return a1.getOcenka().compareTo(a2.getOcenka());
					}
					});
			
				int kol = b.toArray().length;
				
				h = b.get(kol-1);
		//		System.out.print(" " + h.xOld + " " + h.yOld + "  - " + h.x + " " + h.y +" " + (int)(h.ocenka) +" ");
				
				coord =coor2.clone();
				Figuras.list = (ArrayList<Figura>) list2.clone();
				Figuras.list_hod = (ArrayList<hod_poss>) a2.clone();
				return h.ocenka;
				
			}


	 Figuras.hod_poss hodgetHod(){
		
		return h;
		
	}
	 
	 double	nextAgain2(boolean white, Figura coor2[][], ArrayList<Figura> list2, ArrayList<hod_poss> a2, int j) throws IOException{
			boolean black;
			ocenka= 0;
			black=white;
			b.clear();
			if (white == true) white = false ; else white = true;
				Figuras.hod_poss a, c  ;
				coor=coor2.clone();
				
				ArrayList<hod_poss> a1= new ArrayList<hod_poss>();
				Figuras.coord=coor.clone();
				Figuras.allMoves(white, list2, Figuras.list_hod);
				a1= (ArrayList<hod_poss>) Figuras.list_hod.clone();
				
		
				for (int t =0; t< a1.toArray().length; t++) {
					g=j;
					ocenka=0;
					
					list.clear();
					list = (ArrayList<Figura>) list2.clone();
					a= a1.get(t);
					hod e = new hod(a.xOld, a.yOld, a.x, a.y, list);
					Figuras.allMoves(white, list, Figuras.list_hod);
					
					
					if (g>0){
					g=g-1;
					
					//////////////// try
					
					Figuras.allMoves(white, list, Figuras.list_hod);
					nextHod hb = new nextHod();
					
					ocenka= ocenka		+(Double)	(hb.nextAgain2(white, coord, list, Figuras.list_hod, 0)) *0.9;
					
				//	Figuras.allMoves(black, list, Figuras.list_hod);
					
				//	nextHod he = new nextHod();
				//	ocenka = ocenka + (Double)		(he.nextHod(black,coord, list, Figuras.list_hod, 0))*0.2;
				
				//	System.out.println(hb.hodgetHod().xOld +" "+  hb.hodgetHod().yOld + "  - "+   hb.hodgetHod().x +" "+  hb.hodgetHod().y);
				
					////////////////// try second
					//c=hb.hodgetHod();
//					hod f = new hod(hb.hodgetHod().xOld, hb.hodgetHod().yOld, hb.hodgetHod().x, hb.hodgetHod().y, list);
//					Figuras.allMoves(black, list, Figuras.list_hod);
//					
//					ocenka = ocenka+ (Double)		(Position.kol_hod(black, Figuras.list_hod, list))*-0.25;
//					f.temp1.x=c.xOld;
//					f.temp1.y=c.yOld;
//					f.temp1.start =true;
//					if (e.temp2 != null) f.temp2.alive =true;
//					coord[c.xOld][c.yOld] =f.temp1;
//					coord[c.x][c.y] =f.temp2;
					
				  
					//////////////////// conec try
					
					Figuras.allMoves(black, list, Figuras.list_hod);
					} 
					
					 ocenka = ocenka+ (Double)		(Position.kol_hod(white, Figuras.list_hod, list))*0.3;
				//		System.out.println("Berem hod: " +a.xOld + " " + a.yOld + " - "+ a.x + " "+ a.y + " oc:"+ ocenka);
					
					
					a.ocenka =ocenka;
				
					//Possible.print_possible(Figuras.list_hod);
					
					Figuras.coord=coor.clone();
					coord = coor.clone();
					
					b.add(a);
					e.temp1.x=a.xOld;
					e.temp1.y=a.yOld;
					e.temp1.start =true;
					if (e.temp2 != null) e.temp2.alive =true;
					coord[a.xOld][a.yOld] =e.temp1;
					coord[a.x][a.y] =e.temp2;
				//	Figuras.list = (ArrayList<Figura>) a1.clone();
				
					list = (ArrayList<Figura>) list2.clone();
				}
			
				Collections.sort((List)b, new Comparator<Figuras.hod_poss>() {

					public int compare(Figuras.hod_poss a1,Figuras.hod_poss a2) {
					return a1.getOcenka().compareTo(a2.getOcenka());
					}
					});
			
				int kol = b.toArray().length;
				
				h = b.get(kol-1);
		//		System.out.print(" " + h.xOld + " " + h.yOld + "  - " + h.x + " " + h.y +" " + (int)(h.ocenka) +" ");
				
				coord =coor2.clone();
				Figuras.list = (ArrayList<Figura>) list2.clone();
				Figuras.list_hod = (ArrayList<hod_poss>) a2.clone();
				return h.ocenka;
				
			}
	 
	 
	 
	 
	 
	 
	 
	 
	 }
	
	}




