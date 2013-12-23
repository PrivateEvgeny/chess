import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.*;

public class ChessImages {

	public static Image IconChessNotebook;
	public static Image imageKnightBlack;
	public static Image WKing, WFerz, WTura, WSlon, WKon, WPeshka, Hod;
	public static Image BKing, BFerz, BTura, BSlon, BKon, BPeshka;

	public static void load(Display display) {
		// IconChessNotebook = new Image(display,
		// ChessImages.class.getResourceAsStream("Icon.svg.png"));
		// imageKnightBlack = new Image(display,
		// ChessImages.class.getResourceAsStream("index.jpg"));
		// imageKnightBlack.getImageData().scaledTo(20, 20);
		WKing = new Image(display, ChessImages.class
				.getResourceAsStream("WKing.png"));
		WFerz = new Image(display, ChessImages.class
				.getResourceAsStream("WFerz.png"));
		WTura = new Image(display, ChessImages.class
				.getResourceAsStream("WTura.png"));
		WSlon = new Image(display, ChessImages.class
				.getResourceAsStream("WSlon.png"));
		WKon = new Image(display, ChessImages.class
				.getResourceAsStream("WKon.png"));
		WPeshka = new Image(display, ChessImages.class
				.getResourceAsStream("WPeshka.png"));
		Hod = new Image(display, ChessImages.class
				.getResourceAsStream("WPeshka.png"));
		Hod.getImageData().scaledTo(3, 3);
		BKing = new Image(display, ChessImages.class
				.getResourceAsStream("BKing.png"));
		BFerz = new Image(display, ChessImages.class
				.getResourceAsStream("BFerz.png"));
		BTura = new Image(display, ChessImages.class
				.getResourceAsStream("BTura.png"));
		BSlon = new Image(display, ChessImages.class
				.getResourceAsStream("BSlon.png"));
		BKon = new Image(display, ChessImages.class
				.getResourceAsStream("BKon.png"));
		BPeshka = new Image(display, ChessImages.class
				.getResourceAsStream("BPeshka.png"));
	}

}
