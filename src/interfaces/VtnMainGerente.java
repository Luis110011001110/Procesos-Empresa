/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author david
 */
public class VtnMainGerente extends javax.swing.JFrame
{

    /**
     * Creates new form VtnMainAdmin
     */
    public VtnMainGerente()
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
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLOp1 = new javax.swing.JLabel();
        jLIconSucursal = new javax.swing.JLabel();
        btn_2 = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        jLOp2 = new javax.swing.JLabel();
        jLIconEmpleado = new javax.swing.JLabel();
        btn_3 = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        jLOp3 = new javax.swing.JLabel();
        jLIconEmpleado1 = new javax.swing.JLabel();
        btn_4 = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        jLOp4 = new javax.swing.JLabel();
        jLIconEmpleado2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLWelcome = new javax.swing.JLabel();
        jLIconAdmin = new javax.swing.JLabel();
        jLNameUser = new javax.swing.JLabel();
        jLCerrar = new javax.swing.JLabel();
        jLMinimizar = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLHelp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLNameUser1 = new javax.swing.JLabel();
        jLNameSucursal = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal Administrador");
        setExtendedState(6);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 89, 152));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_1.setBackground(new java.awt.Color(223, 227, 238));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btn_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btn_1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
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
        jLOp1.setText("Gestionar empleados");
        btn_1.add(jLOp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jLIconSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empleados.png"))); // NOI18N
        btn_1.add(jLIconSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(btn_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 290, -1));

        btn_2.setBackground(new java.awt.Color(223, 227, 238));
        btn_2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btn_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btn_2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                btn_2MousePressed(evt);
            }
        });
        btn_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_2.setBackground(new java.awt.Color(139, 157, 195));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btn_2.add(ind_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLOp2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLOp2.setForeground(new java.awt.Color(59, 89, 152));
        jLOp2.setText("Gestionar productos");
        btn_2.add(jLOp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jLIconEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto.png"))); // NOI18N
        btn_2.add(jLIconEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(btn_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 290, -1));

        btn_3.setBackground(new java.awt.Color(223, 227, 238));
        btn_3.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btn_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btn_3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                btn_3MousePressed(evt);
            }
        });
        btn_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_3.setBackground(new java.awt.Color(139, 157, 195));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btn_3.add(ind_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLOp3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLOp3.setForeground(new java.awt.Color(59, 89, 152));
        jLOp3.setText("Venta de productos");
        btn_3.add(jLOp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jLIconEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carro-de-la-compra.png"))); // NOI18N
        btn_3.add(jLIconEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(btn_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, -1));

        btn_4.setBackground(new java.awt.Color(223, 227, 238));
        btn_4.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                btn_4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                btn_4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                btn_4MousePressed(evt);
            }
        });
        btn_4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_4.setBackground(new java.awt.Color(139, 157, 195));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btn_4.add(ind_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLOp4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLOp4.setForeground(new java.awt.Color(59, 89, 152));
        jLOp4.setText("Realizar pedido");
        btn_4.add(jLOp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 20));

        jLIconEmpleado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pedido.png"))); // NOI18N
        btn_4.add(jLIconEmpleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(btn_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 290, -1));

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

        jLIconAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gerente.png"))); // NOI18N
        jPanel5.add(jLIconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLNameUser.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLNameUser.setForeground(new java.awt.Color(223, 227, 238));
        jPanel5.add(jLNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, -1));

        jLCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion2.png"))); // NOI18N
        jLCerrar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLCerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jLCerrarMousePressed(evt);
            }
        });
        jPanel5.add(jLCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 25, -1));

        jLMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizar2.png"))); // NOI18N
        jLMinimizar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLMinimizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 520, 810));

        jPanel3.setBackground(new java.awt.Color(223, 227, 238));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNameUser1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLNameUser1.setForeground(new java.awt.Color(59, 89, 152));
        jLNameUser1.setText("Gerente sucursal:");
        jPanel3.add(jLNameUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jLNameSucursal.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLNameSucursal.setForeground(new java.awt.Color(59, 89, 152));
        jPanel3.add(jLNameSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

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
        new VtnGestionEmpleadosGerente().setVisible(true);
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_2MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_2MousePressed
    {//GEN-HEADEREND:event_btn_2MousePressed
        this.dispose();
        new VtnGestionProductosGerente().setVisible(true);
    }//GEN-LAST:event_btn_2MousePressed

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

    private void btn_2MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_2MouseEntered
    {//GEN-HEADEREND:event_btn_2MouseEntered
        btn_2.setBackground(new Color(139, 157, 195));
        ind_2.setBackground(new Color(223, 227, 238));
    }//GEN-LAST:event_btn_2MouseEntered

    private void btn_2MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_2MouseExited
    {//GEN-HEADEREND:event_btn_2MouseExited
        btn_2.setBackground(new Color(223, 227, 238));
        ind_2.setBackground(new Color(139, 157, 195));
    }//GEN-LAST:event_btn_2MouseExited

    private void btn_3MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_3MouseEntered
    {//GEN-HEADEREND:event_btn_3MouseEntered
        btn_3.setBackground(new Color(139, 157, 195));
        ind_3.setBackground(new Color(223, 227, 238));
    }//GEN-LAST:event_btn_3MouseEntered

    private void btn_3MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_3MouseExited
    {//GEN-HEADEREND:event_btn_3MouseExited
        btn_3.setBackground(new Color(223, 227, 238));
        ind_3.setBackground(new Color(139, 157, 195));
    }//GEN-LAST:event_btn_3MouseExited

    private void btn_3MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_3MousePressed
    {//GEN-HEADEREND:event_btn_3MousePressed
        this.dispose();
        new VtnGestionVentas().setVisible(true);
    }//GEN-LAST:event_btn_3MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        jLNameUser.setText(VtnLogin.emp.getNombre());

    }//GEN-LAST:event_formWindowOpened

    private void btn_4MouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_4MouseEntered
    {//GEN-HEADEREND:event_btn_4MouseEntered
        btn_4.setBackground(new Color(139, 157, 195));
        ind_4.setBackground(new Color(223, 227, 238));
    }//GEN-LAST:event_btn_4MouseEntered

    private void btn_4MouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_4MouseExited
    {//GEN-HEADEREND:event_btn_4MouseExited
        btn_4.setBackground(new Color(223, 227, 238));
        ind_4.setBackground(new Color(139, 157, 195));
    }//GEN-LAST:event_btn_4MouseExited

    private void btn_4MousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_btn_4MousePressed
    {//GEN-HEADEREND:event_btn_4MousePressed
        this.dispose();
        new VtnGestionPedidos().setVisible(true);
    }//GEN-LAST:event_btn_4MousePressed

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
            java.util.logging.Logger.getLogger(VtnMainGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnMainGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VtnMainGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_1;
    private javax.swing.JPanel btn_2;
    private javax.swing.JPanel btn_3;
    private javax.swing.JPanel btn_4;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JLabel jLCerrar;
    private javax.swing.JLabel jLHelp;
    private javax.swing.JLabel jLIconAdmin;
    private javax.swing.JLabel jLIconEmpleado;
    private javax.swing.JLabel jLIconEmpleado1;
    private javax.swing.JLabel jLIconEmpleado2;
    private javax.swing.JLabel jLIconSucursal;
    private javax.swing.JLabel jLMinimizar;
    private javax.swing.JLabel jLNameSucursal;
    private javax.swing.JLabel jLNameUser;
    private javax.swing.JLabel jLNameUser1;
    private javax.swing.JLabel jLOp1;
    private javax.swing.JLabel jLOp2;
    private javax.swing.JLabel jLOp3;
    private javax.swing.JLabel jLOp4;
    private javax.swing.JLabel jLWelcome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}