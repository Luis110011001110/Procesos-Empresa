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
public class Clientes
{

    private int id_cliente;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String correo;

    PreparedStatement ps;
    ResultSet rs;

    public Clientes()
    {
    }

    public Clientes(int id_cliente, String nombre, String ap_paterno, String ap_materno, String correo)
    {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.correo = correo;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente()
    {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente)
    {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the ap_paterno
     */
    public String getAp_paterno()
    {
        return ap_paterno;
    }

    /**
     * @param ap_paterno the ap_paterno to set
     */
    public void setAp_paterno(String ap_paterno)
    {
        this.ap_paterno = ap_paterno;
    }

    /**
     * @return the ap_materno
     */
    public String getAp_materno()
    {
        return ap_materno;
    }

    /**
     * @param ap_materno the ap_materno to set
     */
    public void setAp_materno(String ap_materno)
    {
        this.ap_materno = ap_materno;
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

    public void inserta(JFrame jf, Object obj, Connection con)
    {
        Clientes Cli = (Clientes) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?,?)");
            ps.setInt(1, Cli.getId_cliente());
            ps.setString(2, Cli.getNombre());
            ps.setString(3, Cli.getAp_paterno());
            ps.setString(4, Cli.getAp_materno());
            ps.setString(5, Cli.getCorreo());

            int res = ps.executeUpdate();

            if (res > 0)
            {
                Mensaje.exito(jf, "Cliente registrado con exito");
            } else
            {
                Mensaje.error(jf, "No se pudo registrar el cliente!!!");
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
            ps = con.prepareStatement("DELETE FROM clientes WHERE id_cliente=?");
            ps.setInt(1, id);

            int res = ps.executeUpdate();

            if (res > 0)
            {
                Mensaje.exito(null, "Cliente eliminado");
            } else
            {
                Mensaje.error(null, "No se pudo eliminar a este cliente");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void modfica(JFrame jf, Object obj, Connection con)
    {
        Clientes cli = (Clientes) obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE clientes SET nombre=?, apellido_paterno=?, apellido_materno=?, correo_contacto=? WHERE id_cliente=?");

            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getAp_paterno());
            ps.setString(3, cli.getAp_materno());
            ps.setString(4, cli.getCorreo());
            ps.setInt(5, cli.id_cliente);

            int res = ps.executeUpdate();

            if (res > 0)
            {
                Mensaje.exito(jf, "Cliente modificado con exito");
            } else
            {
                Mensaje.error(jf, "Los datos del cliente no se pudieron modificar!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public Object consultaUnica(int id, Connection con)
    {
        Clientes cli = new Clientes();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM clientes WHERE id_cliente=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next())
            {
                cli.setId_cliente(rs.getInt("id_cliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setAp_paterno(rs.getString("apellido_paterno"));
                cli.setAp_materno(rs.getString("apellido_materno"));
                cli.setCorreo(rs.getString("correo"));
            } else
            {
                Mensaje.error(null, "No se encontro ningun cliente");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return cli;
    }
}
