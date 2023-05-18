package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.io.IOException;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class VentanaPrincipal extends Controlador {

	@FXML
	private StackPane stackPaneMenuDesplegable;

	private String estiloBotonesMenuDesplegable = "-fx-background-color: #c4eece; -fx-background-radius: 3; -fx-border-radius: 3; -fx-border-width: 0;";
	private String estiloVboxMenuDesplegable = "-fx-background-color: #7cb88b; -fx-effect: innershadow(Three-pass-box, black, 4, 0, 2, 0 ); -fx-border-width: 3 3 3 0; -fx-border-color:black; -fx-border-radius: 0 5 5 0; -fx-background-radius: 0 6 6 0;";

	@FXML
	private void initialize() {
		System.out.println("Método initialize de VentanaPrincipal");
	}

	// ------------------------------------------------------------------------- BORRAR ---------------------------------------------------------------------------------

	@FXML
	void btBorrarAlquiler(ActionEvent event) {
		BorrarAlquiler ventanaBorrarAlquiler = (BorrarAlquiler) Controladores.get("vistas/borrarAlquiler.fxml",
				"Vista grafica de borrar alquiler", getEscenario());
		ventanaBorrarAlquiler.getEscenario().showAndWait();
	}

	@FXML
	void btBorrarCliente(ActionEvent event) {
		BorrarCliente ventanaBorrarCliente = (BorrarCliente) Controladores.get("vistas/borrarCliente.fxml",
				"Vista grafica de borrar cliente", getEscenario());
		ventanaBorrarCliente.getEscenario().showAndWait();
	}

	@FXML
	void btBorrarVehiculo(ActionEvent event) {
		BorrarVehiculo ventanaBorrarVehiculo = (BorrarVehiculo) Controladores.get("vistas/borrarVehiculo.fxml",
				"Vista grafica de borrar vehiculo", getEscenario());
		ventanaBorrarVehiculo.getEscenario().showAndWait();
	}

	// --------------------------------------------------------------------------- BUSCAR -----------------------------------------------------------------------------

	@FXML
	void btBuscarAlquiler(ActionEvent event) {
		BuscarAlquiler ventanaBuscarAlquiler = (BuscarAlquiler) Controladores.get("vistas/buscarAlquiler.fxml",
				"Vista grafica de borrar alquiler", getEscenario());
		ventanaBuscarAlquiler.getEscenario().showAndWait();
	}

	@FXML
	void btBuscarCliente(ActionEvent event) {
		BuscarCliente ventanaBuscarCliente = (BuscarCliente) Controladores.get("vistas/buscarCliente.fxml",
				"Vista grafica de borrar cliente", getEscenario());
		ventanaBuscarCliente.getEscenario().showAndWait();
	}

	@FXML
	void btBuscarVehiculo(ActionEvent event) {
		BuscarVehiculo ventanaBuscarVehiculo = (BuscarVehiculo) Controladores.get("vistas/buscarVehiculo.fxml",
				"Vista grafica de borrar vehiculo", getEscenario());
		ventanaBuscarVehiculo.getEscenario().showAndWait();
	}

	// ------------------------------------------------------------------------- INSERTAR -----------------------------------------------------------------------------

	@FXML
	void btInsertarAlquiler(ActionEvent event) {
		InsertarAlquiler ventanaInsertarAlquiler = (InsertarAlquiler) Controladores.get("vistas/insertarAlquiler.fxml",
				"Vista gráfica de insertar alquiler", getEscenario());
		ventanaInsertarAlquiler.getEscenario().showAndWait();
	}

	@FXML
	void btInsertarCliente(ActionEvent event) {
		InsertarCliente ventanaInsertarCliente = (InsertarCliente) Controladores.get("vistas/insertarCliente.fxml",
				"Vista gráfica de insertar cliente", getEscenario());
		ventanaInsertarCliente.getEscenario().showAndWait();
	}

	@FXML
	void btInsertarVehiculo(ActionEvent event) {
		InsertarVehiculo ventanaInsertarVehiculo = (InsertarVehiculo) Controladores.get("vistas/insertarVehiculo.fxml",
				"Vista gráfica de insertar vehículo", getEscenario());
		ventanaInsertarVehiculo.getEscenario().showAndWait();
	}

	// -------------------------------------------------------------------------- LISTAR ------------------------------------------------------------------------------

	@FXML
	void btListarAlquiler(ActionEvent event) {
		ListarAlquileres ventanaListarAlquileres = (ListarAlquileres) Controladores.get("vistas/listarAlquileres.fxml",
				"Vista grafica de listar alquileres", getEscenario());
		ventanaListarAlquileres.getEscenario().showAndWait();
	}

	@FXML
	void btListarCliente(ActionEvent event) {
		ListarClientes ventanaListarClientes = (ListarClientes) Controladores.get("vistas/listarClientes.fxml",
				"Vista grafica de listar clientes", getEscenario());
		ventanaListarClientes.getEscenario().showAndWait();
	}

	@FXML
	void btListarVehiculo(ActionEvent event) {
		ListarVehiculos ventanaListarVehiculos = (ListarVehiculos) Controladores.get("vistas/listarVehiculos.fxml",
				"Vista grafica de listar vehiculos", getEscenario());
		ventanaListarVehiculos.getEscenario().showAndWait();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

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

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	VBox crearMenuVbox() {
		VBox vbox = new VBox();
		
		vbox.setStyle(estiloVboxMenuDesplegable);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMaxWidth(150);
		vbox.setMaxHeight(250);
		
		return vbox;
	}
	
	Button crearBotonesMenu() {
		Button boton = new Button();
		
		boton.setStyle(estiloBotonesMenuDesplegable);
		boton.setMinWidth(150);
		boton.setOpacity(1.0);
		
		return boton;
	}
	
	void desplegarMenu() {
	
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.2), stackPaneMenuDesplegable);
		translateTransition.setFromX(-10);
		translateTransition.setToX(0);

		translateTransition.play();
	}
	
/*	void plegarMenu() {
		
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), stackPaneMenuDesplegable);
		translateTransition.setFromY(0);
		translateTransition.setToY(-stackPaneMenuDesplegable.getHeight());
		
		translateTransition.play();
	}
*/	
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	@FXML
	void ratonPresionaBotonMenu(MouseEvent event) {
		VBox vbox = crearMenuVbox();
		
		if (!stackPaneMenuDesplegable.getChildren().isEmpty()) {
			
			stackPaneMenuDesplegable.getChildren().clear();
		} else {

			Button botonSalir = crearBotonesMenu();
			Button botonGuardar = crearBotonesMenu();
			
			botonSalir.setText("salir");
			botonSalir.setOnAction(this::salir);

			botonGuardar.setText("guardar");
			botonGuardar.setOnAction(this::guardar);
			
			vbox.getChildren().addAll(botonGuardar, botonSalir);
			VBox.setMargin(botonSalir, new Insets(6));
			VBox.setMargin(botonGuardar, new Insets(6));
			
			stackPaneMenuDesplegable.getChildren().add(0, vbox);
			stackPaneMenuDesplegable.setAlignment(Pos.CENTER_LEFT);
			
			desplegarMenu();
		}
	}

	@FXML
	void salir(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	void guardar(ActionEvent event) {
		System.exit(0);
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	@FXML
	void ratonPresionaBotonVista(MouseEvent event) {
		VBox vbox = crearMenuVbox();
		
		if (!stackPaneMenuDesplegable.getChildren().isEmpty()) {
			
			stackPaneMenuDesplegable.getChildren().clear();
		} else {

			Button botonBlanco = crearBotonesMenu();
			Button botonNegro = crearBotonesMenu();
			Button botonColor = crearBotonesMenu();
			Button botonMinimizar = crearBotonesMenu();
			Button botonMaximizar = crearBotonesMenu();

			botonBlanco.setText("Blanco");
			botonBlanco.setOnAction(e -> ratonPulsaCambiarColorBlanco());

			botonNegro.setText("Negro");
			botonNegro.setOnAction(e -> ratonPulsaCambiarColorNegro());

			botonColor.setText("Color");
			botonColor.setOnAction(e -> ratonPulsaCambiarColor());

			botonMinimizar.setText("Minimizar");
			botonMinimizar.setOnAction(e -> ratonPulsaMinimizar());

			botonMaximizar.setText("Maximizar");
			botonMaximizar.setOnAction(e -> ratonPulsaMaximizar());
			
			VBox.setMargin(botonBlanco, new Insets(6));
			VBox.setMargin(botonNegro, new Insets(6));
			VBox.setMargin(botonColor, new Insets(6));
			VBox.setMargin(botonMinimizar, new Insets(6));
			VBox.setMargin(botonMaximizar, new Insets(6));
			vbox.getChildren().addAll(botonBlanco, botonNegro, botonColor, botonMinimizar, botonMaximizar);
			
			stackPaneMenuDesplegable.getChildren().add(0, vbox);
			stackPaneMenuDesplegable.setAlignment(Pos.CENTER_LEFT);

			desplegarMenu();
		}
	}

	void ratonPulsaMaximizar() {
		
	}

	void ratonPulsaMinimizar() {
		
	}

	void ratonPulsaCambiarColor() {
		
	}

	void ratonPulsaCambiarColorNegro() {
		
	}

	void ratonPulsaCambiarColorBlanco() {
		
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@FXML
	void ratonPresionaBotonEstadisticas(MouseEvent event) {
		VBox vbox = crearMenuVbox();
		
		if (!stackPaneMenuDesplegable.getChildren().isEmpty()) {
			stackPaneMenuDesplegable.getChildren().clear();
		} else {

			Button botonEstadisticas = crearBotonesMenu();

			botonEstadisticas.setText("Estadisticas");
			botonEstadisticas.setOnAction(e -> ratonPulsaMostrarEstadisitcas());

			vbox.getChildren().addAll(botonEstadisticas);

			stackPaneMenuDesplegable.getChildren().add(0, vbox);
			stackPaneMenuDesplegable.setAlignment(Pos.CENTER_LEFT);
			
			desplegarMenu();
		}
	}

	void ratonPulsaMostrarEstadisitcas() {
		
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

	@FXML
	void ratonPresionaBotonInformacion(MouseEvent event) {
		VBox vbox = crearMenuVbox();
		
		if (!stackPaneMenuDesplegable.getChildren().isEmpty()) {
			stackPaneMenuDesplegable.getChildren().clear();
		} else {

			Button botonAutor = crearBotonesMenu();

			botonAutor.setText("Autor");
			botonAutor.setOnAction(e ->ratonPulsaBotonAutor());
			
			vbox.getChildren().addAll(botonAutor);

			stackPaneMenuDesplegable.getChildren().add(0, vbox);
			stackPaneMenuDesplegable.setAlignment(Pos.CENTER_LEFT);
			
			desplegarMenu();
		}
	}

	void ratonPulsaBotonAutor() {
		Autor ventanaAutor = (Autor) Controladores.get("vistas/Autor.fxml", "Vista grafica del autor", getEscenario());
		ventanaAutor.getEscenario().showAndWait();
	}

	// --------------------------------------------------------------------------------------------------------------------------------

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

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------
