/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Conextion.Conexiones;
import cjb.ci.Mensaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author mosh_
 */
public class Estados
{
    private int id_estado;
    private String nombre_estado;
    private String capital;
    
    PreparedStatement ps;
    ResultSet rs;

    public Estados()
    {
    }

    public Estados(int id_estado, String nombre_estado, String capital)
    {
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
        this.capital = capital;
    }

    /**
     * @return the id_estado
     */
    public int getId_estado()
    {
        return id_estado;
    }

    /**
     * @param id_estado the id_estado to set
     */
    public void setId_estado(int id_estado)
    {
        this.id_estado = id_estado;
    }

    /**
     * @return the nombre_estado
     */
    public String getNombre_estado()
    {
        return nombre_estado;
    }

    /**
     * @param nombre_estado the nombre_estado to set
     */
    public void setNombre_estado(String nombre_estado)
    {
        this.nombre_estado = nombre_estado;
    }

    /**
     * @return the capital
     */
    public String getCapital()
    {
        return capital;
    }

    /**
     * @param capital the capital to set
     */
    public void setCapital(String capital)
    {
        this.capital = capital;
    }

    
    public Object consultaUnicaid(String id, Connection con)
    {
        Estados est = new Estados();
        try
        {
        
            ps = con.prepareStatement("SELECT * FROM estados WHERE id_estado=?");
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                est.setId_estado(rs.getInt("id_estado"));
                est.setNombre_estado(rs.getString("nombre_estado"));
                est.setCapital(rs.getString("capital"));
                return est;
            }
            else
            {
                Mensaje.error(null, "No hay empleados registrados");
                
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }
    
    public Object consultaUnicaEstado(String estado, Connection con)
    {
        Estados est = new Estados();
        try
        {
            ps = con.prepareStatement("SELECT * FROM estados WHERE nombre_estado=?");
            ps.setString(1, estado);
            rs = ps.executeQuery();
            if (rs.next())
            {
                est.setId_estado(rs.getInt("id_estado"));
                est.setNombre_estado(rs.getString("nombre_estado"));
                est.setCapital(rs.getString("capital"));
                return est;
            }
            else
            {
                Mensaje.error(null, "Estado no encontrado");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return null;
    }
    
    public Estados[] consultaMultipleVec(Connection con){  
        try {
            String sql = "SELECT * FROM estados";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ultimo = rs.last();
            int total=0;
            if (ultimo) {
                total=rs.getRow();
            }
            
            System.out.println(total);
            int i=0;
            Estados[] filas = new Estados[total];
            rs.first();
            Estados est = new Estados(rs.getInt("id_estado"), rs.getString("nombre_estado"), rs.getString("capital"));
            filas[i++] = est;
            while (rs.next()) {
                 est = new Estados(rs.getInt("id_estado"), rs.getString("nombre_estado"), rs.getString("capital"));
            filas[i++] = est;
                
            }
            return filas;
    }catch(Exception e){
            System.out.println("Error"+e.toString());
    }
        return null;
    }
}
