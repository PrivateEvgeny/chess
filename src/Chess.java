
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
 
public class Chess {
	public static Display display = new Display();
	static String word = null;
	static int[] r = new int[4];
	static char[] r2 = new char[4];

	public static void main(String[] args) throws IOException {
	
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		double o_white = 0;
		double o_black = 0;
		boolean colo = true;
		boolean start = true;

		Figuras.initStart();
		initDoska(true);
	
		
		 Position s = new Position();
		 System.out.println(s.kol_hod(true, Figuras.list_hod, Figuras.list));
		 
		for (int u = 0; u < 50; u++) {
			
			
			
			
			
			

			
			
			
			
			System.out.println(colo);
			Figuras.allMoves(colo, Figuras.list, Figuras.list_hod);
			s.posHod(colo);
			enemyHod(s);
			Possible.nullMassive(Figuras.list_hod);
			if (colo) colo=false; else {
				if(!colo) colo = true;}
			initDoska(colo);
			//nashHod();
			//Possible.nullMassive(Figuras.list_hod);
			//Figuras.allMoves(false, Figuras.list, Figuras.list_hod);
			//Possible.print_possible(Figuras.list_hod);
		
			
//			Figuras.allMoves(false, Figuras.list, Figuras.list_hod);
//			Position.posHod(false);
//			
//			
//			initDoska(false);
//			enemyHod();
//			
//			initDoska(false);
			
	//		Figuras.allMoves(false, Figuras.list, Figuras.list_hod);
			
		
			
		}

	}
	static void up_one(){
		Figuras ss;
		ArrayList<Figuras.hod_poss> hod = new ArrayList<Figuras.hod_poss>();
		hod = Figuras.list_hod; 
		
		
		
		
		
	}
	static void enemyHod(Position s) {
		int g =3;
		Random random = new Random();
		
		int kol = s.b.toArray().length;
		if (kol<3) g= 1;
		int rand = Math.abs(random.nextInt(g));
		rand =0;
		Figuras.hod_poss h; 
		//= Figuras.list_hod.get(rand);
		h = s.b.get(kol-rand-1);
		
		System.out.println("hod:: " + h.xOld + " "+  h.yOld + " - " + h.x + " " + h.y);
		new Figuras.hod(h.xOld, h.yOld, h.x, h.y);
		Possible.nullMassive(Figuras.list_hod);
	}

	private static void nashHod() {
		Character c = new Character(word.charAt(0));
		String s = c.toString();
		r[0] = Integer.parseInt(s);

		c = new Character(word.charAt(1));
		s = c.toString();
		r[1] = Integer.parseInt(s);

		c = new Character(word.charAt(2));
		s = c.toString();
		r[2] = Integer.parseInt(s);

		c = new Character(word.charAt(3));
		s = c.toString();
		r[3] = Integer.parseInt(s);
		new Figuras.hod(r[0], r[1], r[2], r[3]);
	}

	public static void initDoska(boolean start) throws IOException {
		final Shell shell = new Shell(display);
		ChessImages.load(display);
		shell.setSize(400, 400);
		shell.setText("Chess Notebook");
		shell.setImage(ChessImages.IconChessNotebook);
		// final Image chessTabImage = new Image(display,
		// ChessImages.imageKnightBlack.getImageData().scaledTo(20, 20));

		Rectangle clientArea = shell.getClientArea();

		final TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);

		final TabItem item = new TabItem(tabFolder, SWT.NONE);
		tabFolder.setSize(clientArea.width - 2, clientArea.height - 2);

		item.setText("Партия ");
		item.setToolTipText("This is my tab");
		// item.setImage(chessTabImage);

		final Composite board = new Composite(tabFolder, SWT.NONE);

		ChessBoard a = new ChessBoard(board, SWT.NONE, display, start);

		item.setControl(board);

		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));

		shell.open();
//		 while ((!shell.isDisposed() | ( word != null))) {
//		 
//		 if (!display.readAndDispatch())
//		 display.sleep();
//		 }shell.close();
//
		do {
			System.out.println("Next:");
			word = bReader.readLine();
			display.sleep();
		} while (!shell.isDisposed() & word == null);
		
		shell.close();

	}

}
