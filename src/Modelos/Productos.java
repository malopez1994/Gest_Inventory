/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Miguel Lopez
 */
public class Productos {
     public Integer Id ;
     public String Nombre;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getP_Unitario() {
        return P_Unitario;
    }

    public void setP_Unitario(Integer P_Unitario) {
        this.P_Unitario = P_Unitario;
    }

    public Integer getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(Integer Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }
     public Integer P_Unitario;
     public Integer Id_Proveedor;
    }
