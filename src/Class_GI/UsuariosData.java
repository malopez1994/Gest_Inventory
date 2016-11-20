package Class_GI;
import Modelos.Usuarios;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Miguel Lopez
 */
public class UsuariosData {
    static Connection con;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    public static void conectar()
   {
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url ="jdbc:oracle:thin:@localhost:1521:XE"; 
        con =  DriverManager.getConnection(url,"G_INVENTORY","desarrollo");
    }
    catch(Exception e)
    {
    }
   }
    
    public  Usuarios validar_usuario(String User,String Pass,String type) throws ClassNotFoundException
    { 
     try 
     {
     Usuarios user = null;
        conectar();
            if(type == "Usuario")
            {
            type = "Usr";
            }
            else
            {
            type = "Adm";
            }
       String query = "select Id,Nombre,Apellido,Usuario,Tipo_Usuario from Usuarios where usuario='"+ User +"' and Contraseña='"+ Pass +"' and Tipo_Usuario = '" + type + "'";
       pst = con.prepareStatement(query);
       rs = pst.executeQuery();
       
       while(rs.next())
       {
       user = new Usuarios();
       user.Id =Integer.parseInt(rs.getObject(1).toString());
       if( rs.getObject(2)==null)
       {
           user.Nombre= "";
       }
       else
       {
           user.Nombre= rs.getObject(2).toString();
       }
       if( rs.getObject(3)==null)
       {
           user.Apellido= "";
       }
       else
       {
           user.Apellido= rs.getObject(3).toString();
       }
       user.Usuario=rs.getObject(4).toString();
       user.Tipo=rs.getObject(5).toString();
       
    //   _user = new Usuarios(Integer.parseInt(rs.getObject(1).toString()), rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString());
     }
     
     return user;
     }
         catch (SQLException | NumberFormatException e) {
            return null;
        }
    }
    
    public boolean crear_usuario(Usuarios User) throws SQLException
    {
    try
    {
      conectar();
      if(User.Tipo == "Usuario")
      {
        User.Tipo = "Usr";
      }
      else
      {
        User.Tipo = "Adm";
      }
      String query = "Insert Into USUARIOS (ID,NOMBRE,APELLIDO,USUARIO,CONTRASEÑA,TIPO_USUARIO,FECHA,ESTADO) values("+ User.Id +",'"+ User.Nombre + "','"+ User.Apellido +"','"+ User.Usuario +"','"+ User.Contraseña +"','"+ User.Tipo +"',SYSDATE,1)";
      st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
      st.executeUpdate(query);
      st.close();
      return true; 
    }
    catch(NumberFormatException e)
    {
      return false;
    }
    }
}
    

