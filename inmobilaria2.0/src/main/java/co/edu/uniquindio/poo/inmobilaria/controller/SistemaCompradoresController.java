package co.edu.uniquindio.poo.inmobilaria.controller;

import co.edu.uniquindio.poo.inmobilaria.model.*;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SistemaCompradoresController {

    private Inmobilaria inmobiliaria;
    private Comprador compradorLogueado;


    @FXML private Button btnCerrarSesionW3;
    @FXML private Button btnCerrarSesionMiW3;


    @FXML private TextField txtBIFiltrosCiudadW3;
    @FXML private ComboBox<TipoInmueble> cmbBIFiltrosTipoInmuebleW3;
    @FXML private TextField txtBIFiltrosAreaMinW3;
    @FXML private TextField txtBIFiltrosPrecioMinW3;
    @FXML private TextField txtBIFiltrosPrecioMaxW3;
    @FXML private Button btnBuscarW3, btnRealizarOfertaW3, btnComprarW3;

    @FXML private TableView<Inmueble> tbTablaInmueblesW3;
    @FXML private TableColumn<Inmueble, String> colCodigoW3;
    @FXML private TableColumn<Inmueble, TipoInmueble> colTipoW3;
    @FXML private TableColumn<Inmueble, String> colCiudadW3;
    @FXML private TableColumn<Inmueble, String> colDireccionW3;
    @FXML private TableColumn<Inmueble, String> colAreaW3;
    @FXML private TableColumn<Inmueble, Double> colPrecioW3;
    @FXML private TableColumn<Inmueble, Estado> colEstadoW3;

    private ObservableList<Inmueble> listaInmueblesBusqueda = FXCollections.observableArrayList();


    @FXML private TableView<Oferta> TablaMisOfertasW3;
    @FXML private TableColumn<Oferta, String> ColcodigoMisOfertasW3;
    @FXML private TableColumn<Oferta, TipoInmueble> ColTipoMisOfertasW3;
    @FXML private TableColumn<Oferta, String> ColCiudadMisOfertasW3;
    @FXML private TableColumn<Oferta, String> ColDireccionMisOfertasW3;
    @FXML private TableColumn<Oferta, String> ColAreaMisOfertasW3;
    @FXML private TableColumn<Oferta, LocalDateTime> ColFechaOfertaMisOfertasW3;
    @FXML private TableColumn<Oferta, EstadoOferta> ColEstadoMisOfertasW3;
    @FXML private TableColumn<Oferta, Double> ColValorOfertaMisOfertasW3;
    @FXML private Button btnConcretarMisOfertasW3, btnCancelarMisOfertasW3;

    private ObservableList<Oferta> listaMisOfertas = FXCollections.observableArrayList();


    @FXML private TableView<Transaccion> TablaMisComprasW3;
    @FXML private TableColumn<Transaccion, String> ColcodigoMisComprasW3;
    @FXML private TableColumn<Transaccion, TipoInmueble> ColTipoInmuebleMisComprasW3;
    @FXML private TableColumn<Transaccion, String> ColCiudadMisComprasW3;
    @FXML private TableColumn<Transaccion, String> ColVendedorMisComprasW3;
    @FXML private TableColumn<Transaccion, TipoOperacion> ColOperacionMisComprasW3;
    @FXML private TableColumn<Transaccion, LocalDateTime> ColFechaMisComprasW3;
    @FXML private TableColumn<Transaccion, Double> ColValorFinalMisComprasW3;

    private ObservableList<Transaccion> listaMisCompras = FXCollections.observableArrayList();


    @FXML private TableView<Inmueble> TablaInmueblesRecomW3;
    @FXML private TableColumn<Inmueble, String> ColIRCodigoW3;
    @FXML private TableColumn<Inmueble, TipoInmueble> ColIRTipoW3;
    @FXML private TableColumn<Inmueble, String> ColIRCiudadW3;
    @FXML private TableColumn<Inmueble, String> ColIRDireccionW3;
    @FXML private TableColumn<Inmueble, String> ColIRAreaW3;
    @FXML private TableColumn<Inmueble, Double> ColIRPrecioW3;
    @FXML private Button btnIRRealizarOfertaW3, btnIRComprarW3;

    private ObservableList<Inmueble> listaRecomendaciones = FXCollections.observableArrayList();


    @FXML private TableView<Alerta> TableBandejaAlertaW3;
    @FXML private TableColumn<Alerta, LocalDateTime> ColNAFechaW3;
    @FXML private TableColumn<Alerta, String> ColNAMotivoW3;
    @FXML private TableColumn<Alerta, String> ColNAMensajeW3;
    @FXML private Button btnEliminarAlertaW3;

    private ObservableList<Alerta> listaAlertas = FXCollections.observableArrayList();


    @FXML private TextField txtCambiarNombreMiW3;
    @FXML private TextField txtCambiarTelefonoMiW3;
    @FXML private Label labNivelPuntosW3;
    @FXML private Button btnCambiarNombreMiW3, btnCambiarTelefonoMiW3;
    @FXML private CheckBox checkBSmsW3, checkBCorreoW3, checkBWhattsapW3;

    @FXML
    void initialize() {

        colCodigoW3.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colTipoW3.setCellValueFactory(new PropertyValueFactory<>("tipoInmueble"));
        colCiudadW3.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colDireccionW3.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colAreaW3.setCellValueFactory(new PropertyValueFactory<>("area"));
        colPrecioW3.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colEstadoW3.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbTablaInmueblesW3.setItems(listaInmueblesBusqueda);
        cmbBIFiltrosTipoInmuebleW3.setItems(FXCollections.observableArrayList(TipoInmueble.values()));


        ColcodigoMisOfertasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getInmueble().getCodigo()));
        ColTipoMisOfertasW3.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getInmueble().getTipoInmueble()));
        ColCiudadMisOfertasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getInmueble().getCiudad()));
        ColDireccionMisOfertasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getInmueble().getDireccion()));
        ColAreaMisOfertasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getInmueble().getArea()));
        ColFechaOfertaMisOfertasW3.setCellValueFactory(new PropertyValueFactory<>("fechaoferta"));
        ColEstadoMisOfertasW3.setCellValueFactory(new PropertyValueFactory<>("estado"));
        ColValorOfertaMisOfertasW3.setCellValueFactory(new PropertyValueFactory<>("valoroferta"));
        TablaMisOfertasW3.setItems(listaMisOfertas);


        ColcodigoMisComprasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().codigotransaccion()));
        ColTipoInmuebleMisComprasW3.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().inmueble().getTipoInmueble()));
        ColCiudadMisComprasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().inmueble().getCiudad()));
        ColVendedorMisComprasW3.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().vendedor().getNombre()));
        ColOperacionMisComprasW3.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().tipooperacion()));
        ColFechaMisComprasW3.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().fechatransaccion()));
        ColValorFinalMisComprasW3.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().valorfinal()));
        TablaMisComprasW3.setItems(listaMisCompras);


        ColIRCodigoW3.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        ColIRTipoW3.setCellValueFactory(new PropertyValueFactory<>("tipoInmueble"));
        ColIRCiudadW3.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        ColIRDireccionW3.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        ColIRAreaW3.setCellValueFactory(new PropertyValueFactory<>("area"));
        ColIRPrecioW3.setCellValueFactory(new PropertyValueFactory<>("precio"));
        TablaInmueblesRecomW3.setItems(listaRecomendaciones);


        ColNAFechaW3.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        ColNAMotivoW3.setCellValueFactory(new PropertyValueFactory<>("motivo"));
        ColNAMensajeW3.setCellValueFactory(new PropertyValueFactory<>("mensaje"));
        TableBandejaAlertaW3.setItems(listaAlertas);
    }

    public void setInmobiliariaYComprador(Inmobilaria inmobiliaria, Comprador compradorLogueado) {
        this.inmobiliaria = inmobiliaria;
        this.compradorLogueado = compradorLogueado;
        cargarDatosGenerales();
    }

    private void cargarDatosGenerales() {
        if (compradorLogueado != null && inmobiliaria != null) {
            txtCambiarNombreMiW3.setText(compradorLogueado.getNombre());
            txtCambiarTelefonoMiW3.setText(compradorLogueado.getTelefono());
            actualizarPuntosPerfil();
            actualizarTablaBusqueda();
            actualizarTablaRecomendaciones();
            actualizarTablaCompras();
            actualizarTablaAlertas();
        }
    }

    private void actualizarPuntosPerfil() {
        labNivelPuntosW3.setText("Puntos: " + compradorLogueado.getPuntoreputacion());
    }

    private void actualizarTablaBusqueda() {
        if (inmobiliaria != null) {
            listaInmueblesBusqueda.clear();
            List<Inmueble> disponibles = inmobiliaria.getListainmueble().stream()
                    .filter(i -> i.getEstado() == Estado.DISPONIBLE)
                    .collect(Collectors.toList());
            listaInmueblesBusqueda.addAll(disponibles);
        }
    }

    private void actualizarTablaRecomendaciones() {
        if (inmobiliaria != null && compradorLogueado != null) {
            listaRecomendaciones.clear();
            String preferencia = compradorLogueado.getPreferenciabusqueda();
            if (preferencia != null && !preferencia.isEmpty()) {
                List<Inmueble> recomendados = inmobiliaria.getListainmueble().stream()
                        .filter(i -> i.getEstado() == Estado.DISPONIBLE)
                        .filter(i -> i.getTipoInmueble().name().equalsIgnoreCase(preferencia))
                        .collect(Collectors.toList());
                listaRecomendaciones.addAll(recomendados);
            }
        }
    }

    private void actualizarTablaCompras() {
        if (inmobiliaria != null && compradorLogueado != null) {
            listaMisCompras.clear();
            List<Transaccion> comprasUsuario = inmobiliaria.getListatransaccion().stream()
                    .filter(t -> t.comprador().getIdentificacion().equals(compradorLogueado.getIdentificacion()))
                    .collect(Collectors.toList());
            listaMisCompras.addAll(comprasUsuario);
        }
    }

    private void actualizarTablaAlertas() {
        if (compradorLogueado != null) {
            listaAlertas.clear();

        }
    }


    @FXML
    void ActionBuscarbtnW3(ActionEvent event) {
        if (inmobiliaria == null) return;
        String ciudadFiltro = txtBIFiltrosCiudadW3.getText().trim();
        TipoInmueble tipoFiltro = cmbBIFiltrosTipoInmuebleW3.getValue();
        String areaMinStr = txtBIFiltrosAreaMinW3.getText().trim();
        String precioMinStr = txtBIFiltrosPrecioMinW3.getText().trim();
        String precioMaxStr = txtBIFiltrosPrecioMaxW3.getText().trim();

        List<Inmueble> filtrados = inmobiliaria.getListainmueble().stream()
                .filter(i -> i.getEstado() == Estado.DISPONIBLE)
                .filter(i -> ciudadFiltro.isEmpty() || i.getCiudad().toLowerCase().contains(ciudadFiltro.toLowerCase()))
                .filter(i -> tipoFiltro == null || i.getTipoInmueble() == tipoFiltro)
                .filter(i -> {
                    if (areaMinStr.isEmpty()) return true;
                    try { return Double.parseDouble(i.getArea()) >= Double.parseDouble(areaMinStr); }
                    catch (NumberFormatException e) { return true; }
                })
                .filter(i -> {
                    if (precioMinStr.isEmpty()) return true;
                    try { return i.getPrecio() >= Double.parseDouble(precioMinStr); }
                    catch (NumberFormatException e) { return true; }
                })
                .filter(i -> {
                    if (precioMaxStr.isEmpty()) return true;
                    try { return i.getPrecio() <= Double.parseDouble(precioMaxStr); }
                    catch (NumberFormatException e) { return true; }
                })
                .collect(Collectors.toList());

        listaInmueblesBusqueda.setAll(filtrados);
    }

    @FXML void ActionKeyCiudadW3(KeyEvent event) { ActionBuscarbtnW3(null); }
    @FXML void ActionKeyAreaMinW3(KeyEvent event) { ActionBuscarbtnW3(null); }
    @FXML void ActionKeyPrecioMinW3(KeyEvent event) { ActionBuscarbtnW3(null); }
    @FXML void ActionKeyPrecioMaxW3(KeyEvent event) { ActionBuscarbtnW3(null); }


    @FXML
    void ActionRealizarOfertabtnW3(ActionEvent event) {
        Inmueble seleccionado = tbTablaInmueblesW3.getSelectionModel().getSelectedItem();
        procesarCreacionOferta(seleccionado);
    }

    @FXML
    void ActionIRRealizarOfertaW3(ActionEvent event) {
        Inmueble seleccionado = TablaInmueblesRecomW3.getSelectionModel().getSelectedItem();
        procesarCreacionOferta(seleccionado);
    }

    private void procesarCreacionOferta(Inmueble seleccionado) {
        if (seleccionado != null) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Realizar Oferta");
            dialog.setHeaderText("Inmueble: " + seleccionado.getCodigo() + " - Precio Original: $" + seleccionado.getPrecio());
            dialog.setContentText("Ingrese el valor de su oferta:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(valorStr -> {
                try {
                    double valor = Double.parseDouble(valorStr);
                    String codigoOferta = "OF-" + System.currentTimeMillis();

                    Oferta nuevaOferta = new Oferta(codigoOferta, compradorLogueado, seleccionado, valor);
                    listaMisOfertas.add(nuevaOferta);

                    String mensaje = compradorLogueado.realizaroferta(seleccionado, valor);
                    actualizarPuntosPerfil();
                    mostrarMensaje("Oferta Registrada", mensaje);
                } catch (NumberFormatException e) {
                    mostrarMensaje("Error", "Ingrese un valor numérico válido.");
                } catch (IllegalArgumentException e) {
                    mostrarMensaje("Error", e.getMessage());
                }
            });
        } else {
            mostrarMensaje("Advertencia", "Por favor, seleccione un inmueble de la tabla.");
        }
    }

    @FXML
    void ActionbtnCancelarOfertawW3(ActionEvent event) {
        Oferta seleccionada = TablaMisOfertasW3.getSelectionModel().getSelectedItem();
        if (seleccionada != null && seleccionada.getEstado() == EstadoOferta.PENDIENTE) {
            seleccionada.rechazaroferta();
            TablaMisOfertasW3.refresh();
            mostrarMensaje("Éxito", "Usted ha cancelado la oferta.");
        } else {
            mostrarMensaje("Advertencia", "Seleccione una oferta en estado PENDIENTE.");
        }
    }


    @FXML
    void ActionComprarbtnW3(ActionEvent event) {
        Inmueble seleccionado = tbTablaInmueblesW3.getSelectionModel().getSelectedItem();
        procesarCompraDirecta(seleccionado);
    }

    @FXML
    void ActionIRComprarW3(ActionEvent event) {
        Inmueble seleccionado = TablaInmueblesRecomW3.getSelectionModel().getSelectedItem();
        procesarCompraDirecta(seleccionado);
    }

    private void procesarCompraDirecta(Inmueble seleccionado) {
        if (seleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar Compra");
            confirmacion.setHeaderText("¿Está seguro de comprar este inmueble?");
            confirmacion.setContentText("Código: " + seleccionado.getCodigo() + "\nValor Final: $" + seleccionado.getPrecio());

            Optional<ButtonType> result = confirmacion.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    String codTrans = "TR-" + System.currentTimeMillis();
                    Vendedor vendedorInmueble = seleccionado.getVendedor();


                    Transaccion nuevaTrans = new Transaccion(
                            codTrans, compradorLogueado, vendedorInmueble, seleccionado,
                            seleccionado.getPrecio(), TipoOperacion.VENTA, LocalDateTime.now()
                    );

                    inmobiliaria.getListatransaccion().add(nuevaTrans);
                    seleccionado.setEstado(Estado.VENDIDO);

                    compradorLogueado.setPuntoreputacion(compradorLogueado.getPuntoreputacion() + 50);


                    String msg = "Compra registrada con éxito.";
                    compradorLogueado.comprarinmueble(seleccionado);

                    actualizarPuntosPerfil();
                    actualizarTablaBusqueda();
                    actualizarTablaRecomendaciones();
                    actualizarTablaCompras();

                    mostrarMensaje("Compra Exitosa", msg);
                } catch (Exception e) {
                    mostrarMensaje("Error", "No se pudo procesar la compra: " + e.getMessage());
                }
            }
        } else {
            mostrarMensaje("Advertencia", "Seleccione un inmueble de la tabla para comprar.");
        }
    }

    @FXML
    void ActionbtnConcretarOfertaW3(ActionEvent event) {
        Oferta seleccionada = TablaMisOfertasW3.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            if (seleccionada.getEstado() == EstadoOferta.ACEPTADA) {
                try {
                    String codTrans = "TR-" + System.currentTimeMillis();
                    Inmueble inmueble = seleccionada.getInmueble();

                    Transaccion nuevaTrans = new Transaccion(
                            codTrans, compradorLogueado, inmueble.getVendedor(), inmueble,
                            seleccionada.getValoroferta(), TipoOperacion.VENTA, LocalDateTime.now()
                    );

                    inmobiliaria.getListatransaccion().add(nuevaTrans);
                    inmueble.setEstado(Estado.VENDIDO);

                    compradorLogueado.setPuntoreputacion(compradorLogueado.getPuntoreputacion() + 50);

                    TablaMisOfertasW3.refresh();
                    actualizarPuntosPerfil();
                    actualizarTablaBusqueda();
                    actualizarTablaRecomendaciones();
                    actualizarTablaCompras();

                    mostrarMensaje("Éxito", "La oferta ha sido concretada y se generó la transacción.");
                } catch (Exception e) {
                    mostrarMensaje("Error", e.getMessage());
                }
            } else {
                mostrarMensaje("Advertencia", "Solo puede concretar ofertas que hayan sido ACEPTADAS por el vendedor.");
            }
        } else {
            mostrarMensaje("Advertencia", "Seleccione una oferta de la lista.");
        }
    }


    @FXML
    void ActionEliminarAlertaW3(ActionEvent event) {
        Alerta seleccionada = TableBandejaAlertaW3.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {

            mostrarMensaje("Información", "La funcionalidad de eliminar está comentada hasta completar la lista de alertas.");
        } else {
            mostrarMensaje("Advertencia", "Seleccione una alerta de la tabla para eliminar.");
        }
    }

    @FXML void MouseClickedTablaInmueblesW3(MouseEvent event) { }
    @FXML void MouseClickedMisOfertasW3(MouseEvent event) { }
    @FXML void MouseClickedInmueblesRecW3(MouseEvent event) { }
    @FXML void MouseClickedAlertaW3(MouseEvent event) { }


    @FXML
    void ActionCambiarNombreMiW3(ActionEvent event) {
        if (compradorLogueado != null) {
            String nuevoNombre = txtCambiarNombreMiW3.getText().trim();
            if (!nuevoNombre.isEmpty()) {
                compradorLogueado.setNombre(nuevoNombre);
                mostrarMensaje("Perfil Actualizado", "Nombre modificado correctamente.");
            } else {
                mostrarMensaje("Error", "El campo de nombre no puede estar vacío.");
            }
        }
    }

    @FXML
    void ActionCambiarTelefonoMiW3(ActionEvent event) {
        if (compradorLogueado != null) {
            String nuevoTel = txtCambiarTelefonoMiW3.getText().trim();
            if (!nuevoTel.isEmpty()) {
                compradorLogueado.setTelefono(nuevoTel);
                mostrarMensaje("Perfil Actualizado", "Teléfono modificado correctamente.");
            } else {
                mostrarMensaje("Error", "El campo de teléfono no puede estar vacío.");
            }
        }
    }

    @FXML void ActionCerrarSesionW3(ActionEvent event) { cerrarVentana(event); }
    @FXML void ActionCerrarSesionMiW3(ActionEvent event) { cerrarVentana(event); }

    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}