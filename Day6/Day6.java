import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

class Day6 {

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

            // Total to save total characters processed -4, data to be quicker.
            int total = 0;
            String data = lines.get(0);

            // Looping through values.
            for (int i = 0; i < data.length(); i++) {
                char first = data.charAt(i);
                char second = data.charAt(i + 1);
                char third = data.charAt(i + 2);
                char fourth = data.charAt(i + 3);
                if (first == second || first == third || first == fourth || second == third || second == fourth || third == fourth) {
                    total += 1;
                } else {
                    return total + 4; 
                }
            }
            return 0; // So the compulor stops yelling at me
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

            // Total to save total characters processed -4, data to be quicker.
            int total = 0;
            String data = lines.get(0);

            // Looping through values.
            for (int i = 0; i < data.length(); i++) {
                Hashtable<Character, Integer> temp = new Hashtable<Character, Integer>();
                for (int j = 0; j < 14; j++) {
                    if (temp.get(Character.valueOf(data.charAt(i + j))) != null) {
                        temp.put(Character.valueOf(data.charAt(i + j)), Integer.valueOf(temp.get(Character.valueOf(data.charAt(i + j))) + 1));
                    } else {
                        temp.put(Character.valueOf(data.charAt(i + j)), Integer.valueOf(0));
                    }
                }
                if (temp.size() != 14) {
                    total += 1;
                } else {
                    return total + 14; // Add 14 to ocmpensate for characters processed 
                }
            }
            return 0; // So the compulor stops yelling at me
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