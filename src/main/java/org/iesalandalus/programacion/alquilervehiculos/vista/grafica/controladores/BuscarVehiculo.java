package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BuscarVehiculo extends Controlador {

	@FXML
	private Label LCIlindradas;

	@FXML
	private Label LMarca;

	@FXML
	private Label LMatricula;

	@FXML
	private Label LModelo;

	@FXML
	private Label LPMA;

	@FXML
	private Label LPlazas;

	@FXML
	private TextField tfMatriculaBuscado;

	@FXML
	void ratonPulsaBorrar(MouseEvent event) {
		LMarca.setText(null);
		LMarca.setDisable(true);
		//LMarca.setStyle(OPACIDAD_MEDIA);

		LModelo.setText(null);
		LModelo.setDisable(true);
		//LModelo.setStyle(OPACIDAD_MEDIA);

		LMatricula.setText(null);
		LMatricula.setDisable(true);
		//LMatricula.setStyle(OPACIDAD_MEDIA);

		LCIlindradas.setText(null);
		LCIlindradas.setDisable(true);
		//LCIlindradas.setStyle(OPACIDAD_MEDIA);

		LPlazas.setText(null);
		LPlazas.setDisable(true);
		//LPlazas.setStyle(OPACIDAD_MEDIA);

		LPMA.setText(null);
		LPMA.setDisable(true);
		//LPMA.setStyle(OPACIDAD_MEDIA);
	}

	@FXML
	void ratonPulsaCancelar(MouseEvent event) {
		getEscenario().close();
	}

	@FXML
	void ratonPulsaCheck(MouseEvent event) {
		try {

			Vehiculo vehiculo = VistaGrafica.getInstancia().getControlador().buscar(Vehiculo.getVehiculoConMatricula(tfMatriculaBuscado.getText()));
			
			LMarca.setText(vehiculo.getMarca());
			LMatricula.setText(vehiculo.getMatricula());
			LModelo.setText(vehiculo.getModelo());
			
			if (vehiculo instanceof Turismo turismo) {
				LCIlindradas.setText(String.format("%s", turismo.getCilindrada()));	
				LPlazas.setText(null);
				LPMA.setText(null);
			} else if (vehiculo instanceof Furgoneta furgoneta) {
				LPMA.setText(String.format("%s", furgoneta.getPma()));
				LPlazas.setText(String.format("%s", furgoneta.getPlazas()));
				LCIlindradas.setText(null);
			} else if (vehiculo instanceof Autobus autobus) {
				LPlazas.setText(String.format("%s", autobus.getPlazas()));
				LCIlindradas.setText(null);
				LPMA.setText(null);
			}
			
			Dialogos.mostrarDialogoAdvertencia("AVISO: Busqueda vehículo", "El vehículo se ha buscado correctamente",
					getEscenario());

		} catch (NullPointerException | IllegalArgumentException e) {
			Dialogos.mostrarDialogoError("ERROR: Excepcion buscar vehículo", e.getMessage(), getEscenario());
		}
	}
}
