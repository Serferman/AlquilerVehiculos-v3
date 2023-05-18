package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListarAlquileres extends Controlador {

	@FXML
	private TextField tfClientes;

	@FXML
	private TextField tfVehiculos;

	@FXML
	private TableView<Alquiler> tvAlquileres;

	private TableColumn<Alquiler, String> tcNombre = new TableColumn<>("Nombre");
	private TableColumn<Alquiler, String> tcDni = new TableColumn<>("Dni");
	private TableColumn<Alquiler, String> tcTelefono = new TableColumn<>("Telefono");

	private TableColumn<Alquiler, String> tcMarca = new TableColumn<>("Marca");
	private TableColumn<Alquiler, String> tcModelo = new TableColumn<>("Modelo");
	private TableColumn<Alquiler, String> tcMatricula = new TableColumn<>("Matricula");
	private TableColumn<Alquiler, String> tcCilindrada = new TableColumn<>("Cilindrada");
	private TableColumn<Alquiler, String> tcPma = new TableColumn<>("PMA");
	private TableColumn<Alquiler, String> tcPlazas = new TableColumn<>("Plazas");

	@FXML
	void initialize() {
		tfClientes.focusedProperty().addListener(e -> comprobarSeleccionClientes());
		tfVehiculos.focusedProperty().addListener(e -> comprobarSeleccionVehiculos());

		tvAlquileres.getColumns().add(tcNombre);
		tvAlquileres.getColumns().add(tcDni);
		tvAlquileres.getColumns().add(tcTelefono);

		tvAlquileres.getColumns().add(tcMarca);
		tvAlquileres.getColumns().add(tcModelo);
		tvAlquileres.getColumns().add(tcMatricula);
		tvAlquileres.getColumns().add(tcCilindrada);
		tvAlquileres.getColumns().add(tcPma);
		tvAlquileres.getColumns().add(tcPlazas);

		tcDni.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getDni()));
		tcNombre.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getNombre()));
		tcTelefono.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getTelefono()));

		tcMarca.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getMarca()));
		tcModelo.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getModelo()));
		tcMatricula.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getMatricula()));
		tcCilindrada.setCellValueFactory(
				fila -> new SimpleStringProperty(comprobarCilindradas(fila.getValue().getVehiculo())));
		tcPma.setCellValueFactory(fila -> new SimpleStringProperty(comprobarPma(fila.getValue().getVehiculo())));
		tcPlazas.setCellValueFactory(fila -> new SimpleStringProperty(comprobarPlazas(fila.getValue().getVehiculo())));

		tvAlquileres
				.setItems(FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres()));
	}

	// -------------------------------------------------------------------------------------------------------------------
	
	String comprobarCilindradas(Vehiculo vehiculo) {
		return (vehiculo instanceof Turismo turismo) ? String.format("%s", turismo.getCilindrada()) : "";
	}

	String comprobarPma(Vehiculo vehiculo) {
		return (vehiculo instanceof Furgoneta furgoneta) ? String.format("%s", furgoneta.getPma()) : "";
	}

	String comprobarPlazas(Vehiculo vehiculo) {
		String plazasTipoVehiculo = "";

		if (vehiculo instanceof Autobus autobus) {
			plazasTipoVehiculo = String.format("%s", autobus.getPlazas());
		} else if (vehiculo instanceof Furgoneta furgoneta) {
			plazasTipoVehiculo = String.format("%s", furgoneta.getPlazas());
		}

		return plazasTipoVehiculo;
	}

	// -------------------------------------------------------------------------------------------------------------------
	
	void comprobarSeleccionClientes() {
		tfClientes.setStyle("-fx-opacity: 1;");

		tfVehiculos.clear();
		tfVehiculos.setStyle("-fx-opacity: 0.5;");
	}

	void comprobarSeleccionVehiculos() {
		tfVehiculos.setStyle("-fx-opacity: 1;");

		tfClientes.clear();
		tfClientes.setStyle("-fx-opacity: 0.5;");
	}

	// -------------------------------------------------------------------------------------------------------------------
	
	@FXML
	void ratonPulsaCheck(MouseEvent event) {
		if (!tfClientes.getText().isEmpty()) {
			if (!tvAlquileres.getColumns().isEmpty()) {
				tvAlquileres.getColumns().clear();

				construirTablaListarClientes();
			} else {
				construirTablaListarClientes();
			}
		} else if (!tfVehiculos.getText().isEmpty()) {
			if (!tvAlquileres.getColumns().isEmpty()) {
				tvAlquileres.getColumns().clear();

				construirTablaListarVehiculos();
			} else {
				construirTablaListarVehiculos();
			}
		}
	}

	void construirTablaListarClientes() {
		tvAlquileres.getColumns().add(tcNombre);
		tvAlquileres.getColumns().add(tcDni);
		tvAlquileres.getColumns().add(tcTelefono);

		tvAlquileres.getColumns().add(tcMarca);
		tvAlquileres.getColumns().add(tcModelo);
		tvAlquileres.getColumns().add(tcMatricula);
		tvAlquileres.getColumns().add(tcCilindrada);
		tvAlquileres.getColumns().add(tcPma);
		tvAlquileres.getColumns().add(tcPlazas);
		
		tcDni.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getDni()));
		tcNombre.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getNombre()));
		tcTelefono.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getTelefono()));

		tcMarca.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getMarca()));
		tcModelo.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getModelo()));
		tcMatricula.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getMatricula()));
		tcCilindrada.setCellValueFactory(fila -> new SimpleStringProperty(comprobarCilindradas(fila.getValue().getVehiculo())));
		tcPma.setCellValueFactory(fila -> new SimpleStringProperty(comprobarPma(fila.getValue().getVehiculo())));
		tcPlazas.setCellValueFactory(fila -> new SimpleStringProperty(comprobarPlazas(fila.getValue().getVehiculo())));

		tcDni.setStyle("-fx-alignment: CENTER;");
		tcNombre.setStyle("-fx-alignment: CENTER;");
		tcTelefono.setStyle("-fx-alignment: CENTER;");
		
		tcMarca.setStyle("-fx-alignment: CENTER;");
		tcModelo.setStyle("-fx-alignment: CENTER;");
		tcMatricula.setStyle("-fx-alignment: CENTER;");
		tcCilindrada.setStyle("-fx-alignment: CENTER;");
		tcPma.setStyle("-fx-alignment: CENTER;");
		tcPlazas.setStyle("-fx-alignment: CENTER;");
		
		tvAlquileres.setItems(FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres(Cliente.getClienteConDni(tfClientes.getText()))));
	}

	void construirTablaListarVehiculos() {

		tvAlquileres.getColumns().add(tcNombre);
		tvAlquileres.getColumns().add(tcDni);
		tvAlquileres.getColumns().add(tcTelefono);

		tvAlquileres.getColumns().add(tcMarca);
		tvAlquileres.getColumns().add(tcModelo);
		tvAlquileres.getColumns().add(tcMatricula);
		tvAlquileres.getColumns().add(tcCilindrada);
		tvAlquileres.getColumns().add(tcPma);
		tvAlquileres.getColumns().add(tcPlazas);

		tcDni.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getDni()));
		tcNombre.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getNombre()));
		tcTelefono.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getCliente().getTelefono()));

		tcMarca.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getMarca()));
		tcModelo.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getModelo()));
		tcMatricula.setCellValueFactory(fila -> new SimpleStringProperty(fila.getValue().getVehiculo().getMatricula()));
		tcCilindrada.setCellValueFactory(fila -> new SimpleStringProperty(comprobarCilindradas(fila.getValue().getVehiculo())));
		tcPma.setCellValueFactory(fila -> new SimpleStringProperty(comprobarPma(fila.getValue().getVehiculo())));
		tcPlazas.setCellValueFactory(fila -> new SimpleStringProperty(comprobarPlazas(fila.getValue().getVehiculo())));

		tcDni.setStyle("-fx-alignment: CENTER;");
		tcNombre.setStyle("-fx-alignment: CENTER;");
		tcTelefono.setStyle("-fx-alignment: CENTER;");
		
		tcMarca.setStyle("-fx-alignment: CENTER;");
		tcModelo.setStyle("-fx-alignment: CENTER;");
		tcMatricula.setStyle("-fx-alignment: CENTER;");
		tcCilindrada.setStyle("-fx-alignment: CENTER;");
		tcPma.setStyle("-fx-alignment: CENTER;");
		tcPlazas.setStyle("-fx-alignment: CENTER;");
		
		tvAlquileres.setItems(FXCollections.observableList(VistaGrafica.getInstancia().getControlador().getAlquileres(Vehiculo.getVehiculoConMatricula(tfVehiculos.getText()))));

	}
}
