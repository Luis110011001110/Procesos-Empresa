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

/**
 *
 * @author mosh_
 */
public class Tipo_sucursal
{

    private int id_tiposucursal;
    private String tipo;

    PreparedStatement ps;
    ResultSet rs;

    public Tipo_sucursal()
    {
    }

    public Tipo_sucursal(int id_tiposucursal, String tipo)
    {
        this.id_tiposucursal = id_tiposucursal;
        this.tipo = tipo;
    }

    /**
     * @return the id_tiposucursal
     */
    public int getId_tiposucursal()
    {
        return id_tiposucursal;
    }

    /**
     * @param id_tiposucursal the id_tiposucursal to set
     */
    public void setId_tiposucursal(int id_tiposucursal)
    {
        this.id_tiposucursal = id_tiposucursal;
    }

    /**
     * @return the tipo
     */
    public String getTipo()
    {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    
    public void insertar(Object obj, Connection con)
    {
        Tipo_sucursal tip = (Tipo_sucursal) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO tipo_sursal VALUES (?,?)");
            ps.setInt(1, tip.getId_tiposucursal());
            ps.setString(2, tip.getTipo());

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Tipo de sucursal registrado");
            } else
            {
                Mensaje.error(null, "Tipo de sucursal no agregado");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void eliminar(int id, Connection con)
    {
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("DELETE FROM tipo_sursal WHERE id_tiposucursal=?");
            ps.setInt(1, id);

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "tipo eliminado");
            } else
            {
                Mensaje.error(null, "el tipo no se pudo eliminar");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public Object consultaUnica(int id, Connection con)
    {
        Tipo_sucursal tip = new Tipo_sucursal();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM tipo_sursal WHERE id_tiposucursal=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                tip.setId_tiposucursal(rs.getInt("id_tiposucursal"));
                tip.setTipo(rs.getString("tipo"));
            }
            else
            {
                Mensaje.error(null, "no se encontraron tipos registrados");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return tip;
    }
}
