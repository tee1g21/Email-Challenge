import java.util.Scanner; 
import java.net.MalformedURLException;
import java.net.*;
import java.io.*;

public class EmailChallenge{
    public static void main(String[] args) throws IOException{     
        
        //scanner class used to take userinput from command line
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Email ID: ");
        String id = scanner.next(); 
        scanner.close();

        //assigns webpage used to fetch name to string variable
        String webpage = "https://www.ecs.soton.ac.uk/people/"; 
        
        //uses try to catch error if URL doesn't work
        URL url; 
        try {

            //creates URL object using webpage string
            url = new URL(webpage + id);

            //creates bufferedreader object to read data from the URL
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            //creates property variable containing the string that will be looked for when the URL is read in
            String property = "property=\"name\"";
            String name = "Name not found";
            String inputLine;

            //while loop takes each line of URL read in
            //if the propety is contained in that line the name is extracted
            while ((inputLine = in.readLine()) != null){
                if(inputLine.contains(property)){
                     inputLine = inputLine.substring(inputLine.indexOf(property));
                    name = inputLine.substring(inputLine.indexOf(">") + 1, inputLine.indexOf("<"));
                    break;
                }
            }
           
            in.close();
            System.out.println("Name: " + name);

        } catch (MalformedURLException e) {
            System.out.println("Incorrect URL");
        } 
  
    }
   
}   
