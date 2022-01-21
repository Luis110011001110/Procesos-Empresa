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
public class Proveedores
{

    private int id_proveedor;
    private String nombre_proveedor;
    private String descripcion;
    private String telefono;
    private String correo;
    private String web;

    PreparedStatement ps;
    ResultSet rs;

    public Proveedores()
    {
    }

    public Proveedores(int id_proveedor, String nombre_proveedor, String descripcion, String telefono, String correo, String web)
    {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.correo = correo;
        this.web = web;
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
     * @return the nombre_proveedor
     */
    public String getNombre_proveedor()
    {
        return nombre_proveedor;
    }

    /**
     * @param nombre_proveedor the nombre_proveedor to set
     */
    public void setNombre_proveedor(String nombre_proveedor)
    {
        this.nombre_proveedor = nombre_proveedor;
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
     * @return the telefono
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the web
     */
    public String getWeb()
    {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web)
    {
        this.web = web;
    }

    public void inserta(JFrame jf,Object obj, Connection con)
    {
        Proveedores prov = (Proveedores) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO proveedores VALUES (?,?,?,?,?,?)");
            ps.setInt(1, prov.getId_proveedor());
            ps.setString(2, prov.getNombre_proveedor());
            ps.setString(3, prov.getDescripcion());
            ps.setString(4, prov.getTelefono());
            ps.setString(5, prov.getCorreo());
            ps.setString(6, prov.getWeb());

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Provedor registrado con exito");
            } else
            {
                Mensaje.error(jf, "No se pudo registrar este provedor!!!");
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
            ps = con.prepareStatement("DELETE FROM proveedores WHERE id_proveedor=?");
            ps.setInt(1, id);

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Proveedor Eliminado");
            } else
            {
                Mensaje.error(null, "Este provedor no se puede eliminar!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void modifica(JFrame jf, Object obj, Connection con)
    {
        Proveedores prv = (Proveedores)obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE proveedores SET nombre_proveedor=?,descripcion=?,telefono=?,correo=?,web=? WHERE id_proveedor=?");
            
            ps.setString(1, prv.getNombre_proveedor());
            ps.setString(2, prv.getDescripcion());
            ps.setString(3, prv.getTelefono());
            ps.setString(4, prv.getCorreo());
            ps.setString(5, prv.getWeb());
            ps.setInt(6, prv.getId_proveedor());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Provedor modificado");
            }
            else
            {
                Mensaje.error(jf, "Este proveedor no se puede modificar");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Proveedores prv = new Proveedores();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM proveedores WHERE id_proveedor=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                prv.setId_proveedor(rs.getInt("id_proveedor"));
                prv.setNombre_proveedor(rs.getString("nombre_proveedor"));
                prv.setDescripcion(rs.getString("descripcion"));
                prv.setTelefono(rs.getString("telefono"));
                prv.setCorreo(rs.getString("correo"));
                prv.setWeb(rs.getString("web"));
            }
            else
            {
                Mensaje.error(null, "No hay proveedores registrados");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return prv;
    }
}
