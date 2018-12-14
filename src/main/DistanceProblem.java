package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistanceProblem {
    private static String filePath;
    private final Distance distance = new Distance();
    private final List<String> list = new ArrayList<>();
    private double msTime;
    
    public static void main(String[] args) {
        
        filePath = "./src/main/fichero.txt";
        new DistanceProblem().execute();
        /*
        if(args.length == 2){            
            filePath = args[1];
            new DistanceProblem().execute();
        }else{
            filePath = "./src/fichero.txt";
        }*/
    }

    private void execute() {
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
        } catch (IOException ex) {
            Logger.getLogger(DistanceProblem.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
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
        double ini = System.currentTimeMillis();
        distance.edit_distance(str1, str2, str1.length(), str2.length());
        msTime = (System.currentTimeMillis()-ini)/1000;
        System.out.println("Time interno: " + distance.getTime());
        System.out.println("World " + str1 + "-" + str2 + "take " + msTime + "seconds");
    }
}