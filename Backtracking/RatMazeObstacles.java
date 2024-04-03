//{ Driver Code Starts
// Initial Template for Java
//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
      //check if last cell is obstacle
        if(m[n-1][n-1] == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add("-1");
            return list;
        }
        boolean[][] arr = new boolean[n][n];

      //else add another boolean matrix for backtracking 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = true;
            }
        }
        return allPaths(m,arr,0,0,"");
    }
    
    public static ArrayList<String> allPaths(int[][] maze, boolean[][] m,int r,int c,String p){
        if(r==m.length-1 && c==m[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        //check if visited for new arr or obstacles in maze then return
        if(!m[r][c] || maze[r][c] == 0) return list;
      
        //else no obstacles or not visited
        m[r][c] = false;
        if(maze[r][c] == 1 && r<m.length-1){
            list.addAll(allPaths(maze,m,r+1,c,p+'D'));
        }
        if(maze[r][c] == 1 && c<m.length-1){
            list.addAll(allPaths(maze,m,r,c+1,p+'R'));
        }
        if(maze[r][c] == 1 && r>0){
            list.addAll(allPaths(maze,m,r-1,c,p+'U'));
        }
        if(maze[r][c] == 1 && c>0){
            list.addAll(allPaths(maze,m,r,c-1,p+'L'));
        }
      //revert back if visited
        m[r][c] = true;
        return list;
    }
}
