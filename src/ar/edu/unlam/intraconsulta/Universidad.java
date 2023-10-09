package ar.edu.unlam.intraconsulta;

import java.util.ArrayList;

public class Universidad {

//	private Alumno alumnos[];
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materia;
	private ArrayList<InscripcionMateria> inscripcionesMaterias;

	public Universidad(String nombre) {
//		this.alumnos = new Alumno[100];
		this.nombre = nombre;
		this.alumnos = new ArrayList<>();
		this.materia = new ArrayList<>();
		this.inscripcionesMaterias = new ArrayList<>();
	}

	public Boolean registrar(Alumno alumno) {
		if (buscarAlumnoPorDni(alumno.getDni()) == null) {
			this.alumnos.add(alumno);
			return true;
		}
		if (!existeAlumno(alumno.getDni())) {
			return this.alumnos.add(alumno);
		}
		return false;
	}

	public Alumno buscarAlumnoPorDni(Integer dni) {

		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				return this.alumnos.get(i);
			}
		}

		return null;

	}

	public Boolean existeAlumno(Integer dni) {
		for (int i = 0; i < this.alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}

	public Boolean registrarMateria(Materia materia) {

		return this.materia.add(materia);
	}

	public boolean inscribirAlumnoAUnaMateria(Integer dni, Integer codigo) {

		InscripcionMateria inscribir = null;
		ArrayList<InscripcionMateria> historiaAcademica = historiaAcademica(dni);
		Alumno alumno = this.buscarAlumnoPorDni(dni);
		Materia materia = this.buscarMateriaPorCodigo(codigo);
		ArrayList<Materia> correlativas = materia.getCorrelativas();		
		
		/*
		 * 1- Buscar si tiene las correlativas aprobadas necesarias para poder inscribirse
		 * */
		boolean materiasNecesariasAprobadas = false;
		
		for (int i = 0; i < historiaAcademica.size();i++) {
			if (historiaAcademica.get(i).getAlumno().equals(alumno)) {
				
			}
		}
		
//		for (int i = 0; i < historiaAcademica.size();i++) {
////			Si la materia no tiene correlativas, inscribir.
//			if (correlativas.size() == 0) {
//				inscripcionesMaterias.add(new InscripcionMateria(alumno,materia));
//				materiasNecesariasAprobadas = true;
//				break;
////				Si la materia si tiene correlativas, verificar que tenga las 
////				correlativas aprobadas con 4 o mas para inscribir.
//			}else {
//				for(int j = 0; j < correlativas.size();j++) {
//					if(historiaAcademica.get(j).getAlumno().)
//				}
//			}
//		}
		
		
//		if (alumno != null && materia != null) {
//			if ()
//		}
		

		return false;
	}

	private Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materia.size(); i++) {
			if (this.materia.get(i).getCodigo().equals(codigo)) {
				return this.materia.get(i);
			}
		}
		return null;
	}

	public ArrayList<InscripcionMateria> historiaAcademica(Integer dni) {

		ArrayList<InscripcionMateria> historiaArrayList = new ArrayList<>();

		for (int i = 0; i < this.inscripcionesMaterias.size(); i++) {
			if (this.inscripcionesMaterias.get(i).getAlumno().getDni().equals(dni)) {
				historiaArrayList.add(this.inscripcionesMaterias.get(i));
			}
		}

		return historiaArrayList;

	}

	public Boolean evaluarAAlumno(Alumno alumno, Materia materia, Nota nota) {
		// TODO Auto-generated method stub
//		Buscar inscripcion a materia Alumno y Materia en el array "inscripcionesMaterias".
//		Si se encuentra al alumno y materia. Colocar nota con InscripcionMateria.setNota(nota).
//		Linea 66: Linea de interes.
		for (int i = 0; i < this.inscripcionesMaterias.size(); i++) {
			if (this.inscripcionesMaterias.get(i).getAlumno().getDni().equals(alumno.getDni())
					&& this.inscripcionesMaterias.get(i).getMateria().getCodigo().equals(materia.getCodigo())) {
				this.inscripcionesMaterias.get(i).setNota(nota);
				return true;
			}
		}
		return false;

	}

	public boolean agregarMateriaCorrelativaAMateria(Materia materia, ArrayList<Materia> arrayCorrelativas) {
		for (int i = 0; i < this.materia.size(); i++) {
			if (this.materia.get(i).equals(materia) && this.materia.get(i) != null) {
				return this.materia.get(i).agregarCorrelativas(arrayCorrelativas);
			}
		}
		return false;
	}

}
