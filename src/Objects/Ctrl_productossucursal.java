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
import javax.swing.JFrame;

/**
 *
 * @author mosh_
 */
public class Ctrl_productossucursal
{
    private int id_productosucursal;
    private int id_sucursal;
    private int id_almacen;
    private int id_productos;
    private int stok_producto;
    
    PreparedStatement ps;
    ResultSet rs;
    public Ctrl_productossucursal()
    {
    }

    public Ctrl_productossucursal(int id_productosucursal, int id_sucursal, int id_almacen, int id_productos, int stok_producto)
    {
        this.id_productosucursal = id_productosucursal;
        this.id_sucursal = id_sucursal;
        this.id_almacen = id_almacen;
        this.id_productos = id_productos;
        this.stok_producto = stok_producto;
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
     * @return the id_almacen
     */
    public int getId_almacen()
    {
        return id_almacen;
    }

    /**
     * @param id_almacen the id_almacen to set
     */
    public void setId_almacen(int id_almacen)
    {
        this.id_almacen = id_almacen;
    }

    /**
     * @return the id_categoria
     */
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
     * @return the stok_producto
     */
    public int getStok_producto()
    {
        return stok_producto;
    }

    /**
     * @param stok_producto the stok_producto to set
     */
    public void setStok_producto(int stok_producto)
    {
        this.stok_producto = stok_producto;
    }
    
    
    public void inserta(Object obj, Connection con)
    {
        Ctrl_productossucursal cps = (Ctrl_productossucursal)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO ctrl_productossucursal VALUES (?,?,?,?,?)");
            ps.setInt(1,cps.getId_productosucursal() );
            ps.setInt(2, cps.getId_sucursal());
            ps.setInt(3, cps.getId_almacen());
            ps.setInt(4, cps.getId_productos());
            ps.setInt(5, cps.getStok_producto());
            
            int res = ps.executeUpdate();
            
            if (res > 0)
            {
                Mensaje.exito(null, "Producto registrado con exito");
            }
            else
            {
                Mensaje.error(null, "El producto no se pudo registrar!!!");
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
            ps = con.prepareStatement("DELETE FROM ctrl_productossucursal WHERE id_productosucursal=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            if (res > 0)
            {
                Mensaje.exito(null, "Producto eliminado");
            }
            else
            {
                Mensaje.error(null, "No se pudo eliminar el producto!!!1");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void modifica(JFrame jf, Object obj, Connection con)
    {
        Ctrl_productossucursal cps = (Ctrl_productossucursal)obj;
        try
        {
            ps = con.prepareStatement("UPDATE ctrl_productossucursal SET id_sucursal=?,id_almacen=?,id_productos=?,stok_producto=? WHERE id_productosucursal=?");
            ps.setInt(1, cps.getId_sucursal());
            ps.setInt(2, cps.getId_almacen());
            ps.setInt(3, cps.getId_productos());
            ps.setInt(4, cps.getStok_producto());
            ps.setInt(5, cps.getId_productosucursal());
            int res = ps.executeUpdate();
            
            if (res > 0)
            {
                Mensaje.exito(jf, "Productos modificado con exito");
            }
            else
            {
                Mensaje.error(jf, "No se pudo modificar el producto!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Ctrl_productossucursal cps = new Ctrl_productossucursal();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM ctrl_productossucursal WHERE id_productosucursal=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                cps.setId_productosucursal(rs.getInt("id_productosucursal"));
                cps.setId_sucursal(rs.getInt("id_sucursal"));
                cps.setId_almacen(rs.getInt("id_almacen"));
                cps.setId_productos(rs.getInt("id_productos"));
                cps.setStok_producto(rs.getInt("stok_producto"));
            }
            else
            {
                Mensaje.error(null, "No se encontraron produtos");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return cps;
    }

    
}
