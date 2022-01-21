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
public class Tipo_usuario
{

    private int id_tipousuario;
    private String tipo_usuario;

    PreparedStatement ps;
    ResultSet rs;

    public Tipo_usuario()
    {
    }

    public Tipo_usuario(int id_tipousuario, String tipo_usuario)
    {
        this.id_tipousuario = id_tipousuario;
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the id_tipousuario
     */
    public int getId_tipousuario()
    {
        return id_tipousuario;
    }

    /**
     * @param id_tipousuario the id_tipousuario to set
     */
    public void setId_tipousuario(int id_tipousuario)
    {
        this.id_tipousuario = id_tipousuario;
    }

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario()
    {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario)
    {
        this.tipo_usuario = tipo_usuario;
    }

    public void inserta(Object obj, Connection con)
    {
        Tipo_usuario tip = (Tipo_usuario) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO tipo_usuario VALUES (?,?)");
            ps.setInt(1, tip.getId_tipousuario());
            ps.setString(2, tip.getTipo_usuario());

            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Tipo de usuari registrado");
            } else
            {
                Mensaje.error(null, "No se puede registrar este tipo de usuario");
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
            ps = con.prepareStatement("DELETE FROM tipo_usuario WHERE id_tipousuario=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(null, "Tipo de usuario eliminado");
            }
            else
            {
                Mensaje.exito(null, "No se pudo eliminar este tipo de usuario!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnica(int id, Connection con)
    {
        Tipo_usuario tip = new Tipo_usuario();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT FROM tipo_usuario WHERE id_tipousuario=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                tip.setId_tipousuario(rs.getInt("id_tipousuario"));
                tip.setTipo_usuario(rs.getString("tipo_usuario"));
            }
            else
            {
                Mensaje.error(null, "No hay tipos de usuario registrados");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return tip;
    }
    
    public Tipo_usuario[] consultaMultipleVec(Connection con){  
        try {
            String sql = "SELECT * FROM tipo_usuario";
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ultimo = rs.last();
            int total=0;
            if (ultimo) {
                total=rs.getRow();
            }
            
            System.out.println(total);
            int i=0;
            Tipo_usuario[] filas = new Tipo_usuario[total];
            rs.first();
            Tipo_usuario tiusu = new Tipo_usuario(rs.getInt("id_tipousuario"), rs.getString("tipo_usuario"));
            filas[i++] = tiusu;
            while (rs.next()) {
                 tiusu = new Tipo_usuario(rs.getInt("id_tipousuario"), rs.getString("tipo_usuario"));
            filas[i++] = tiusu;
                
            }
            return filas;
    }catch(Exception e){
            System.out.println("Error"+e.toString());
    }
        return null;
    }
}
