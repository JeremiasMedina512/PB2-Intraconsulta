package ar.edu.unlam.intraconsulta;

import java.util.ArrayList;

public class UniversidadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Verificar metodo agregarMateriaCorrelativaAMateria */
		String nombreUniversidad = "Unlam";

		String nombrePrimeraMateria = "pb1";
		Integer codigoPrimeraMateria = 1;
		String nombreSegundaMateria = "pb2";
		Integer codigoSegundaMateria = 2;
		Integer valorNota = 10;
		Integer dni = 123;
		Boolean resultadoEsperado = false;
		ArrayList<Materia> arrayCorrelativas = new ArrayList<>();
		

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia primeraMateria = new Materia(codigoPrimeraMateria, nombrePrimeraMateria);
		Materia segundaMateria = new Materia(codigoSegundaMateria, nombreSegundaMateria);
		Alumno alumno = new Alumno(dni, "Jeremias", "Medina");
		Nota nota = new Nota(valorNota);
		arrayCorrelativas.add(segundaMateria);
		
		unlam.registrar(alumno);
		unlam.registrarMateria(primeraMateria);
		unlam.registrarMateria(segundaMateria);
		
		if(unlam.agregarMateriaCorrelativaAMateria(segundaMateria, arrayCorrelativas)) 
			System.out.println("True");
		else
			System.out.println("False");
		
		
	}

}
