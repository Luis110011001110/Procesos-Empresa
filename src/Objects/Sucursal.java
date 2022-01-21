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
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;

/**
 *
 * @author mosh_
 */
public class Sucursal
{
    private int id_sucursal;
    private String nombre_sucursal;
    private int id_tiposucursal;
    private int id_estado;
    private String direccion;
    private String telefono;
    private String correo;

    PreparedStatement ps;
    ResultSet rs;
    
    public Sucursal()
    {
    }

    public Sucursal(int id_sucursal, String nombre_sucursal, int id_tiposucursal, int id_estado, String direccion, String telefono, String correo)
    {
        this.id_sucursal = id_sucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.id_tiposucursal = id_tiposucursal;
        this.id_estado = id_estado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
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
     * @return the nombre_sucursal
     */
    public String getNombre_sucursal()
    {
        return nombre_sucursal;
    }

    /**
     * @param nombre_sucursal the nombre_sucursal to set
     */
    public void setNombre_sucursal(String nombre_sucursal)
    {
        this.nombre_sucursal = nombre_sucursal;
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
     * @return the id_estado
     */
    public int getId_estado()
    {
        return id_estado;
    }

    /**
     * @param id_estado the id_estado to set
     */
    public void setId_estado(int id_estado)
    {
        this.id_estado = id_estado;
    }

    /**
     * @return the direccion
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
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
    
    public void inserta(JFrame jf,Object obj, Connection con)
    {
        Sucursal suc = (Sucursal)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO sucursal VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, suc.getId_sucursal());
            ps.setString(2, suc.getNombre_sucursal());
            ps.setInt(3, suc.getId_tiposucursal());
            ps.setInt(4, suc.getId_estado());
            ps.setString(5, suc.getDireccion());
            ps.setString(6, suc.getTelefono());
            ps.setString(7, suc.getCorreo());
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Sucursal registrada con exito");
            }
            else
            {
                Mensaje.error(jf, "No se puede eliminar esta sucursal");
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
            ps = con.prepareStatement("DELETE FROM sucursal WHERE id_sucursal=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Sucursal eliminada");
            }
            else
            {
                Mensaje.error(jf, "No se puede eliminar esta sucursal");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void modifica(JFrame jf, Object obj, Connection con)
    {
        Sucursal suc = (Sucursal)obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE sucursal SET nombre_sucursal=?,tipo=?,estado=?,direccion=?,telefono=?,correo=? WHERE id_sucursal=?");
            
            ps.setString(1, suc.getNombre_sucursal());
            ps.setInt(2, suc.getId_tiposucursal());
            ps.setInt(3, suc.getId_estado());
            ps.setString(4, suc.getDireccion());
            ps.setInt(5, Integer.parseInt(suc.getTelefono()));
            ps.setString(6, suc.getCorreo());
            ps.setInt(7, suc.getId_sucursal());
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Sucursal Modificada");
            }
            else
            {
                Mensaje.error(null, "No se puede modificar esta sucursal");
            }
        } catch (Exception e)
        {
            System.out.println("Error en objeto"+e.toString());
        }
    }
    
    public  Object consultaUnica(int id, Connection con)
    {
        Sucursal suc = new Sucursal();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT *FROM sucursal WHERE id_sucursal=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if(rs.next())
            {
                suc.setId_sucursal(rs.getInt("id_sucursal"));
                suc.setNombre_sucursal(rs.getString("nombre_sucursal"));
                suc.setId_tiposucursal(rs.getInt("id_tiposucursal"));
                suc.setId_estado(rs.getInt("id_estado"));
                suc.setDireccion(rs.getString("direccion"));
                suc.setTelefono(rs.getString("telefono"));
                suc.setCorreo(rs.getString("correo"));
            }
            else
            {
                Mensaje.error(null, "No hay sucursales registradas!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return suc;
    }
    
    public Object[] consultaMultipleMat(Connection con){
               
        try {
            String sql = "SELECT id_sucursal,nombre_sucursal,tipo_sucursal.tipo,estado,direccion,telefono,correo FROM sucursal "
                    + "inner join tipo_sucursal on tipo_sucursal.id_tiposucursal = sucursal.tipo";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rrsw = rs.getMetaData();
            int cantcolumnas = rrsw.getColumnCount();
            Object[] filas = new Object[cantcolumnas];
            while (rs.next()) {
                for (int i = 0; i < cantcolumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    System.out.println(String.valueOf(rs.getObject(i+1)));
                }
            }
            return filas;
        
    }catch(Exception e){
            System.out.println("Error"+e.toString());
    }
        return null;
    }
    
    public Sucursal[] consultaMultipleVec(Connection con){  
        try {
            String sql = "SELECT * FROM sucursal";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ultimo = rs.last();
            int total=0;
            if (ultimo) {
                total=rs.getRow();
            }
            
            System.out.println(total);
            int i=0;
            Sucursal[] filas = new Sucursal[total];
            rs.first();
            Sucursal suc = new Sucursal(rs.getInt("id_sucursal"), rs.getString("nombre_sucursal"), rs.getInt("tipo"), rs.getInt("estado"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"));
            filas[i++] = suc;
            while (rs.next()) {
                 suc = new Sucursal(rs.getInt("id_sucursal"), rs.getString("nombre_sucursal"), rs.getInt("tipo"), rs.getInt("estado"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"));
            filas[i++] = suc;
                
            }
            return filas;
    }catch(Exception e){
            System.out.println("Error"+e.toString());
    }
        return null;
    }
    
    
}

        
