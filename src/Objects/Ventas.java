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
public class Ventas
{
    private int id_venta;
    private int id_sucursal;
    private int id_empleado;
    private float cantidad_vendida;
    private String fecha_venta;

    PreparedStatement ps;
    ResultSet rs;
    
    public Ventas()
    {
    }

    public Ventas(int id_venta, int id_sucursal, int id_empleado, float cantidad_vendida, String fecha_venta)
    {
        this.id_venta = id_venta;
        this.id_sucursal = id_sucursal;
        this.id_empleado = id_empleado;
        this.cantidad_vendida = cantidad_vendida;
        this.fecha_venta = fecha_venta;
    }

    /**
     * @return the id_venta
     */
    public int getId_venta()
    {
        return id_venta;
    }

    /**
     * @param id_venta the id_venta to set
     */
    public void setId_venta(int id_venta)
    {
        this.id_venta = id_venta;
    }

    /**
     * @return the id_sucursal
     */
    public int getId_sucursal()
    {
        return id_sucursal;
    }

    /**
     * @param id_sucursal the id_sucursal to set
     */
    public void setId_sucursal(int id_sucursal)
    {
        this.id_sucursal = id_sucursal;
    }

    /**
     * @return the id_empleado
     */
    public int getId_empleado()
    {
        return id_empleado;
    }

    /**
     * @param id_empleado the id_empleado to set
     */
    public void setId_empleado(int id_empleado)
    {
        this.id_empleado = id_empleado;
    }

    /**
     * @return the cantidad_vendida
     */
    public float getCantidad_vendida()
    {
        return cantidad_vendida;
    }

    /**
     * @param cantidad_vendida the cantidad_vendida to set
     */
    public void setCantidad_vendida(float cantidad_vendida)
    {
        this.cantidad_vendida = cantidad_vendida;
    }

    /**
     * @return the fecha_venta
     */
    public String getFecha_venta()
    {
        return fecha_venta;
    }

    /**
     * @param fecha_venta the fecha_venta to set
     */
    public void setFecha_venta(String fecha_venta)
    {
        this.fecha_venta = fecha_venta;
    }
    
    public void inserta(Object obj, Connection con)
    {
        Ventas vt = (Ventas)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO ventas VALUES (?,?,?,?,?)");
            ps.setInt(1, vt.getId_venta());
            ps.setInt(2, vt.getId_sucursal());
            ps.setInt(3, vt.getId_empleado());
            ps.setFloat(4, vt.getCantidad_vendida());
            ps.setString(5, vt.getFecha_venta());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Venta registrada");
            }
            else
            {
                Mensaje.error(null, "No se pudo registrar esta venta");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void elimina(int id, Connection con)
    {
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("DELETE FROM ventas WHERE id_venta=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Venta eliminada");
            }
            else
            {
                Mensaje.error(null, "No se puede eliminar esta venta!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void modifica(int id, Object obj, Connection con)
    {
        Ventas vnt = (Ventas)obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE ventas SET cantidad_vendida=?,fecha_venta=? WHERE id_venta=?");
            ps.setInt(1, id);
            ps.setFloat(4, vnt.getCantidad_vendida());
            ps.setString(5, vnt.getFecha_venta());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Venta modifcada");
            }
            else
            {
                Mensaje.error(null, "No se puede modifcar esta venta");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Ventas ven = new Ventas();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM ventas WHERE id_venta=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                ven.setId_venta(rs.getInt("id_venta"));
                ven.setId_sucursal(rs.getInt("id_sucursal"));
                ven.setId_empleado(rs.getInt("id_empleado"));
                ven.setCantidad_vendida(rs.getInt("cantidad_vendida"));
                ven.setFecha_venta(rs.getString("fecha_venta"));
            }
            else
            {
                Mensaje.error(null,"No hay ventas registradas");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return ven;
    }
}
