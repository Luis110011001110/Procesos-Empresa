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
public class Categorias {

    private int id_categoria;
    private String nombre_categoria;
    private String descripcion;

    private PreparedStatement ps;
    private ResultSet rs;

    public Categorias() {
    }

    public Categorias(int id_categoria, String nombre_categoria, String descripcion) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
        this.descripcion = descripcion;
    }

    /**
     * @return the id_categoria
     */
    public int getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nombre_categoria
     */
    public String getNombre_categoria() {
        return nombre_categoria;
    }

    /**
     * @param nombre_categoria the nombre_categoria to set
     */
    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the ps
     */
    public PreparedStatement getPs() {
        return ps;
    }

    /**
     * @param ps the ps to set
     */
    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void inserta(Object obj, Connection con) {
        Categorias cat = (Categorias) obj;
        try {
            setPs(con.prepareStatement("INSERT INTO categorias (id_categoria,nombre_categoria,descripcion) VALUES (?,?,?)"));
            getPs().setInt(1, cat.getId_categoria());
            getPs().setString(2, cat.getNombre_categoria());
            getPs().setString(3, cat.getDescripcion());

            int res = getPs().executeUpdate();

            if (res > 0) {
                Mensaje.exito(null, "Categoria registrada con exito");
            } else {
                Mensaje.error(null, "No se pudo regsitrar esta categoria!!!");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void elimina(int id, Connection con) {
        try {
            con = Conexiones.conectar();
            setPs(con.prepareStatement("DELETE FROM categorias WHERE id_categoria=?"));
            getPs().setInt(1, id);

            int res = getPs().executeUpdate();

            if (res > 0) {
                Mensaje.exito(null, "Categoria eliminada");
            } else {
                Mensaje.error(null, "No se pudo eliminar esta categoria!!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modifica(JFrame jf, Object obj, Connection con) {
        Categorias cat = (Categorias) obj;
        try {
            con = Conexiones.conectar();
            setPs(con.prepareStatement("UPDATE categorias SET nombre_categoria=? , descripcion=? WHERE id_categoria=?"));
            getPs().setString(1, cat.getNombre_categoria());
            getPs().setString(2, cat.getDescripcion());
            getPs().setInt(3, cat.getId_categoria());

            int res = getPs().executeUpdate();

            if (res > 0) {
                Mensaje.exito(jf, "Categoria Modificada");
            } else {
                Mensaje.error(jf, "No se pudo modificar esta categoria!!");
            }
        } catch (Exception e) {
        }
    }

    public Object consultaUnica(int id, Connection con) {
        Categorias cat = new Categorias();
        try {
            con = Conexiones.conectar();
            setPs(con.prepareStatement("SELECT * FROM categorias WHERE id_catgeoria=?"));
            getPs().setInt(1, id);

            setRs(getPs().executeQuery());
            if (getRs().next()) {
                cat.setId_categoria(rs.getInt("id_categoria"));
                cat.setNombre_categoria(rs.getString("nombre_categoria"));
                cat.setDescripcion(rs.getString("descripcion"));
            } else {
                Mensaje.error(null, "No se encontraron categorias!!!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return cat;
    }

    public Categorias[] consultaMultipleVec(Connection con) {
        try {
            ResultSet res;
            String sql = "SELECT * FROM categorias";
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();
            boolean ultimo = res.last();
            int total = 0;
            if (ultimo) {
                total = res.getRow();
            }

            System.out.println(total);
            int i = 0;
            Categorias[] filas = new Categorias[total];
            res.first();
            Categorias cat = new Categorias(res.getInt("id_categoria"), res.getString("nombre_categoria"), res.getString("descripcion"));
            filas[i++] = cat;
            while (res.next()) {
                cat = new Categorias(res.getInt("id_categoria"), res.getString("nombre_categoria"), res.getString("descripcion"));
                filas[i++] = cat;
            }
            return filas;
        } catch (SQLException e) {
            System.out.println("Error" + e.toString());
        }
        return null;
    }
}
