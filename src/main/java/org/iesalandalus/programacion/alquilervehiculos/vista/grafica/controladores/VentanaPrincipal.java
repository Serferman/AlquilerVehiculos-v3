package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.io.IOException;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VentanaPrincipal extends Controlador {

	@FXML
	private StackPane stackPaneMenuDesplegable;
	private VBox vbox;

	@FXML
	private void initialize() {
		System.out.println("Método initialize de VentanaPrincipal");
	}

	//------------------------------------------------------------------------- BORRAR ---------------------------------------------------------------------------------
	
	@FXML
	void btBorrarAlquiler(ActionEvent event) {
		borrarAlquiler ventanaBorrarAlquiler = (borrarAlquiler) Controladores.get("vistas/borrarAlquiler.fxml", "Vista grafica de borrar alquiler", null);
		ventanaBorrarAlquiler.getEscenario().showAndWait();
	}

	@FXML
	void btBorrarCliente(ActionEvent event) {
		borrarCliente ventanaBorrarCliente = (borrarCliente) Controladores.get("vistas/borrarCliente.fxml", "Vista grafica de borrar cliente", null);
		ventanaBorrarCliente.getEscenario().showAndWait();
	}

	@FXML
	void btBorrarVehiculo(ActionEvent event) {
		borrarVehiculo ventanaBorrarVehiculo = (borrarVehiculo) Controladores.get("vistas/borrarVehiculo.fxml", "Vista grafica de borrar vehiculo", null);
		ventanaBorrarVehiculo.getEscenario().showAndWait();
	}
	
	//--------------------------------------------------------------------------- BUSCAR -----------------------------------------------------------------------------
	
	@FXML
	void btBuscarAlquiler(ActionEvent event) {
		buscarAlquiler ventanaBuscarAlquiler = (buscarAlquiler) Controladores.get("vistas/buscarAlquiler.fxml", "Vista grafica de borrar alquiler", null);
		ventanaBuscarAlquiler.getEscenario().showAndWait();
	}

	@FXML
	void btBuscarCliente(ActionEvent event) {
		buscarCliente ventanaBuscarCliente = (buscarCliente) Controladores.get("vistas/buscarCliente.fxml", "Vista grafica de borrar cliente", null);
		ventanaBuscarCliente.getEscenario().showAndWait();
	}

	@FXML
	void btBuscarVehiculo(ActionEvent event) {
		buscarVehiculo ventanaBuscarVehiculo = (buscarVehiculo) Controladores.get("vistas/buscarVehiculo.fxml", "Vista grafica de borrar vehiculo", null);
		ventanaBuscarVehiculo.getEscenario().showAndWait();
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@FXML
	void btInsertarAlquiler(ActionEvent event) {
		insertarAlquiler ventanaInsertarAlquiler = (insertarAlquiler) Controladores.get("vistas/insertarAlquiler.fxml", "Vista grafica de insertar alquiler", null);
		ventanaInsertarAlquiler.getEscenario().showAndWait();
	}

	@FXML
	void btInsertarCliente(ActionEvent event) {
		insertarCliente ventanaInsertarCliente = (insertarCliente) Controladores.get("vistas/insertarCliente.fxml", "Vista grafica de insertar cliente", null);
		ventanaInsertarCliente.getEscenario().showAndWait();
	}

	@FXML
	void btInsertarVehiculo(ActionEvent event) {
		insertarVehiculo ventanaInsertarVehiculo = (insertarVehiculo) Controladores.get("vistas/insertarVehiculo.fxml", "Vista grafica de insertar vehiculo", null);
		ventanaInsertarVehiculo.getEscenario().showAndWait();
	}

	//------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@FXML
	void btListarAlquiler(ActionEvent event) {
		listarAlquileres ventanaListarAlquileres = (listarAlquileres) Controladores.get("vistas/listarAlquileres.fxml", "Vista grafica de listar alquileres", null);
		ventanaListarAlquileres.getEscenario().showAndWait();
	}

	@FXML
	void btListarCliente(ActionEvent event) {
		listarClientes ventanaListarClientes = (listarClientes) Controladores.get("vistas/listarClientes.fxml", "Vista grafica de listar clientesr", null);
		ventanaListarClientes.getEscenario().showAndWait();
	}

	@FXML
	void btListarVehiculo(ActionEvent event) {
		listarVehiculos ventanaListarVehiculos = (listarVehiculos) Controladores.get("vistas/listarVehiculos.fxml", "Vista grafica de listar vehiculos", null);
		ventanaListarVehiculos.getEscenario().showAndWait();
	}

	@FXML
	void salir(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void ratonEncimaBoton(MouseEvent event) {
		DropShadow sombra = new DropShadow();
		sombra.setColor(Color.GRAY);
		Button boton = (Button) event.getSource();
		boton.setEffect(sombra);
	}

	@FXML
	void ratonSaliendoBoton(MouseEvent event) {
		Button boton = (Button) event.getSource();
		boton.setEffect(null);
	}

	// --------------------------------------------------------------------------------------------------------------------------------

	@FXML
	void ratonPresionaBotonCasa(MouseEvent event) {
		if (!stackPaneMenuDesplegable.getChildren().isEmpty()) {
			stackPaneMenuDesplegable.getChildren().remove(stackPaneMenuDesplegable.getChildren().indexOf(vbox));
		} else {
			vbox = new VBox();
			Button botonSalir = new Button("Salir");

			botonSalir.setStyle("-fx-background-color: #eef3d0; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-width: 1;");
			botonSalir.setMinWidth(80);
			botonSalir.setOpacity(1.0);
			botonSalir.setOnAction(e -> salir(e));

			vbox.setStyle("-fx-background-color: #ecefdb; -fx-effect: dropshadow(Three-pass-box, black, 14, 0, 2, 0 );");
			vbox.setAlignment(Pos.CENTER);
			vbox.setMaxWidth(80);
			vbox.setMaxHeight(596);
			vbox.setSpacing(30);
			vbox.getChildren().addAll(botonSalir);

			stackPaneMenuDesplegable.getChildren().add(0,vbox);
			stackPaneMenuDesplegable.setAlignment(Pos.CENTER_LEFT);
		}
	}

	@FXML
	void ratonPresionaBotonLupa(MouseEvent event) {
		if (!stackPaneMenuDesplegable.getChildren().isEmpty()) {
			stackPaneMenuDesplegable.getChildren().remove(stackPaneMenuDesplegable.getChildren().indexOf(vbox));
		} else {
			vbox = new VBox();
			Button botonHelp = new Button("Autor");

			botonHelp.setStyle("-fx-background-color: #eef3d0; -fx-background-radius: 5; -fx-border-radius: 5; -fx-border-width: 1;");
			botonHelp.setMinWidth(80);

			vbox.setStyle("-fx-background-color: #ecefdb; -fx-effect: dropshadow(Three-pass-box, black, 14, 0, 2, 0 );");
			vbox.setAlignment(Pos.CENTER);
			vbox.setMaxWidth(80);
			vbox.setMaxHeight(596);
			vbox.setSpacing(30);
			vbox.getChildren().addAll(botonHelp);

			stackPaneMenuDesplegable.getChildren().add(0,vbox);
			stackPaneMenuDesplegable.setAlignment(Pos.CENTER_LEFT);
		}
	}

	@FXML
	void ratonPresionaHyperlinkGithub(ActionEvent event) {
		String url = "https://github.com/Serferman/AlquilerVehiculos-v3";
		String os = System.getProperty("os.name").toLowerCase();

		String command = "";

		if (os.contains("win")) {
			command = "cmd /c start";
		} else if (os.contains("mac")) {
			command = "open";
		} else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			command = "xdg-open";
		}

		try {
			ProcessBuilder pb = new ProcessBuilder(command, url);
			pb.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	void ratonPresionaHyperlinkThingiverse(MouseEvent event) {
		String url = "https://www.thingiverse.com/serferman12";
		String os = System.getProperty("os.name").toLowerCase();

		String command = "";

		if (os.contains("win")) {
			command = "cmd /c start";
		} else if (os.contains("mac")) {
			command = "open";
		} else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			command = "xdg-open";
		}

		try {
			ProcessBuilder pb = new ProcessBuilder(command, url);
			pb.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
