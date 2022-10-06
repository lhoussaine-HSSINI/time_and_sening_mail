import javax.mail.MessagingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static Timer timer = new Timer(); // creating timer
    public static TimerTask task = new MyTask(); // creating timer task
    public static void main(String[] args) throws MessagingException, IOException {
        String coede_active = generate_code("lhoussaine hssini");
        timer.schedule(task,1000,5*60*1000);
        Fatma_send_mail_active_account.go("bontop.2018@gmail.com", coede_active);
        // scheduling the task at the specified time at fixed-rate
        System.out.println("set code activate  :");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        if (password.equals(coede_active)){
            System.out.println(" fatma your account is active  ");
            timer.cancel();
            timer.purge();
        }else
            System.out.println(" fatma your account not active  ");


    }
    public static String generate_code(String input)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32)
            {
                hashtext = "0" + hashtext;
            }
            return hashtext.substring(0,5);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
}