/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Objects.Almacen;
import Reportes.Conectar;
import cjb.ci.CtrlInterfaz;
import cjb.ci.Mensaje;
import cjb.ci.Validaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static interfaces.VtnLogin.con;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class VtnGestionAlmacen extends javax.swing.JFrame
{

    static DefaultTableModel modelo;
    static Boolean edicion = false;
    //static Estados[] est;

    /**
     * Creates new form VtnMainAdmin
     */
    public VtnGestionAlmacen()
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLTipoSucursal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLEstado = new javax.swing.JLabel();
        txtNombre_almacen = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLNameUser1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        pdf = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLWelcome = new javax.swing.JLabel();
        jLIconAdmin = new javax.swing.JLabel();
        jLNameUser = new javax.swing.JLabel();
        jLMinimizar = new javax.swing.JLabel();
        jLCerrar = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(223, 227, 238));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 807));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(59, 89, 152));
        jSeparator3.setForeground(new java.awt.Color(59, 89, 152));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 150, 10));

        jLTipoSucursal.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLTipoSucursal.setForeground(new java.awt.Color(59, 89, 152));
        jLTipoSucursal.setText("Nombre Almacen:");
        jPanel2.add(jLTipoSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(59, 89, 152));
        jSeparator4.setForeground(new java.awt.Color(59, 89, 152));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 150, 10));

        jLEstado.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLEstado.setForeground(new java.awt.Color(59, 89, 152));
        jLEstado.setText("Descripcion:");
        jPanel2.add(jLEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        txtNombre_almacen.setBackground(new java.awt.Color(223, 227, 238));
        txtNombre_almacen.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtNombre_almacen.setForeground(new java.awt.Color(59, 89, 152));
        txtNombre_almacen.setBorder(null);
        txtNombre_almacen.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtNombre_almacenKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtNombre_almacenKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre_almacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 150, 20));

        txtDescripcion.setBackground(new java.awt.Color(223, 227, 238));
        txtDescripcion.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(59, 89, 152));
        txtDescripcion.setBorder(null);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 150, 20));

        btnnuevo.setBackground(new java.awt.Color(59, 89, 152));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 100, 40));

        btncancelar.setBackground(new java.awt.Color(59, 89, 152));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 100, 40));

        jButton1.setBackground(new java.awt.Color(59, 89, 152));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 100, 40));

        jPanel3.setBackground(new java.awt.Color(223, 227, 238));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNameUser1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLNameUser1.setForeground(new java.awt.Color(59, 89, 152));
        jLNameUser1.setText("Gestión Almacenes");
        jPanel3.add(jLNameUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 810));

        jPanel4.setBackground(new java.awt.Color(247, 247, 247));
        jPanel4.setForeground(new java.awt.Color(247, 247, 247));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 807));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setSelectionBackground(new java.awt.Color(223, 227, 238));
        jTable2.setSelectionForeground(new java.awt.Color(139, 157, 195));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 930, 350));

        btneditar.setBackground(new java.awt.Color(59, 89, 152));
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btneditarActionPerformed(evt);
            }
        });
        jPanel4.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 170, 50));

        btneliminar.setBackground(new java.awt.Color(59, 89, 152));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 170, 50));

        pdf.setBackground(new java.awt.Color(59, 89, 152));
        pdf.setForeground(new java.awt.Color(255, 255, 255));
        pdf.setText("Impresion de Categorias");
        pdf.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pdfActionPerformed(evt);
            }
        });
        jPanel4.add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 170, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 1000, 700));

        jPanel5.setBackground(new java.awt.Color(139, 157, 195));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLWelcome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLWelcome.setForeground(new java.awt.Color(223, 227, 238));
        jLWelcome.setText("Bienvenido:");
        jPanel5.add(jLWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jLIconAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrador-con-ruedas-dentadas.png"))); // NOI18N
        jPanel5.add(jLIconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLNameUser.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLNameUser.setForeground(new java.awt.Color(223, 227, 238));
        jPanel5.add(jLNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

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
        jPanel5.add(jLMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 30, -1));

        jLCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar2.png"))); // NOI18N
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
        jPanel5.add(jLCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 30, 40));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 1000, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLCerrarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLCerrarMousePressed
    {//GEN-HEADEREND:event_jLCerrarMousePressed
        this.dispose();
        new VtnMainAdmin().setVisible(true);
    }//GEN-LAST:event_jLCerrarMousePressed

    private void jLMinimizarMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLMinimizarMousePressed
    {//GEN-HEADEREND:event_jLMinimizarMousePressed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLMinimizarMousePressed

    private void jLCerrarMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLCerrarMouseEntered
    {//GEN-HEADEREND:event_jLCerrarMouseEntered
        ImageIcon icon = new ImageIcon("src/images/cerrar1.png");
        Icon a = new ImageIcon(icon.getImage());
        jLCerrar.setIcon(a);
    }//GEN-LAST:event_jLCerrarMouseEntered

    private void jLCerrarMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jLCerrarMouseExited
    {//GEN-HEADEREND:event_jLCerrarMouseExited
        ImageIcon icon = new ImageIcon("src/images/cerrar2.png");
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CrearModelo();
        llenaTabla();
        cjb.ci.CtrlInterfaz.habilita(edicion, txtDescripcion, txtNombre_almacen);
        cjb.ci.CtrlInterfaz.habilita(!edicion, btnnuevo, btncancelar, btneliminar, btneditar);
        jLNameUser.setText(VtnLogin.emp.getNombre());
    }//GEN-LAST:event_formWindowOpened

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        if (!edicion)
        {
            txtNombre_almacen.setText(String.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1)));
            txtDescripcion.setText(String.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 2)));
        }
    }//GEN-LAST:event_jTable2MousePressed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        try
        {
            if (edicion)
            {
                if (Mensaje.pregunta(this, "¿Seguro que quiere editar a " + jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1) + "?") == JOptionPane.YES_OPTION)
                {
                    Almacen alm = new Almacen(Integer.parseInt(
                            String.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0))),
                            txtNombre_almacen.getText(), txtDescripcion.getText());
                    alm.modifica(this, alm, con);

                    llenaTabla();
                    edicion = false;
                    cjb.ci.CtrlInterfaz.habilita(edicion, txtDescripcion, txtNombre_almacen);
                    cjb.ci.CtrlInterfaz.habilita(!edicion, btnnuevo, btncancelar, btneliminar, btneditar);
                    btnnuevo.setText("Nuevo");
                }

            } else
            {
                if (null == jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0))
                {

                }
                edicion = true;
                cjb.ci.CtrlInterfaz.habilita(edicion, txtDescripcion, txtNombre_almacen);
                cjb.ci.CtrlInterfaz.habilita(!edicion, btnnuevo, btneliminar);
                btnnuevo.setText("Aceptar");
            }
        } catch (Exception e)
        {
            Mensaje.error(this, "Selecione un elemento de la tabla");
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try
        {
            if (Mensaje.pregunta(this, "¿Seguro que quiere eliminar a " + jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 1) + "?") == JOptionPane.YES_OPTION)
            {
                Almacen alm = new Almacen();
                alm.elimina(Integer.parseInt(String.valueOf(jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0))), con);
                llenaTabla();
            }

        } catch (Exception e)
        {
            Mensaje.error(this, "Selecione un elemento de la tabla");
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        cjb.ci.CtrlInterfaz.limpia(txtDescripcion, txtNombre_almacen);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btncancelarActionPerformed
    {//GEN-HEADEREND:event_btncancelarActionPerformed
        edicion = false;
        cjb.ci.CtrlInterfaz.habilita(edicion, txtDescripcion, txtNombre_almacen);
        cjb.ci.CtrlInterfaz.habilita(!edicion, btnnuevo, btncancelar, btneliminar, btneditar);
        cjb.ci.CtrlInterfaz.limpia(txtDescripcion, txtNombre_almacen);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnnuevoActionPerformed
    {//GEN-HEADEREND:event_btnnuevoActionPerformed
        if (edicion)
        {
            if (Mensaje.pregunta(this, "¿Seguro que quiere dar de alta?") == JOptionPane.YES_OPTION)
            {
                Almacen alm = new Almacen(0,
                        txtNombre_almacen.getText(),
                        txtDescripcion.getText());
                alm.inserta(alm, con);
                llenaTabla();
                edicion = false;
                cjb.ci.CtrlInterfaz.habilita(edicion, txtDescripcion, txtNombre_almacen);
                cjb.ci.CtrlInterfaz.habilita(!edicion, btnnuevo, btncancelar, btneliminar, btneditar);
                btnnuevo.setText("Nuevo");
            }

        } else
        {
            edicion = true;
            CtrlInterfaz.selecciona(txtNombre_almacen);
            cjb.ci.CtrlInterfaz.habilita(edicion, txtDescripcion, txtNombre_almacen);
            cjb.ci.CtrlInterfaz.habilita(!edicion, btneditar, btneliminar);
            cjb.ci.CtrlInterfaz.limpia(txtDescripcion, txtNombre_almacen);
            btnnuevo.setText("Aceptar");
        }
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtDescripcionKeyTyped
    {//GEN-HEADEREND:event_txtDescripcionKeyTyped
        if (txtDescripcion.getText().length() >= 10)
        {
            evt.consume();
        }
        Validaciones.validaEntero(evt);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtDescripcionKeyPressed
    {//GEN-HEADEREND:event_txtDescripcionKeyPressed
        Validaciones.enter(this, evt, btnnuevo);
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtNombre_almacenKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtNombre_almacenKeyTyped
    {//GEN-HEADEREND:event_txtNombre_almacenKeyTyped
        Validaciones.validaAlfanumerico(evt);
    }//GEN-LAST:event_txtNombre_almacenKeyTyped

    private void txtNombre_almacenKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtNombre_almacenKeyPressed
    {//GEN-HEADEREND:event_txtNombre_almacenKeyPressed
        Validaciones.enter(this, evt, txtDescripcion);
    }//GEN-LAST:event_txtNombre_almacenKeyPressed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        JasperReport reporte; //Creo el objeto reporte
        // Ubicacion del Reporte
        String path = "src\\Reportes\\almacenes.jasper";
        try
        {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Cargo el reporte al objeto
            JasperPrint jprint = JasperFillManager.fillReport(path, null, cn); //Llenado del Reporte con Tres parametros ubicacion,parametros,conexion a la base de datos
            JasperViewer viewer = new JasperViewer(jprint, false); //Creamos la vista del Reporte
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Le agregamos que se cierre solo el reporte cuando lo cierre el usuario
            viewer.setVisible(true); //Inicializamos la vista del Reporte
        } catch (JRException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pdfActionPerformed

    public void llenaTabla()
    {
//        Sucursal suc = new Sucursal();
//        modelo.addRow(suc.consultaMultipleMat(VtnLogin.con));
        modelo.setRowCount(0);
        try
        {
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT id_almacen,nombre_almacen,descripcion FROM almacen ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rrsw = rs.getMetaData();
            int cantcolumnas = rrsw.getColumnCount();
            Object[] filas = new Object[cantcolumnas];
            while (rs.next())
            {
                for (int i = 0; i < cantcolumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception e)
        {
            System.out.println("Error" + e.toString());
        }
    }

    private void CrearModelo()
    {
        try
        {
            modelo = (new DefaultTableModel(
                    null, new String[]
                    {
                        "id", "nombre del almacen", "descripcion del almacen"
                    })
            {
                Class[] types = new Class[]
                {
                    java.lang.Object.class,
                    java.lang.Object.class,
                    java.lang.Object.class,
                };
                boolean[] canEdit = new boolean[]
                {
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex)
                {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex)
                {
                    return canEdit[colIndex];
                }
            });
            jTable2.setModel(modelo);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

//    public int ExtraeId(String nombre)
//    {
//        for (int i = 0; i < est.length; i++)
//        {
//            if (est[i].getNombre_estado().equals(nombre))
//            {
//                return est[i].getId_estado();
//            }
//        }
//        return 0;
//    }
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
            java.util.logging.Logger.getLogger(VtnGestionAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionAlmacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnGestionAlmacen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLCerrar;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLIconAdmin;
    private javax.swing.JLabel jLMinimizar;
    private javax.swing.JLabel jLNameUser;
    private javax.swing.JLabel jLNameUser1;
    private javax.swing.JLabel jLTipoSucursal;
    private javax.swing.JLabel jLWelcome;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton pdf;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre_almacen;
    // End of variables declaration//GEN-END:variables
    //CONECTA CON LA BASE DE DATOS
    Conectar cc = new Conectar();
    Connection cn = cc.conexion();
}
