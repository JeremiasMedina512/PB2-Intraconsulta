package ar.edu.unlam.intraconsulta;

import java.util.ArrayList;

public class InscripcionMateria {

	private Alumno alumno;
	private Materia materia;
	private Nota nota;

	public InscripcionMateria(Alumno alumno, Materia materia) {
		this.alumno = alumno;
		this.materia = materia;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}




}
