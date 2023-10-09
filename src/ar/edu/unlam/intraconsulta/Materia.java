package ar.edu.unlam.intraconsulta;

import java.util.ArrayList;

public class Materia {

	private Integer codigo;
	private String nombre;
	private ArrayList<Materia> correlativas;

	public Materia(Integer codigo, String nombre) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.nombre = nombre;
		this.correlativas = new ArrayList<>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean agregarCorrelativas(ArrayList<Materia> arrayCorrelativas) {
		if (this.correlativas.addAll(arrayCorrelativas)) {
			return true;
		}
		return false;

	}

	public ArrayList<Materia> getCorrelativas() {
		return this.correlativas;
	}

}
