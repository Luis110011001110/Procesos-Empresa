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
 * @author LUIS
 */
public class Pedidos {
    private int id_pedido;
    private String remitente;
    private String destinatario;
    private String asunto;
    //private String archivo;
    private String Descripcion;
    
    PreparedStatement ps;
    ResultSet rs;

    public Pedidos() {
    }

    public Pedidos(int id_pedido, String remitente, String destinatario, String asunto,  String Descripcion) {
        this.id_pedido = id_pedido;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.asunto = asunto;
//        this.archivo = archivo;
        this.Descripcion = Descripcion;
    }
    
    /**
     * @return the id_pedido
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * @return the remitente
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * @param remitente the remitente to set
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the archivo
     */
//    public String getArchivo() {
//        return archivo;
//    }
//
//    /**
//     * @param archivo the archivo to set
//     */
//    public void setArchivo(String archivo) {
//        this.archivo = archivo;
//    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

public void inserta(JFrame jf, Object obj, Connection con)
    {
        Pedidos ped = (Pedidos) obj;
        try
        {
            ps = con.prepareStatement("INSERT INTO pedido VALUES (?,?,?,?,?)");
            ps.setInt(1, ped.getId_pedido());
            ps.setString(2, ped.getRemitente());
            ps.setString(3, ped.getDestinatario());
            ps.setString(4, ped.getAsunto());
            ps.setString(5, ped.getDescripcion());

            int res = ps.executeUpdate();

            if (res > 0)
            {
                Mensaje.exito(jf, "Correo registrado registrado con exito");
            } else
            {
                Mensaje.error(jf, "No se pudo registrar el correo!!!");
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }


}
