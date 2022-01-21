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
public class Productos
{

    private int id_productos;
    private String nombre_producto;
    private int id_categoria;
    private String descripcion;
    private float precio_fabricacion;
    private float precio_venta;

    PreparedStatement ps;
    ResultSet rs;

    public Productos()
    {
    }

    public Productos(int id_productos, String nombre_producto,int id_categoria ,String descripcion, float precio_fabricacion, float precio_venta)
    {
        this.id_productos = id_productos;
        this.nombre_producto = nombre_producto;
        this.id_categoria = id_categoria;
        this.descripcion = descripcion;
        this.precio_fabricacion = precio_fabricacion;
        this.precio_venta = precio_venta;
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
     * @return the nombre_producto
     */
    public String getNombre_producto()
    {
        return nombre_producto;
    }

    /**
     * @param nombre_producto the nombre_producto to set
     */
    public void setNombre_producto(String nombre_producto)
    {
        this.nombre_producto = nombre_producto;
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

    /**
     * @return the precio_fabricacion
     */
    public float getPrecio_fabricacion()
    {
        return precio_fabricacion;
    }

    /**
     * @param precio_fabricacion the precio_fabricacion to set
     */
    public void setPrecio_fabricacion(float precio_fabricacion)
    {
        this.precio_fabricacion = precio_fabricacion;
    }

    /**
     * @return the precio_venta
     */
    public float getPrecio_venta()
    {
        return precio_venta;
    }

    /**
     * @param precio_venta the precio_venta to set
     */
    public void setPrecio_venta(float precio_venta)
    {
        this.precio_venta = precio_venta;
    }
    
    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void inserta(JFrame jf, Object obj, Connection con)
    {
        Productos prod = (Productos) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO productos VALUES (?,?,?,?,?,?)");            
            ps.setInt(1, prod.getId_productos());
            ps.setString(2, prod.getNombre_producto());
            ps.setInt(3, prod.getId_categoria());
            ps.setString(4, prod.getDescripcion());
            ps.setFloat(5, prod.getPrecio_fabricacion());
            ps.setFloat(6, prod.getPrecio_venta());

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Producto registrado");
            } else
            {
                Mensaje.error(jf, "No se pudo registrar este producto!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void elimina(JFrame jf,int id, Connection con)
    {
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("DELETE FROM productos WHERE id_productos=?");
            ps.setInt(1, id);

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Prodcuto eliminado");
            } else
            {
                Mensaje.error(jf, "No se puede eliminar este producto");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void modifica(JFrame jf, Object obj, Connection con)
    {
        Productos pro = (Productos) obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE productos SET nombre_producto=?,id_categoria=?,descripcion=?,precio_fabricacion=?,precio_venta=? WHERE id_productos=?");
            ps.setString(1, pro.getNombre_producto());
            ps.setInt(2, pro.getId_categoria());
            ps.setString(3, pro.getDescripcion());
            ps.setFloat(4, pro.getPrecio_fabricacion());
            ps.setFloat(5, pro.getId_categoria());
            ps.setInt(6, pro.getId_productos());
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Prodcuto modifcado");
            } else
            {
                Mensaje.error(jf, "No se puede modificar este producto!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public Object consultaUnica(int id, Connection con)
    {
        Productos pro = new Productos();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM productos WHERE id_productos=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                pro.setId_productos(rs.getInt("id_productos"));
                pro.setId_categoria(rs.getInt("id_categoria"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio_fabricacion(rs.getFloat("precio_fabricacion"));
                pro.setPrecio_venta(rs.getFloat("precio_venta"));
            }
            else
            {
                Mensaje.error(null, "No hay productos registrados");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return pro;
    }
    
    public Productos[] consultaMultipleVec(Connection con){  
        try {
            
            String sql = "SELECT * FROM productos";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ultimo = rs.last();
            int total=0;
            if (ultimo) {
                total=rs.getRow();
            }
            
            System.out.println(total);
            int i=0;
            Productos[] filas = new Productos[total];
            rs.first();
            Productos pro = new Productos(rs.getInt("id_productos"), rs.getString("nombre_producto"), rs.getInt("id_categoria"), rs.getString("descripcion"), rs.getFloat("precio_fabricacion"), rs.getFloat("precio_venta"));
            filas[i++] = pro;
            while (rs.next()) {
                 pro = new Productos(rs.getInt("id_productos"), rs.getString("nombre_producto"), rs.getInt("id_categoria"), rs.getString("descripcion"), rs.getFloat("precio_fabricacion"), rs.getFloat("precio_venta"));
            filas[i++] = pro;
                
            }
            return filas;
    }catch(Exception e){
            System.out.println("Error"+e.toString());
    }
        return null;
    }

    
    
}
