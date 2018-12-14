// A Dynamic Programming based Java program to find minimum 
// number operations to convert str1 to str2
package mainTabulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class DistanceTabulationProblem 
{
	final List<String> list = new ArrayList<>();
	double msTime, ini, fin;
	static String filePath;
	private final DistanceTabulation distance = new DistanceTabulation();
        
	public static void main(String args[])
	{
		
		switch(args.length){
			case 1:
				filePath=args[0];
				break;
			default:
				filePath = "./fichero.txt";
				break;
		}
		
		new DistanceTabulationProblem().execute();
	}
	
	private void execute() {
            System.out.println("--Tabulation--");
            ini = System.nanoTime();
            input();
            process();
		
	}
	
	private void input() {
		BufferedReader bf = null;
		try{
			bf = new BufferedReader(new FileReader(filePath));
			//read path and insert words on List
			String line = bf.readLine();
			while(line != null){
				String[] wordsByLine = line.split(";");
				for (String e : wordsByLine) {
					list.add(e);
				}
				line = bf.readLine();
			}
		}catch(IOException ex){
			System.err.println("Error al abrir el fichero");
			System.exit(1);
		}finally{
			try {
				if(bf!= null) bf.close();
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
				System.exit(1);
			}
		}
		
	}
	
	private void process() {
		String str1, str2;
		//iterate over list
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()){
			str1 = it.next();
			str2 = it.next();
			output(str1, str2);
		}
	}
	
	private void output(String str1, String str2) {
		int res = distance.editDistDP(str1, str2, str1.length(), str2.length());
		msTime = (System.nanoTime()-ini)/1000000;
		System.out.println("Palabra [" + str1 + "] [" + str2 + "] se han realizado " + res + " cambios y tiempo " + msTime + " miliseconds");
	}
}/*This code is contributed by Rajat Mishra*/
