import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {
  
  private String email;
  
  public EmailValidator(String email){
    this.email = email; 
  }
  
  private static final String email_regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
  private static final Pattern email_pattern = Pattern.compile(email_regex, Pattern.CASE_INSENSITIVE);

  public boolean validar(String email) {
    if (email == null) return false;
    Matcher matcher = email_pattern.matcher(email);
    return matcher.matches();
  }

  public void send(String email, String DNI, double amount){
    if (validar(email)) {
        sendEmailNotification(email, DNI, amount);
    } else {
        throw new IllegalArgumentException("Email invalido");
    }
  }
  
}
