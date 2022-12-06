import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Day1 {

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

            // Create 2 vars, one to hold biggest amt, the other to temporarily hold top values
            int biggest = 0;
            int temp = 0;

            // Loop through all strings
            for (String line: lines) {
                // If we don't meet a blank, continue adding to temp
                if (line.strip() != "") {
                    temp += Integer.valueOf(line);
                } else {
                    // Check if we need to change biggest to temp
                    if (temp > biggest) {
                        biggest = temp;
                    }
                    temp = 0;
                }
            }

            return biggest;
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

            // Create 2 vars, one array of size 3 to hold top 3 values, other to temp hold values
            int[] top = {0, 0, 0};
            int temp = 0;

            // Loop through all values
            for (String line: lines) {
                if (line.strip() != "") {
                    // Same as before, keep adding to temp until we find a blank
                    temp += Integer.valueOf(line);
                } else {
                    // Loop through all values of top, if we find a value that is higher, then set it. continue to keep track of all variables
                    int secondTemp;
                    if (temp > top[2]) {
                        secondTemp = top[2];
                        top[2] = temp;
                        temp = secondTemp;
                    }
                    if (temp > top[1]) {
                        secondTemp = top[1];
                        top[1] = temp;
                        temp = secondTemp;
                    }
                    if (temp > top[0]) {
                        secondTemp = top[0];
                        top[0] = temp;
                        temp = secondTemp;
                    }
                    temp = 0;
                }
            }
            
            return top[0] + top[1] + top[2];
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