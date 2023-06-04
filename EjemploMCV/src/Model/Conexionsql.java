
package Model;
import java.sql.*;


public class Conexionsql {
    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String query = "";
    
    //constructor
    public Conexionsql() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //"com.mysql.jdbc.Driver"
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplomvc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "12345678JABM");
            s = conexion.createStatement();
        }
        catch(Exception ex){
            System.out.println("ERROR: No encuentro el driver de la BD: " +ex.getMessage());                        
        }
    }
    
    public ResultSet GetRs(){
        return rs;
    }
    
    public void setRs(String consulta){
        try{
            this.rs = s.executeQuery(consulta);
        } catch(SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
        }
    }
    
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
}
