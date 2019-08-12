import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

public class LoginClass {
  private String username;
  private String password;
  private String role;
  enum Roles{
   admin,
   zookeeper,
   veterinarian
  }

  public boolean getRoleBoolean() {
    if (this.role.length() > 0) {
      return true;
    }
    return false;
  }

  private void setRole(String line){
       for(Roles enumValue : Roles.values()){
         if(line.endsWith(enumValue.toString())){
          this.role = enumValue.toString();
         }
       }
  }

  public void logIn() {
    System.out.println("showing " + this.role + " file");
  }

  private void checkCredentials(Scanner credReader) {
    String data = credReader.nextLine();
    if (data.startsWith(this.username)) { 
      int usernameLength = this.username.length()+1;
      int pswEnd = usernameLength + 32;
      String filePswd = data.substring(usernameLength, pswEnd);
      if (filePswd.equals(this.password)){
        this.setRole(data);
      }     
    }
  }

  private void searchFile(){
     try {
        File myFile = new File("users.txt");
        Scanner credReader = new Scanner(myFile);  
        while (credReader.hasNextLine()) {
          this.checkCredentials(credReader);
        }
        credReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }  
  }
  
  public void loginAttempt() {
    Scanner inputScanner = new Scanner(System.in);
    System.out.println("Enter username and password");
    // String input
    this.username = inputScanner.nextLine();
    this.password = inputScanner.nextLine();
    this.searchFile();
  }
 
}