package td2dat;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TD2DAT {
	
	String datePattern = "yyyy/MM/dd HH:mm:ss.SSS";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern, new Locale("en", "GB"));
	
	Date initGPS;
	
	public TD2DAT() throws Exception {
		this.initGPS = simpleDateFormat.parse("1980/01/06 00:00:00.000");
	}
	
	public void getAndWriteData(String pathToInit, String pathToRes) throws Exception{
		String line[];
		try {
			FileReader fr = new FileReader(pathToInit);
			FileWriter fw = new FileWriter(pathToRes);
			Scanner sc = new Scanner(fr);
			
			fw.write("GPST DATE TIME LAT LON HEIGHT(MSL)\n");
			
			int l = 0;
			
			while(sc.hasNext()) {
				line = sc.nextLine().split("[,]");

				if(l<25) { // skip text info
					l++;
					continue;
				} else {
					fw.write(String.format("%.3f %s %s %s %s\n", 
							convertToGPSTime(simpleDateFormat.parse(line[0])),
							line[0], line[1].replaceAll(" ", ""), line[2].replaceAll(" ", ""),
							line[3].replaceAll(" ", "")));
				}
			}
			sc.close();
			fr.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	// convert date object to gps time
	public double convertToGPSTime(Date date) {
		return ((double)(date.getTime() - initGPS.getTime()))/1000 + 18; // при пересчёте почему-то всегда возникает ошибка в 18 секунд
	}
}
