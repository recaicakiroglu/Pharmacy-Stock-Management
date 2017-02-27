/**
 * This class is heart of the entire code system.
 * basically Reading(line by line)
 *  Placement(Split word by word) 
 *  Controls and finally printing 
 * @author Recai 
 * @version 1.0
 *
 */
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class ReadFile {
	/**
	 * 2 List stores the data of  pills and users.
	 */
	private Scanner input;
	List<Pills> PL = new ArrayList<Pills>();
	List<Pills> FL = new ArrayList<Pills>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	/**
	 * This method opens Files.
	 * @param str
	 */
	public void openFile(String str) {
		
		try {
			input = new Scanner(new File(str));
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	/**
	 * 
	 * @param pre   ARGS[0] Pills
	 * @param med    ARGS[1] User
	 * @throws ParseException
	 */
	public void readFile(String pre,String med) throws ParseException {
		try {
			File file = new File(med);
			File file2 = new File(pre);
			FileReader fileReader = new FileReader(file);
			FileReader fileReader2 = new FileReader(file2);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
			StringBuffer stringBuffer = new StringBuffer();
			StringBuffer stringBuffer2 = new StringBuffer();
			String line;
			String line2;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			while ((line2 = bufferedReader2.readLine()) != null) {
				stringBuffer2.append(line2);
				stringBuffer2.append("\n");
			}
			String text = stringBuffer.toString();
			String text2 = stringBuffer2.toString();
			String lines[] = text.split("\n");
			String lines2[] = text2.split("\n");
			String words2[] = lines2[0].split("\t");
			String Date = words2[2];
			String Id = words2[1];
			for (int i = 0; i < lines.length; i++) {
				String words[] = lines[i].split("\t");
				Date date1 = sdf.parse(words[2]);
				Date date2 = sdf.parse(words[3]);
				Double Price = Double.parseDouble(words[4]);
				Pills e = new Pills(words[0], words[1], date1, date2, Price);
				PL.add(e);
			}
			List<User> request = new ArrayList<User>();
			for (int i = 1; i < lines2.length; i++) {
				String words3[] = lines2[i].split("\t");
				Double Unit = Double.parseDouble(words3[1]);
				User e = new User(words3[0], Unit);
				request.add(e);
			}
			Controls(Date, Id, request, lines.length);
			fileReader.close();
			fileReader2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This void method is collects all data like date,Id and of course arraylist
	 * and later than start removing one by one 
	 * first checkpoint for names
	 * second checkpoint for date
	 * third checkpoint for Price
	 * and print the survivors.
	 * @param Date Date in the prescription
	 * @param Id Patient's Social Security Number
	 * @param list Arraylist
	 * @param PillSize List.length()
	 * @throws ParseException for string to double.
	 */
	public void Controls(String Date, String Id, List<User> list, int PillSize) throws ParseException {
		Date date = sdf.parse(Date);
		double Total = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < PillSize; j++) {
				if (list.get(i).getName().equals(PL.get(j).getName()) && PL.get(j).getSocialSecurity().equals(Id)) {
					if (PL.get(j).getEffectiveDate().before(date) && PL.get(j).getExpiryDate().after(date))
						FL.add(PL.get(j));
				}
			}
		}

		for (int i = 0; i < FL.size(); i++) {
			for (int j = 0; j < FL.size(); j++) {
				if (FL.get(i).getName().equals(FL.get(j).getName())) {
					if (FL.get(i).getPrice() <= FL.get(j).getPrice()) {
						if (i != j) {
							FL.remove(j);
							j = j - 1;
						}
					} else if (FL.get(i).getPrice() >= FL.get(j).getPrice()) {
						if (i != j) {
							FL.remove(i);
							j = j - 1;
						}
					}
				}
			}
		}
		for (int i = 0; i < FL.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (FL.get(i).getName().equals(list.get(j).getName())) {
					Double Money = FL.get(i).getPrice() * list.get(j).getUnit();
					Total = Total + Money;
					System.out.printf(FL.get(i).getName() + " \t" + FL.get(i).getPrice() + "\t" + list.get(j).getUnit()
							+ "\t" + "%.2f" + "\n", Money);
				}
			}
		}
		System.out.printf("Total %.2f", Total);
	}
/**
 * Close File
 */
	public void closeFile() {
		input.close();
	}
}