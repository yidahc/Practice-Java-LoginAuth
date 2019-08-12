import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

class Main {

  static void showFile() {
    System.out.println("showing file");
  }

  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);

    System.out.println("Enter name and password");

    // String input
    String name = myObj.nextLine();
    String password = myObj.nextLine();

    try {
        File myFile = new File("credentials.txt");
        Scanner credReader = new Scanner(myFile);  
        while (credReader.hasNextLine()) {
          String data = credReader.nextLine();
          if (data.startsWith(name)) {
            String[] thisUser = data.split(" ");
            System.out.println(thisUser[0]);
//            if (thisUser[1].equals(password)){
  //            showFile();
    //        }      
          }
        }
        credReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }  
    // Output input by user
    //System.out.println("Name: " + name); 
    //System.out.println("Password: " + password); 
  }
}