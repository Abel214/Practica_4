/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Listas.DynamicList;
import Controlador.autoControl.DatoAutoControl1;
import Controlador.autos.AgenteControl1;
import Modelo.Tipos;
import Vista.Lista.Tabla.ModeloTablaAuto;
import Vista.Lista.Util.UtilVista;
import Vista.Lista.Util.UtilVista1;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author ALEJANDRO
 */
public class VentaAuto extends javax.swing.JFrame {

    private DatoAutoControl1 autoControl = new DatoAutoControl1();
    private ModeloTablaAuto mtp = new ModeloTablaAuto();

    /**
     * Creates new form VentaCasa
     */
    public VentaAuto() {
        initComponents();
        this.setLocationRelativeTo(null);
        Limpiar();
    }

    private void CargarTabla() {
        mtp.setTipos(autoControl.getTipos());
        cbxEstado.setSelectedIndex(0);
        cbxTipoAuto.setSelectedIndex(-1);
        cbxVendedores.setSelectedIndex(-1);
        cbxPago.setSelectedIndex(0);
        tblMostrar.setModel((TableModel) mtp);
        tblMostrar.updateUI();
    }

    private void Limpiar() {
        try {
            UtilVista.CargarComboRolesL(cbxTipoAuto);
            UtilVista1.cargarcomboRolesL(cbxVendedores);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        txtMarca.setEnabled(true);
        tblMostrar.clearSelection();
        txtColor.setText(" ");
        txtMarca.setText(" ");
        txtPrecio.setText(" ");
        CargarTabla();
        cbxEstado.setSelectedIndex(-1);//limpia combobo
        cbxPago.setSelectedIndex(-1);//limpia combobo
        cbxTipoAuto.setSelectedIndex(-1);
        autoControl.setTipos1(null);
    }

    private Boolean Validar() {
        return (!txtMarca.getText().trim().isEmpty()
                && !txtPrecio.getText().trim().isEmpty()
                && !txtColor.getText().trim().isEmpty());
    }

    private void Guardar() {
        if (Validar()) {
//            String textoPrecio = txtPrecio.getText();
//            float precio = Float.parseFloat(textoPrecio);
            autoControl.getTipos1().setMarca(txtMarca.getText());
            autoControl.getTipos1().setEstado_auto(cbxEstado.getSelectedItem().toString());
            autoControl.getTipos1().setEstado_pago(cbxPago.getSelectedItem().toString());
            autoControl.getTipos1().setColor(txtColor.getText());
            autoControl.getTipos1().setPrecio(txtPrecio.getText());
            autoControl.getTipos1().setId_auto(UtilVista.ObtenerCasaControladorL(cbxTipoAuto));
            autoControl.getTipos1().setVendedor(UtilVista1.obtenerRolControl(cbxVendedores));
            if (autoControl.persist()) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                autoControl.setTipos1(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos  ");

        }
    }

    private void cargarVista() {
        int fila = tblMostrar.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registtro de la tabla");
        } else {
            try {
                autoControl.setTipos1(mtp.getTipos().getInfo(fila));
                txtColor.setText(autoControl.getTipos1().getColor());
                txtMarca.setText(autoControl.getTipos1().getMarca());
                cbxTipoAuto.setSelectedIndex(autoControl.getTipos().getId_auto() - 1);

            } catch (Exception e) {
            }

        }
    }
     private void ordenar(){
        String criterio = cbxCriterio.getSelectedItem().toString().toLowerCase();
        Integer tipo=0;
        if (cbxOrden.isSelected()) {
            tipo = 1;
        } 
        try {
            mtp.setTipos(autoControl.ordenarQuickSort(autoControl.all(), tipo, criterio));
             tblMostrar.setModel(mtp);
            tblMostrar.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    private void buscar(){
        String texto = txtBuscar.getText();
        String criterio= cbxCriterio1.getSelectedItem().toString();
        if(cbxBuscar.getSelectedItem().toString()=="Busqueda_Binaria"){
        try {
            System.out.println("Busqueda_Binaria");
            mtp.setTipos(autoControl.all());
            mtp.setTipos(autoControl.busquedaBinaria(texto, mtp.getTipos(), criterio));
            tblMostrar.setModel(mtp);
            tblMostrar.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } else if(cbxBuscar.getSelectedItem().toString()=="Busqueda_Lineal_Binaria"){
           try {
            System.out.println("Busqueda_Lineal_Binaria");
            mtp.setTipos(autoControl.all());
            mtp.setTipos(autoControl.busquedaBinariaLineal(texto, mtp.getTipos(), criterio));
            tblMostrar.setModel(mtp);
            tblMostrar.updateUI();
        } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }     
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoAuto = new javax.swing.JComboBox<>();
        txtColor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnCorregir = new javax.swing.JButton();
        cbxVendedores = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxPago = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        cbxOrden = new javax.swing.JCheckBox();
        cbxCriterio = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnOrdenar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbxCriterio1 = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxBuscar = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("VENTA DE AUTOS ");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Color:");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Estado Auto:");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hipotecada", "Endeuda", "Libre", " " }));
        cbxEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstadoItemStateChanged(evt);
            }
        });
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Tipo Auto:");

        cbxTipoAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoAutoActionPerformed(evt);
            }
        });

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(tblMostrar);

        btnAgregar.setText("AGREGAR VENTA AUTO");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("GUARDAR CAMBIOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Marca:");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        btnCorregir.setText("SELECCIONAR DATO");
        btnCorregir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorregirActionPerformed(evt);
            }
        });

        cbxVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVendedoresActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Vendedores:");

        cbxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pagado", "Cancelado", "En Proceso" }));

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Estado de pago:");

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Precio:");

        cbxOrden.setText("Descendente");

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "estado_pago", "estado_casa", "vendedor", "color", "marca", "precio", " ", " " }));

        jLabel9.setText("Criterio:");

        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar:");

        cbxCriterio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "estado_pago", "estado_casa", "vendedor", "color", "marca", "precio", " ", " " }));

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busqueda_Binaria", "Busqueda_Lineal_Binaria", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(154, 154, 154))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(btnCorregir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(cbxOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btnOrdenar)
                                        .addGap(156, 156, 156))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxCriterio1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBuscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtColor)
                                    .addComponent(cbxTipoAuto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMarca)
                                    .addComponent(cbxVendedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPrecio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtras)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxTipoAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnCorregir)
                            .addComponent(btnModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxOrden)
                            .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btnOrdenar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbxCriterio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstadoItemStateChanged

    }//GEN-LAST:event_cbxEstadoItemStateChanged

    private void cbxTipoAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoAutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoAutoActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Guardar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (Validar()) {
//            String textoPrecio = txtPrecio.getText();
//            float precio = Float.parseFloat(textoPrecio);
            autoControl.getTipos1().setMarca(txtMarca.getText());
            autoControl.getTipos1().setEstado_auto(cbxEstado.getSelectedItem().toString());
            autoControl.getTipos1().setEstado_pago(cbxPago.getSelectedItem().toString());
            autoControl.getTipos1().setColor(txtColor.getText());
             autoControl.getTipos1().setPrecio(txtPrecio.getText());
            autoControl.getTipos1().setId_auto(UtilVista.ObtenerCasaControladorL(cbxTipoAuto));
            autoControl.getTipos1().setVendedor(UtilVista1.obtenerRolControl(cbxVendedores));
            if (autoControl.merge(autoControl.getTipos1(), tblMostrar.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Datos guardados con exito");
                autoControl.setTipos1(null);
                CargarTabla();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos ");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed

    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnCorregirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorregirActionPerformed

        int filaSeleccionada = tblMostrar.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String marca= mtp.getValueAt(filaSeleccionada, 0).toString();
            String modelo = mtp.getValueAt(filaSeleccionada, 1).toString();
            String color = mtp.getValueAt(filaSeleccionada, 2).toString();
            String estadoAuto= mtp.getValueAt(filaSeleccionada, 3).toString();
            String  estadoPago= mtp.getValueAt(filaSeleccionada, 4).toString();
            String precio= mtp.getValueAt(filaSeleccionada, 5).toString();
            String vendedor = mtp.getValueAt(filaSeleccionada, 6).toString();
            txtPrecio.setText(precio);
            txtMarca.setText(marca);
            cbxTipoAuto.setSelectedItem(modelo);
            txtColor.setText(color);
            cbxEstado.setSelectedItem(estadoAuto);
            cbxVendedores.setSelectedItem(vendedor);
            cbxPago.setSelectedItem(estadoPago);
        
           
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCorregirActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Menu menuPrincipal = new Menu();
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void cbxVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxVendedoresActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentaAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentaAuto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCorregir;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JComboBox<String> cbxBuscar;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxCriterio1;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JCheckBox cbxOrden;
    private javax.swing.JComboBox<String> cbxPago;
    private javax.swing.JComboBox<String> cbxTipoAuto;
    private javax.swing.JComboBox<String> cbxVendedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
