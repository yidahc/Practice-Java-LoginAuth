class Main {
  public static void main(String[] args) {
    int failedAttempts = 0;
    while (failedAttempts < 3) {
      LoginClass myLogin = new LoginClass();
      myLogin.loginAttempt();
      failedAttempts ++;
    }
    System.out.println("Error. Too many failed attempts. Exiting program");
  }
}