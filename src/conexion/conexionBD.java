package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
     private static final String host="localhost:3306";
   private static final String user="root";
   private static final String pass="";
   private static final String bd="multideas";
   private static Connection CNBD;
   
   public static Connection ConectarBD() throws SQLException, ClassNotFoundException{
       if(CNBD==null){
       try{
           Class.forName("com.mysql.jdbc.Driver");
          CNBD=DriverManager.getConnection("jdbc:mysql://"+host+"/"+bd+"?zeroDateTimeBehavior=convertToNull",user,pass);
       }catch(SQLException SQLex){
           throw new SQLException(SQLex.getMessage());
       }catch(java.lang.ClassNotFoundException cnfe){
           throw new ClassNotFoundException(cnfe.getMessage());
       }
       return CNBD;
       }else{
           return CNBD;
       }
   }
   
   public Connection obtenerConexion(){
       return CNBD;
   }
}
