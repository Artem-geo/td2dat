package td2dat;

public class Main {
	public static void main(String[] args) throws Exception{
		
		if (args.length !=2) {
			System.out.println("Wrong number of arguments");
		} else {
			String pathToInit = args[0];
			String pathToRes = args[1];	
			TD2DAT td = new TD2DAT();
			td.getAndWriteData(pathToInit, pathToRes);
		}
	}
}
