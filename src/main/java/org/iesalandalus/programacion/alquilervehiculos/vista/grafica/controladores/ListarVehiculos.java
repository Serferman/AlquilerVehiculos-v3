package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarVehiculos extends Controlador {

	@FXML
	private TableView<Vehiculo> tvVehiculos;

	@FXML
	private RadioButton rdAutobuses;

	@FXML
	private RadioButton rdFurgoneta;

	@FXML
	private RadioButton rdTurismos;

	@FXML
	void initialize() {

		ToggleGroup grupoRadioButtons = new ToggleGroup();
	
		rdAutobuses.selectedProperty().addListener(e -> construirTablaAutobuses());
		rdFurgoneta.selectedProperty().addListener(e -> construirTablaFurgoneta());
		rdTurismos.selectedProperty().addListener(e -> construirTablaTurismos());

		rdAutobuses.setToggleGroup(grupoRadioButtons);
		rdFurgoneta.setToggleGroup(grupoRadioButtons);
		rdTurismos.setToggleGroup(grupoRadioButtons);
		
	}

	void construirTablaTurismos() {

		if (tvVehiculos.getColumns().isEmpty()) {
			TableColumn<Vehiculo, String> tcMarca = new TableColumn<>("Marca");
			TableColumn<Vehiculo, String> tcModelo = new TableColumn<>("Modelo");
			TableColumn<Vehiculo, String> tcMatricula = new TableColumn<>("Matricula");
			TableColumn<Vehiculo, String> tcCilindrada = new TableColumn<>("Cilindrada");

			tvVehiculos.getColumns().add(tcMarca);
			tvVehiculos.getColumns().add(tcModelo);
			tvVehiculos.getColumns().add(tcMatricula);
			tvVehiculos.getColumns().add(tcCilindrada);

			tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
			tcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
			tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
			tcCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));

			List<Vehiculo> listaTurismos = new ArrayList<>();

			for (Vehiculo vehiculo : VistaGrafica.getInstancia().getControlador().getVehiculos()) {
				if (vehiculo instanceof Turismo) {
					listaTurismos.add(vehiculo);
				}
			}

			tvVehiculos.setItems(FXCollections.observableList(listaTurismos));
		} else {
			tvVehiculos.getColumns().clear();
		}
	}

	void construirTablaFurgoneta() {

		if (tvVehiculos.getColumns().isEmpty()) {
			TableColumn<Vehiculo, String> tcMarca = new TableColumn<>("Marca");
			TableColumn<Vehiculo, String> tcModelo = new TableColumn<>("Modelo");
			TableColumn<Vehiculo, String> tcMatricula = new TableColumn<>("Matricula");
			TableColumn<Vehiculo, String> tcPMA = new TableColumn<>("PMA");
			TableColumn<Vehiculo, String> tcPlazas = new TableColumn<>("Plazas");

			tvVehiculos.getColumns().add(tcMarca);
			tvVehiculos.getColumns().add(tcModelo);
			tvVehiculos.getColumns().add(tcMatricula);
			tvVehiculos.getColumns().add(tcPMA);
			tvVehiculos.getColumns().add(tcPlazas);

			tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
			tcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
			tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
			tcPMA.setCellValueFactory(new PropertyValueFactory<>("pma"));
			tcPlazas.setCellValueFactory(new PropertyValueFactory<>("plazas"));

			List<Vehiculo> listaFurgoneta = new ArrayList<>();

			for (Vehiculo vehiculo : VistaGrafica.getInstancia().getControlador().getVehiculos()) {
				if (vehiculo instanceof Furgoneta) {
					listaFurgoneta.add(vehiculo);
				}
			}

			tvVehiculos.setItems(FXCollections.observableList(listaFurgoneta));
		} else {
			tvVehiculos.getColumns().clear();;
		}
	}

	void construirTablaAutobuses() {

		if (tvVehiculos.getColumns().isEmpty()) {
			TableColumn<Vehiculo, String> tcMarca = new TableColumn<>("Marca");
			TableColumn<Vehiculo, String> tcModelo = new TableColumn<>("Modelo");
			TableColumn<Vehiculo, String> tcMatricula = new TableColumn<>("Matricula");
			TableColumn<Vehiculo, String> tcplazas = new TableColumn<>("Plazas");

			tvVehiculos.getColumns().add(tcMarca);
			tvVehiculos.getColumns().add(tcModelo);
			tvVehiculos.getColumns().add(tcMatricula);
			tvVehiculos.getColumns().add(tcplazas);

			tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
			tcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
			tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
			tcplazas.setCellValueFactory(new PropertyValueFactory<>("plazas"));

			List<Vehiculo> listaAutobus = new ArrayList<>();

			for (Vehiculo vehiculo : VistaGrafica.getInstancia().getControlador().getVehiculos()) {
				if (vehiculo instanceof Autobus) {
					listaAutobus.add(vehiculo);
				}
			}

			tvVehiculos.setItems(FXCollections.observableList(listaAutobus));
		} else {
			tvVehiculos.getColumns().clear();
		}
	}

}
