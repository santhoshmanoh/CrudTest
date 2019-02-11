import java.sql.Blob;

public class Person {

    String name;
    String email;
    byte[] imagepath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImagepath() {
        return imagepath;
    }

    public void setImagepath(byte[] imagepath) {
        this.imagepath = imagepath;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Name :" + name + "\n");

        return buffer.toString();
    }
}