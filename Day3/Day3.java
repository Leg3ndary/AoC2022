import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Day3 {

    public static int getPriority(char character) {
        // Luckily ords in java are similar to python
        int originalOrd = (int) character;
        if (Character.isLowerCase(character)) {
            return originalOrd - 96;
        }
        return originalOrd - 38; // 64 - 26
    }

    public static char getItem(String rucksack) {
        // Retrieving the correct item type
        String first = rucksack.substring(0, (int) rucksack.length() / 2);
        String second = rucksack.substring((int) rucksack.length() / 2, rucksack.length());
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (((Character) first.charAt(i)).equals((Character) second.charAt(j))) {
                    return first.charAt(i);
                }
            }
        }
        return 'a'; // compiler yelling at me for not always specifying a return
    }

    public static char getBadge(ArrayList<String> rucksack) {
        // Retrieving the badge from a group of 3 little elves
        for (int i = 0; i < rucksack.get(0).length(); i++) {
            for (int j = 0; j < rucksack.get(1).length(); j++) {
                for (int k = 0; k < rucksack.get(2).length(); k++) {
                    if (((Character) rucksack.get(0).charAt(i)).equals((Character) rucksack.get(1).charAt(j)) && ((Character) rucksack.get(0).charAt(i)).equals((Character) rucksack.get(2).charAt(k))) {
                        return rucksack.get(0).charAt(i);
                    }
                }
            }
        }
        return 'a';
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

            // Yay, time to do this again
            // I don't think java has a way to define methods inside methods so they'll be at the top
            int total = 0;
            for (String line: lines) {
                total += getPriority(getItem(line));
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

            // Did what I did in python...
            int total = 0;
            ArrayList<String> temp = new ArrayList<String>();

            for (String line: lines) {
                temp.add(line);
                if (temp.size() == 3) {
                    total += getPriority(getBadge(temp));
                    temp = new ArrayList<String>();
                }
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