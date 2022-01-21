/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Reportes.Conectar;
import static interfaces.VtnLogin.con;
import java.awt.Color;
import java.security.Principal;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author david
 */
public class VtnMainEmpleado extends javax.swing.JFrame
{

    /**
     * Creates new form VtnMainAdmin
     */
    public VtnMainEmpleado()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLOp1 = new javax.swing.JLabel();
        jLIconSucursal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLWelcome = new javax.swing.JLabel();
        jLIconAdmin = new javax.swing.JLabel();
        jLNameUser = new javax.swing.JLabel();
        jLCerrar = new javax.swing.JLabel();
        jLMinimizar = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLHelp = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLNameUser1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal Administrador");
        setExtendedState(6);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 89, 152));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new java.awt.Color(223, 227, 238));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });
        btn_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_1.setBackground(new java.awt.Color(139, 157, 195));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btn_1.add(ind_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLOp1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLOp1.setForeground(new java.awt.Color(59, 89, 152));
        jLOp1.setText("Venta de productos");
        btn_1.add(jLOp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jLIconSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carro-de-la-compra.png"))); // NOI18N
        btn_1.add(jLIconSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 290, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 780));

        jPanel2.setBackground(new java.awt.Color(223, 227, 238));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 807));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(139, 157, 195));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLWelcome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLWelcome.setForeground(new java.awt.Color(223, 227, 238));
        jLWelcome.setText("Bienvenido:");
        jPanel5.add(jLWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jLIconAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vendedor.png"))); // NOI18N
        jPanel5.add(jLIconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLNameUser.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLNameUser.setForeground(new java.awt.Color(223, 227, 238));
        jPanel5.add(jLNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion2.png"))); // NOI18N
        jLCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLCerrarMousePressed(evt);
            }
        });
        jPanel5.add(jLCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 25, -1));

        jLMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar2.png"))); // NOI18N
        jLMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLMinimizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLMinimizarMousePressed(evt);
            }
        });
        jPanel5.add(jLMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 110, 514, 180));

        jPanel6.setBackground(new java.awt.Color(139, 157, 195));

        jLHelp.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLHelp.setForeground(new java.awt.Color(223, 227, 238));
        jLHelp.setText("Ayuda");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLHelp)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLHelp)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 510, -1));

        jButton1.setText("MISION, VISION , VALORES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 200, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 520, 810));

        jPanel3.setBackground(new java.awt.Color(223, 227, 238));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNameUser1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLNameUser1.setForeground(new java.awt.Color(59, 89, 152));
        jLNameUser1.setText("Empleado");
        jPanel3.add(jLNameUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 790, 110));

        jPanel4.setBackground(new java.awt.Color(247, 247, 247));
        jPanel4.setForeground(new java.awt.Color(247, 247, 247));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 807));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 630, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLCerrarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLCerrarMousePressed
    {//GEN-HEADEREND:event_jLCerrarMousePressed
        this.dispose();
        new VtnLogin().setVisible(true);
    }//GEN-LAST:event_jLCerrarMousePressed

    private void jLMinimizarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLMinimizarMousePressed
    {//GEN-HEADEREND:event_jLMinimizarMousePressed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLMinimizarMousePressed

    private void jLCerrarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLCerrarMouseEntered
    {//GEN-HEADEREND:event_jLCerrarMouseEntered
        ImageIcon icon = new ImageIcon("src/images/cerrar-sesion1.png");
        Icon a = new ImageIcon(icon.getImage());
        jLCerrar.setIcon(a);
    }//GEN-LAST:event_jLCerrarMouseEntered

    private void jLCerrarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLCerrarMouseExited
    {//GEN-HEADEREND:event_jLCerrarMouseExited
        ImageIcon icon = new ImageIcon("src/images/cerrar-sesion2.png");
        Icon a = new ImageIcon(icon.getImage());
        jLCerrar.setIcon(a);
    }//GEN-LAST:event_jLCerrarMouseExited

    private void jLMinimizarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLMinimizarMouseEntered
    {//GEN-HEADEREND:event_jLMinimizarMouseEntered
        ImageIcon icon = new ImageIcon("src/images/minimizar1.png");
        Icon a = new ImageIcon(icon.getImage());
        jLMinimizar.setIcon(a);
    }//GEN-LAST:event_jLMinimizarMouseEntered

    private void jLMinimizarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLMinimizarMouseExited
    {//GEN-HEADEREND:event_jLMinimizarMouseExited
        ImageIcon icon = new ImageIcon("src/images/minimizar2.png");
        Icon a = new ImageIcon(icon.getImage());
        jLMinimizar.setIcon(a);
    }//GEN-LAST:event_jLMinimizarMouseExited

    private void btn_1MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_1MousePressed
    {//GEN-HEADEREND:event_btn_1MousePressed
        this.dispose();
        new VtnGestionVentas().setVisible(true);
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_1MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_1MouseEntered
    {//GEN-HEADEREND:event_btn_1MouseEntered
        btn_1.setBackground(new Color(139, 157, 195));
        ind_1.setBackground(new Color(223, 227, 238));
    }//GEN-LAST:event_btn_1MouseEntered
    private void btn_1MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_1MouseExited
    {//GEN-HEADEREND:event_btn_1MouseExited
        btn_1.setBackground(new Color(223, 227, 238));
        ind_1.setBackground(new Color(139, 157, 195));
    }//GEN-LAST:event_btn_1MouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        jLNameUser.setText(VtnLogin.emp.getNombre());
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JasperReport reporte; //Creo el objeto reporte
        // Ubicacion del Reporte
        String path = "src\\Reportes\\empresa.jasper";
        try
        {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Cargo el reporte al objeto
            JasperPrint jprint = JasperFillManager.fillReport(path, null, con); //Llenado del Reporte con Tres parametros ubicacion,parametros,conexion a la base de datos
            JasperViewer viewer = new JasperViewer(jprint, false); //Creamos la vista del Reporte
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Le agregamos que se cierre solo el reporte cuando lo cierre el usuario
            viewer.setVisible(true); //Inicializamos la vista del Reporte
        } catch (JRException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("GTK".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnMainEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel ind_1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLCerrar;
    private javax.swing.JLabel jLHelp;
    private javax.swing.JLabel jLIconAdmin;
    private javax.swing.JLabel jLIconSucursal;
    private javax.swing.JLabel jLMinimizar;
    private javax.swing.JLabel jLNameUser;
    private javax.swing.JLabel jLNameUser1;
    private javax.swing.JLabel jLOp1;
    private javax.swing.JLabel jLWelcome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
    //CONECTA CON LA BASE DE DATOS
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
}
