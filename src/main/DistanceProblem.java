package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DistanceProblem {
    private static String filePath;
    private final Distance distance = new Distance();
    private final List<String> list = new ArrayList<>();
    private double msTime, ini, fin;
    
    public static void main(String[] args) {
        switch(args.length){
            case 1:
                filePath=args[0];
                break;
            default:
                filePath = "./fichero.txt";
                break;
        }
        
        new DistanceProblem().execute();
    }

    private void execute() {
        System.out.println("--Memoization--");
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
        int res = distance.edit_distance(str1, str2, str1.length(), str2.length());
        msTime = (System.nanoTime()-ini)/1000000;
        System.out.println("Palabra [" + str1 + "] [" + str2 + "] se han realizado " + res + " cambios y tiempo " + msTime + " miliseconds");
    }
}
