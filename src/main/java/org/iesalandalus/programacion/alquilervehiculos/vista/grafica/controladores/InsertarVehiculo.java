package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class InsertarVehiculo extends Controlador {
    
	@FXML
    private ChoiceBox<String> chbTipoVehiculo;
	
	@FXML
	private TextField tfMarca;

	@FXML
	private TextField tfModelo;
	    
    @FXML
    private TextField tfMatricula;
	
	@FXML
    private TextField tfCilindradas;

    @FXML
    private TextField tfPMA;

    @FXML
    private TextField tfPlazas;
    
    private static final String TURISMO = "Turismo";
    private static final String AUTOBUS = "Autobus";
    private static final String FURGONETA = "Furgoneta";
    
    @FXML
    void initialize() {
    	// Creamos las opciones del choice box
		chbTipoVehiculo.setItems(FXCollections.observableArrayList(TURISMO, AUTOBUS, FURGONETA));
		// Comprobacion del campo seleccionado mediante los listener
		chbTipoVehiculo.valueProperty().addListener(nv -> comprobarTipoVehiculo());
    }
    
    void comprobarTipoVehiculo() {
    	
		String opcionSeleccionada = chbTipoVehiculo.valueProperty().getValue();
		//chbTipoVehiculo.setValue(TURISMO);
    	
    	if (opcionSeleccionada.equals(TURISMO)) {
			tfPlazas.setDisable(true);
			tfPlazas.setStyle("-fx-opacity: 0.5;");
			
			tfPMA.setDisable(true);
			tfPMA.setStyle("-fx-opacity: 0.5;");
			
			tfCilindradas.setDisable(false);
			tfCilindradas.setStyle("-fx-opacity: 1.0;");
			
		} else if (opcionSeleccionada.equals(AUTOBUS)) {
			tfPMA.setDisable(true);
			tfPMA.setStyle("-fx-opacity: 0.5;");
			
			tfCilindradas.setDisable(true);
			tfCilindradas.setStyle("-fx-opacity: 0.5;");
			
			tfPlazas.setDisable(false);
			tfPlazas.setStyle("-fx-opacity: 1.0;");
			
		} else if (opcionSeleccionada.equals(FURGONETA)) {
			tfCilindradas.setDisable(true);
			tfCilindradas.setStyle("-fx-opacity: 0.5;");
			
			tfPlazas.setDisable(false);
			tfPlazas.setStyle("-fx-opacity: 1.0;");
			
			tfPMA.setDisable(false);
			tfPMA.setStyle("-fx-opacity: 1.0;");
			
		}
    }
    
    // Crea un vehiculo
    public Vehiculo getVehiculo() {
		String marca = tfMarca.getText();
		String modelo = tfModelo.getText();
		String matricula = tfMatricula.getText();
		
		Vehiculo vehiculo = null;
		
		String opcionSeleccionada = chbTipoVehiculo.valueProperty().getValue();
		
		if (opcionSeleccionada.equals(TURISMO)) {
			vehiculo = new Turismo(marca,modelo,Integer.parseInt(tfCilindradas.getText()),matricula);
		} else if (opcionSeleccionada.equals(AUTOBUS)) {
			vehiculo = new Autobus(marca, modelo, Integer.parseInt(tfPlazas.getText()),matricula);
		} else if (opcionSeleccionada.equals(FURGONETA)) {
			vehiculo = new Furgoneta(marca, modelo, Integer.parseInt(tfPMA.getText()),Integer.parseInt(tfPlazas.getText()),matricula);
		}
		
		return Vehiculo.copiar(vehiculo);
	}

    @FXML
    void ratonPulsaAceptar(MouseEvent event) {
    	try {
			VistaGrafica.getInstancia().getControlador().insertar(getVehiculo());
			Dialogos.mostrarDialogoAdvertencia("AVISO: Insercion vehículo", "El vehículo se ha insertado correctamente", getEscenario());
			getEscenario().close();
			
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			Dialogos.mostrarDialogoError("ERROR: Excepcion insertar vehículo", e.getMessage(), getEscenario());
		}
    }

    @FXML
    void ratonPulsaCancelar(MouseEvent event) {
    	getEscenario().close();
    }   
    
    @FXML
    void ratonPulsaBorrar(MouseEvent event) {
    	tfMarca.clear();
    	tfModelo.clear();
    	tfMatricula.clear();
    	tfCilindradas.clear();
    	tfPlazas.clear();
    	tfPMA.clear();
    }
}
