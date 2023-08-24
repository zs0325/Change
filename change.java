

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Question2 {

    public long countWays(int n)
    {
        long[] ways = new long[100000000+1];
        int arr[] = {1, 2, 5,10,20,50,100,200};
        ways[0] = 1;                 //can only make R0 with no coins
        for (int i:arr)              //for each type of coin
            for (int j=i; j<=n; j++)
                ways[j] += ways[j-i]; //add amount of different ways to make change
        return ways[n];
    }
    
    public static void main(String args[])
    {
        Question2 test = new Question2();
        try{
            File file= new File("juice.csv");
            Scanner scan = new Scanner(file);
            scan.nextLine();
            int bill=0,tip=0,given=0;
            while(scan.hasNextLine()){
            String data =scan.nextLine();
            String[] d = data.split(";");
            bill =Integer.parseInt(d[0]);
            tip =Integer.parseInt(d[1]);
            given =Integer.parseInt(d[2]);
            int amount= bill+tip;
            int change = given-amount;
            
        System.out.println("The final amount to pay is R"+amount);
        System.out.println("The customer requires R"+change+" change.");
        System.out.println("The number of ways to make change for R"+change+" is "+test.countWays(change));
        System.out.println("\n");
        }
        }
        catch(FileNotFoundException e){
            System.out.println("file not found...");
            System.exit(0);
        }
        
    }
}
