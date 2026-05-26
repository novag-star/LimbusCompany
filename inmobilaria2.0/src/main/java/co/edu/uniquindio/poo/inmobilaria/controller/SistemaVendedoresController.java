package co.edu.uniquindio.poo.inmobilaria.controller;

import co.edu.uniquindio.poo.inmobilaria.model.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;

public class SistemaVendedoresController {

    private Inmobilaria inmobiliaria;
    private Vendedor vendedorLogueado;

    @FXML private Button btnCerrarSesionW4, btnCerrarSesionPW4;


    @FXML private TextField txtCodigoNiW4, txtCiudadNiW4, txtDireccionNiW4, txtAreaNiW4, txtPrecioNiW4;
    @FXML private ComboBox<TipoInmueble> cbTipoInmuebleNiW4;

    @FXML private Label labNivelPuntosW4;
    @FXML private TextField txtNombrePW4, txtTelefonoPW4;

    @FXML private TableView<Inmueble> TablaMiW4;
    @FXML private TableColumn<Inmueble, String> ColCodigoMiW4;
    @FXML private TableColumn<Inmueble, TipoInmueble> ColTipoMiW4;
    @FXML private TableColumn<Inmueble, String> ColCiudadMiW4;
    @FXML private TableColumn<Inmueble, Double> ColPrecioActualMiW4;
    @FXML private TableColumn<Inmueble, String> ColDireccionMiW4;
    @FXML private TableColumn<Inmueble, Estado> ColEstadoMiW4;

    @FXML private TableView<Oferta> TablaOfertasRoW4;
    @FXML private TableColumn<Oferta, String> ColCodigoInmuebleRoW4;
    @FXML private TableColumn<Oferta, TipoInmueble> ColTipoInmuebleRoW4;
    @FXML private TableColumn<Oferta, String> ColCompradorRoW4;
    @FXML private TableColumn<Oferta, Double> ColPrecioOriginalRoW4;
    @FXML private TableColumn<Oferta, Double> ColPrecioOfertaRoW4;
    @FXML private TableColumn<Oferta, EstadoOferta> ColEstadoRoW4;

    @FXML private TableView<Inmueble> tablaInmueblesRIMM;
    @FXML private TableColumn<Inmueble, TipoInmueble> ColTipoInmuebleRIMM;
    @FXML private TableColumn<Inmueble, String> ColCiudadRIMM;

    @FXML private TableView<String> tablaCiudadesRCcMD;
    @FXML private TableColumn<String, String> ColNombreCiudadRCcMD;

    @FXML private TableView<Usuario> tablaCompradoresRcma;
    @FXML private TableColumn<Usuario, Integer> ColPuntosRcma;
    @FXML private TableColumn<Usuario, String> ColNombreRcma;
    @FXML private TableColumn<Usuario, String> ColTelefonoRcma;
    @FXML private TableColumn<Usuario, String> ColCorreoRcma;

    @FXML private TableView<Vendedor> tablaVendedoresRvcmp;
    @FXML private TableColumn<Vendedor, Integer> ColNumeroPropiedadesRvcmp;
    @FXML private TableColumn<Vendedor, String> ColNombreRvcmp;
    @FXML private TableColumn<Vendedor, String> ColTelefonoRvcmp;


    @FXML
    void initialize() {

        ColCodigoMiW4.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        ColTipoMiW4.setCellValueFactory(new PropertyValueFactory<>("tipoInmueble"));
        ColCiudadMiW4.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        ColPrecioActualMiW4.setCellValueFactory(new PropertyValueFactory<>("precio"));
        ColDireccionMiW4.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        ColEstadoMiW4.setCellValueFactory(new PropertyValueFactory<>("estado"));
        cbTipoInmuebleNiW4.setItems(FXCollections.observableArrayList(TipoInmueble.values()));


        ColCodigoInmuebleRoW4.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getInmueble().getCodigo()));
        ColTipoInmuebleRoW4.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getInmueble().getTipoInmueble()));
        ColCompradorRoW4.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getComprador().getNombre()));
        ColPrecioOriginalRoW4.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getInmueble().getPrecio()));
        ColPrecioOfertaRoW4.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getValoroferta()));
        ColEstadoRoW4.setCellValueFactory(cell -> new SimpleObjectProperty<>(cell.getValue().getEstado()));


        ColTipoInmuebleRIMM.setCellValueFactory(new PropertyValueFactory<>("tipoInmueble"));
        ColCiudadRIMM.setCellValueFactory(new PropertyValueFactory<>("ciudad"));

        ColNombreCiudadRCcMD.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue())); // Especial para listas de String

        ColPuntosRcma.setCellValueFactory(new PropertyValueFactory<>("puntoreputacion"));
        ColNombreRcma.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ColTelefonoRcma.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        ColCorreoRcma.setCellValueFactory(new PropertyValueFactory<>("correo"));

        ColNumeroPropiedadesRvcmp.setCellValueFactory(new PropertyValueFactory<>("cantidadpropiedad"));
        ColNombreRvcmp.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ColTelefonoRvcmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }


    public void setInmobiliariaYVendedor(Inmobilaria inmobiliaria, Vendedor vendedor) {
        this.inmobiliaria = inmobiliaria;
        this.vendedorLogueado = vendedor;

        actualizarDatos();
    }

    private void actualizarDatos() {
        if (vendedorLogueado != null) {
            txtNombrePW4.setText(vendedorLogueado.getNombre());
            txtTelefonoPW4.setText(vendedorLogueado.getTelefono());
            labNivelPuntosW4.setText("Puntos: " + vendedorLogueado.getPuntoreputacion());

            TablaMiW4.setItems(FXCollections.observableArrayList(vendedorLogueado.getListainmueble()));


            if(tablaInmueblesRIMM != null) tablaInmueblesRIMM.setItems(FXCollections.observableArrayList(inmobiliaria.reporteInmueblesMasVendidos()));
            if(tablaCiudadesRCcMD != null) tablaCiudadesRCcMD.setItems(FXCollections.observableArrayList(inmobiliaria.reporteCiudadesMayorDemanda()));
            if(tablaCompradoresRcma != null) tablaCompradoresRcma.setItems(FXCollections.observableArrayList(inmobiliaria.reporteCompradoresActivos()));
            if(tablaVendedoresRvcmp != null) tablaVendedoresRvcmp.setItems(FXCollections.observableArrayList(inmobiliaria.reporteVendedoresConMasPropiedades()));
        }
    }


    @FXML
    void ActionAceptarOfertaRoW4(ActionEvent event) {
        Oferta seleccionada = TablaOfertasRoW4.getSelectionModel().getSelectedItem();
        if (seleccionada != null && seleccionada.getEstado() == EstadoOferta.PENDIENTE) {
            seleccionada.aceptaroferta();
            seleccionada.getInmueble().setEstado(Estado.VENDIDO);
            actualizarDatos();
            mostrarMensaje("Éxito", "Oferta ACEPTADA.");
        } else {
            mostrarMensaje("Advertencia", "Seleccione una oferta PENDIENTE.");
        }
    }

    @FXML
    void ActionRechazarOfertaRoW4(ActionEvent event) {
        Oferta seleccionada = TablaOfertasRoW4.getSelectionModel().getSelectedItem();
        if (seleccionada != null && seleccionada.getEstado() == EstadoOferta.PENDIENTE) {
            seleccionada.rechazaroferta();
            TablaOfertasRoW4.refresh();
            mostrarMensaje("Información", "Oferta RECHAZADA.");
        }
    }


    @FXML
    void ActionPublicarInmuebleNiW4(ActionEvent event) {
        try {
            String codigo = txtCodigoNiW4.getText().trim();
            TipoInmueble tipo = cbTipoInmuebleNiW4.getValue();
            String ciudad = txtCiudadNiW4.getText().trim();
            String direccion = txtDireccionNiW4.getText().trim();
            String area = txtAreaNiW4.getText().trim();

            if(txtPrecioNiW4.getText().isEmpty()) { mostrarMensaje("Error", "Ingrese un precio."); return; }
            double precio = Double.parseDouble(txtPrecioNiW4.getText());

            if(codigo.isEmpty() || tipo == null || ciudad.isEmpty() || direccion.isEmpty() || area.isEmpty()) {
                mostrarMensaje("Error", "Todos los campos obligatorios."); return;
            }

            Inmueble nuevoInmueble = new Inmueble(codigo, tipo, direccion, ciudad, area, precio, vendedorLogueado);
            if (inmobiliaria.agregarinmueble(nuevoInmueble)) {
                vendedorLogueado.registrarinmueble(nuevoInmueble);
                actualizarDatos();
                ActionLimpiarDatosNiW4(null);
                mostrarMensaje("Éxito", "Inmueble publicado. ¡Ganaste +10 de reputación!");
            } else {
                mostrarMensaje("Error", "Ya existe un inmueble con ese código.");
            }
        } catch (NumberFormatException e) { mostrarMensaje("Error", "Precio inválido."); }
    }

    @FXML
    void ActionLimpiarDatosNiW4(ActionEvent event) {
        txtCodigoNiW4.clear(); cbTipoInmuebleNiW4.getSelectionModel().clearSelection();
        txtCiudadNiW4.clear(); txtDireccionNiW4.clear(); txtAreaNiW4.clear(); txtPrecioNiW4.clear();
    }


    @FXML void ActionCerrarSesionW4(ActionEvent event) { cerrarVentana(event); }
    @FXML void ActionCerrarSesionPW4(ActionEvent event) { cerrarVentana(event); }
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @FXML void ActionCambiarPrecioMiW4(ActionEvent event) {}
    @FXML void ActionEliminarInmuebleMiW4(ActionEvent event) {}
    @FXML void ActionCambiarNombrePW4(ActionEvent event) {}
    @FXML void ActionCambiarTelefonoPW4(ActionEvent event) {}

    @FXML void MouseClickedMiW4(MouseEvent event) {}
    @FXML void MouseclickedTablaOfertasRoW4(MouseEvent event) {}
    @FXML void KeyTypedCodigoNiW4(KeyEvent event) {}
    @FXML void KeyTypedCiudadNiW4(KeyEvent event) {}
    @FXML void KeyTipedDireccionNiW4(KeyEvent event) {}
    @FXML void KeyTipedAreaNiW4(KeyEvent event) {}
    @FXML void KeyTipedPrecioNiW4(KeyEvent event) {}
    @FXML void KeyTypedNombrePW4(KeyEvent event) {}
    @FXML void KeyTypedTelefonoPW4(KeyEvent event) {}

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}