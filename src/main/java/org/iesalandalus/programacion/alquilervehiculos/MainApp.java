package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		Controlador controlador = new Controlador(new ModeloCascada(FactoriaFuenteDatos.FICHEROS),procesarArgumentos(args));
		controlador.comenzar();
	}

	private static Vista procesarArgumentos(String[] arg) {
        Vista vista = FactoriaVista.GRAFICA.crear();
        
        for (String argObtenido : arg) {
            if (argObtenido.equals("-vtexto")) {
                vista = FactoriaVista.TEXTO.crear();
            }else if(argObtenido.equals("-vgrafica")) {
                vista = FactoriaVista.GRAFICA.crear();
            }
        }
        return vista;
    }	
}
