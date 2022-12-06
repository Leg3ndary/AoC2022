import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Day2 {

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

            // Create an overall score var and meta var
            int score = 0;
            int meta = 0;

            for (String line: lines) {
                meta = 0;

                String[] instructions = line.split(" ");
                String elf = instructions[0].strip().toUpperCase();
                String me = instructions[1].strip().toUpperCase();

                // Adding the score of you throwing rps
                if (me.equals("X")) {
                    meta += 1;
                } else if (me.equals("Y")) {
                    meta += 2;
                } else {
                    meta += 3;
                }

                // In the case of draws, wins and then losses
                if ((elf.equals("A") && me.equals("X")) || (elf.equals("B") && me.equals("Y")) || (elf.equals("C") && me.equals("Z"))) {
                    meta += 3;
                } else if ((elf.equals("A") && me.equals("Y")) || (elf.equals("B") && me.equals("Z")) || (elf.equals("C") && me.equals("X"))) {
                    meta += 6;
                }

                score += meta;
            }
            return score;
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
            
            // Below is my own work copy pasted.
            // Create an overall score var and meta var
            int score = 0;
            int meta = 0;

            for (String line: lines) {
                meta = 0;

                String[] instructions = line.split(" ");
                String elf = instructions[0].strip().toUpperCase();
                String me = instructions[1].strip().toUpperCase();

                // We just have to adjust the values for this problem
                if (me.equals("X")) {
                    if (elf.equals("A")) {
                        me = "Z";
                    } else if (elf.equals("B")) {
                        me = "X";
                    } else {
                        me = "Y";
                    }
                } else if (me.equals("Z")) {
                    if (elf.equals("A")) {
                        me = "Y";
                    } else if (elf.equals("B")) {
                        me = "Z";
                    } else {
                        me = "X";
                    }
                } else {
                    if (elf.equals("A")) {
                        me = "X";
                    } else if (elf.equals("B")) {
                        me = "Y";
                    } else {
                        me = "Z";
                    }
                }

                // Adding the score of you throwing rps
                if (me.equals("X")) {
                    meta += 1;
                } else if (me.equals("Y")) {
                    meta += 2;
                } else {
                    meta += 3;
                }

                // In the case of draws, wins and then losses
                if ((elf.equals("A") && me.equals("X")) || (elf.equals("B") && me.equals("Y")) || (elf.equals("C") && me.equals("Z"))) {
                    meta += 3;
                } else if ((elf.equals("A") && me.equals("Y")) || (elf.equals("B") && me.equals("Z")) || (elf.equals("C") && me.equals("X"))) {
                    meta += 6;
                }

                score += meta;
            }

            
            return score;
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