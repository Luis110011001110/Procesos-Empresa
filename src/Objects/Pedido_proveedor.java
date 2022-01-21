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
public class Pedido_proveedor
{
    private int id_pedidoproveedor;
    private int id_sucursal;
    private int id_empleado;
    private int id_productos;
    private int id_proveedor;
    private int id_solicitud;
    private int cnatidad_solicitada;
    private float precio_unitario;
    
    PreparedStatement ps;
    ResultSet rs;

    public Pedido_proveedor()
    {
    }

    public Pedido_proveedor(int id_pedidoproveedor, int id_sucursal, int id_empleado, int id_productos, int id_proveedor, int id_solicitud, int cnatidad_solicitada, float precio_unitario)
    {
        this.id_pedidoproveedor = id_pedidoproveedor;
        this.id_sucursal = id_sucursal;
        this.id_empleado = id_empleado;
        this.id_productos = id_productos;
        this.id_proveedor = id_proveedor;
        this.id_solicitud = id_solicitud;
        this.cnatidad_solicitada = cnatidad_solicitada;
        this.precio_unitario = precio_unitario;
    }

    /**
     * @return the id_pedidoproveedor
     */
    public int getId_pedidoproveedor()
    {
        return id_pedidoproveedor;
    }

    /**
     * @param id_pedidoproveedor the id_pedidoproveedor to set
     */
    public void setId_pedidoproveedor(int id_pedidoproveedor)
    {
        this.id_pedidoproveedor = id_pedidoproveedor;
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
     * @return the id_productos
     */
    public int getId_productos()
    {
        return id_productos;
    }

    /**
     * @param id_productos the id_productos to set
     */
    public void setId_productos(int id_productos)
    {
        this.id_productos = id_productos;
    }

    /**
     * @return the id_proveedor
     */
    public int getId_proveedor()
    {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(int id_proveedor)
    {
        this.id_proveedor = id_proveedor;
    }

    /**
     * @return the id_solicitud
     */
    public int getId_solicitud()
    {
        return id_solicitud;
    }

    /**
     * @param id_solicitud the id_solicitud to set
     */
    public void setId_solicitud(int id_solicitud)
    {
        this.id_solicitud = id_solicitud;
    }

    /**
     * @return the cnatidad_solicitada
     */
    public int getCnatidad_solicitada()
    {
        return cnatidad_solicitada;
    }

    /**
     * @param cnatidad_solicitada the cnatidad_solicitada to set
     */
    public void setCnatidad_solicitada(int cnatidad_solicitada)
    {
        this.cnatidad_solicitada = cnatidad_solicitada;
    }

    /**
     * @return the precio_unitario
     */
    public float getPrecio_unitario()
    {
        return precio_unitario;
    }

    /**
     * @param precio_unitario the precio_unitario to set
     */
    public void setPrecio_unitario(float precio_unitario)
    {
        this.precio_unitario = precio_unitario;
    }
    
    public void inserta(Object obj, Connection con)
    {
        Pedido_proveedor pedi = (Pedido_proveedor)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO pedido_proveedor VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, pedi.getId_pedidoproveedor());
            ps.setInt(2, pedi.getId_sucursal());
            ps.setInt(3, pedi.getId_empleado());
            ps.setInt(4, pedi.getId_productos());
            ps.setInt(5, pedi.getId_proveedor());
            ps.setInt(6, pedi.getId_solicitud());
            ps.setInt(7, pedi.getCnatidad_solicitada());
            ps.setFloat(8, pedi.getPrecio_unitario());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Pedido registrado");
            }
            else
            {
                Mensaje.error(null, "El pedido no se pudo registrar");
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
            ps = con.prepareStatement("DELETE FROM pedido_proveedor WHERE id_pedidoproveedor=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Pedido eliminado");
            }
            else
            {
                Mensaje.error(null, "No se puede elimianr este pedido");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Pedido_proveedor pedi = new Pedido_proveedor();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM pedido_proveedor WHERE id_pedidoproveedor=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                pedi.setId_pedidoproveedor(rs.getInt("id_pedidoproveedor"));
                pedi.setId_sucursal(rs.getInt("id_sucursal"));
                pedi.setId_empleado(rs.getInt("id_empleado"));
                pedi.setId_productos(rs.getInt("id_productos"));
                pedi.setId_proveedor(rs.getInt("id_proveedor"));
                pedi.setId_solicitud(rs.getInt("id_solicitud"));
                pedi.setCnatidad_solicitada(rs.getInt("cantidad_solicitada"));
                pedi.setPrecio_unitario(rs.getFloat("precio_unitario"));
            }
            else
            {
                Mensaje.error(null, "No se encontraron pedidos");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return pedi;
    }
}
