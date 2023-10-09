package ar.edu.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {
		String nombreUniversidad = "Unlam";
		String direccion = "Florencio Varela";
		Integer dni = 1234;
		String nombreAlumno = "Jeremias";
		String apellidoAlumno = "Medina";
		Boolean registroExitoso = false;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, nombreAlumno, apellidoAlumno);
		registroExitoso = unlam.registrar(alumno);

		assertTrue(registroExitoso);
	}

	@Test
	public void queNoSePuedaRegistrarUnAlumnoCuandoElAlumnoYaEsteRegistradoUnaUniversidad() {
		String nombreUniversidad = "Unlam";
		String direccion = "Florencio Varela";
		Integer dni = 1234;
		String nombreAlumno = "Jeremias";
		String apellidoAlumno = "Medina";
		Boolean registroExitoso = false;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, nombreAlumno, apellidoAlumno);
		unlam.registrar(alumno);

		Alumno alumno1 = new Alumno(dni, "Jose", "Lopez");
		registroExitoso = unlam.registrar(alumno1);

		assertFalse(registroExitoso);
	}

	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {
		String nombre = "Unlam";
		Universidad unlam = new Universidad(nombre);
		nombre = "pb2";
		Integer codigo = 1;
		Materia pb2 = new Materia(codigo, nombre);
		Boolean resultadoEsperado = false;

		resultadoEsperado = unlam.registrarMateria(pb2);
		System.out.println(resultadoEsperado);

		assertTrue(resultadoEsperado);
	}

	@Test
	public void queSePuedaInscribirUnAlumnoEnUnaMateria() {
		String nombreUniversidad = "Unlam";

		String nombreAlumno = "Jeremias";
		String apellidoAlumno = "Medina";
		Integer dni = 1234;

		String nombreMateria = "pb2";
		Integer codigoMateria = 1;

		Universidad unlam = new Universidad(nombreUniversidad);
		Alumno alumno = new Alumno(dni, nombreAlumno, apellidoAlumno);
		Materia materia = new Materia(codigoMateria, nombreMateria);

		unlam.registrar(alumno);
		unlam.registrarMateria(materia);

		Boolean resultadoEsperado = unlam.inscribirAlumnoAUnaMateria(dni, codigoMateria);
		assertTrue(resultadoEsperado);

	}

	@Test
	public void colocarNotaAAlumno() {
		String nombreUniversidad = "Unlam";

		String nombreMateria = "pb1";
		Integer codigoMateria = 1;

		Integer valorNota = 10;

		Boolean valorEsperado = false;

		Universidad unlam = new Universidad(nombreUniversidad);
		Materia materia = new Materia(codigoMateria, nombreMateria);
		Alumno alumno = new Alumno(123, "Jeremias", "Medina");
		Nota nota = new Nota(valorNota);

		unlam.registrar(alumno);
		unlam.registrarMateria(materia);
		unlam.inscribirAlumnoAUnaMateria(alumno.getDni(), materia.getCodigo());

		valorEsperado = unlam.evaluarAAlumno(alumno, materia, nota);
		assertTrue(valorEsperado);

	}

	@Test
	public void agregarCorrelatividadAMateria() {
//		Ver historia academica de un alumno.
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
		Materia segundaMateria = new Materia (codigoSegundaMateria, nombreSegundaMateria);
		Alumno alumno = new Alumno(dni, "Jeremias", "Medina");
		Nota nota = new Nota(valorNota);
		arrayCorrelativas.add(segundaMateria);

		unlam.registrar(alumno);
		unlam.registrarMateria(primeraMateria);
		unlam.registrarMateria(segundaMateria);
		unlam.inscribirAlumnoAUnaMateria(alumno.getDni(), primeraMateria.getCodigo());
		unlam.evaluarAAlumno(alumno, primeraMateria, nota);
		
		resultadoEsperado = unlam.agregarMateriaCorrelativaAMateria(primeraMateria, arrayCorrelativas);
		
		assertTrue(resultadoEsperado);
		


		
	}
	
	@Test
	public void queSoloSePuedaInscribirAUnaMateriaSiTieneAprobadaLasMateriaNecesariasAprobadas() {
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
		Materia segundaMateria = new Materia (codigoSegundaMateria, nombreSegundaMateria);
		Alumno alumno = new Alumno(dni, "Jeremias", "Medina");
		Nota nota = new Nota(valorNota);
		arrayCorrelativas.add(primeraMateria);

		unlam.registrar(alumno);
		unlam.registrarMateria(primeraMateria);
		unlam.registrarMateria(segundaMateria);
		unlam.agregarMateriaCorrelativaAMateria(segundaMateria, arrayCorrelativas);
		unlam.inscribirAlumnoAUnaMateria(alumno.getDni(), primeraMateria.getCodigo());
		unlam.evaluarAAlumno(alumno, primeraMateria, nota);
		unlam.inscribirAlumnoAUnaMateria(alumno.getDni(), segundaMateria.getCodigo());

		
		
		
	
	}


}
