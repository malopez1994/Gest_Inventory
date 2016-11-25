/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_GI;

import static Class_GI.UsuariosData.conectar;
import static Class_GI.UsuariosData.pst;
import Modelos.Proveedores;
import Modelos.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Lopez
 */
public class ProveedorData {
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
    
   public ArrayList<Proveedores> Listaproveedores()
    { 
     try 
     {
       conectar();
       ArrayList<Proveedores> ListProveedor = new ArrayList<Proveedores>() ;
       String query = "select id,nombre from proveedores";
       pst = con.prepareStatement(query);
       rs = pst.executeQuery();
       Proveedores proveedor;
       while(rs.next())
       {
           proveedor= new Proveedores();
           proveedor.Id = Integer.parseInt(rs.getObject(1).toString());
           proveedor.Nombre = rs.getObject(2).toString();
           ListProveedor.add(proveedor);
       }
     
     return ListProveedor;
     }
         catch (SQLException | NumberFormatException e) {
            return null;
        }
    }
    
}
