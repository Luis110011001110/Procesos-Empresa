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
public class Empresa
{

    private int id_empresa;
    private String nombre_empresa;
    private String descripcion;
    private String mision;
    private String vision;
    private String ubicacion;
    private String web;
    private String rfc;

    PreparedStatement ps;
    ResultSet rs;

    public Empresa()
    {
    }

    public Empresa(int id_empresa, String nombre_empresa, String descripcion, String mision, String vision, String ubicacion, String web, String rfc)
    {
        this.id_empresa = id_empresa;
        this.nombre_empresa = nombre_empresa;
        this.descripcion = descripcion;
        this.mision = mision;
        this.vision = vision;
        this.ubicacion = ubicacion;
        this.web = web;
        this.rfc = rfc;
    }

    /**
     * @return the id_empresa
     */
    public int getId_empresa()
    {
        return id_empresa;
    }

    /**
     * @param id_empresa the id_empresa to set
     */
    public void setId_empresa(int id_empresa)
    {
        this.id_empresa = id_empresa;
    }

    /**
     * @return the nombre_empresa
     */
    public String getNombre_empresa()
    {
        return nombre_empresa;
    }

    /**
     * @param nombre_empresa the nombre_empresa to set
     */
    public void setNombre_empresa(String nombre_empresa)
    {
        this.nombre_empresa = nombre_empresa;
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
     * @return the mision
     */
    public String getMision()
    {
        return mision;
    }

    /**
     * @param mision the mision to set
     */
    public void setMision(String mision)
    {
        this.mision = mision;
    }

    /**
     * @return the vision
     */
    public String getVision()
    {
        return vision;
    }

    /**
     * @param vision the vision to set
     */
    public void setVision(String vision)
    {
        this.vision = vision;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion()
    {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion)
    {
        this.ubicacion = ubicacion;
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

    /**
     * @return the rfc
     */
    public String getRfc()
    {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc)
    {
        this.rfc = rfc;
    }
    
    public void inserta(Object obj, Connection con)
    {
        Empresa empr = (Empresa) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO empresa VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, empr.getId_empresa());
            ps.setString(2, empr.getNombre_empresa());
            ps.setString(3, empr.getDescripcion());
            ps.setString(4, empr.getMision());
            ps.setString(5, empr.getVision());
            ps.setString(6, empr.getUbicacion());
            ps.setString(7, empr.getWeb());
            ps.setString(8, empr.getRfc());

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Empresa registrada con exito");
            } else
            {
                Mensaje.error(null, "No se pudo registrar esta empresa!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void elimina(String id, Connection con)
    {
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("DELETE FROM empresa WHERE id_empresa=?");
            ps.setString(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.error(null, "Empresa eliminada");
            }
            else
            {
                Mensaje.error(null, "No se pudo eliminar esta empresa!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void modifica(int id, Object obj, Connection con)
    {
        Empresa empr = new Empresa();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE empresa SET nombre_empresa=?,descripcion=?,mision=?,vision=?,ubicacion=?,web=?,rfc=? WHERE id_empresa=?");
            ps.setInt(1, id);
            ps.setString(2, empr.getNombre_empresa());
            ps.setString(3, empr.getDescripcion());
            ps.setString(4, empr.getMision());
            ps.setString(5, empr.getVision());
            ps.setString(6, empr.getUbicacion());
            ps.setString(7, empr.getWeb());
            ps.setString(8, empr.getRfc());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Datos de empresa modificada con exito");
            }
            else
            {
                Mensaje.error(null, "No se pudieron modificar los dato de esta empresa");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Empresa empr = new Empresa();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM empresa WHERE id_empresa=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                empr.setId_empresa(rs.getInt("id_empresa"));
                empr.setNombre_empresa(rs.getString("nombre_empresa"));
                empr.setDescripcion(rs.getString("descripcion"));
                empr.setMision(rs.getString("mision"));
                empr.setVision(rs.getString("vision"));
                empr.setUbicacion(rs.getString("ubicacion"));
                empr.setWeb(rs.getString("web"));
                empr.setRfc(rs.getString("rfc"));
            }
            else
            {
                Mensaje.error(null, "No hay empresas registradas!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return empr;
    }
}
