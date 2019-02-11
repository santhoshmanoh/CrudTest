import java.io.*;
import java.sql.*;
import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.util.logging.*;
import static com.mysql.cj.conf.PropertyKey.logger;

public class Crudconnect extends DataSource {
    private final static Logger log = Logger.getLogger(Crudconnect.class.getName());

    public Person create(Person person) throws Exception {
        log.info("Connecting to Database process initiated");
        try {
            Connection c = getDBConnection("jdbc:mysql://localhost:3306/santhosh", "root", "activeai2019");
            PreparedStatement stmt = c.prepareStatement(DBConstantds.a);
            log.info("Insertion procedure Initiated");
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getEmail());
            // Blob blob = new SerialBlob(person.getImagepath());
            //    Scanner sc=new Scanner(System.in);
            File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
            FileInputStream f = new FileInputStream(file);
            byte[] byteArray = new byte[(int) (file.length())];
            // stmt.setBlob(3,person.setImagepath(byteArray));
            stmt.setBlob(3, f, (int) file.length());
            stmt.executeUpdate();
            System.out.println(" Record created successfully");
            c.close();

        } catch (SQLException e) {
            log.warn("exception  thrown from the SQL workbench ");
            throw new SQLException(e);
        }

        return person;
    }

    public Person retrieve(String name) throws Exception {
        try {
            Connection c = getDBConnection("jdbc:mysql://localhost:3306/santhosh", "root", "activeai2019");
            PreparedStatement stmt = c.prepareStatement(DBConstantds.b);
            log.info("Retrieval from database initiated");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getBlob(3));
            }

            if (!rs.first()) {
                return null;
            }

            Blob blob;
            Person p = new Person();
            p.setName(rs.getString(1));
            p.setEmail(rs.getString(2));
            blob = rs.getBlob("image");
            byte b[] = blob.getBytes(1, (int) blob.length());
            p.setImagepath(b);
            //  System.out.println(rs.getString(1) +"  "+ rs.getString(2) +"  "+ rs.getBlob(3));
            c.close();
            return p;

        } catch (SQLException e) {
            log.warn("insertion interrupted with exception  thrown from the SQL workbench ");
            throw new SQLException(e);
        }

    }

    public Person update(Person person) throws Exception {

        try {
            Connection c = getDBConnection("jdbc:mysql://localhost:3306/santhosh", "root", "activeai2019");
            PreparedStatement stmt = c.prepareStatement(DBConstantds.c);
            log.info("Updating to database initiated");
            stmt.setString(1, person.getName());
            // Scanner sc=new Scanner(System.in);
            File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
            FileInputStream f = new FileInputStream(file);
            // byte[] byteArray = new byte[(int)(file.length())];
            //  stmt.setBlob(3,person.setImagepath(byteArray));
            stmt.setBlob(2, f, (int) file.length());
            stmt.setString(3, person.getEmail());
            //  Blob blob = new SerialBlob(person.getImagepath());
            // stmt.setBlob(2,blob);
            stmt.executeUpdate();
            System.out.println("Updated successfully");
            c.close();
        } catch (SQLException e) {
            log.warn("updation interrupted with exception  thrown from the SQL workbench ");
            throw new SQLException(e);
        }
        return person;
    }

    public Boolean delete(String email) throws Exception {
        Person person = new Person();
        try {
            Connection c = getDBConnection("jdbc:mysql://localhost:3306/santhosh", "root", "activeai2019");
            PreparedStatement stmt = c.prepareStatement(DBConstantds.d);
            log.info("Deletion from database initiated");
            stmt.setString(1, email);
            int a = stmt.executeUpdate();
            if (a > 0) {
                System.out.println("Row deleted successfully");
                return true;
            }
            c.close();
        } catch (SQLException e) {
            log.warn(" deletion interrupted with exception  thrown from the SQL workbench ");
            throw new SQLException(e);
        }
        return true;
    }

}