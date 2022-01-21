/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plastimarproject;

import Conextion.Conexiones;
import java.sql.Connection;
import interfaces.VtnGestionVentas;

/**
 *
 * @author mosh_
 */
public class PlastimarProject
{
    
    public static Connection connection;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        connection = Conexiones.conectar();
        VtnGestionVentas ventas = new VtnGestionVentas();
        ventas.setVisible(true);
    }
    
}
