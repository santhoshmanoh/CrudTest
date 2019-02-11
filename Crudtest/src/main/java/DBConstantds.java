public class DBConstantds {

    public static final String a = "INSERT INTO details (name,email,image) values (?, ?, ?)";
    public static final String b ="SELECT * FROM details";
    public static final String c="UPDATE details SET name=?, image=? WHERE email=?";
    public static final String d="DELETE FROM details WHERE email=?";
}
