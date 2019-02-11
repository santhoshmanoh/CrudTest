import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;1

import static java.util.logging.Level.FINE;


public class Mainclass  {


    public static void main(String[] args) throws Exception
    {
        final Logger log = Logger.getLogger(Mainclass.class.getName());
//       PropertyConfigurator.configure("src/main/resources/log4j.properties");
//        ConsoleHandler ch=new ConsoleHandler();
//        Handler handler =new FileHandler("/User/santhosh/Downloads/logsan.log");
       Crudconnect crudconnect= new Crudconnect();
        Person person=new Person();
        log.info("Crud procedure started");
        System.out.println("Crud Operation");
        Scanner sc=new Scanner(System.in);
        System.out.println("  Enter the operation to be performed :\n");
        System.out.println("1.Create  2.Retrieve 3.Update 4.Delete\n");
        log.info("prompting user input");
        int i=sc.nextInt();
        switch(i){
            case 1:
                log.info("user opted for inserting to backend database");
                System.out.println("Enter details");
                System.out.println("Name :");
                person.setName(sc.next());
                System.out.println("Email :");
                person.setEmail(sc.next());
                System.out.println("Image path :");
                crudconnect.create(person);
                log.info("user has created a record at the database");
                break;
            case 2:
                log.info("user opted for retriving from database");
                System.out.println(" Details are :");
               // String n =sc.next();
                crudconnect.retrieve("true");
                log.info("user has viewed the table contents ");
                break;
            case 3:
                log.info("user opted for updating to the database");
                System.out.println("Enter the email of the person whose details are to be updated");
                person.setEmail(sc.next());
                System.out.println("Enter Name :");
                person.setName(sc.next());
                System.out.println("Enter Image path :");
                crudconnect.update(person);
                log.info("user has updated a existing record");
                break;
            case 4:
                log.info("user opted for deletion from database");
                System.out.println("  Enter the email address of the person whose record is to be deleted :");
                String str=sc.next();
                crudconnect.delete(str);
                log.info("user droped a person record form the database");
                break;

        }


    }




}
