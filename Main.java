package td2dat;

public class Main {
	public static void main(String[] args) throws Exception{		
		
		if (args.length !=2) {
			System.out.println("Wrong number of arguments");
			System.out.println("Define two arguments: 1- path to initial file, 2 - path to file with results of conversion");
		} else {
			String pathToInit = args[0];
			String pathToRes = args[1];	
			TD2DAT td = new TD2DAT();
			td.getAndWriteData(pathToInit, pathToRes);
		}
		
	}
}
