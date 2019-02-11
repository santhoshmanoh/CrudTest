import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class Testclass {
    final Logger log = Logger.getLogger(Mainclass.class.getName());

    @Mock
    private DataSource ds;
    @Mock
    private Connection c;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;

    @Before
    public void setUp() throws Exception {
        Person p = new Person();
        p.setName("Avinashe");
        p.setEmail("avi@gmail");
        File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
        FileInputStream f = new FileInputStream(file);
        byte[] byteArray = new byte[(int) (file.length())];
        f.read(byteArray);
        p.setImagepath(byteArray);
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);
        when(rs.first()).thenReturn(true);
        when(rs.getString(1)).thenReturn("Avinashe");
        when(rs.getString(2)).thenReturn(p.getEmail());
        // when(rs.getBlob(3)).thenReturn(p.getImagepath());
        when(stmt.executeQuery()).thenReturn(rs);
    }

    @Test(expected = NullPointerException.class)
    public void nullCreateThrowsException() throws Exception {
        Person p = new Person();
        new Crudconnect().create(null);
        if (p == null)
            log.setLevel(Level.ERROR);
    }

    @Test
    public void createPerson() throws Exception {
        Person p = new Person();
        Crudconnect dao = new Crudconnect();
        p.setName("Avinashe");
        p.setEmail("avi@gmail");
        File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
        FileInputStream f = new FileInputStream(file);
        byte[] byteArray = new byte[(int) (file.length())];
        f.read(byteArray);
        p.setImagepath(byteArray);
        Crudconnect c1 = new Crudconnect();
        assertSame(p, c1.create(p));
        dao.delete(p.getEmail());


    }

    @Test
    public void createAndRetrievePerson() throws Exception {
        Person p = new Person();
        p.setName("Avinashe");
        p.setEmail("avi@gmail");
        File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
        FileInputStream f = new FileInputStream(file);
        byte[] byteArray = new byte[(int) (file.length())];
        f.read(byteArray);
        p.setImagepath(byteArray);
        Crudconnect dao = new Crudconnect();
        // dao.create(p);
        System.out.println(p.toString());
        Person r = dao.retrieve(p.getName());
       System.out.println(r.toString());
        assertEquals(p.name, r.name);
         //dao.delete(p.getEmail());
    }

    @Test
    public void deletedperson() throws Exception {
        Person p = new Person();
        Crudconnect dao = new Crudconnect();
        Boolean B = dao.delete(p.getEmail());
        assertTrue(B);
    }

    @Test
    public void updatePerson() throws Exception {
        Person p = new Person();
        p.setName("Avinashe");
        p.setEmail("avi@gmail");
        File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
        FileInputStream f = new FileInputStream(file);
        byte[] byteArray = new byte[(int) (file.length())];
        f.read(byteArray);
        p.setImagepath(byteArray);
        Crudconnect c1 = new Crudconnect();
        assertSame(p, c1.update(p));

    }
    @After
    public void teardown() throws Exception {
        Person p = new Person();
        p.setName("Avinashe");
        p.setEmail("avi@gmail");
        File file = new File("/Users/santhosh/Downloads/pexels-photo-237272.jpeg");
        FileInputStream f = new FileInputStream(file);
        byte[] byteArray = new byte[(int) (file.length())];
        f.read(byteArray);
        p.setImagepath(byteArray);
        assertNotNull(ds);
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        when(ds.getConnection()).thenReturn(c);
        when(rs.first()).thenReturn(true);
        when(rs.getString(1)).thenReturn("Avinashe");
        when(rs.getString(2)).thenReturn(p.getEmail());
        // when(rs.getBlob(3)).thenReturn(p.getImagepath());
        when(stmt.executeQuery()).thenReturn(rs);
        Crudconnect c1 = new Crudconnect();
         c1.create(p);
    }
}