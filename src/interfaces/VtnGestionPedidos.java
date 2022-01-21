/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Conextion.Conexiones;
import Objects.Clientes;
import Objects.Pedidos;
import Reportes.Conectar;
import cjb.ci.CtrlInterfaz;
import cjb.ci.Mensaje;
import static interfaces.VtnGestionClientes.edicion;
import static interfaces.VtnGestionClientes.modelo;
import static interfaces.VtnLogin.con;
import java.awt.Color;
import java.io.File;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author mosh_
 */
public class VtnGestionPedidos extends javax.swing.JFrame
{

    private String emisor="institucionacademica0066";
    private String receptor="luisgustavozepedagonzalez";
    private String passw ="proyectomauro";
    private String asun = "Inserte asunto aqui";
    private JFileChooser abrirArchivo = new JFileChooser(new File(""));
    private boolean soloMensaje = true;
    private String ruta="";
    
    
    static Boolean edicion = false;
    
    /**
     * Creates new form Enviar
     */
    public VtnGestionPedidos()
    {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(false);
        jLRuta1.setText("Ruta Archivo"+ruta);
        String direct ="@gmail.com";
        jtfRemitente.setText(emisor+direct);
        jtfDestinatario.setText(receptor+direct);
        jtfpassword.setText(passw);
        jtfAsunto.setText(asun);
    }
    
    public class hilo implements Runnable
    {

        @Override
        public void run()
        {
            String texto = jTextArea1.getText();
            String correo = jtfRemitente.getText();
            String pass = jtfpassword.getText();
            String rec = jtfDestinatario.getText();
            String asu = jtfAsunto.getText();
            
            if (!texto.equals("") & !correo.equals("@gmail.com") & !pass.equals("") & !rec.equals("@gmail.com") & !asu.equals(""))
            {
                Enviar(texto,correo,pass,rec,asu);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No ha llenado los campos");
                System.out.println("xd");
            }
        }

        private void Enviar(String texto, String correo, String pass, String rec, String asu)
        {
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            
            Session session = Session.getDefaultInstance(props, null);
            
            BodyPart adjunto = new MimeBodyPart();
            MimeMultipart multiparte = new MimeMultipart();
            
            if (ruta =="")
            {
                soloMensaje = false;
            }
            else
            {
                soloMensaje = true;
            }
            
            if (soloMensaje)
            {
                File archivo = new File(ruta);
                try
                {
                    if (archivo.exists())
                    {
                        BodyPart textos = new MimeBodyPart();
                        textos.setText(texto);
                        adjunto.setDataHandler(new DataHandler(new FileDataSource(ruta)));
                        adjunto.setFileName(archivo.getName());
                        multiparte.addBodyPart(textos);
                        multiparte.addBodyPart(adjunto);
                        System.out.println("Enviando archivo");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Ruta de archivo incorrecta");
                    }
                } catch (Exception e)
                {
                    System.out.println("Error al enviar archivo");
                }
            }
            
            try
            {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(asu);
                
                if (soloMensaje)
                {
                    message.setContent(multiparte);
                }
                else
                {
                    message.setText(texto);
                }
                
                Transport t = session.getTransport("smtp");
                t.connect(correo, pass);
                t.sendMessage(message, message.getAllRecipients());
                t.close();
                ruta="";
                
                JOptionPane.showMessageDialog(null, "Correo Enviado");
                btnCancelarActionPerformed(null);
            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "No se pudo enviar el correo");
            }
            
        }

        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLRemitente = new javax.swing.JLabel();
        jLAsunto = new javax.swing.JLabel();
        jLDescripcion = new javax.swing.JLabel();
        jtfRemitente = new javax.swing.JTextField();
        jtfAsunto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAñadir = new javax.swing.JButton();
        btnQuitarArchivo = new javax.swing.JButton();
        jLDestinatario = new javax.swing.JLabel();
        jtfDestinatario = new javax.swing.JTextField();
        jLPassword = new javax.swing.JLabel();
        jLTamanio = new javax.swing.JLabel();
        jLRuta1 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jtfpassword = new javax.swing.JPasswordField();
        registrar = new javax.swing.JButton();
        Print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Realizar Pedido");

        jLRemitente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLRemitente.setForeground(new java.awt.Color(0, 102, 153));
        jLRemitente.setText("Remitente");

        jLAsunto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLAsunto.setForeground(new java.awt.Color(0, 102, 153));
        jLAsunto.setText("Asunto");

        jLDescripcion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLDescripcion.setForeground(new java.awt.Color(0, 102, 153));
        jLDescripcion.setText("Descrrpcion");

        jtfRemitente.setBackground(new java.awt.Color(204, 204, 255));

        jtfAsunto.setBackground(new java.awt.Color(204, 204, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnAñadir.setBackground(new java.awt.Color(0, 102, 153));
        btnAñadir.setText("Añadir Archivo");
        btnAñadir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnQuitarArchivo.setBackground(new java.awt.Color(0, 102, 153));
        btnQuitarArchivo.setText("Quitar Archivo");
        btnQuitarArchivo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        btnQuitarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarArchivoActionPerformed(evt);
            }
        });

        jLDestinatario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLDestinatario.setForeground(new java.awt.Color(0, 102, 153));
        jLDestinatario.setText("Destinatario");

        jtfDestinatario.setBackground(new java.awt.Color(204, 204, 255));

        jLPassword.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLPassword.setForeground(new java.awt.Color(0, 102, 153));
        jLPassword.setText("Contraseña");

        jLTamanio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLTamanio.setForeground(new java.awt.Color(0, 102, 153));
        jLTamanio.setText("Tamaño Archivo");

        jLRuta1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLRuta1.setForeground(new java.awt.Color(0, 102, 153));
        jLRuta1.setText("Ruta Archivo");

        btnEnviar.setBackground(new java.awt.Color(0, 102, 153));
        btnEnviar.setText("Enviar");
        btnEnviar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jtfpassword.setText("jPasswordField1");

        registrar.setBackground(new java.awt.Color(0, 102, 153));
        registrar.setText("Registrar");
        registrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        Print.setBackground(new java.awt.Color(0, 102, 153));
        Print.setText("Imprimir Resgistros");
        Print.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(btnQuitarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(Print, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLRemitente)
                                .addGap(32, 32, 32)
                                .addComponent(jtfRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLDescripcion))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLTamanio)
                                    .addComponent(jLRuta1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLDestinatario)
                                    .addComponent(jLAsunto)
                                    .addComponent(jLPassword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRemitente)
                    .addComponent(jtfRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDestinatario)
                    .addComponent(jtfDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAsunto)
                    .addComponent(jtfAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLRuta1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDescripcion)
                    .addComponent(jLTamanio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEnviarActionPerformed
    {//GEN-HEADEREND:event_btnEnviarActionPerformed
       Runnable enviar = new hilo();
       Thread t = new Thread(enviar);
       t.start();             
    }//GEN-LAST:event_btnEnviarActionPerformed

    
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAñadirActionPerformed
    {//GEN-HEADEREND:event_btnAñadirActionPerformed
        abrirArchivo.setDialogTitle("Busqueda de archivo a enviar");
        abrirArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (abrirArchivo.showOpenDialog(this)==0)
        {
            File archivo = new File(abrirArchivo.getSelectedFile().toString());
            if (archivo.exists())
            {
                ruta = abrirArchivo.getSelectedFile().toString();
                jLRuta1.setText("Ruta del archivo: "+ruta);
                jLTamanio.setText("Peso de archivo: "+archivo.length()+" bits");
            }
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnQuitarArchivoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnQuitarArchivoActionPerformed
    {//GEN-HEADEREND:event_btnQuitarArchivoActionPerformed
        ruta="";
        jLRuta1.setText("Ruta "+ruta);
        jLTamanio.setText("Peso archivo ");
        
    }//GEN-LAST:event_btnQuitarArchivoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelarActionPerformed
    {//GEN-HEADEREND:event_btnCancelarActionPerformed
        ruta="";
        jLRuta1.setText("Ruta "+ruta);
        jLTamanio.setText("Peso archivo ");
        jtfAsunto.setText("Inserte Asunto");
        jtfRemitente.setText("@gmail.com");
        jtfDestinatario.setText("@gmail.com");
        jtfpassword.setText(passw);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if (!edicion)
        {
            if (Mensaje.pregunta(this, "¿Seguro que quiere enviar el correo") == JOptionPane.YES_OPTION)
            {
                Pedidos ped = new Pedidos(0,
                        jtfRemitente.getText(),
                        jtfDestinatario.getText(),
                        jtfAsunto.getText(),
                        jTextArea1.getText());
                ped.inserta(this, ped, con);
                edicion = false;
                cjb.ci.CtrlInterfaz.habilita(!edicion, jtfRemitente, jtfDestinatario, jtfpassword, jtfAsunto,btnAñadir);
                cjb.ci.CtrlInterfaz.habilita(!edicion, btnAñadir, btnCancelar, btnEnviar, btnQuitarArchivo);
                btnEnviar.setText("Enviar");
            }
        }else
        {
            edicion = true;
            CtrlInterfaz.selecciona(jtfRemitente);
                cjb.ci.CtrlInterfaz.habilita(!edicion, jtfRemitente, jtfDestinatario, jtfpassword, jtfAsunto,btnAñadir);
                cjb.ci.CtrlInterfaz.habilita(!edicion, btnAñadir, btnCancelar, btnEnviar, btnQuitarArchivo);
            //cjb.ci.CtrlInterfaz.limpia(jtfRemitente, jtfpassword, jtfDestinatario, jtfAsunto);
            registrar.setText("Aceptar");
        }    
    }//GEN-LAST:event_registrarActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        JasperReport reporte; //Creo el objeto reporte
        // Ubicacion del Reporte
        String path = "src\\Reportes\\RegistroCorreo.jasper";
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
    }//GEN-LAST:event_PrintActionPerformed


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
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnGestionPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Print;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnQuitarArchivo;
    private javax.swing.JLabel jLAsunto;
    private javax.swing.JLabel jLDescripcion;
    private javax.swing.JLabel jLDestinatario;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLRemitente;
    private javax.swing.JLabel jLRuta1;
    private javax.swing.JLabel jLTamanio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jtfAsunto;
    private javax.swing.JTextField jtfDestinatario;
    private javax.swing.JTextField jtfRemitente;
    private javax.swing.JPasswordField jtfpassword;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
    //CONECTA CON LA BASE DE DATOS
    Conectar cc = new Conectar();
    Connection cn = Conexiones.conectar();

}
