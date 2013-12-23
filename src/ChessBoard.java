import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ChessBoard extends Canvas implements PaintListener {
	static Image[][] pieces;
	static Figura[][] figura;
	static Composite comp;
	Rectangle clientArea;

	public ChessBoard(Composite shell, int style, Display display, boolean start) {
		super();

		comp = shell;
		comp.addPaintListener(this);
		clientArea = comp.getClientArea();
		pieces = new Image[8][8];

		initFigures(display);

	}

	void initStart() {

	};

	public void init2(Display display) {
		ChessImages.load(display);
		pieces[3][7] = ChessImages.WTura;
	}

	private void initFigures(Display display) {
		int k = 0, z = 0;
		ChessImages.load(display);

		for (int v = 0; v < 8; v++) {
			for (int h = 0; h < 8; h++) {

				pieces[v][h] = null;

			}
		}

		Iterator it = Figuras.list.iterator();
		Figura f;

		while (it.hasNext()) {
			f = (Figura) it.next();
			if (f.alive) {
				k = f.x;
				z = f.y;
				pieces[z][k] = f.im;
			}

		}

		// Рисуем возможные ходы
		// Figuras.hod hod;
		// it = Figuras.list_hod.iterator();
		// while(it.hasNext()){
		// hod = (Figuras.hod) it.next();
		// k=hod.x;
		// z = hod.y;
		// pieces[z][k] = ChessImages.Hod;
		//			
		//			
		// }
		// конец рисуем возможные ходы
	}

	static void hod(int x1, int y1, int x2, int y2) {

		pieces[x2][y2] = pieces[x1][y1];
		pieces[x1][y1] = null;
	}

	static void pp_del() {

		pieces[4][4] = null;

	}

	public void paintControl(PaintEvent e) {

		Rectangle clientArea = comp.getClientArea();
		GC c = e.gc;

		for (int v = 0; v < 8; v++) {
			for (int h = 0; h < 8; h++) {

				int squareWidth = clientArea.width / 8;
				int squareHeight = clientArea.height / 8;
				boolean isWhiteSquare = ((v + h) % 2 == 0);
				Color squareColor = isWhiteSquare ? new Color(null, 255, 255,
						255) : new Color(null, 0, 192, 0);
				c.setBackground(squareColor);
				c.fillRectangle(v * squareWidth, h * squareHeight, squareWidth,
						squareHeight);
				c.setForeground(new Color(null, 0, 0, 0));
				c.drawRectangle(v * squareWidth, h * squareHeight, squareWidth,
						squareHeight);
			} // for
			e.gc.drawRectangle(0, 0, clientArea.width - 1,
					clientArea.height - 1);

		}

		for (int v = 0; v < 8; v++) {
			for (int h = 0; h < 8; h++) {

				paintPiece(c, v, h, pieces[v][h]);

			}

		}

	} // 

	private void paintPiece(GC c, int v, int h, Image image) {

		if (image == null)
			return;
		Rectangle imageRect = image.getBounds();
		int imageWidth = imageRect.width;
		int imageHeight = imageRect.height;
		int squareWidth = comp.getClientArea().width / 8 - 2;
		int squareHeight = comp.getClientArea().height / 8 - 2;

		c.drawImage(image, 0, 0, imageWidth, imageHeight, v * (squareWidth + 2)
				+ 1, h * (squareHeight + 2) + 1, squareWidth, squareHeight);

	}

}
