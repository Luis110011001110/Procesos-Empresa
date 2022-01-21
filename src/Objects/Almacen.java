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
import javax.swing.JOptionPane;

/**
 *
 * @author mosh_
 */
public class Almacen
{

    private int id_almacen;
    private String nombre_almacen;
    private String descripcion;
    private PreparedStatement ps;
    private ResultSet rs;

    public Almacen()
    {
    }

    public Almacen(int id_almacen, String nombre_almacen, String descripcion)
    {
        this.id_almacen = id_almacen;
        this.nombre_almacen = nombre_almacen;
        this.descripcion = descripcion;
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
     * @return the nombre_almacen
     */
    public String getNombre_almacen()
    {
        return nombre_almacen;
    }

    /**
     * @param nombre_almacen the nombre_almacen to set
     */
    public void setNombre_almacen(String nombre_almacen)
    {
        this.nombre_almacen = nombre_almacen;
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
     * @return the ps
     */
    public PreparedStatement getPs()
    {
        return ps;
    }

    /**
     * @param ps the ps to set
     */
    public void setPs(PreparedStatement ps)
    {
        this.ps = ps;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs()
    {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs)
    {
        this.rs = rs;
    }

    public void inserta(Object obj, Connection con)
    {
        Almacen alm = (Almacen) obj;
        try
        {
            setPs(con.prepareStatement("INSERT INTO almacen (id_almacen,nombre_almacen,descripcion) VALUES (?,?,?)"));
            getPs().setInt(1, alm.getId_almacen());
            getPs().setString(2, alm.getNombre_almacen());
            getPs().setString(3, alm.getDescripcion());

            int res = getPs().executeUpdate();

            if (res > 0)
            {
                JOptionPane.showMessageDialog(null, "Almacen registrado con exito");
            } else
            {
                JOptionPane.showMessageDialog(null, "No se registro el almacen");
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
            setPs(con.prepareStatement("DELETE FROM almacen WHERE id_almacen=?"));
            getPs().setInt(1, id);
            int res = getPs().executeUpdate();

            if (res > 0)
            {
                Mensaje.exito(null, "Almacen eliminado con exito");

            } else
            {
                Mensaje.error(null, "No se pudo eliminar el almacen registrado");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void modifica(JFrame jf, Object obj, Connection con)
    {
        Almacen alm = (Almacen) obj;
        try
        {
            con = Conexiones.conectar();
            setPs(con.prepareStatement("UPDATE almacen SET nombre_almacen=?, descripcion=? WHERE id_almacen=?"));
            getPs().setString(1, alm.getNombre_almacen());
            getPs().setString(2, alm.getDescripcion());
            getPs().setInt(3, alm.getId_almacen());

            int res = ps.executeUpdate();

            if (res > 0)
            {
                Mensaje.exito(jf, "Almacen modificado con exito");
            } else
            {
                Mensaje.error(jf, "No se pudo modificar este almacen");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public Object consultaUnica(String id, Connection con)
    {
        Almacen alm = new Almacen();
        try
        {
            con = Conexiones.conectar();
            setPs(con.prepareStatement("SELECT * FROM almacen WHERE id_almacen=?"));
            getPs().setString(1, id);

            setRs(getPs().executeQuery());
            if (getRs().next())
            {
                alm.setId_almacen(rs.getInt("id_almacen"));
                alm.setNombre_almacen(rs.getString("nombre_almacen"));
                alm.setDescripcion(rs.getString("descripcion"));
            } else
            {
                Mensaje.error(null, "No se enoctro ningun almacen");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return alm;
    }

    public Almacen[] consultaMultipleVec(Connection con)
    {
        try
        {
            String sql = "SELECT * FROM almacen";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ultimo = rs.last();
            int total = 0;
            if (ultimo)
            {
                total = rs.getRow();
            }

            System.out.println(total);
            int i = 0;
            Almacen[] filas = new Almacen[total];
            rs.first();
            Almacen suc = new Almacen(rs.getInt("id_almacen"), rs.getString("nombre_almacen"), rs.getString("descripcion"));
            filas[i++] = suc;
            while (rs.next())
            {
                suc = new Almacen(rs.getInt("id_almacen"), rs.getString("nombre_almacen"), rs.getString("descripcion"));
                filas[i++] = suc;

            }
            return filas;
        } catch (Exception e)
        {
            System.out.println("Error" + e.toString());
        }
        return null;
    }
}
