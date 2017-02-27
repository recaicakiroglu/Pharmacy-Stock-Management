import java.text.ParseException;


/**
 * Represents a simple main class.nothing in here.
 * just object and call method
 * <p>
 * Args strings like medicaments.txt and prescription.txt read here and pass into next stop(ReadFile)   <p> tag
 * for split.
 * </p>
 *
 * @author Recai 
 * @version 1.0
 * 
 */
public class Main {
	/**
	 * @param args  2 input file as param
	 * @throws ParseException throws ParseException because of string to double function
	 */
	public static void main(String[] args) throws ParseException {
		ReadFile r = new ReadFile();
		r.readFile(args[0],args[1]);
	}
}
