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
public class Pedido_sucursal
{
    private int id_pedidosucursal;
    private int id_sucursal;
    private int id_productos;
    private int id_empleado;
    private int id_solicitud;
    private int cantidad_solicitada;
    private String estado_pedido;
    
    PreparedStatement ps;
    ResultSet rs;

    public Pedido_sucursal()
    {
    }

    public Pedido_sucursal(int id_pedidosucursal, int id_sucursal, int id_productos, int id_empleado, int id_solicitud, int cantidad_solicitada, String estado_pedido)
    {
        this.id_pedidosucursal = id_pedidosucursal;
        this.id_sucursal = id_sucursal;
        this.id_productos = id_productos;
        this.id_empleado = id_empleado;
        this.id_solicitud = id_solicitud;
        this.cantidad_solicitada = cantidad_solicitada;
        this.estado_pedido = estado_pedido;
    }

    /**
     * @return the id_pedidosucursal
     */
    public int getId_pedidosucursal()
    {
        return id_pedidosucursal;
    }

    /**
     * @param id_pedidosucursal the id_pedidosucursal to set
     */
    public void setId_pedidosucursal(int id_pedidosucursal)
    {
        this.id_pedidosucursal = id_pedidosucursal;
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
     * @return the cantidad_solicitada
     */
    public int getCantidad_solicitada()
    {
        return cantidad_solicitada;
    }

    /**
     * @param cantidad_solicitada the cantidad_solicitada to set
     */
    public void setCantidad_solicitada(int cantidad_solicitada)
    {
        this.cantidad_solicitada = cantidad_solicitada;
    }

    /**
     * @return the estado_pedido
     */
    public String getEstado_pedido()
    {
        return estado_pedido;
    }

    /**
     * @param estado_pedido the estado_pedido to set
     */
    public void setEstado_pedido(String estado_pedido)
    {
        this.estado_pedido = estado_pedido;
    }
    
    
    public void insertar (Object obj, Connection con)
    {
        Pedido_sucursal ped = (Pedido_sucursal)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO pedidos_sucursal VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, ped.getId_pedidosucursal());
            ps.setInt(2, ped.getId_sucursal());
            ps.setInt(3, ped.getId_productos());
            ps.setInt(4, ped.getId_empleado());
            ps.setInt(5, ped.getId_solicitud());
            ps.setInt(6, ped.getCantidad_solicitada());
            ps.setString(7, ped.getEstado_pedido());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Pedido Solicitado con exito");
            }
            else
            {
                Mensaje.error(null, "No se pudo realizar este pedido!!!");
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
            ps = con.prepareStatement("DELETE FROM pedidos_sucursal WHERE id_pedidosucursal=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Registro de pedido eliminado");
            }
            else
            {
                Mensaje.exito(null, "No se pudo eliminar este registro del pedido");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Pedido_sucursal ped = new Pedido_sucursal();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM pedidos_sucursal WHERE id_pedidosucursal=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                ped.setId_pedidosucursal(rs.getInt("id_pedidosucursal"));
                ped.setId_sucursal(rs.getInt("id_sucursal"));
                ped.setId_productos(rs.getInt("id_productos"));
                ped.setId_empleado(rs.getInt("id_empleado"));
                ped.setId_solicitud(rs.getInt("id_solicitud"));
                ped.setCantidad_solicitada(rs.getInt("cantidad_solicitada"));
                ped.setEstado_pedido(rs.getString("estado_pedido"));
            }
            else
            {
                Mensaje.error(null, "No hay pedidos registrados!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return ped;
    }
}
