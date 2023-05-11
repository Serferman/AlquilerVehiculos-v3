package org.iesalandalus.programacion.alquilervehiculos.vista.grafica;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Dialogos;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LanzadorVentanaPrincipal extends Application {
	
	private static final String TITULO = "Vista Gráfica de Alquiler Vehículos";
	
	public void start(Stage escenarioPrincipal) throws Exception {
		try {
			
			Controlador ventanaPrincipal = Controladores.get("vistas/VentanaPrincipal.fxml", TITULO, null);		
			ventanaPrincipal.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaPrincipal.getEscenario(), e));
			//ventanaPrincipal.getEscenario().setIconified(false);
			/*
			String operativeS1 = System.getenv("$DESKTOP_SESSION").toLowerCase();
			
			try {
				ProcessBuilder pb = new ProcessBuilder("lsb_release -d");
				pb.start();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			if (operativeSystem.contains("mint")) {
				System.out.println("A");
			}
			
			//ventanaPrincipal.getEscenario().setMaximized(true);*/
			ventanaPrincipal.getEscenario().show();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void comenzar() {
		launch(LanzadorVentanaPrincipal.class);
	}
	
	private void confirmarSalida(Stage escenario, WindowEvent e) {
		if (Dialogos.mostrarDialogoConfirmacion("Salir", "¿Seguro que quieres salir de la aplicación?", escenario)) {
			escenario.close();
		} else {
			e.consume();
		}
	}
}
