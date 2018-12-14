package main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Distance {
    private long time;
    
    //map de double key para insetar como keys las dos palabras y el valor
    private MultiKeyHashMap<String, String, Integer> dp = new MultiKeyHashMap<>();
    
    private int distance(String str1, String str2, int m, int n){
        long ini = System.currentTimeMillis();
        int result;
        
        if(m == 0){
            dp.put(str1, str2, n);
            return n;
        }
        
        if(n == 0){
            dp.put(str1, str2, m);
            return m;
        }
        
        str1 = str1.substring(0, m-1);
        str2 = str2.substring(0, n-1);
        
        if(str1.equals(str2)){
            result = distance(str1, str2, m-1, n-1);
            dp.put(str1, str2, result);
        }else{
            result = 1 + min(distance(str1, str2, m, n-1),
                    distance(str1, str2, m-1, n),
                    distance(str1, str2, m-1, n-1));
            dp.put(str1, str2, result);
        }
        long fin = System.currentTimeMillis();
        time = ((fin - ini) /1000);
        return result;
    }
    
    public int edit_distance(String str1, String str2, int m, int n){
        
        if(dp.containsKey(str1, str2)) return dp.get(str1, str2);
        else return distance(str1, str2, m, n);
        
    }
    
    private int min(int a, int b, int c){
        if(a <= b && a <= c) return a;
        if(b <= a && b <= c) return b;
        return c;
    }

    public MultiKeyHashMap<String, String, Integer> getDp() {
        return dp;
    }

    public long getTime() {
        return time;
    }
}
