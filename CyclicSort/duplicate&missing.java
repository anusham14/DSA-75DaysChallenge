//{ Driver Code Starts
// Initial Template for Java
//https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int missing = 0 , dupli = 0;
        int[] result = new int[2];
        cyclicSort(arr,n);
        for(int i=0;i<n;i++)
        {
            if(i+1 != arr[i]){
                //duplicate is arr[i]
                //missing is i+1
                    result[0] = arr[i];
                    result[1] = i+1;
            }
            //else if(i+1 != arr[i] && i+1 > arr[i]){
            //        result[0] = i+1;
            //        result[1] = arr[i];  
            //    }
        }
        return result;
        
    }
    void cyclicSort(int[] arr,int n){
        int i=0 ;
        while(i<n){
            int correct = arr[i]-1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else i++;
        }
    }
}
