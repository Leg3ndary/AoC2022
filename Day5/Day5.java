import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Day5 {

    public static String problem1(String filename) throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        try
        {
            ArrayList<String> lines = new ArrayList<String>();
            while (s.hasNextLine())
            {
                lines.add(s.nextLine()); // Removed strip.
            }

            // Getting index of where the instructions split from crates.
            int split = lines.indexOf("");

            // Get the stack length which in this case is 9.
            int stackLength = Integer.valueOf(lines.get(split - 1).split(" ")[lines.get(split - 1).split(" ").length - 1]);

            // Create the 2d arraylist stacks.
            ArrayList<ArrayList<Character>> stacks = new ArrayList<ArrayList<Character>>();

            // Loop through length of stacks to add more arraylists.
            for (int i = 0; i < stackLength; i++) {
                stacks.add(new ArrayList<Character>());
            }
            
            // Adding all the correct values.
            for (int i = 0; i < split - 1; i++) {
                for (int j = 0; j < stackLength; j++) {
                    if (!lines.get(i).substring(j * 4 + 1, j * 4 + 2).strip().equals("")) {
                        stacks.get(j).add(lines.get(i).substring(j * 4 + 1, j * 4 + 2).charAt(0));
                    }
                }
            }

            // Doing all the moves.
            for (int i = split + 1; i < lines.size(); i++) {
                String instructions = lines.get(i);
                int num = Integer.valueOf(instructions.split(" ")[1]);
                int from = Integer.valueOf(instructions.split(" ")[3]) - 1;
                int dest = Integer.valueOf(instructions.split(" ")[5]) - 1;

                for (int j = 0; j < num; j++) {
                    stacks.get(dest).add(0, stacks.get(from).remove(0));
                }
            }

            // Compiling final answer.
            String answer = "";
            for (int i = 0; i < stackLength; i++) {
                answer += stacks.get(i).remove(0);
            }

            return answer; 
        }
        finally
        {
            s.close();
        }
    }

    public static String problem2(String filename) throws FileNotFoundException
    {
        File f = new File(filename);
        Scanner s = new Scanner(f);
        try
        {
            ArrayList<String> lines = new ArrayList<String>();
            while (s.hasNextLine())
            {
                lines.add(s.nextLine()); // Removed Strip
            }

            // Getting index of where the instructions split from crates.
            int split = lines.indexOf("");

            // Get the stack length which in this case is 9.
            int stackLength = Integer.valueOf(lines.get(split - 1).split(" ")[lines.get(split - 1).split(" ").length - 1]);

            // Create the 2d arraylist stacks.
            ArrayList<ArrayList<Character>> stacks = new ArrayList<ArrayList<Character>>();

            // Loop through length of stacks to add more arraylists.
            for (int i = 0; i < stackLength; i++) {
                stacks.add(new ArrayList<Character>());
            }
            
            // Adding all the correct values.
            for (int i = 0; i < split - 1; i++) {
                for (int j = 0; j < stackLength; j++) {
                    if (!lines.get(i).substring(j * 4 + 1, j * 4 + 2).strip().equals("")) {
                        stacks.get(j).add(lines.get(i).substring(j * 4 + 1, j * 4 + 2).charAt(0));
                    }
                }
            }

            // Doing all the moves.
            for (int i = split + 1; i < lines.size(); i++) {
                String instructions = lines.get(i);
                int num = Integer.valueOf(instructions.split(" ")[1]);
                int from = Integer.valueOf(instructions.split(" ")[3]) - 1;
                int dest = Integer.valueOf(instructions.split(" ")[5]) - 1;

                for (int j = 0; j < num; j++) {
                    stacks.get(dest).add(0, stacks.get(from).remove(num - 1 - j));
                }
            }

            // Compiling final answer.
            String answer = "";
            for (int i = 0; i < stackLength; i++) {
                answer += stacks.get(i).remove(0);
            }

            return answer; 
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