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
public class Venta_productos
{
    private int id_ventaproductos;
    private int id_venta;
    private int id_productosucursal;
    private int id_categoria;
    private int cantida_vendida;
    private String descripcion;

    PreparedStatement ps;
    ResultSet rs;

    public Venta_productos()
    {
    }

    
    public Venta_productos(int id_ventaproductos, int id_venta, int id_productosucursal, int id_categoria, int cantida_vendida, String descripcion)
    {
        this.id_ventaproductos = id_ventaproductos;
        this.id_venta = id_venta;
        this.id_productosucursal = id_productosucursal;
        this.id_categoria = id_categoria;
        this.cantida_vendida = cantida_vendida;
        this.descripcion = descripcion;
    }

    /**
     * @return the id_ventaproductos
     */
    public int getId_ventaproductos()
    {
        return id_ventaproductos;
    }

    /**
     * @param id_ventaproductos the id_ventaproductos to set
     */
    public void setId_ventaproductos(int id_ventaproductos)
    {
        this.id_ventaproductos = id_ventaproductos;
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
     * @return the id_productosucursal
     */
    public int getId_productosucursal()
    {
        return id_productosucursal;
    }

    /**
     * @param id_productosucursal the id_productosucursal to set
     */
    public void setId_productosucursal(int id_productosucursal)
    {
        this.id_productosucursal = id_productosucursal;
    }

    /**
     * @return the id_categoria
     */
    public int getId_categoria()
    {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria)
    {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the cantida_vendida
     */
    public int getCantida_vendida()
    {
        return cantida_vendida;
    }

    /**
     * @param cantida_vendida the cantida_vendida to set
     */
    public void setCantida_vendida(int cantida_vendida)
    {
        this.cantida_vendida = cantida_vendida;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    
    public void inserta(Object obj, Connection con)
    {
        Venta_productos vp = (Venta_productos)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO venta_productos VALUES(?,?,?,?,?,?)");
            ps.setInt(1, vp.getId_ventaproductos());
            ps.setInt(2, vp.getId_venta());
            ps.setInt(3, vp.getId_productosucursal());
            ps.setInt(4, vp.getId_categoria());
            ps.setInt(5, vp.getCantida_vendida());
            ps.setString(6, vp.getDescripcion());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Venta Registrada");
            }
            else
            {
                Mensaje.error(null, "No se puede registrar esta venta!!!");
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
            ps = con.prepareStatement("DELETE FROM venta_productos WHERE id_ventaproductos=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Venta eliminada");
            }
            else
            {
                Mensaje.error(null, "No se puede eliminar esta venta");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void modifica(int id, Object obj, Connection con)
    {
        Venta_productos vrn = (Venta_productos)obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE venta_productos SET cantidad_vendida=?,descripcion=? WHERE id_ventaproductos=?");
            ps.setInt(1, id);
            ps.setInt(5, vrn.getCantida_vendida());
            ps.setString(6, vrn.getDescripcion());
            
            int res = ps.executeUpdate();
            if (res >0)
            {
                Mensaje.exito(null, "Venta modificada");
            }
            else
            {
                Mensaje.error(null, "No se puede modificar esta venta");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Venta_productos vn = new Venta_productos();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM venta_productos WHERE id_ventaproductos=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                vn.setId_ventaproductos(rs.getInt("id_ventaproductos"));
                vn.setId_venta(rs.getInt("id_venta"));
                vn.setId_productosucursal(rs.getInt("id_productosucursal"));
                vn.setId_categoria(rs.getInt("id_categoria"));
                vn.setCantida_vendida(rs.getInt("cantidad_vendida"));
                vn.setDescripcion(rs.getString("descripcion"));
            }
            else
            {
                Mensaje.error(null, "No hay ventas de prouctos registradas!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return vn;
    }
}
