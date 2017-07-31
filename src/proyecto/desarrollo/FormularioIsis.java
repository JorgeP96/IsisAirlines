package proyecto.desarrollo;

import proyecto.desarrollo.modelo.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class FormularioIsis extends javax.swing.JFrame {
    public ArrayList<Avion> Aviones;
    public ArrayList<Vuelo> Vuelos;
    public ArrayList<Pasajero> Pasajeros;

    public FormularioIsis(){
        initComponents();
        mostrarAviones();
        mostrarVuelos();
        mostrarPasajeros();
        mostrarAvion();
        mostrarClase();
        mostrarVuelo();
    }
    
    
    
    //Métodos para mostrar datos de todas las tablas y combobox
    public void mostrarAviones(){
        try{
            //Eliminamos todos los Items del ComboBox
            comboBoxAvionBuscarId.removeAllItems();
            
            //Obtenemos todos los aviones con sus datos y los guardamos en el array aviones
            Aviones = DAOAvion.obtenerTodo(); 
            
            //Obtenemos el modelo para la tabla que mostrara los almacenes con sus datos
            DefaultTableModel mostrarAviones = (DefaultTableModel)tblAvionBuscarTodos.getModel();
            
            //Insertamos el numero de filas de acuerdo al tamaño del array almacenes
            mostrarAviones.setNumRows(Aviones.size());
            
            //Declaramos variable para movernos por la tabla e insertar los datos de los almacenes
            int i = 0;
            
            for(Avion avion:Aviones){
                //Agregamos el numero del almacen al ComboBox
                comboBoxAvionBuscarId.addItem(avion.getIdAvion());
                
                //Agregamos los datos del avión en sus respectivas columnas
                tblAvionBuscarTodos.setValueAt(avion.getIdAvion(), i, 0);
                tblAvionBuscarTodos.setValueAt(avion.getFabricante(), i, 1);
                tblAvionBuscarTodos.setValueAt(avion.getModelo(), i, 2);
                tblAvionBuscarTodos.setValueAt(avion.getCapacidad() + " personas", i, 3);
                tblAvionBuscarTodos.setValueAt(avion.getAutonomia() + " Hrs", i, 4);
                i++;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }
    }
    
    public void mostrarVuelos(){
        try{
            //Eliminamos todos los Items del ComboBox
            comboBoxVueloBuscarId.removeAllItems();

            //Obtenemos todos los vuelos con sus datos y los guardamos en el array vuelos
            Vuelos = DAOVuelo.obtenerTodo(); 
            
            //Obtenemos el modelo para la tabla que mostrara los vendedores con sus datos
            DefaultTableModel mostrarVuelos = (DefaultTableModel)tblVueloBuscarTodos.getModel();
            
            //Insertamos el numero de filas de acuerdo al tamaño del array vuelos
            mostrarVuelos.setNumRows(Aviones.size());
            
            //Declaramos variable para movernos por la tabla e insertar los datos de los vuelos
            int i = 0;
            
            for(Vuelo vuelo:Vuelos){
                //Agregamos el id de vuelo al ComboBox
                comboBoxVueloBuscarId.addItem(String.valueOf(vuelo.getId()));
                
                //Agregamos los datos de vuelo a la tabla para mostrarlos
                tblVueloBuscarTodos.setValueAt(vuelo.getId(), i, 0);
                tblVueloBuscarTodos.setValueAt(vuelo.getFecha(), i, 1);
                tblVueloBuscarTodos.setValueAt(vuelo.getOrigen(), i, 2);
                tblVueloBuscarTodos.setValueAt(vuelo.getDestino(), i, 3);
                tblVueloBuscarTodos.setValueAt(vuelo.getAvion(), i, 4);
                i++;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }
    }
    
    public void mostrarPasajeros(){
        try{
            //Eliminamos todos los Items del ComboBox
            comboBoxPasajeroBuscarId.removeAllItems();
            
            //Obtenemos todos los pasajeros con sus datos y los guardamos en el array pasajeros
            Pasajeros = DAOPasajero.obtenerTodo(); 
            
            //Obtenemos el modelo para la tabla que mostrara los pasajeros con sus datos
            DefaultTableModel mostrarPasajeros = (DefaultTableModel)tblClienteBuscarTodos.getModel();
            
            //Insertamos el numero de filas de acuerdo al tamaño del array clientes
            mostrarPasajeros.setNumRows(Pasajeros.size());
            
            //Declaramos variable para movernos por la tabla e insertar los datos de los clientes
            int i = 0;
            
            for(Pasajero pasajero:Pasajeros){
                //Agregamos el numero del pasajero al ComboBox
                comboBoxPasajeroBuscarId.addItem(String.valueOf(pasajero.getId()));
                
                //Agregamos el numero de cliente, numero de almacen y nombre del cliente en las columna 0, 1 y 2
                tblClienteBuscarTodos.setValueAt(pasajero.getId(), i, 0);
                tblClienteBuscarTodos.setValueAt(pasajero.getNombre(), i, 1);
                tblClienteBuscarTodos.setValueAt(pasajero.getAsiento(), i, 2);
                tblClienteBuscarTodos.setValueAt(pasajero.getClase(), i, 3);
                tblClienteBuscarTodos.setValueAt(pasajero.getVuelo(), i, 4);
                i++;
            }
        } catch (Exception e){
            //JOptionPane.showMessageDialog(null,"ErrorAqui es: " + e.getMessage() + "\nCausa: " + e.getCause());
        }
    }
    
    public void mostrarAvion(){
        try{
            //Eliminamos todos los Items del ComboBox
            comboBoxVueloAvion.removeAllItems();
            
            //Obtenemos todos los aviones con sus datos y los guardamos en el array aviones
            Aviones = DAOAvion.obtenerTodo();
            
            for(Avion avion:Aviones){
                //Agregamos el numero del almacen al ComboBox
                comboBoxVueloAvion.addItem(avion.getIdAvion());
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }
    }
    
    public void mostrarClase(){
        comboBoxPasajerosClase.removeAllItems();
        
        comboBoxPasajerosClase.addItem("Turista");
        comboBoxPasajerosClase.addItem("Primera");
        comboBoxPasajerosClase.addItem("Business");
    }
    
    public void mostrarVuelo(){
        try{
            //Eliminamos todos los Items del ComboBox
            comboBoxPasajerosVuelo.removeAllItems();

            //Obtenemos todos los vuelos con sus datos y los guardamos en el array vuelos
            Vuelos = DAOVuelo.obtenerTodo();
            
            for(Vuelo vuelo:Vuelos){
                //Agregamos el numero del vendedor al ComboBox
                comboBoxPasajerosVuelo.addItem(String.valueOf(vuelo.getId()));
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage() + "\nCausa: " + e.getCause());
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlAviones = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlAvionesGuardar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAvionId = new javax.swing.JTextField();
        txtAvionFabricante = new javax.swing.JTextField();
        btnAvionCancelar = new javax.swing.JButton();
        btnAvionAceptar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtAvionModelo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAvionCapacidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAvionAutonomia = new javax.swing.JTextField();
        pnlAvionesBuscarTodos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAvionBuscarTodos = new javax.swing.JTable();
        pnlAvionesBuscarID = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        comboBoxAvionBuscarId = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblAvionBuscarId = new javax.swing.JTable();
        pnlVuelos = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        pnlVuelosGuardar = new javax.swing.JPanel();
        btnVueloAceptar = new javax.swing.JButton();
        btnVueloancelar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtVueloId = new javax.swing.JTextField();
        txtVueloFecha = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtVueloOrigen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtVueloDestino = new javax.swing.JTextField();
        comboBoxVueloAvion = new javax.swing.JComboBox<>();
        pnlVuelosBuscarTodos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVueloBuscarTodos = new javax.swing.JTable();
        pnlVuelosBuscarID = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblVueloBuscarId = new javax.swing.JTable();
        comboBoxVueloBuscarId = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        pnlPasajeros = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        pnlPasajerosGuardar = new javax.swing.JPanel();
        btnPasajeroAceptar = new javax.swing.JButton();
        btnPasajeroCancelar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPasajeroId = new javax.swing.JTextField();
        txtPasajeroNombre = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPasajeroAsiento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        comboBoxPasajerosClase = new javax.swing.JComboBox<>();
        comboBoxPasajerosVuelo = new javax.swing.JComboBox<>();
        pnlPasajerosBuscarTodos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblClienteBuscarTodos = new javax.swing.JTable();
        pnlPasajerosBuscarID = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        comboBoxPasajeroBuscarId = new javax.swing.JComboBox<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblPasajeroBuscarId = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Isis Airlines");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Administración");

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel1.setText("Id:");

        jLabel2.setText("Fabricante:");

        txtAvionId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        btnAvionCancelar.setText("Cancelar");
        btnAvionCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvionCancelarActionPerformed(evt);
            }
        });

        btnAvionAceptar.setText("Aceptar");
        btnAvionAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvionAceptarActionPerformed(evt);
            }
        });

        jLabel9.setText("Modelo:");

        jLabel10.setText("Capacidad:");

        jLabel11.setText("Autonomía:");

        javax.swing.GroupLayout pnlAvionesGuardarLayout = new javax.swing.GroupLayout(pnlAvionesGuardar);
        pnlAvionesGuardar.setLayout(pnlAvionesGuardarLayout);
        pnlAvionesGuardarLayout.setHorizontalGroup(
            pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvionesGuardarLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAvionesGuardarLayout.createSequentialGroup()
                        .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAvionCapacidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAvionModelo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAvionFabricante, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAvionId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAvionAutonomia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlAvionesGuardarLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAvionAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAvionCancelar)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        pnlAvionesGuardarLayout.setVerticalGroup(
            pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvionesGuardarLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvionFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvionModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvionCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvionAutonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlAvionesGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvionCancelar)
                    .addComponent(btnAvionAceptar))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Guardar", pnlAvionesGuardar);

        tblAvionBuscarTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Avión", "Fabricante", "Modelo", "Capacidad", "Autonomía"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAvionBuscarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAvionBuscarTodos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblAvionBuscarTodos);

        javax.swing.GroupLayout pnlAvionesBuscarTodosLayout = new javax.swing.GroupLayout(pnlAvionesBuscarTodos);
        pnlAvionesBuscarTodos.setLayout(pnlAvionesBuscarTodosLayout);
        pnlAvionesBuscarTodosLayout.setHorizontalGroup(
            pnlAvionesBuscarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        pnlAvionesBuscarTodosLayout.setVerticalGroup(
            pnlAvionesBuscarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Buscar Todos", pnlAvionesBuscarTodos);

        jLabel20.setText("ID:");

        comboBoxAvionBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAvionBuscarIdActionPerformed(evt);
            }
        });

        tblAvionBuscarId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Fabricante", "Modelo", "Capacidad", "Autonomía"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAvionBuscarId.setEnabled(false);
        tblAvionBuscarId.setShowHorizontalLines(false);
        tblAvionBuscarId.setShowVerticalLines(false);
        jScrollPane13.setViewportView(tblAvionBuscarId);

        javax.swing.GroupLayout pnlAvionesBuscarIDLayout = new javax.swing.GroupLayout(pnlAvionesBuscarID);
        pnlAvionesBuscarID.setLayout(pnlAvionesBuscarIDLayout);
        pnlAvionesBuscarIDLayout.setHorizontalGroup(
            pnlAvionesBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvionesBuscarIDLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(comboBoxAvionBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAvionesBuscarIDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlAvionesBuscarIDLayout.setVerticalGroup(
            pnlAvionesBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvionesBuscarIDLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlAvionesBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(comboBoxAvionBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Buscar por ID", pnlAvionesBuscarID);

        javax.swing.GroupLayout pnlAvionesLayout = new javax.swing.GroupLayout(pnlAviones);
        pnlAviones.setLayout(pnlAvionesLayout);
        pnlAvionesLayout.setHorizontalGroup(
            pnlAvionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        pnlAvionesLayout.setVerticalGroup(
            pnlAvionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("Aviones", pnlAviones);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btnVueloAceptar.setText("Aceptar");
        btnVueloAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueloAceptarActionPerformed(evt);
            }
        });

        btnVueloancelar.setText("Cancelar");
        btnVueloancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueloancelarActionPerformed(evt);
            }
        });

        jLabel12.setText("Avión:");

        jLabel13.setText("Id:");

        jLabel14.setText("Fecha:");

        txtVueloId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel15.setText("Origen:");

        jLabel16.setText("Destino:");

        comboBoxVueloAvion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxVueloAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVueloAvionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlVuelosGuardarLayout = new javax.swing.GroupLayout(pnlVuelosGuardar);
        pnlVuelosGuardar.setLayout(pnlVuelosGuardarLayout);
        pnlVuelosGuardarLayout.setHorizontalGroup(
            pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVuelosGuardarLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVuelosGuardarLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnVueloAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVueloancelar))
                    .addGroup(pnlVuelosGuardarLayout.createSequentialGroup()
                        .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtVueloDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtVueloOrigen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVueloFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVueloId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxVueloAvion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        pnlVuelosGuardarLayout.setVerticalGroup(
            pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVuelosGuardarLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVueloId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVueloFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVueloOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVueloDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxVueloAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlVuelosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVueloAceptar)
                    .addComponent(btnVueloancelar))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Guardar", pnlVuelosGuardar);

        tblVueloBuscarTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vuelo", "Fecha", "Origen", "Destino", "Avión"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblVueloBuscarTodos);

        javax.swing.GroupLayout pnlVuelosBuscarTodosLayout = new javax.swing.GroupLayout(pnlVuelosBuscarTodos);
        pnlVuelosBuscarTodos.setLayout(pnlVuelosBuscarTodosLayout);
        pnlVuelosBuscarTodosLayout.setHorizontalGroup(
            pnlVuelosBuscarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
        pnlVuelosBuscarTodosLayout.setVerticalGroup(
            pnlVuelosBuscarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Buscar Todos", pnlVuelosBuscarTodos);

        tblVueloBuscarId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Origen", "Destino", "Avión"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVueloBuscarId.setEnabled(false);
        tblVueloBuscarId.setShowHorizontalLines(false);
        tblVueloBuscarId.setShowVerticalLines(false);
        jScrollPane15.setViewportView(tblVueloBuscarId);

        comboBoxVueloBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVueloBuscarIdActionPerformed(evt);
            }
        });

        jLabel21.setText("ID:");

        javax.swing.GroupLayout pnlVuelosBuscarIDLayout = new javax.swing.GroupLayout(pnlVuelosBuscarID);
        pnlVuelosBuscarID.setLayout(pnlVuelosBuscarIDLayout);
        pnlVuelosBuscarIDLayout.setHorizontalGroup(
            pnlVuelosBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVuelosBuscarIDLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(comboBoxVueloBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlVuelosBuscarIDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlVuelosBuscarIDLayout.setVerticalGroup(
            pnlVuelosBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVuelosBuscarIDLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(pnlVuelosBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(comboBoxVueloBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Buscar por ID", pnlVuelosBuscarID);

        javax.swing.GroupLayout pnlVuelosLayout = new javax.swing.GroupLayout(pnlVuelos);
        pnlVuelos.setLayout(pnlVuelosLayout);
        pnlVuelosLayout.setHorizontalGroup(
            pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        pnlVuelosLayout.setVerticalGroup(
            pnlVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("Vuelos", pnlVuelos);

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btnPasajeroAceptar.setText("Aceptar");
        btnPasajeroAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasajeroAceptarActionPerformed(evt);
            }
        });

        btnPasajeroCancelar.setText("Cancelar");
        btnPasajeroCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasajeroCancelarActionPerformed(evt);
            }
        });

        jLabel17.setText("Vuelo:");

        jLabel3.setText("Id:");

        jLabel4.setText("Nombre:");

        txtPasajeroId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel18.setText("Asiento:");

        jLabel19.setText("Clase:");

        comboBoxPasajerosClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboBoxPasajerosVuelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlPasajerosGuardarLayout = new javax.swing.GroupLayout(pnlPasajerosGuardar);
        pnlPasajerosGuardar.setLayout(pnlPasajerosGuardarLayout);
        pnlPasajerosGuardarLayout.setHorizontalGroup(
            pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasajerosGuardarLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPasajerosGuardarLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnPasajeroAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPasajeroCancelar))
                    .addGroup(pnlPasajerosGuardarLayout.createSequentialGroup()
                        .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPasajeroAsiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtPasajeroNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPasajeroId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxPasajerosClase, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxPasajerosVuelo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        pnlPasajerosGuardarLayout.setVerticalGroup(
            pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasajerosGuardarLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasajeroId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasajeroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasajeroAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPasajerosClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPasajerosVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPasajerosGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPasajeroAceptar)
                    .addComponent(btnPasajeroCancelar))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Guardar", pnlPasajerosGuardar);

        tblClienteBuscarTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pasajero", "Nombre", "Asiento", "Clase", "Vuelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClienteBuscarTodos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblClienteBuscarTodos);

        javax.swing.GroupLayout pnlPasajerosBuscarTodosLayout = new javax.swing.GroupLayout(pnlPasajerosBuscarTodos);
        pnlPasajerosBuscarTodos.setLayout(pnlPasajerosBuscarTodosLayout);
        pnlPasajerosBuscarTodosLayout.setHorizontalGroup(
            pnlPasajerosBuscarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        pnlPasajerosBuscarTodosLayout.setVerticalGroup(
            pnlPasajerosBuscarTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Buscar Todos", pnlPasajerosBuscarTodos);

        jLabel22.setText("ID:");

        comboBoxPasajeroBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPasajeroBuscarIdActionPerformed(evt);
            }
        });

        tblPasajeroBuscarId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Asiento", "Clase", "Vuelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPasajeroBuscarId.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPasajeroBuscarId.setEnabled(false);
        tblPasajeroBuscarId.setShowHorizontalLines(false);
        tblPasajeroBuscarId.setShowVerticalLines(false);
        jScrollPane16.setViewportView(tblPasajeroBuscarId);

        javax.swing.GroupLayout pnlPasajerosBuscarIDLayout = new javax.swing.GroupLayout(pnlPasajerosBuscarID);
        pnlPasajerosBuscarID.setLayout(pnlPasajerosBuscarIDLayout);
        pnlPasajerosBuscarIDLayout.setHorizontalGroup(
            pnlPasajerosBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasajerosBuscarIDLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(comboBoxPasajeroBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPasajerosBuscarIDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPasajerosBuscarIDLayout.setVerticalGroup(
            pnlPasajerosBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPasajerosBuscarIDLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(pnlPasajerosBuscarIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(comboBoxPasajeroBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Buscar por ID", pnlPasajerosBuscarID);

        javax.swing.GroupLayout pnlPasajerosLayout = new javax.swing.GroupLayout(pnlPasajeros);
        pnlPasajeros.setLayout(pnlPasajerosLayout);
        pnlPasajerosLayout.setHorizontalGroup(
            pnlPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        pnlPasajerosLayout.setVerticalGroup(
            pnlPasajerosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("Pasajeros", pnlPasajeros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //Eventos de botones y combobox
    private void comboBoxPasajeroBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPasajeroBuscarIdActionPerformed
        //Si el combobox no está vacío entonces...
        if(comboBoxPasajeroBuscarId.getItemCount() > 0){
            //Recupera el indice y muestra el valor correspondiente en la tabla para eliminarlo
            tblPasajeroBuscarId.setValueAt(Pasajeros.get(comboBoxPasajeroBuscarId.getSelectedIndex()).getNombre(), 0, 0);
            tblPasajeroBuscarId.setValueAt(Pasajeros.get(comboBoxPasajeroBuscarId.getSelectedIndex()).getAsiento(), 0, 1);
            tblPasajeroBuscarId.setValueAt(Pasajeros.get(comboBoxPasajeroBuscarId.getSelectedIndex()).getClase(), 0, 2);
            tblPasajeroBuscarId.setValueAt(Pasajeros.get(comboBoxPasajeroBuscarId.getSelectedIndex()).getVuelo(), 0, 3);

        }
    }//GEN-LAST:event_comboBoxPasajeroBuscarIdActionPerformed

    private void btnPasajeroCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasajeroCancelarActionPerformed
        //Limpiamos los textField para el nuevo ingreso de datos
        txtPasajeroId.setText("");
        txtPasajeroNombre.setText("");
        txtPasajeroAsiento.setText("");
        mostrarVuelo();
        mostrarClase();
    }//GEN-LAST:event_btnPasajeroCancelarActionPerformed

    private void btnPasajeroAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasajeroAceptarActionPerformed
        
        try {
            //Recuperamos los valores de los textFields y los guardamos en las variables correspondientes
            String id = txtPasajeroId.getText();
            String nombre = txtPasajeroNombre.getText();
            String asiento = txtPasajeroAsiento.getText();
            String clase = comboBoxPasajerosClase.getSelectedItem().toString();
            String vuelo = comboBoxPasajerosVuelo.getSelectedItem().toString();

            //Creamos nuevo objeto de pasajero con parametros
            Pasajero pasajero = new Pasajero(id, nombre, asiento, clase, vuelo);

            //Invocamos el método estático guardar y le pasamos el objeto pasajero
            DAOPasajero.guardar(pasajero);

            //Ejecutamos el método para mostrar datos en la tabla y el combobox
            mostrarPasajeros();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally{
            //Limpiamos los textField para el nuevo ingreso de datos
            txtPasajeroId.setText("");
            txtPasajeroNombre.setText("");
            txtPasajeroAsiento.setText("");
            mostrarVuelo();
            mostrarClase();
        }
    }//GEN-LAST:event_btnPasajeroAceptarActionPerformed

    private void comboBoxVueloBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVueloBuscarIdActionPerformed
        //Si el combobox no está vacío entonces...
        if(comboBoxVueloBuscarId.getItemCount() > 0){
            //Recupera el indice y muestra el valor correspondiente en la tabla para eliminarlo
            tblVueloBuscarId.setValueAt(Vuelos.get(comboBoxVueloBuscarId.getSelectedIndex()).getFecha(), 0, 0);
            tblVueloBuscarId.setValueAt(Vuelos.get(comboBoxVueloBuscarId.getSelectedIndex()).getOrigen(), 0, 1);
            tblVueloBuscarId.setValueAt(Vuelos.get(comboBoxVueloBuscarId.getSelectedIndex()).getDestino(), 0, 2);
            tblVueloBuscarId.setValueAt(Vuelos.get(comboBoxVueloBuscarId.getSelectedIndex()).getAvion(), 0, 3);
        }
    }//GEN-LAST:event_comboBoxVueloBuscarIdActionPerformed

    private void comboBoxAvionBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAvionBuscarIdActionPerformed
        //Si el combobox no está vacío entonces...
        if(comboBoxAvionBuscarId.getItemCount() > 0){
            //Recupera el indice y muestra el valor correspondiente en la tabla para mostrar
            tblAvionBuscarId.setValueAt(Aviones.get(comboBoxAvionBuscarId.getSelectedIndex()).getFabricante(), 0, 0);
            tblAvionBuscarId.setValueAt(Aviones.get(comboBoxAvionBuscarId.getSelectedIndex()).getModelo(), 0, 1);
            tblAvionBuscarId.setValueAt(Aviones.get(comboBoxAvionBuscarId.getSelectedIndex()).getCapacidad() + " personas", 0, 2);
            tblAvionBuscarId.setValueAt(Aviones.get(comboBoxAvionBuscarId.getSelectedIndex()).getAutonomia() + "Hrs", 0, 3);
        }
    }//GEN-LAST:event_comboBoxAvionBuscarIdActionPerformed

    private void btnAvionAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvionAceptarActionPerformed

        try{
            //Recuperamos el valor de los textFields y los guardamos en las variables correspondientes
            String idAvion = txtAvionId.getText();
            String fabricante = txtAvionFabricante.getText();
            String modelo = txtAvionModelo.getText();
            int capacidad = Integer.parseInt(txtAvionCapacidad.getText());
            int autonomia = Integer.parseInt(txtAvionAutonomia.getText());
        
            //Creamos nuevo objeto de avion con parametros
            Avion avion = new Avion(idAvion, fabricante, modelo, capacidad, autonomia);

            //Invocamos el método estático guardar y le pasamos el objeto avión
            DAOAvion.guardar(avion);

            //Ejecutamos el método para mostrar datos en la tabla y el combobox
            mostrarAviones();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally{
            //Limpiamos los textField para el nuevo ingreso de datos
            txtAvionId.setText("");
            txtAvionFabricante.setText("");
            txtAvionModelo.setText("");
            txtAvionCapacidad.setText("");
            txtAvionAutonomia.setText("");
            mostrarAvion();
        }
    }//GEN-LAST:event_btnAvionAceptarActionPerformed

    private void btnAvionCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvionCancelarActionPerformed
        //Limpiamos los textField para el nuevo ingreso de datos
        txtAvionId.setText("");
        txtAvionFabricante.setText("");
    }//GEN-LAST:event_btnAvionCancelarActionPerformed

    private void btnVueloancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueloancelarActionPerformed
        //Limpiamos los textField para el nuevo ingreso de datos
        txtVueloId.setText("");
        txtVueloFecha.setText("");
        txtVueloOrigen.setText("");
        txtVueloDestino.setText("");
        mostrarAvion();
    }//GEN-LAST:event_btnVueloancelarActionPerformed

    private void btnVueloAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueloAceptarActionPerformed
        
        try{
            //Recuperamos los valores de los textFields y los guardamos en las variables correspondientes
            String id = txtVueloId.getText();
            String fecha = txtVueloFecha.getText();
            String origen = txtVueloOrigen.getText();
            String destino = txtVueloDestino.getText();
            String avion = comboBoxVueloAvion.getSelectedItem().toString();
            
            //Creamos nuevo objeto de vuelo con parametros
            Vuelo vuelo = new Vuelo(id, fecha, origen, destino, avion);

            //Invocamos el método estático guardar y le pasamos el objeto vendedor
            DAOVuelo.guardar(vuelo);

            //Ejecutamos el método para mostrar datos en la tabla y el combobox
            mostrarVuelos();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } finally{
            //Limpiamos los textField para el nuevo ingreso de datos
            txtVueloId.setText("");
            txtVueloFecha.setText("");
            txtVueloOrigen.setText("");
            txtVueloDestino.setText("");
            mostrarAvion();
            mostrarVuelo();
        }
    }//GEN-LAST:event_btnVueloAceptarActionPerformed

    private void comboBoxVueloAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVueloAvionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxVueloAvionActionPerformed

    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvionAceptar;
    private javax.swing.JButton btnAvionCancelar;
    private javax.swing.JButton btnPasajeroAceptar;
    private javax.swing.JButton btnPasajeroCancelar;
    private javax.swing.JButton btnVueloAceptar;
    private javax.swing.JButton btnVueloancelar;
    private javax.swing.JComboBox<String> comboBoxAvionBuscarId;
    private javax.swing.JComboBox<String> comboBoxPasajeroBuscarId;
    private javax.swing.JComboBox<String> comboBoxPasajerosClase;
    private javax.swing.JComboBox<String> comboBoxPasajerosVuelo;
    private javax.swing.JComboBox<String> comboBoxVueloAvion;
    private javax.swing.JComboBox<String> comboBoxVueloBuscarId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlAviones;
    private javax.swing.JPanel pnlAvionesBuscarID;
    private javax.swing.JPanel pnlAvionesBuscarTodos;
    private javax.swing.JPanel pnlAvionesGuardar;
    private javax.swing.JPanel pnlPasajeros;
    private javax.swing.JPanel pnlPasajerosBuscarID;
    private javax.swing.JPanel pnlPasajerosBuscarTodos;
    private javax.swing.JPanel pnlPasajerosGuardar;
    private javax.swing.JPanel pnlVuelos;
    private javax.swing.JPanel pnlVuelosBuscarID;
    private javax.swing.JPanel pnlVuelosBuscarTodos;
    private javax.swing.JPanel pnlVuelosGuardar;
    private javax.swing.JTable tblAvionBuscarId;
    private javax.swing.JTable tblAvionBuscarTodos;
    private javax.swing.JTable tblClienteBuscarTodos;
    private javax.swing.JTable tblPasajeroBuscarId;
    private javax.swing.JTable tblVueloBuscarId;
    private javax.swing.JTable tblVueloBuscarTodos;
    private javax.swing.JTextField txtAvionAutonomia;
    private javax.swing.JTextField txtAvionCapacidad;
    private javax.swing.JTextField txtAvionFabricante;
    private javax.swing.JTextField txtAvionId;
    private javax.swing.JTextField txtAvionModelo;
    private javax.swing.JTextField txtPasajeroAsiento;
    private javax.swing.JTextField txtPasajeroId;
    private javax.swing.JTextField txtPasajeroNombre;
    private javax.swing.JTextField txtVueloDestino;
    private javax.swing.JTextField txtVueloFecha;
    private javax.swing.JTextField txtVueloId;
    private javax.swing.JTextField txtVueloOrigen;
    // End of variables declaration//GEN-END:variables
}
