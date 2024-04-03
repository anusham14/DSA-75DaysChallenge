// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        boolean[][] maze = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        System.out.println(allPaths(maze,0,0,""));
    }
    
    public static ArrayList<String> allPaths(boolean[][] m,int r,int c,String p){
        if(r==m.length-1 && c==m[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(!m[r][c]) return list;
        m[r][c] = false;
        if(r<m.length-1){
            list.addAll(allPaths(m,r+1,c,p+'D'));
        }
        if(c<m.length-1){
            list.addAll(allPaths(m,r,c+1,p+'R'));
        }
        if(r>0){
            list.addAll(allPaths(m,r-1,c,p+'U'));
        }
        if(c>0){
            list.addAll(allPaths(m,r,c-1,p+'L'));
        }
        m[r][c] = true;
        return list;
    }
}
