class Main {
  public static void main(String[] args) {
    int failedAttempts = 0;
    while (failedAttempts < 3) {
      LoginClass myLogin = new LoginClass();
      myLogin.loginAttempt();
      if (mySession.getRoleBoolean()) {
        break;
      }
      failedAttempts ++;
    }
  
    if (failedAttempts >= 3) {
      System.out.println("Error. Too many failed attempts. Exiting program");
    }
    mySession.showFile();
  }
}