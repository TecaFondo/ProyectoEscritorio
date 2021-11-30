package proyectokohlercarlos;


/**
 *
 * @author Carlos Vincent Kohler Rosasco
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conectar {
    Connection conectar;
    public Connection conexion() throws SQLException{
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/encripta", "root", "");
            Statement statement = conectar.createStatement();
            String table = "CREATE TABLE clave (" +
                   "ID INT(64) NOT NULL AUTO_INCREMENT, " +
                   " Nombre VARCHAR(255), " + 
                   " Clave VARCHAR(255), " + 
                   " Descripcion VARCHAR(255), " + 
                   " MET INT(1),"
                     + "PRIMARY KEY(ID))";
            statement.executeUpdate(table);
            table = "CREATE TABLE usuarios (" +
                   " Nombre VARCHAR(255), " + 
                   " Clave VARCHAR(255), " + 
                   "PRIMARY KEY(Nombre))";
            statement.executeUpdate(table);
            System.out.println("Base de datos creada");
            
        }
        catch(SQLException sqlException){
            //System.out.println(sqlException);
            if(sqlException.getErrorCode() == 1049){
                
                String sql = "CREATE DATABASE encripta";
                conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
                Statement statement = conectar.createStatement();
                statement.executeUpdate(sql);
                conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/encripta", "root", "");
                statement = conectar.createStatement();
                String table = "CREATE TABLE clave (" +
                   "ID INT(64) NOT NULL AUTO_INCREMENT, " +
                   " Nombre VARCHAR(255), " + 
                   " Clave VARCHAR(255), " + 
                   " Descripcion VARCHAR(255), " + 
                   " MET INT(1),"+
                   "Usuario VARCHAR(255),"+
                   "PRIMARY KEY(ID))";
                statement.executeUpdate(table);
                table = "CREATE TABLE usuarios (" +
                   " Nombre VARCHAR(255), " + 
                   " Clave VARCHAR(255), " + 
                   "PRIMARY KEY(Nombre))";
                statement.executeUpdate(table);
                System.out.println("Base de datos creada");
                //statement.executeUpdate(table);
            }
            else{
                if(sqlException.getErrorCode()==1050){
                    return conectar;
                }
                else{
                    sqlException.printStackTrace();
                }
                
            }
        }
        catch (ClassNotFoundException e){   
            System.out.println(e.getMessage());
        }
    return conectar;
    }
}


    
