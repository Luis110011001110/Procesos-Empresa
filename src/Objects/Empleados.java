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
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author mosh_
 */
public class Empleados
{
    private int id_empleado;
    private int id_sucursal;
    private int id_tipousuario;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private char sexo;
    private String fecha_nacimiento;
    private String curp;
    private String telefono;
    private String correo;
    private String password;
    private String fecha_alta;
    
    PreparedStatement ps;
    ResultSet rs;

    public Empleados()
    {
    }

    public Empleados(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public Empleados(int id_empleado, int id_sucursal, int id_tipousuario, String nombre, String ap_paterno, String ap_materno, char sexo, String fecha_nacimiento, String curp, String telefono, String correo, String password, String fecha_alta)
    {
        this.id_empleado = id_empleado;
        this.id_sucursal = id_sucursal;
        this.id_tipousuario = id_tipousuario;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.curp = curp;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.fecha_alta = fecha_alta;
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
     * @return the sexo
     */
    public char getSexo()
    {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo)
    {
        this.sexo = sexo;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento()
    {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento)
    {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the curp
     */
    public String getCurp()
    {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp)
    {
        this.curp = curp;
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
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    /**
     * @return the fecha_alta
     */
    public String getFecha_alta()
    {
        return fecha_alta;
    }

    /**
     * @param fecha_alta the fecha_alta to set
     */
    public void setFecha_alta(String fecha_alta)
    {
        this.fecha_alta = fecha_alta;
    }
    
    
    public void inserta(JFrame jf, Object obj, Connection con)
    {
        Empleados emp = (Empleados)obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,emp.getId_empleado());
            ps.setInt(2,emp.getId_sucursal());
            ps.setInt(3,emp.getId_tipousuario());
            ps.setString(4,emp.getNombre());
            ps.setString(5,emp.getAp_paterno());
            ps.setString(6,emp.getAp_materno());
            ps.setString(7,String.valueOf(emp.getSexo()));
            ps.setString(8,emp.getFecha_nacimiento());
            ps.setString(9,emp.getCurp());
            ps.setString(10,emp.getTelefono());
            ps.setString(11,emp.getCorreo());
            ps.setString(12,emp.getPassword());
            ps.setString(13,emp.getFecha_alta());
            
            int res = ps.executeUpdate();
            
            if (res > 0)
            {
                Mensaje.exito(jf, "Empleado registrado");
            }
            else
            {
                Mensaje.error(jf, "No se pudo registrar este empleado");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void elimina(JFrame jf, int id, Connection con)
    {
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("DELETE FROM empleados WHERE id_empleado=?");
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            if (res > 0)
            {
                Mensaje.exito(jf, "Empleado eliminado");
            }
            else
            {
                Mensaje.error(jf, "No se pudo elimiar este empleado");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public void modifica(JFrame jf, Object obj, Connection con)
    {
        Empleados emp = (Empleados)obj;
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("UPDATE empleados SET id_sucursal=?,id_tipousuario=? ,nombre=?,apellido_materno=?,apellido_paterno=?,sexo=?,"
                    + "fecha_nacimiento=?,curp=?,telefono_contacto=?,correo=?,password=? WHERE id_empleado=?");
            ps.setInt(1, emp.getId_sucursal());
            ps.setInt(2, emp.getId_tipousuario());
            ps.setString(3, emp.getNombre());
            ps.setString(4, emp.getAp_materno());
            ps.setString(5, emp.getAp_paterno());
            ps.setString(6, String.valueOf(emp.getSexo()));
            ps.setString(7, emp.getFecha_nacimiento());
            ps.setString(8, emp.getCurp());
            ps.setString(9, emp.getTelefono());
            ps.setString(10, emp.getCorreo());
            ps.setString(11, emp.getPassword());
            ps.setInt(12, emp.getId_empleado());
            int res = ps.executeUpdate();
            if (res > 0 )
            {
                Mensaje.exito(jf, "Datos de empleado modficados con exito");
            }
            else
            {
                Mensaje.error(jf, "No se pudieron modificar los datos de empleado!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    public Object consultaUnicaid(String id, Connection con)
    {
        Empleados emp = new Empleados();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM empleados WHERE id_empleado=?");
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            if (rs.next())
            {
                emp.setId_empleado(rs.getInt("id_empleado"));
                emp.setId_sucursal(rs.getInt("id_sucursal"));
                emp.setId_tipousuario(rs.getInt("id_tipousuario"));
                emp.setNombre(rs.getString("nombre"));
                emp.setAp_paterno(rs.getString("apellido_paterno"));
                emp.setAp_materno(rs.getString("apellido_materno"));
                emp.setSexo(rs.getString("Sexo").charAt(0));
                emp.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                emp.setCurp(rs.getString("curp"));
                emp.setCurp(rs.getString("telefono_contacto"));
                emp.setCorreo(rs.getString("correo"));
                emp.setPassword(rs.getString("password"));
                emp.setFecha_alta(rs.getString("fecha_alta"));
            }
            else
            {
                Mensaje.error(null, "No hay empleados registrados");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return emp;
    }
    
    public Object consultaUnicausurio(String usuario, Connection con)
    {
        Empleados emp = new Empleados();
        try
        {
            con = Conexiones.conectar();
            ps = con.prepareStatement("SELECT * FROM empleados WHERE correo=?");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next())
            {
                emp.setId_empleado(rs.getInt("id_empleado"));
                emp.setId_sucursal(rs.getInt("id_sucursal"));
                emp.setId_tipousuario(rs.getInt("id_tipousuario"));
                emp.setNombre(rs.getString("nombre"));
                emp.setAp_paterno(rs.getString("apellido_paterno"));
                emp.setAp_materno(rs.getString("apellido_materno"));
                emp.setSexo(rs.getString("Sexo").charAt(0));
                emp.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                emp.setCurp(rs.getString("curp"));
                emp.setCurp(rs.getString("telefono_contacto"));
                emp.setCorreo(rs.getString("correo"));
                emp.setPassword(rs.getString("password"));
                emp.setFecha_alta(rs.getString("fecha_alta"));
            }
            else
            {
                Mensaje.error(null, "Usuario no encontrado");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return emp;
    }
    
    public Empleados[] consultaMultipleVector(Connection con)
    {
        try
        {
            String sql = "SELECT * FROM empleados";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            boolean ultimo = rs.last();
            int total =0;
            if (ultimo)
            {
                total =rs.getRow();
            }
            
            System.out.println(total);
            int i=0;
            Empleados[] filas = new Empleados[total];
            rs.first();
            Empleados emp = new Empleados(rs.getInt("id_empleado"), 
                    rs.getInt("id_sucural"),
                    rs.getInt("id_tipousuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"), 
                    rs.getString("sexo").charAt(0), 
                    rs.getString("fecha_nacimiento"),
                    rs.getString("curp"),
                    rs.getString("telefono_contacto"), 
                    rs.getString("correo"),
                    rs.getString("pasword"), 
                    rs.getString("fecha_alta"));
            filas[i++] = emp;
            while (rs.next())
            {                
                emp = new Empleados(rs.getInt("id_empleado"), 
                    rs.getInt("id_sucural"),
                    rs.getInt("id_tipousuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido_paterno"),
                    rs.getString("apellido_materno"), 
                    rs.getString("sexo").charAt(0), 
                    rs.getString("fecha_nacimiento"),
                    rs.getString("curp"),
                    rs.getString("telefono_contacto"), 
                    rs.getString("correo"),
                    rs.getString("pasword"), 
                    rs.getString("fecha_alta"));
            filas[i++] = emp;
            }
            return filas;
        } catch (SQLException e)
        {
            System.out.println("Error"+e.toString());
        }
        return null;
    }
}
