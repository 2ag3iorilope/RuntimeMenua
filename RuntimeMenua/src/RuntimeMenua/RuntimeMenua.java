package RuntimeMenua;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class RuntimeMenuak kontsola sinpleko menu bat eskaintzen du hainbat prozesu abiarazteko,
 * hala nola egutegi bat, Google Chrome bat eta Java exekutagarri bat.
 */
public class RuntimeMenua {

	/**
	 * The main method.
	 *
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		RuntimeMenua menu = new RuntimeMenua();
		menu.Menua();
	}

	/**
	 * Menu nagusia erakusten du eta erabiltzailearen sarrera prozesatzen du.
	 * Menuak egutegi bat irekitzeko aukerak ditu, Google Chrome, eta Java exekutagarri bat, edo aplikaziotik irtetea.
	 */
	public void Menua() {
		Scanner scanner = new Scanner(System.in);
		int option = 0;

		do {
			System.out.println("\n==============================");
			System.out.println("        MENUA       ");
			System.out.println("==============================");
			System.out.println("1. Egutegia-rekin prozesu seme bat sortzea");
			System.out.println("2. Prozesu seme bat sortzea Google Chrome-rekin");
			System.out.println("3. Prozesu seme bat sortzea Javako exekutagarri batekin");
			System.out.println("4. Irten");
			System.out.println("==============================");
			System.out.print("Aukeratu:: ");

			try {
				option = scanner.nextInt(); // Intenta lerroko sarrera irakurri
				switch (option) {
				case 1:
					startCalendarProcess();
					break;
				case 2:
					startChromeProcess();
					break;
				case 3:
					startJavaProcess();
					break;
				case 4:
					System.out.println("Irteten!");
					break;
				default:
					System.out.println("Aukera Desegokia.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Sarrera desegokia. Mesedez, zenbaki bat sartu.");
				scanner.next(); // Hustu sarrera okerra
			}

		} while (option != 4);

		scanner.close();
	}

	/**
	 * Egutegi-prozesu bat hasten du, sistemaren egutegi-aplikazioa erabiliz.
	 * Gaur egun, Outlook Calendar irekitzen du, eskuragarri badago.
	 */
	@SuppressWarnings("deprecation")
	private void startCalendarProcess() {
		try {
			Runtime.getRuntime().exec("cmd.exe /c start outlookcal:");
			System.out.println("Egutegia ireki da.");
		} catch (IOException e) {
			System.out.println("Errorea egutegia Irekitzerakoan: " + e.getMessage());
		}
	}

	/**
	 * Google Chrome prozesu bat hasten da. Metodo honek Google Chrome martxan jartzen du sisteman instalatuta bada.
	 */
	@SuppressWarnings("deprecation")
	private void startChromeProcess() {
		try {
			Runtime.getRuntime().exec("cmd.exe /c start chrome");
			System.out.println("Google Chrome Ireki da.");
		} catch (IOException e) {
			System.out.println("Errorea Chrome irekitzerakoan: " + e.getMessage());
		}
	}

	/**
	 * Java prozesu bat hasten da, JAR fitxategi jakin bat exekutatzen duena.
	 *
	 * @throws IOException if an I/O error occurs when trying to execute the JAR file
	 */
	private void startJavaProcess() {
		try {
			String jarPath = "C:\\Users\\2ag3.iorilope\\Desktop\\Ariketa1.jar"; 
			Runtime.getRuntime().exec(new String[]{"java", "-jar", jarPath});
			System.out.println("Exekutablea hasi da.");
		} catch (IOException e) {
			System.out.println("Errorea JAR fitxategia exekutatzean: " + e.getMessage());
		}
	}
}
