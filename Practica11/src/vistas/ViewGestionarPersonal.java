package vistas;

import java.awt.Point;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

public class ViewGestionarPersonal extends JFrame {

    /**
     * Creates new form ViewGestionarPersonal
     */
    File archivo = new File("data/personales.csv");
    File archivoComboCargo = new File("data/cargos.csv");
    String opcionBoton = null;
    int numeroEditar = 0;
    int numeroEliminar = 0;

    public ViewGestionarPersonal() throws IOException {
        initComponents();
        verificarArchivo();
        asignarEventoMouse();
        IniciarCajasTextos();
    }

    private void verificarArchivo() {

        if (!archivo.exists()) {

            try {
                archivo.createNewFile();
                System.out.println("Archivo de base de datos creado correctamente");

                agregarCampo();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        } else {
            System.out.println("El archivo existe");
            try {
                leerArchivo();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    private void agregarCampo() {

        BufferedWriter escribirArchivo = null;
        try {
            try {
                escribirArchivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));
            } catch (UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            try {

                escribirArchivo.write("CEDULA" + "," + "NOMBRE" + "," + "APELLIDO PATERNO" + "," + "APELLIDO MATERNO" + "," + "FECHA NACIMIENTO" + "," + "DIRECCION" + "," + "TEL. FIJO" + "," + "TEL. MOVIL" + "," + "FECHA INGRESO" + "," + "CARGO" + "\n");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            System.out.println("Campos agregado correctamente");
            try {
                escribirArchivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            try {
                escribirArchivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

    }

    private void leerArchivo() throws FileNotFoundException, IOException {

        String linea = null;
        int numeroRegistros = 0;
        BufferedReader leerFichero = new BufferedReader(new FileReader(archivo));

        while ((linea = leerFichero.readLine()) != null) {

            numeroRegistros += 1;

        }

        leerFichero.close();

        if (numeroRegistros == 0) {

            System.out.println("No existen registros en el archivo");

        } else {

            String delimitador = ",";
            leerFichero = new BufferedReader(new FileReader(archivo));
            String strLine = "";
            StringTokenizer st = null;
            int lineNumber = 0, tokenNumber = 0;
            String[][] datos = new String[numeroRegistros][10];
            int posicion = 0;

            while ((strLine = leerFichero.readLine()) != null) {

                lineNumber++;
                st = new StringTokenizer(strLine, delimitador);

                while (st.hasMoreTokens()) {

                    tokenNumber++;
                    datos[posicion][0] = st.nextToken().trim();
                    datos[posicion][1] = st.nextToken().trim();
                    datos[posicion][2] = st.nextToken().trim();
                    datos[posicion][3] = st.nextToken().trim();
                    datos[posicion][4] = st.nextToken().trim();
                    datos[posicion][5] = st.nextToken().trim();
                    datos[posicion][6] = st.nextToken().trim();
                    datos[posicion][7] = st.nextToken().trim();
                    datos[posicion][8] = st.nextToken().trim();
                    datos[posicion][9] = st.nextToken().trim();
                    posicion += 1;

                }
                tokenNumber = 0;
            }

            leerFichero.close();

            DefaultTableModel modelo = (DefaultTableModel) tblPersonal.getModel();
            limpiarTabla(modelo);
            for (int i = 1; i < datos.length; i++) {
                String[] data = new String[11];
                data[0] = String.valueOf(i + 1);
                for (int j = 0; j < datos[i].length; j++) {
                    data[(j + 1)] = datos[i][j];
                }
                modelo.addRow(data);
            }

        }
    }

    private void cargarComboCargo() {

        cboCargo.removeAllItems();
        try {
            BufferedReader ficheroaleer = new BufferedReader(new FileReader(archivoComboCargo));
            String linea;

            while ((linea = ficheroaleer.readLine()) != null) {

                StringTokenizer tokens = new StringTokenizer(linea, ",");
                String cargo = (String) tokens.nextElement();

                cboCargo.addItem(tokens.nextToken());

            }

            ficheroaleer.close();

        } catch (Exception x) {
            x.printStackTrace();
        }

    }

    public void limpiarTabla(DefaultTableModel modelo) {
        for (int i = tblPersonal.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTeleFijo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTeleMovil = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        txtBuscarPersonal = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        txtCargo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        cboCargo = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(890, 590));
        jPanel1.setPreferredSize(new java.awt.Dimension(890, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("GESTIÓN PERSONAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Cedula");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Apellido Paterno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtCedula.setToolTipText("Ingrese su número de cedula");
        txtCedula.setEnabled(false);
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 260, -1));

        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 270, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Apellido Materno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        txtApellidoPaterno.setEnabled(false);
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 260, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Nacimiento");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtApellidoMaterno.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtApellidoMaterno.setEnabled(false);
        jPanel1.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 270, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Dirección");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, -1));

        txtFechaNacimiento.setEnabled(false);
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 260, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel7.setText("Tel. Fijo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtDireccion.setEnabled(false);
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 270, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Tel. Móvil");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        txtTeleFijo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtTeleFijo.setEnabled(false);
        jPanel1.add(txtTeleFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 260, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Fecha Ingreso");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtTeleMovil.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtTeleMovil.setEnabled(false);
        jPanel1.add(txtTeleMovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 270, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("Cargo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, -1, -1));

        txtFechaIngreso.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtFechaIngreso.setToolTipText("");
        txtFechaIngreso.setEnabled(false);
        jPanel1.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 260, -1));

        btnAgregar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        btnEditar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, -1));

        btnCerrar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, -1, -1));

        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cédula", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha Nacimiento", "Dirección", "Tel. Fijo", "Tel. Móvil", "Fecha Ingreso", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonal);
        if (tblPersonal.getColumnModel().getColumnCount() > 0) {
            tblPersonal.getColumnModel().getColumn(0).setMinWidth(20);
            tblPersonal.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblPersonal.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 320, 870, 230));
        jPanel1.add(txtBuscarPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 280, -1));

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 80, 30));

        btnListar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        btnListar.setText("Listar");
        jPanel1.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));

        txtCargo.setEditable(false);
        txtCargo.setEnabled(false);
        jPanel1.add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 270, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("Nombre: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 80, -1));

        btnActualizar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 80, 30));

        cboCargo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel1.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 270, -1));

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscar = String.valueOf(txtBuscarPersonal.getText());
        String[][] datos = new String[tblPersonal.getRowCount()][11];
        for (int i = 0; i < tblPersonal.getRowCount(); i++) {
            for (int j = 0; j < 11; j++) {
                datos[i][j] = String.valueOf(tblPersonal.getValueAt(i, j));
            }
        }
        DefaultTableModel modelo = (DefaultTableModel) tblPersonal.getModel();
        limpiarTabla(modelo);
        for (int i = 0; i < datos.length; i++) {
            if (datos[i][1].equals(buscar)) {
                modelo.addRow(new Object[]{datos[i][0], datos[i][1], datos[i][2], datos[i][3], datos[i][4], datos[i][5], datos[i][6], datos[i][7], datos[i][8], datos[i][9], datos[i][10]});
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    public final void asignarEventoMouse() {
        tblPersonal.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_event) {
                JTable tabla = (JTable) Mouse_event.getSource();
                Point point = Mouse_event.getPoint();
                int row = tabla.rowAtPoint(point);
                if (Mouse_event.getClickCount() == 2) {
                    btnEditar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnListar.setEnabled(true);

                    numeroEditar = Integer.parseInt("" + tabla.getValueAt(tabla.getSelectedRow(), 0));
                    numeroEliminar = numeroEditar;
                    txtCedula.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 1));
                    txtNombre.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 2));
                    txtApellidoPaterno.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 3));
                    txtApellidoMaterno.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 4));
                    txtFechaNacimiento.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 5));
                    txtDireccion.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 6));
                    txtTeleFijo.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 7));
                    txtTeleMovil.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 8));
                    txtFechaIngreso.setText("" + tabla.getValueAt(tabla.getSelectedRow(), 9));
                    cboCargo.setSelectedItem("" + tabla.getValueAt(tabla.getSelectedRow(), 10));
                }
            }
        });
    }

    public void habilitarCajasTextos(boolean estado) {
        txtCedula.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtApellidoPaterno.setEnabled(estado);
        txtApellidoMaterno.setEnabled(estado);
        txtFechaNacimiento.setEnabled(estado);
        txtDireccion.setEnabled(estado);
        txtTeleFijo.setEnabled(estado);
        txtTeleMovil.setEnabled(estado);
        txtFechaIngreso.setEnabled(estado);
        cboCargo.setEnabled(estado);
    }

    public void IniciarCajasTextos() {
        txtCedula.setText(null);
        txtNombre.setText(null);
        txtApellidoPaterno.setText(null);
        txtApellidoMaterno.setText(null);
        txtFechaNacimiento.setText(null);
        txtDireccion.setText(null);
        txtTeleFijo.setText(null);
        txtTeleMovil.setText(null);
        txtFechaIngreso.setText(null);
        cargarComboCargo();
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        habilitarCajasTextos(true);
        IniciarCajasTextos();
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnListar.setEnabled(false);
        txtCedula.setFocusable(true);
        opcionBoton = "Agregar";
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void ingresarPersonal() {
        BufferedWriter escribirArchivo = null;
        try {
            try {
                escribirArchivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));
            } catch (UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            try {
                System.out.println("clases.GestionarPersonal.ingresarPersonal(): " + cboCargo.getSelectedItem());
                escribirArchivo.write(txtCedula.getText() + "," + txtNombre.getText() + "," + txtApellidoPaterno.getText() + "," + txtApellidoMaterno.getText() + "," + txtFechaNacimiento.getText() + "," + txtDireccion.getText() + "," + txtTeleFijo.getText() + "," + txtTeleMovil.getText() + "," + txtFechaIngreso.getText() + "," + cboCargo.getSelectedItem() + "\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Personal ingresado correctamente");
            try {
                escribirArchivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            try {
                leerArchivo();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            try {
                escribirArchivo.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!(txtCedula.getText().equals("") || txtNombre.getText().equals("") || txtApellidoPaterno.getText().equals("") || txtApellidoMaterno.getText().equals("") || txtFechaNacimiento.getText().equals("") || txtDireccion.getText().equals("") || txtTeleFijo.getText().equals("") || txtTeleMovil.getText().equals("") || txtFechaIngreso.getText().equals("") || cboCargo.getSelectedItem().toString().equals(""))) {
            if (opcionBoton.equals("Agregar")) {
                ingresarPersonal();
            } else if (opcionBoton.equals("Editar")) {
                efectuarEdicion();
                almacenarFichero();
                JOptionPane.showMessageDialog(null, "Se editó el personal satisactoriamente");
            }
            habilitarCajasTextos(false);
            IniciarCajasTextos();
            btnAgregar.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnListar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "No deje espacios vacíos");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void almacenarFichero() {
        try {
            archivo.delete();
            archivo.createNewFile();
            agregarCampo();

            BufferedWriter escribirArchivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));
            for (int i = 0; i < tblPersonal.getRowCount(); i++) {
                escribirArchivo.write(tblPersonal.getValueAt(i, 1) + "," + tblPersonal.getValueAt(i, 2) + "," + tblPersonal.getValueAt(i, 3) + "," + tblPersonal.getValueAt(i, 4) + "," + tblPersonal.getValueAt(i, 5) + "," + tblPersonal.getValueAt(i, 6) + "," + tblPersonal.getValueAt(i, 7) + "," + tblPersonal.getValueAt(i, 8) + "," + tblPersonal.getValueAt(i, 9) + "," + tblPersonal.getValueAt(i, 10) + "\n");
            }
            escribirArchivo.close();
            leerArchivo();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void efectuarEdicion() {
        for (int i = 0; i < tblPersonal.getRowCount(); i++) {
            if (numeroEditar == Integer.parseInt((String) tblPersonal.getValueAt(i, 0))) {
                tblPersonal.setValueAt(numeroEditar, i, 0);
                tblPersonal.setValueAt(txtCedula.getText(), i, 1);
                tblPersonal.setValueAt(txtNombre.getText(), i, 2);
                tblPersonal.setValueAt(txtApellidoPaterno.getText(), i, 3);
                tblPersonal.setValueAt(txtApellidoMaterno.getText(), i, 4);
                tblPersonal.setValueAt(txtFechaNacimiento.getText(), i, 5);
                tblPersonal.setValueAt(txtDireccion.getText(), i, 6);
                tblPersonal.setValueAt(txtTeleFijo.getText(), i, 7);
                tblPersonal.setValueAt(txtTeleMovil.getText(), i, 8);
                tblPersonal.setValueAt(txtFechaIngreso.getText(), i, 9);
                tblPersonal.setValueAt(cboCargo.getSelectedItem().toString(), i, 10);
                break;
            }
        }
    }

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        opcionBoton = "Editar";
        habilitarCajasTextos(true);
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnListar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitarCajasTextos(false);
        IniciarCajasTextos();
        btnAgregar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnListar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            leerArchivo();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(null, "¿En serio desea eliminar este personal?", "Eliminar personal", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            DefaultTableModel modelo = (DefaultTableModel) tblPersonal.getModel();
            for (int i = 0; i < tblPersonal.getRowCount(); i++) {
                if (numeroEliminar == Integer.parseInt(String.valueOf(tblPersonal.getValueAt(i, 0)))) {
                    modelo.removeRow(i);
                }
            }
            JOptionPane.showMessageDialog(null, "Se ha eliminado el personal seleccionado");
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);

            almacenarFichero();
        } else {
            System.out.println("No se ha eliminado nada");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGestionarPersonal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ViewGestionarPersonal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ViewGestionarPersonal.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtBuscarPersonal;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTeleFijo;
    private javax.swing.JTextField txtTeleMovil;
    // End of variables declaration//GEN-END:variables

}
