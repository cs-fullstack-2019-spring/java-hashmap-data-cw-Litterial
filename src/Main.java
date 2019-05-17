import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {

        ex1();
    }

    public static void ex1()
    {
        File myfile =new File("src/test.txt"); //pathname of file
        System.out.println("Hello World!");
        try
        {

          if(myfile.createNewFile()) //creates file if it doesn't already exist in the specified location
          { System.out.println("File created"); }
          else
          {System.out.println("File already exist.");}
        }

        catch(Exception e)
        {
          e.printStackTrace(); //prints error if it catches one
        }


        try
        {
            FileWriter writer= new FileWriter("src/test.txt");
            //writes messages to text file.
            writer.write("Juwan Moore:The uprising developer that outscored Kenn Gibbs on the Microsoft JavaScript Certification test. \n");
            writer.write("Kenn Gibbs:The salty, sore loser who was outscored by Juwan 'The World' Moore on the Microsoft JavaScript Certification test. \n");
            writer.write("The World:The nicknamed give to Juwan Moore once he shocked the world when he outscored Kenn Gibbs on the Microsoft Javascript Certrification test. \n");
            writer.close(); //closes file
        }
        catch(Exception e)
        {
            e.printStackTrace(); //prints error if it catches one
        }


        String entry,search; //entry grabs a string read on the text file; search is what the user types to search a word
        String[] entrytest; //array to hold the split between the word and the definition
        Scanner read = new Scanner(System.in);

        HashMap<String,String> dictionary = new HashMap<String,String>();

        try {
            Scanner scan = new Scanner(myfile);
            while (scan.hasNextLine()) {
                entry = scan.nextLine(); //entry is the next line in the text file
               entrytest= entry.split(":"); //splits elements based off the ":"
               dictionary.put(entrytest[0],entrytest[1]);  // puts elements into the hashmap
            }
        System.out.println("Enter a word to find in the dictionary");
        search=read.nextLine().trim();

        if(dictionary.get(search)==null) //if there is no value for this specific key it will be null.
            System.out.println("There is no definition for "+search);
        else
        System.out.println(search+" - "+ dictionary.get(search));


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
