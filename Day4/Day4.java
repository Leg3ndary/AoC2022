import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Day4 {

    public static int check(String[] pairs) {
        // Just check the basic logic
        int x = (int) Integer.valueOf(pairs[0].split("-")[0]);
        int y = (int) Integer.valueOf(pairs[0].split("-")[1]);
        int a = (int) Integer.valueOf(pairs[1].split("-")[0]);
        int b = (int) Integer.valueOf(pairs[1].split("-")[1]);

        if ((x <= a && y >= b) || (x >= a && y <= b)) {
            return 1;
        }
        return 0;
    }


    public static int overlap(String[] pairs) {
        // Alter the logic a bit
        int x = (int) Integer.valueOf(pairs[0].split("-")[0]);
        int y = (int) Integer.valueOf(pairs[0].split("-")[1]);
        int a = (int) Integer.valueOf(pairs[1].split("-")[0]);
        int b = (int) Integer.valueOf(pairs[1].split("-")[1]);

        if (Integer.max(x, y) < Integer.min(a, b) || Integer.min(x, y) > Integer.max(a, b)) {
            return 0;
        }
        return 1;
    }
    
    public static int problem1(String filename) throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        try
        {
            ArrayList<String> lines = new ArrayList<String>();
            while (s.hasNextLine())
            {
                lines.add(s.nextLine().strip());
            }

            int total = 0;
            for (String line: lines) {
                total += check(line.split(",")); // Return 0 if false, 1 if true, probably should've done this in python too smh
            }
            
            return total;
        }
        finally
        {
            s.close();
        }
    }

    public static int problem2(String filename) throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        try
        {
            ArrayList<String> lines = new ArrayList<String>();
            while (s.hasNextLine())
            {
                lines.add(s.nextLine().strip());
            }

            int total = 0;
            for (String line: lines) {
                total += overlap(line.split(","));
            }
            
            return total;
        }
        finally
        {
            s.close();
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(problem1("data.txt"));
            System.out.println(problem2("data.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}